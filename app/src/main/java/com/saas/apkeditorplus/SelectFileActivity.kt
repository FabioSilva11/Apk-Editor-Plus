package com.saas.apkeditorplus

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import android.widget.ProgressBar
import java.io.File

class SelectFileActivity : BaseActivity(), View.OnClickListener, AdapterView.OnItemClickListener {

    private lateinit var listView: ListView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: FileAdapter
    private var currentPath: String = Environment.getExternalStorageDirectory().path

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_file_activity)
  
        listView = findViewById(R.id.application_list)
        progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        
        val initialDir = File(currentPath)
        adapter = FileAdapter(this, initialDir)
        listView.adapter = adapter
        listView.onItemClickListener = this
  
        updatePathDisplay(initialDir.path)
    }

    private fun updatePathDisplay(path: String) {
        supportActionBar?.title = path
        currentPath = path
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedFile = adapter.getItem(position) as File
        
        if (selectedFile.isDirectory) {
            if (selectedFile.name == "..") {
                val parentDir = adapter.getCurrentDir().parentFile
                if (parentDir != null) {
                    adapter.setDir(parentDir.path)
                    updatePathDisplay(parentDir.path)
                }
            } else {
                adapter.setDir(selectedFile.path)
                updatePathDisplay(selectedFile.path)
            }
        } else if (selectedFile.name.endsWith(".apk", true)) {
            showSignOptionsDialog(selectedFile)
        } else {
            Toast.makeText(this, getString(R.string.select_apk_to_sign), Toast.LENGTH_SHORT).show()
        }
    }

    private fun showSignOptionsDialog(apkFile: File) {
        val options = arrayOf(getString(R.string.sign_with_testkey), getString(R.string.sign_with_custom_keystore))
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.sign_apk_title, apkFile.name))
            .setItems(options) { _, which ->
                when (which) {
                    0 -> signWithTestKey(apkFile)
                    1 -> selectCustomKeyStore(apkFile)
                }
            }
            .show()
    }

    private fun signWithTestKey(apkFile: File) {
        val keyStoreManager = KeyStoreManager(this)
        val testKeyFile = keyStoreManager.getTestKey()
        val outputApk = File(apkFile.parent, apkFile.nameWithoutExtension + "_signed.apk")
        
        val intent = Intent(this, SigningProgressActivity::class.java).apply {
            putExtra("inputPath", apkFile.absolutePath)
            putExtra("outputPath", outputApk.absolutePath)
            putExtra("ksPath", testKeyFile.absolutePath)
            putExtra("ksPass", "testkey")
            putExtra("alias", "testkey")
            putExtra("keyPass", "testkey")
        }
        startActivityForResult(intent, REQUEST_CODE_SIGNING)
    }

    private fun selectCustomKeyStore(apkFile: File) {
        val keyStoreManager = KeyStoreManager(this)
        val files = keyStoreManager.listKeyStores()
        
        if (files.isEmpty()) {
            Toast.makeText(this, getString(R.string.signing_failed_check_keys), Toast.LENGTH_LONG).show()
            return
        }
        
        val names = files.map { it.name }

        AlertDialog.Builder(this)
            .setTitle(R.string.select_keystore)
            .setItems(names.toTypedArray()) { _, which ->
                requestKeyStorePassword(apkFile, files[which])
            }
            .show()
    }

    private fun requestKeyStorePassword(apkFile: File, ksFile: File) {
        val input = android.widget.EditText(this)
        input.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
        input.setPadding(50, 20, 50, 20)
        
        val container = android.widget.FrameLayout(this)
        container.addView(input)

        AlertDialog.Builder(this)
            .setTitle(R.string.password)
            .setView(container)
            .setPositiveButton(android.R.string.ok) { dialog: DialogInterface, which: Int ->
                val password = input.text.toString()
                if (password.isNotEmpty()) {
                    performCustomSign(apkFile, ksFile, password)
                }
            }
            .setNegativeButton(R.string.colormixer_cancel, null)
            .show()
    }

    private fun performCustomSign(apkFile: File, ksFile: File, password: String) {
        val outputApk = File(apkFile.parent, apkFile.nameWithoutExtension + "_signed_custom.apk")
        
        val intent = Intent(this, SigningProgressActivity::class.java).apply {
            putExtra("inputPath", apkFile.absolutePath)
            putExtra("outputPath", outputApk.absolutePath)
            putExtra("ksPath", ksFile.absolutePath)
            putExtra("ksPass", password)
            putExtra("alias", "alias") // Placeholder
            putExtra("keyPass", password)
        }
        startActivityForResult(intent, REQUEST_CODE_SIGNING)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SIGNING && resultCode == RESULT_OK) {
            val targetPath = data?.getStringExtra("targetPath")
            if (targetPath != null) {
                adapter.setDir(targetPath)
                updatePathDisplay(targetPath)
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_SIGNING = 1001
    }

    override fun onClick(v: View) {
        // Nada implementado no momento
    }
}
