package com.saas.apkeditorplus

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.core.content.ContextCompat
import java.io.File
import java.util.Locale

class FileListActivity : BaseActivity(), AdapterView.OnItemClickListener {

    private data class BrowserItem(
        val file: File,
        val isParent: Boolean
    )

    private class BrowserFileAdapter(
        private val context: Context,
        private val apkInfoLoader: ApkArchiveInfoLoader,
        private val onApkInfoChanged: () -> Unit
    ) : BaseAdapter() {

        private val inflater = LayoutInflater.from(context)
        private var currentDirectory: File = File("/")
        private var items: List<BrowserItem> = emptyList()

        fun submitDirectory(directory: File) {
            currentDirectory = directory
            val sortedItems = directory.listFiles()
                ?.sortedWith(compareBy<File>({ !it.isDirectory }, { it.name.lowercase(Locale.getDefault()) }))
                .orEmpty()

            val newItems = mutableListOf<BrowserItem>()
            directory.parentFile?.let { parent ->
                newItems += BrowserItem(parent, true)
            }
            sortedItems.forEach { file ->
                newItems += BrowserItem(file, false)
            }
            items = newItems
            notifyDataSetChanged()
        }

        override fun getCount(): Int = items.size

        override fun getItem(position: Int): Any = items[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowView = convertView
                ?: inflater.inflate(R.layout.item_file, parent, false)

            val iconView = rowView.findViewById<ImageView>(R.id.file_icon)
            val nameView = rowView.findViewById<TextView>(R.id.file_name)
            val detailView = rowView.findViewById<TextView>(R.id.file_details)
            val item = items[position]
            val file = item.file
            val tintColor = resolveIconTint()

            if (item.isParent) {
                nameView.text = ".."
                detailView.text = currentDirectory.parentFile?.absolutePath.orEmpty()
                iconView.setImageResource(R.drawable.ic_file_up)
                iconView.setColorFilter(tintColor)
                return rowView
            }

            nameView.text = file.name

            when {
                file.isDirectory -> {
                    iconView.setImageResource(R.drawable.ic_folder)
                    iconView.setColorFilter(tintColor)
                    detailView.text = context.getString(R.string.folder_label)
                }

                file.name.endsWith(".apk", ignoreCase = true) -> {
                    val cachedInfo = apkInfoLoader.get(file.absolutePath)
                    if (cachedInfo != null) {
                        iconView.clearColorFilter()
                        iconView.setImageDrawable(
                            cachedInfo.icon ?: ContextCompat.getDrawable(context, R.drawable.apk_icon)
                        )
                        detailView.text = cachedInfo.label.ifBlank { formatFileSize(file.length()) }
                    } else {
                        iconView.clearColorFilter()
                        iconView.setImageResource(R.drawable.apk_icon)
                        detailView.text = formatFileSize(file.length())
                        apkInfoLoader.load(file.absolutePath) {
                            onApkInfoChanged()
                        }
                    }
                }

                else -> {
                    iconView.setImageResource(R.drawable.ic_file_unknown)
                    iconView.setColorFilter(tintColor)
                    detailView.text = formatFileSize(file.length())
                }
            }

            return rowView
        }

        private fun resolveIconTint(): Int {
            val typedValue = android.util.TypedValue()
            context.theme.resolveAttribute(R.attr.iconPrimary, typedValue, true)
            return typedValue.data
        }

        private fun formatFileSize(size: Long): String {
            if (size <= 0L) return "0 B"
            val units = arrayOf("B", "KB", "MB", "GB", "TB")
            val digitGroup = (Math.log10(size.toDouble()) / Math.log10(1024.0)).toInt()
            return String.format(
                Locale.US,
                "%.1f %s",
                size / Math.pow(1024.0, digitGroup.toDouble()),
                units[digitGroup]
            )
        }
    }

    companion object {
        private const val LAST_DIR_KEY = "apkDirectory"
    }

    private lateinit var pathView: TextView
    private lateinit var keywordEdit: EditText
    private lateinit var searchButton: ImageButton
    private lateinit var storageToggle: View
    private lateinit var storageIcon: ImageView
    private lateinit var listView: ListView
    private lateinit var adapter: BrowserFileAdapter
    private lateinit var apkInfoLoader: ApkArchiveInfoLoader

