package com.saas.apkeditorplus

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.saas.apkeditorplus.utils.AxmlDecoder
import com.apk.axml.ResourceTableParser
import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipFile

class AxmlEditActivity : BaseActivity() {

    private lateinit var toolbar: com.google.android.material.appbar.MaterialToolbar
    private lateinit var listView: ListView
    private lateinit var progressBar: ProgressBar
    private lateinit var apkPath: String
    private var currentPath: String = "" // Caminho relativo dentro do APK (ex: "res/layout/")
    private val displayList = mutableListOf<FileItem>()
    private val modifiedFiles = mutableMapOf<String, String>() // ZipEntry -> Path to modified temp file
    private var resourceEntries: List<*>? = null
    private var lastOpenedEntryName: String? = null

    data class FileItem(val name: String, val fullPath: String, val isDirectory: Boolean)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_axmledit)

        apkPath = intent.getStringExtra("apkPath") ?: ""
        if (apkPath.isEmpty()) {
            finish()
        }

        toolbar = findViewById(R.id.header_layout)
        toolbar.setNavigationOnClickListener { onBackPressed() }
        
        listView = findViewById(R.id.files_list)
        progressBar = findViewById(R.id.progress_bar)
        
        loadApkInfo()
        loadResources() 
        loadFiles()

        findViewById<Button>(R.id.btn_close).setOnClickListener { finish() }
        findViewById<Button>(R.id.btn_save).setOnClickListener { startApkCreate() }
    }

    private fun loadResources() {
        Thread {
            try {
                val zipFile = ZipFile(apkPath)
                val entry = zipFile.getEntry("resources.arsc")
                if (entry != null) {
                    val inputStream = zipFile.getInputStream(entry)
                    resourceEntries = ResourceTableParser(inputStream).parse()
                    inputStream.close()
                }
                zipFile.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun loadApkInfo() {
        try {
            val pm = packageManager
            val info = pm.getPackageArchiveInfo(apkPath, 0)
            if (info != null) {
                info.applicationInfo?.let { appInfo ->
                    appInfo.sourceDir = apkPath
                    val label = appInfo.loadLabel(pm).toString()
                    toolbar.title = label
                    toolbar.subtitle = apkPath
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            toolbar.subtitle = apkPath
        }
    }

    private fun loadFiles() {
        progressBar.visibility = View.VISIBLE
        Thread {
            try {
                val zipFile = ZipFile(apkPath)
                val entries = zipFile.entries()
                displayList.clear()

                // Adicionar ".." se não estiver na raiz
                if (currentPath.isNotEmpty()) {
                    displayList.add(FileItem("..", getParentPath(currentPath), true))
                }

                val folders = mutableSetOf<String>()
                val files = mutableListOf<FileItem>()

                while (entries.hasMoreElements()) {
                    val entry = entries.nextElement()
                    val name = entry.name

                    if (name.startsWith(currentPath)) {
                        val relativeName = name.substring(currentPath.length)
                        if (relativeName.isEmpty()) continue

                        val parts = relativeName.split("/")
                        if (parts.size > 1) {
                            // É um diretório ou arquivo dentro de um subdiretório
                            val folderName = parts[0]
                            folders.add(folderName)
                        } else if (!entry.isDirectory) {
                            // É um arquivo no diretório atual
                            files.add(FileItem(relativeName, name, false))
                        }
                    }
                }

                // Adiciona pastas à lista
                folders.sorted().forEach { folderName ->
                    displayList.add(FileItem(folderName, currentPath + folderName + "/", true))
                }
                
                // Adiciona arquivos à lista, ordenados
                files.sortBy { it.name.lowercase() }
                displayList.addAll(files)

                zipFile.close()
                runOnUiThread {
                    updateList()
                    toolbar.subtitle = if (currentPath.isEmpty()) apkPath else "$apkPath/$currentPath"
                    progressBar.visibility = View.GONE
                }
            } catch (e: Exception) {
                e.printStackTrace()
                runOnUiThread {
                    Toast.makeText(this, getString(R.string.error_loading_files, e.message), Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                }
            }
        }.start()
    }

    private fun getParentPath(path: String): String {
        if (path.isEmpty()) return ""
        val p = path.removeSuffix("/")
        val lastSlash = p.lastIndexOf("/")
        return if (lastSlash == -1) "" else p.substring(0, lastSlash + 1)
    }

    private fun updateList() {
        listView.adapter = object : BaseAdapter() {
            override fun getCount(): Int = displayList.size
            override fun getItem(position: Int): Any = displayList[position]
            override fun getItemId(position: Int): Long = position.toLong()

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val view = convertView ?: LayoutInflater.from(this@AxmlEditActivity)
                    .inflate(R.layout.item_zipfile, parent, false)
                
                val textView = view.findViewById<TextView>(R.id.filename)
                val iconView = view.findViewById<ImageView>(R.id.file_icon)
                
                // Ocultar os ícones do lado direito conforme solicitado
                view.findViewById<View>(R.id.menu_edit)?.visibility = View.GONE
                view.findViewById<View>(R.id.menu_save)?.visibility = View.GONE
                
                val item = displayList[position]
                textView.text = item.name
                
                when {
                    item.isDirectory -> {
                        if (item.name == "..") {
                            iconView.setImageResource(R.drawable.ic_file_up)
                        } else {
                            iconView.setImageResource(R.drawable.ic_file_folder)
                        }
                    }
                    isImageFile(item.name) -> {
                        // In the future, load thumbnails. For now, use unknown or generic image icon
                        iconView.setImageResource(R.drawable.ic_file_unknown)
                    }
                    else -> {
                        // Pro version uses ic_file_unknown for most files in this list
                        iconView.setImageResource(R.drawable.ic_file_unknown)
                    }
                }
                
                view.setOnClickListener {
                    if (item.isDirectory) {
                        currentPath = item.fullPath
                        loadFiles()
                    } else {
                        openFile(item.fullPath)
                    }
                }
                return view
            }
        }
    }

    private fun isImageFile(name: String): Boolean {
        val lower = name.lowercase()
        return lower.endsWith(".png") || lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".gif")
    }

    private fun openFile(entryName: String) {
        lastOpenedEntryName = entryName
        progressBar.visibility = View.VISIBLE
        Thread {
            try {
                val tempDir = File(cacheDir, "xml_edit")
                if (!tempDir.exists()) tempDir.mkdirs()
                val tempFile = File(tempDir, entryName.replace("/", "_"))

                var success = false
                var errorLog: String? = null

                // Se o arquivo já foi modificado e o arquivo temporário existe, não extraímos de novo
                if (modifiedFiles.containsKey(entryName) && tempFile.exists()) {
                    success = true
                } else {
                    val zipFile = ZipFile(apkPath)
                    val entry = zipFile.getEntry(entryName)
                    val inputStream = zipFile.getInputStream(entry)
                    val outputStream = FileOutputStream(tempFile)

                    try {
                        if (entryName.endsWith(".xml")) {
                            // Tenta decodificar como AXML usando os recursos se disponíveis
                            val decoder = AxmlDecoder()
                            success = decoder.decodeWithResources(inputStream, outputStream, resourceEntries)
                            if (!success) {
                                errorLog = "AxmlDecoder retornou falso (formato inválido ou corrompido)"
                            }
                        } else {
                            // Copia direta para arquivos não-XML
                            inputStream.copyTo(outputStream)
                            success = true
                        }
                    } catch (e: Exception) {
                        success = false
                        errorLog = e.stackTraceToString()
                    } finally {
                        outputStream.close()
                        inputStream.close()
                        zipFile.close()
                    }
                }
                
                runOnUiThread {
                    progressBar.visibility = View.GONE
                    if (success) {
                        if (entryName.endsWith(".xml")) {
                            val intent = Intent(this, TextEditBigActivity::class.java)
                            intent.putExtra("filePath", tempFile.absolutePath)
                            intent.putExtra("fileName", entryName)
                            startActivityForResult(intent, 100)
                        } else {
                            // Mostrar diálogo informando que apenas XML é suportado
                            com.google.android.material.dialog.MaterialAlertDialogBuilder(this)
                                .setTitle("Unsupported File")
                                .setMessage("Only XML files can be edited in this section.")
                                .setPositiveButton("OK", null)
                                .show()
                        }
                    } else {
                        showErrorDialog(getString(R.string.failed_to_process_file), errorLog ?: getString(R.string.unknown_error))
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                runOnUiThread {
                    progressBar.visibility = View.GONE
                    showErrorDialog(getString(R.string.io_error), e.stackTraceToString())
                }
            }
        }.start()
    }

    private fun showErrorDialog(title: String, log: String) {
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(log)
            .setPositiveButton(R.string.close, null)
            .show()
    }

    override fun onBackPressed() {
        if (currentPath.isNotEmpty()) {
            currentPath = getParentPath(currentPath)
            loadFiles()
        } else {
            super.onBackPressed()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK) {
            findViewById<Button>(R.id.btn_save).visibility = View.VISIBLE
            
            // Registra o arquivo como modificado apenas após salvar com sucesso
            lastOpenedEntryName?.let { entryName ->
                val tempDir = File(cacheDir, "xml_edit")
                val tempFile = File(tempDir, entryName.replace("/", "_"))
                if (tempFile.exists()) {
                    modifiedFiles[entryName] = tempFile.absolutePath
                }
            }
        }
    }

    private fun startApkCreate() {
        val intent = Intent(this, ApkCreateActivity::class.java)
        intent.putExtra("apkPath", apkPath)
        val bundle = Bundle()
        for ((key, value) in modifiedFiles) {
            bundle.putString(key, value)
        }
        intent.putExtra("modifiedFiles", bundle)
        startActivity(intent)
        finish()
    }
}
