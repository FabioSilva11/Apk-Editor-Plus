package com.saas.apkeditorplus

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.io.File
import java.util.Locale
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ApkSearchActivity : BaseActivity(), AdapterView.OnItemClickListener {

    private data class SearchResult(
        val file: File
    )

    private class SearchResultAdapter(
        private val activity: ApkSearchActivity,
        private val apkInfoLoader: ApkArchiveInfoLoader,
        private val onApkInfoChanged: () -> Unit
    ) : BaseAdapter() {

        private val inflater = LayoutInflater.from(activity)
        private var items: List<SearchResult> = emptyList()

        fun submit(items: List<SearchResult>) {
            this.items = items
            notifyDataSetChanged()
        }

        fun add(item: SearchResult) {
            items = items + item
            notifyDataSetChanged()
        }

        override fun getCount(): Int = items.size

        override fun getItem(position: Int): Any = items[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowView = convertView ?: inflater.inflate(R.layout.item_applist, parent, false)
            val iconView = rowView.findViewById<ImageView>(R.id.app_icon)
            val titleView = rowView.findViewById<TextView>(R.id.app_name)
            val detailView = rowView.findViewById<TextView>(R.id.app_desc1)
            val packageView = rowView.findViewById<TextView>(R.id.app_desc2)

            val result = items[position]
            val file = result.file
            titleView.text = file.nameWithoutExtension
            detailView.text = file.absolutePath
            packageView.visibility = View.GONE

            val cachedInfo = apkInfoLoader.get(file.absolutePath)
            if (cachedInfo != null) {
                iconView.clearColorFilter()
                iconView.setImageDrawable(
                    cachedInfo.icon ?: ContextCompat.getDrawable(activity, R.drawable.apk_icon)
                )
                titleView.text = cachedInfo.label.ifBlank { file.nameWithoutExtension }
                if (cachedInfo.packageName.isNotBlank()) {
                    packageView.text = cachedInfo.packageName
                    packageView.visibility = View.VISIBLE
                }
            } else {
                iconView.clearColorFilter()
                iconView.setImageResource(R.drawable.apk_icon)
                apkInfoLoader.load(file.absolutePath) {
                    onApkInfoChanged()
                }
            }

            return rowView
        }
    }

    private lateinit var titleView: TextView
    private lateinit var listView: ListView
    private lateinit var emptyView: TextView
    private lateinit var searchingLayout: View
    private lateinit var adapter: SearchResultAdapter
    private lateinit var apkInfoLoader: ApkArchiveInfoLoader

    private val mainHandler = Handler(Looper.getMainLooper())
    private val searchExecutor: ExecutorService = Executors.newSingleThreadExecutor()
    private val results = mutableListOf<SearchResult>()

    private var keyword: String = ""
    private var searchPath: String = ""

    @Volatile
    private var stopRequested = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apksearch)

        keyword = intent.getStringExtra("Keyword").orEmpty().trim()
        searchPath = intent.getStringExtra("Path").orEmpty().trim()

        bindViews()
        apkInfoLoader = ApkArchiveInfoLoader(this)
        adapter = SearchResultAdapter(this, apkInfoLoader) {
            runOnUiThread { adapter.notifyDataSetChanged() }
        }

        listView.adapter = adapter
        listView.emptyView = emptyView
        listView.onItemClickListener = this
        updateTitle()
        startSearch()
    }

    override fun shouldHideActionBar(): Boolean = true

    override fun onDestroy() {
        stopRequested = true
        searchExecutor.shutdownNow()
        apkInfoLoader.shutdown()
        super.onDestroy()
    }

    private fun bindViews() {
        titleView = findViewById(R.id.title)
        listView = findViewById(R.id.listview_apkfiles)
        emptyView = findViewById(R.id.empty_view)
        searchingLayout = findViewById(R.id.searching_layout)
    }

    private fun startSearch() {
        val root = File(searchPath)
        if (!root.exists() || !root.isDirectory) {
            searchingLayout.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
            Toast.makeText(this, getString(R.string.error_filepath_notexist), Toast.LENGTH_SHORT).show()
            return
        }

        results.clear()
        adapter.submit(emptyList())
        searchingLayout.visibility = View.VISIBLE

        searchExecutor.execute {
            searchInFolder(root)
            mainHandler.post {
                if (!isFinishing && !isDestroyed) {
                    searchingLayout.visibility = View.GONE
                    emptyView.visibility = if (results.isEmpty()) View.VISIBLE else View.GONE
                }
            }
        }
    }

    private fun searchInFolder(directory: File) {
        if (stopRequested) {
            return
        }

        val files = directory.listFiles() ?: return
        val directories = mutableListOf<File>()

        files.forEach { file ->
            if (stopRequested) {
                return
            }

            if (file.isFile) {
                val name = file.name.lowercase(Locale.getDefault())
                val matchesKeyword = keyword.isBlank() ||
                    name.contains(keyword.lowercase(Locale.getDefault()))
                if (name.endsWith(".apk") && matchesKeyword) {
                    publishResult(file)
                }
            } else if (file.isDirectory) {
                directories += file
            }
        }

        directories.sortedBy { it.name.lowercase(Locale.getDefault()) }
            .forEach(::searchInFolder)
    }

    private fun publishResult(file: File) {
        val item = SearchResult(file)
        results += item
        mainHandler.post {
            if (!isFinishing && !isDestroyed) {
                adapter.add(item)
                updateTitle()
            }
        }
    }

    private fun updateTitle() {
        val formatted = getString(R.string.str_files_found, results.size, keyword)
        titleView.text = if (keyword.isBlank()) {
            formatted.removeSuffix(" - ''")
        } else {
            formatted
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val file = (adapter.getItem(position) as SearchResult).file
        showEditModeDialog(file.absolutePath)
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
}
