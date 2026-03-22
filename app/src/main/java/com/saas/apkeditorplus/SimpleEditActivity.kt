package com.saas.apkeditorplus

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.LruCache
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import java.io.File
import java.util.concurrent.Executors
import java.util.zip.ZipFile

class SimpleEditActivity : BaseActivity(), View.OnClickListener {
    private lateinit var apkPath: String
    private lateinit var viewPager: ViewPager
    private lateinit var progressBar: ProgressBar
    private lateinit var centerLayout: View
    private lateinit var summaryView: TextView
    private lateinit var actionButton: Button
    private lateinit var filesLabel: TextView
    private lateinit var imagesLabel: TextView
    private lateinit var audioLabel: TextView

    private lateinit var filesListView: ListView
    private lateinit var imagesListView: ListView
    private lateinit var audiosListView: ListView

    private val modifiedFiles = linkedMapOf<String, String>()
    private val thumbnailCache = object : LruCache<String, Bitmap>(60) {}
    private val thumbnailExecutor = Executors.newFixedThreadPool(2)
    private val mainHandler = Handler(Looper.getMainLooper())
    private var pendingReplaceEntry: ArchiveEntry? = null
    private var selectedTabIndex: Int = 0

    private var fileEntries = emptyList<ArchiveEntry>()
    private var imageEntries = emptyList<ArchiveEntry>()
    private var audioEntries = emptyList<ArchiveEntry>()

    private lateinit var filesAdapter: EntryAdapter
    private lateinit var imagesAdapter: EntryAdapter
    private lateinit var audiosAdapter: EntryAdapter

