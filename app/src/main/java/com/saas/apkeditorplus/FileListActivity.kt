package com.saas.apkeditorplus

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class FileListActivity : BaseActivity(), View.OnClickListener, AdapterView.OnItemClickListener {

    private lateinit var toolbar: com.google.android.material.appbar.MaterialToolbar
    private lateinit var listView: ListView
    private lateinit var adapter: FileAdapter
    private var currentPath: String = Environment.getExternalStorageDirectory().path

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listfile)

        // Inicializa as views
        toolbar = findViewById(R.id.header_layout)
        listView = findViewById(R.id.file_list)
        
        setupToolbar()
        
        // Configura o adaptador
        val initialDir = File(currentPath)
        adapter = FileAdapter(this, initialDir)
        listView.adapter = adapter
        listView.onItemClickListener = this

        // Configura os botões
        findViewById<View>(R.id.menu_home).setOnClickListener(this)
        findViewById<View>(R.id.files_list).setOnClickListener(this)
        findViewById<View>(R.id.search_button).setOnClickListener(this)

        updatePathDisplay(initialDir.path)
    }

    private fun setupToolbar() {
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.inflateMenu(R.menu.menu_filelist)
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_switch_sd -> {
                    Toast.makeText(this, getString(R.string.switch_storage_not_implemented), Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun updatePathDisplay(path: String) {
        toolbar.title = path
        currentPath = path
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedFile = adapter.getItem(position) as File
        
        if (selectedFile.isDirectory) {
            if (selectedFile.name == "..") {
                // Sobe um nível
                val parentDir = adapter.getCurrentDir().parentFile
                if (parentDir != null) {
                    adapter.setDir(parentDir.path)
                    updatePathDisplay(parentDir.path)
                }
            } else {
                // Entra na pasta
                adapter.setDir(selectedFile.path)
                updatePathDisplay(selectedFile.path)
            }
        } else if (selectedFile.name.endsWith(".apk", true)) {
            // Se foi aberta para selecionar um arquivo para verificação
            if (intent.getBooleanExtra("select_for_verify", false)) {
                val resultIntent = Intent()
                resultIntent.putExtra("apkPath", selectedFile.path)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                // Mostra o diálogo de modo de edição normal
                showEditModeDialog(selectedFile.path)
            }
        } else {
            Toast.makeText(this, getString(R.string.select_apk_file), Toast.LENGTH_SHORT).show()
        }
    }

    private fun showEditModeDialog(path: String) {
        val dialog = EditModeDialog(this, path) { mode, apkPath ->
            startEditActivity(mode, apkPath)
        }
        dialog.show()
    }

    private fun startEditActivity(mode: Int, path: String) {
        val intent = when (mode) {
            0 -> Intent(this, UserAppActivity::class.java) // Na versão original, 0 parece ser Full Edit ou algo do tipo
            1 -> Intent(this, SimpleEditActivity::class.java)
            2 -> Intent(this, CommonEditActivity::class.java)
            4 -> Intent(this, AxmlEditActivity::class.java)
            else -> null
        }

        intent?.let {
            it.putExtra("apkPath", path)
            startActivity(it)
        } ?: Toast.makeText(this, getString(R.string.edit_mode_not_supported), Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.menu_home -> {
                val homePath = Environment.getExternalStorageDirectory().path
                adapter.setDir(homePath)
                updatePathDisplay(homePath)
            }
            R.id.files_list -> {
                // Talvez mostrar lista de arquivos recentes ou favoritos
                Toast.makeText(this, getString(R.string.recent_files_not_implemented), Toast.LENGTH_SHORT).show()
            }
            R.id.search_button -> {
                val keyword = findViewById<EditText>(R.id.keyword_edit).text.toString()
                if (keyword.isNotEmpty()) {
                    val intent = Intent(this, ApkSearchActivity::class.java)
                    intent.putExtra("Keyword", keyword)
                    intent.putExtra("Path", currentPath)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, getString(R.string.keyword_required), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
