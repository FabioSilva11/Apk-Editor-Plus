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

class FileListActivity : BaseActivity(), AdapterView.OnItemClickListener {

    private lateinit var listView: ListView
    private lateinit var adapter: FileAdapter
    private var currentPath: String = Environment.getExternalStorageDirectory().path

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listfile)

        listView = findViewById(R.id.file_list)
        
        // Configura o adaptador
        val initialDir = File(currentPath)
        adapter = FileAdapter(this, initialDir)
        listView.adapter = adapter
        listView.onItemClickListener = this

        updatePathDisplay(initialDir.path)
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu): Boolean {
        menuInflater.inflate(R.menu.menu_filelist, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.action_switch_sd -> {
                Toast.makeText(this, getString(R.string.switch_storage_not_implemented), Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updatePathDisplay(path: String) {
        supportActionBar?.title = path
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
            val isSelectForVerify = intent.getBooleanExtra("select_for_verify", false)
            val isSelectForCommonEdit = intent.getBooleanExtra("select_for_common_edit", false)
            
            if (isSelectForVerify) {
                val resultIntent = Intent()
                resultIntent.putExtra("apkPath", selectedFile.path)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else if (isSelectForCommonEdit) {
                startEditActivity(2, selectedFile.path)
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

}