    private val pickReplacementLauncher = registerForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri ->
        val entry = pendingReplaceEntry ?: return@registerForActivityResult
        if (uri == null) {
            pendingReplaceEntry = null
            return@registerForActivityResult
        }
        handleReplacementPicked(entry, uri)
    }

    private data class ArchiveEntry(
        val displayName: String,
        val entryName: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simpleedit)

        apkPath = intent.getStringExtra("apkPath") ?: ""
        if (apkPath.isBlank()) {
            Toast.makeText(this, getString(R.string.apk_path_not_found), Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        bindViews()
        setupPager()
        loadApkInfo()
        loadEntries()
    }

    private fun bindViews() {
        viewPager = findViewById(R.id.pagerView)
        progressBar = findViewById(R.id.progress_bar)
        centerLayout = findViewById(R.id.center_layout)
        summaryView = findViewById(R.id.tv_summary)
        actionButton = findViewById(R.id.btn_close)
        filesLabel = findViewById(R.id.files_label)
        imagesLabel = findViewById(R.id.images_label)
        audioLabel = findViewById(R.id.audio_label)

        centerLayout.visibility = View.INVISIBLE
        actionButton.setOnClickListener(this)
        filesLabel.setOnClickListener(this)
        imagesLabel.setOnClickListener(this)
        audioLabel.setOnClickListener(this)
    }

    private fun setupPager() {
        val inflater = LayoutInflater.from(this)
        val pages = listOf(
            inflater.inflate(R.layout.pageitem_files, viewPager, false),
            inflater.inflate(R.layout.pageitem_images, viewPager, false),
            inflater.inflate(R.layout.pageitem_audios, viewPager, false)
        )

        filesListView = pages[0].findViewById(R.id.files_list)
        imagesListView = pages[1].findViewById(R.id.images_list)
        audiosListView = pages[2].findViewById(R.id.audios_list)

        filesAdapter = EntryAdapter { fileEntries }
        imagesAdapter = EntryAdapter { imageEntries }
        audiosAdapter = EntryAdapter { audioEntries }

        filesListView.adapter = filesAdapter
        imagesListView.adapter = imagesAdapter
        audiosListView.adapter = audiosAdapter

        filesListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            startReplaceFlow(fileEntries[position], arrayOf("*/*"))
        }
        imagesListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            startReplaceFlow(imageEntries[position], arrayOf("image/*"))
        }
        audiosListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            startReplaceFlow(audioEntries[position], arrayOf("audio/*"))
        }

        val clearListener = AdapterView.OnItemLongClickListener { _, _, position, _ ->
            val entry = when (selectedTabIndex) {
                0 -> fileEntries.getOrNull(position)
                1 -> imageEntries.getOrNull(position)
                else -> audioEntries.getOrNull(position)
            } ?: return@OnItemLongClickListener false
            clearReplacement(entry)
            true
        }
        filesListView.onItemLongClickListener = clearListener
        imagesListView.onItemLongClickListener = clearListener
        audiosListView.onItemLongClickListener = clearListener

        viewPager.adapter = object : PagerAdapter() {
            override fun getCount(): Int = pages.size

            override fun isViewFromObject(view: View, obj: Any): Boolean = view === obj

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                val page = pages[position]
                container.addView(page)
                return page
            }

            override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
                container.removeView(obj as View)
            }
        }
        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                selectedTabIndex = position
                updateTabState()
            }
        })
        updateTabState()
    }

    private fun loadApkInfo() {
        runCatching {
            val info = packageManager.getPackageArchiveInfo(apkPath, 0)
            val appInfo = info?.applicationInfo ?: return@runCatching
            appInfo.sourceDir = apkPath
            appInfo.publicSourceDir = apkPath
            val label = appInfo.loadLabel(packageManager)?.toString()
            supportActionBar?.title = label ?: getString(R.string.simple_edit)
            supportActionBar?.subtitle = apkPath
        }.onFailure {
            supportActionBar?.title = getString(R.string.simple_edit)
            supportActionBar?.subtitle = apkPath
        }
    }

    private fun loadEntries() {
        progressBar.visibility = View.VISIBLE
        centerLayout.visibility = View.INVISIBLE
        Thread {
            val result = runCatching {
                ZipFile(apkPath).use { zipFile ->
                    val allEntries = mutableListOf<ArchiveEntry>()
                    val entries = zipFile.entries()
                    while (entries.hasMoreElements()) {
                        val entry = entries.nextElement()
                        if (entry.isDirectory) continue
                        allEntries.add(
                            ArchiveEntry(
                                displayName = entry.name.substringAfterLast('/'),
                                entryName = entry.name
                            )
                        )
                    }
                    val sortedEntries = allEntries.sortedBy { it.entryName.lowercase() }
                    Triple(
                        sortedEntries.filter { isRegularFile(it.entryName) },
                        sortedEntries.filter { isImageFile(it.entryName) },
                        sortedEntries.filter { isAudioFile(it.entryName) }
                    )
                }
            }
            runOnUiThread {
                progressBar.visibility = View.GONE
                result.onSuccess { (files, images, audios) ->
                    fileEntries = files
                    imageEntries = images
                    audioEntries = audios
                    filesAdapter.notifyDataSetChanged()
                    imagesAdapter.notifyDataSetChanged()
                    audiosAdapter.notifyDataSetChanged()
                    centerLayout.visibility = View.VISIBLE
                    updateTabState()
                }.onFailure { error ->
                    Toast.makeText(
                        this,
                        error.message ?: getString(R.string.failed),
                        Toast.LENGTH_LONG
                    ).show()
                    finish()
                }
            }
        }.start()
    }

    private fun startReplaceFlow(entry: ArchiveEntry, mimeTypes: Array<String>) {
        pendingReplaceEntry = entry
        pickReplacementLauncher.launch(mimeTypes)
    }

    private fun handleReplacementPicked(entry: ArchiveEntry, uri: Uri) {
        Thread {
            val result = runCatching {
                val targetDir = File(cacheDir, "simple_edit_replacements").apply { mkdirs() }
                val targetFile = File(targetDir, entry.entryName.replace("/", "_"))
                contentResolver.openInputStream(uri)?.use { input ->
                    targetFile.outputStream().use { output -> input.copyTo(output) }
                } ?: error("Failed to read selected file")
                targetFile
            }
            runOnUiThread {
                pendingReplaceEntry = null
                result.onSuccess { file ->
                    modifiedFiles[entry.entryName] = file.absolutePath
                    refreshVisibleLists()
                    updateActionState()
                    Toast.makeText(this, getString(R.string.file_replaced), Toast.LENGTH_SHORT).show()
                }.onFailure { error ->
                    Toast.makeText(
                        this,
                        error.message ?: getString(R.string.failed),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }.start()
    }

    private fun clearReplacement(entry: ArchiveEntry) {
        val removed = modifiedFiles.remove(entry.entryName)
        if (removed != null) {
            refreshVisibleLists()
            updateActionState()
            Toast.makeText(this, getString(R.string.remove), Toast.LENGTH_SHORT).show()
        }
    }

    private fun refreshVisibleLists() {
        filesAdapter.notifyDataSetChanged()
        imagesAdapter.notifyDataSetChanged()
        audiosAdapter.notifyDataSetChanged()
        updateTabState()
    }

    private fun updateActionState() {
        actionButton.setText(if (modifiedFiles.isEmpty()) R.string.close else R.string.save)
    }

    private fun updateTabState() {
        updateActionState()
        val activated = resolveColorAttr(R.attr.navActivated, 0xFF000000.toInt())
        val normal = resolveColorAttr(R.attr.navNormal, 0xFF666666.toInt())
        updateTabLabel(filesLabel, selectedTabIndex == 0, activated, normal)
        updateTabLabel(imagesLabel, selectedTabIndex == 1, activated, normal)
        updateTabLabel(audioLabel, selectedTabIndex == 2, activated, normal)

        val currentCount = when (selectedTabIndex) {
            0 -> fileEntries.size
            1 -> imageEntries.size
            else -> audioEntries.size
        }
        val title = when (selectedTabIndex) {
            0 -> getString(R.string.files_capital)
            1 -> getString(R.string.images_capital)
            else -> getString(R.string.audios_captical)
        }
        summaryView.text = getString(
            R.string.simple_edit_summary_format,
            title,
            currentCount,
            modifiedFiles.size
        )
    }

    private fun updateTabLabel(label: TextView, selected: Boolean, activatedColor: Int, normalColor: Int) {
        label.setTextColor(if (selected) activatedColor else normalColor)
        label.setBackgroundResource(
            if (selected) R.drawable.mtrl_nav_bg_checked else R.drawable.mtrl_nav_bg_unchecked
        )
    }

    private fun resolveColorAttr(attrRes: Int, fallback: Int): Int {
        val typedArray = obtainStyledAttributes(intArrayOf(attrRes))
        return try {
            typedArray.getColor(0, fallback)
        } finally {
            typedArray.recycle()
        }
    }

    private fun isImageFile(name: String): Boolean {
        val lower = name.lowercase()
        return lower.endsWith(".png") ||
            lower.endsWith(".jpg") ||
            lower.endsWith(".jpeg") ||
            lower.endsWith(".webp") ||
            lower.endsWith(".gif")
    }

    private fun isAudioFile(name: String): Boolean {
        val lower = name.lowercase()
        return lower.endsWith(".mp3") ||
            lower.endsWith(".ogg") ||
            lower.endsWith(".wav") ||
            lower.endsWith(".m4a") ||
            lower.endsWith(".aac") ||
            lower.endsWith(".flac")
    }

    private fun isRegularFile(name: String): Boolean {
        return !isImageFile(name) && !isAudioFile(name)
    }

    private fun loadImagePreview(item: ArchiveEntry, iconView: ImageView) {
        val previewKey = buildPreviewKey(item)
        iconView.tag = previewKey
        iconView.scaleType = ImageView.ScaleType.CENTER_CROP

        val cachedBitmap = thumbnailCache.get(previewKey)
        if (cachedBitmap != null && !cachedBitmap.isRecycled) {
            iconView.setImageBitmap(cachedBitmap)
            return
        }

        iconView.setImageResource(R.drawable.ic_edit_1)
        thumbnailExecutor.execute {
            val bitmap = runCatching { decodeImagePreview(item) }.getOrNull()
            if (bitmap != null) {
                thumbnailCache.put(previewKey, bitmap)
                mainHandler.post {
                    if (iconView.tag == previewKey) {
                        iconView.setImageBitmap(bitmap)
                    }
                }
            }
        }
    }

    private fun buildPreviewKey(item: ArchiveEntry): String {
        val replacementPath = modifiedFiles[item.entryName].orEmpty()
        return "${item.entryName}|$replacementPath"
    }

    private fun decodeImagePreview(item: ArchiveEntry): Bitmap? {
        val replacementPath = modifiedFiles[item.entryName]
        if (!replacementPath.isNullOrBlank()) {
            return decodeSampledBitmapFromFile(File(replacementPath))
        }

        ZipFile(apkPath).use { zipFile ->
            val entry = zipFile.getEntry(item.entryName) ?: return null
            zipFile.getInputStream(entry).use { input ->
                return decodeSampledBitmapFromBytes(input.readBytes())
            }
        }
    }

    private fun decodeSampledBitmapFromFile(file: File): Bitmap? {
        if (!file.exists()) {
            return null
        }
        val bounds = BitmapFactory.Options().apply {
            inJustDecodeBounds = true
        }
        BitmapFactory.decodeFile(file.absolutePath, bounds)
        val options = BitmapFactory.Options().apply {
            inSampleSize = calculateInSampleSize(bounds, 96, 96)
        }
        return BitmapFactory.decodeFile(file.absolutePath, options)
    }

    private fun decodeSampledBitmapFromBytes(bytes: ByteArray): Bitmap? {
        val bounds = BitmapFactory.Options().apply {
            inJustDecodeBounds = true
        }
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size, bounds)
        val options = BitmapFactory.Options().apply {
            inSampleSize = calculateInSampleSize(bounds, 96, 96)
        }
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size, options)
    }

    private fun calculateInSampleSize(
        options: BitmapFactory.Options,
        reqWidth: Int,
        reqHeight: Int
    ): Int {
        var inSampleSize = 1
        val height = options.outHeight
        val width = options.outWidth
        if (height <= 0 || width <= 0) {
            return inSampleSize
        }
        while ((height / inSampleSize) > reqHeight || (width / inSampleSize) > reqWidth) {
            inSampleSize *= 2
        }
        return inSampleSize.coerceAtLeast(1)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.files_label -> viewPager.currentItem = 0
            R.id.images_label -> viewPager.currentItem = 1
            R.id.audio_label -> viewPager.currentItem = 2
            R.id.btn_close -> {
                if (modifiedFiles.isEmpty()) {
                    finish()
                } else {
                    val bundle = Bundle().apply {
                        modifiedFiles.forEach { (entryName, tempPath) ->
                            putString(entryName, tempPath)
                        }
                    }
                    startActivity(
                        Intent(this, ApkCreateActivity::class.java).apply {
                            putExtra("apkPath", apkPath)
                            putExtra("modifiedFiles", bundle)
                        }
                    )
                }
            }
        }
    }

    private inner class EntryAdapter(
        private val itemsProvider: () -> List<ArchiveEntry>
    ) : BaseAdapter() {
        override fun getCount(): Int = itemsProvider().size

        override fun getItem(position: Int): Any = itemsProvider()[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowView = convertView
                ?: layoutInflater.inflate(R.layout.item_zipfile, parent, false)
            val item = itemsProvider()[position]
            val replacement = modifiedFiles[item.entryName]

            rowView.findViewById<TextView>(R.id.filename).text = item.displayName
            rowView.findViewById<TextView>(R.id.detail1).text =
                replacement ?: item.entryName
            rowView.findViewById<View>(R.id.menu_edit).visibility = View.GONE
            rowView.findViewById<View>(R.id.menu_save).visibility = View.GONE

            val icon = rowView.findViewById<ImageView>(R.id.file_icon)
            if (isImageFile(item.entryName)) {
                loadImagePreview(item, icon)
            } else {
                icon.tag = null
                icon.scaleType = ImageView.ScaleType.FIT_CENTER
                icon.setImageResource(
                    when {
                        isAudioFile(item.entryName) -> R.drawable.ic_file_unknown
                        else -> R.drawable.ic_file_unknown
                    }
                )
            }

            val detailColor = if (replacement == null) {
                resolveColorAttr(R.attr.navNormal, 0xFF666666.toInt())
            } else {
                resolveColorAttr(R.attr.navActivated, 0xFF3F51B5.toInt())
            }
            rowView.findViewById<TextView>(R.id.detail1).setTextColor(detailColor)
            return rowView
        }
    }

    override fun onDestroy() {
        thumbnailExecutor.shutdownNow()
        super.onDestroy()
    }
}