    private var currentDirectory: File = File("/")
    private var showingExternalStorage: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listfile)

        bindViews()

        apkInfoLoader = ApkArchiveInfoLoader(this)
        adapter = BrowserFileAdapter(this, apkInfoLoader) {
            runOnUiThread { adapter.notifyDataSetChanged() }
        }
        listView.adapter = adapter
        listView.onItemClickListener = this

        setupInteractions()
        openInitialDirectory()
    }

    override fun shouldHideActionBar(): Boolean = true

    override fun onDestroy() {
        apkInfoLoader.shutdown()
        super.onDestroy()
    }

    private fun bindViews() {
        pathView = findViewById(R.id.dirPath)
        keywordEdit = findViewById(R.id.keyword_edit)
        searchButton = findViewById(R.id.search_button)
        storageToggle = findViewById(R.id.menu_switch_card)
        storageIcon = findViewById(R.id.imageView_extsdcard)
        listView = findViewById(R.id.file_list)
    }

    private fun setupInteractions() {
        searchButton.setOnClickListener { startSearch() }
        storageToggle.setOnClickListener { switchStorage() }
        storageToggle.setOnLongClickListener {
            showStorageMenu(it)
            true
        }
    }

    private fun openInitialDirectory() {
        val savedDirectory = File(getLastDirectory())
        val initialDirectory = when {
            savedDirectory.exists() && savedDirectory.isDirectory -> savedDirectory
            else -> StorageRoots.primary(this)
        }
        openDirectory(initialDirectory)
    }

    private fun openDirectory(directory: File) {
        val safeDirectory = when {
            directory.exists() && directory.isDirectory -> directory
            else -> StorageRoots.primary(this)
        }

        currentDirectory = safeDirectory
        showingExternalStorage = isSamePath(safeDirectory, StorageRoots.external(this))
        adapter.submitDirectory(safeDirectory)
        pathView.text = safeDirectory.absolutePath
        setLastDirectory(safeDirectory.absolutePath)
        updateStorageIcon()
    }

    private fun switchStorage() {
        val externalRoot = StorageRoots.external(this)
        if (showingExternalStorage) {
            openDirectory(StorageRoots.primary(this))
            return
        }

        if (externalRoot == null) {
            Toast.makeText(this, getString(R.string.cannot_find_ext_sdcard), Toast.LENGTH_SHORT).show()
            return
        }

        openDirectory(externalRoot)
    }

    private fun showStorageMenu(anchor: View) {
        val popupMenu = PopupMenu(this, anchor)
        popupMenu.menu.add(0, 1, 0, R.string.sd_card)
        popupMenu.menu.add(0, 2, 1, R.string.ext_sd_card)
        popupMenu.menu.add(0, 3, 2, R.string.app_files)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                1 -> {
                    openDirectory(StorageRoots.primary(this))
                    true
                }

                2 -> {
                    val externalRoot = StorageRoots.external(this)
                    if (externalRoot != null) {
                        openDirectory(externalRoot)
                    } else {
                        Toast.makeText(this, getString(R.string.cannot_find_ext_sdcard), Toast.LENGTH_SHORT).show()
                    }
                    true
                }

                3 -> {
                    openDirectory(filesDir)
                    true
                }

                else -> false
            }
        }
        popupMenu.show()
    }

    private fun updateStorageIcon() {
        storageIcon.setImageResource(R.drawable.ic_sdcard_ext)
        storageIcon.alpha = if (showingExternalStorage) 1f else 0.72f
    }

    private fun startSearch() {
        val intent = Intent(this, ApkSearchActivity::class.java).apply {
            putExtra("Keyword", keywordEdit.text?.toString().orEmpty().trim())
            putExtra("Path", currentDirectory.absolutePath)
        }
        startActivity(intent)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = adapter.getItem(position) as BrowserItem

        when {
            item.isParent -> currentDirectory.parentFile?.let(::openDirectory)
            item.file.isDirectory -> openDirectory(item.file)
            item.file.name.endsWith(".apk", ignoreCase = true) -> handleApkSelection(item.file)
            else -> Toast.makeText(this, getString(R.string.select_apk_file), Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleApkSelection(file: File) {
        file.parentFile?.absolutePath?.let(::setLastDirectory)

        when {
            intent.getBooleanExtra("select_for_verify", false) -> {
                setResult(
                    RESULT_OK,
                    Intent().apply { putExtra("apkPath", file.absolutePath) }
                )
                finish()
            }

            intent.getBooleanExtra("select_for_common_edit", false) -> {
                startEditActivity(EditModeDialog.COMMON_EDIT, file.absolutePath)
            }

            else -> showEditModeDialog(file.absolutePath)
        }
    }

    private fun showEditModeDialog(apkPath: String) {
        EditModeDialog(this, apkPath) { mode, path ->
            startEditActivity(mode, path)
        }.show()
    }

    private fun startEditActivity(mode: Int, apkPath: String) {
        val intent = when (mode) {
            EditModeDialog.FULL_EDIT -> Intent(this, FullEditActivity::class.java)
            EditModeDialog.SIMPLE_EDIT -> Intent(this, SimpleEditActivity::class.java)
            EditModeDialog.COMMON_EDIT -> Intent(this, CommonEditActivity::class.java)
            EditModeDialog.XML_FILE_EDIT -> Intent(this, AxmlEditActivity::class.java)
            else -> null
        }

        intent?.let {
            it.putExtra("apkPath", apkPath)
            startActivity(it)
        } ?: Toast.makeText(this, getString(R.string.edit_mode_not_supported), Toast.LENGTH_SHORT).show()
    }

    private fun getLastDirectory(): String {
        return getSharedPreferences("config", Context.MODE_PRIVATE)
            .getString(LAST_DIR_KEY, StorageRoots.primary(this).absolutePath)
            .orEmpty()
    }

    private fun setLastDirectory(directory: String) {
        getSharedPreferences("config", Context.MODE_PRIVATE)
            .edit()
            .putString(LAST_DIR_KEY, directory)
            .apply()
    }

    private fun isSamePath(first: File?, second: File?): Boolean {
        if (first == null || second == null) {
            return false
        }
        return runCatching { first.canonicalPath == second.canonicalPath }
            .getOrDefault(first.absolutePath == second.absolutePath)
    }
}
