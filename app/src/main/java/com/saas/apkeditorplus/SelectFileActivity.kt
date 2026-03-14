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
import java.io.File

class SelectFileActivity : BaseActivity(), View.OnClickListener, AdapterView.OnItemClickListener {

    private lateinit var toolbar: com.google.android.material.appbar.MaterialToolbar
    private lateinit var listView: ListView
    private lateinit var adapter: FileAdapter
    private var currentPath: String = Environment.getExternalStorageDirectory().path

    override fun shouldHideActionBar(): Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_file_activity)

        toolbar = findViewById(R.id.header_layout)
        setSupportActionBar(toolbar)
        
        toolbar.setNavigationOnClickListener { finish() }
        
        listView = findViewById(R.id.file_list)
        
        val initialDir = File(currentPath)
        adapter = FileAdapter(this, initialDir)
        listView.adapter = adapter
        listView.onItemClickListener = this

        findViewById<View>(R.id.menu_home).setOnClickListener(this)

        updatePathDisplay(initialDir.path)
    }

    private fun updatePathDisplay(path: String) {
        toolbar.title = path
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
            Toast.makeText(this, "Selecione um arquivo APK para assinar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showSignOptionsDialog(apkFile: File) {
        val options = arrayOf("Sign with TestKey", "Sign with Custom KeyStore")
        AlertDialog.Builder(this)
            .setTitle("Sign APK: ${apkFile.name}")
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
            Toast.makeText(this, "Nenhuma chave encontrada em 'Chaves de Assinatura'", Toast.LENGTH_LONG).show()
            return
        }
        
        val names = files.map { it.name }

        AlertDialog.Builder(this)
            .setTitle("Selecionar KeyStore")
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
            .setTitle("Senha")
            .setView(container)
            .setPositiveButton("OK") { dialog: DialogInterface, which: Int ->
                val password = input.text.toString()
                if (password.isNotEmpty()) {
                    performCustomSign(apkFile, ksFile, password)
                }
            }
            .setNegativeButton("Cancelar", null)
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
        when (v.id) {
            R.id.menu_home -> {
                val homePath = Environment.getExternalStorageDirectory().path
                adapter.setDir(homePath)
                updatePathDisplay(homePath)
            }
        }
    }
}
