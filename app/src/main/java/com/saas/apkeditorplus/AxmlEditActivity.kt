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

    private lateinit var listView: ListView
    private lateinit var progressBar: ProgressBar
    private lateinit var apkPath: String
    private var currentPath: String = "" // Caminho relativo dentro do APK (ex: "res/layout/")
    private val displayList = mutableListOf<FileItem>()
    private val modifiedFiles = mutableMapOf<String, String>() // ZipEntry -> Path to modified temp file
    private var resourceEntries: List<*>? = null

    data class FileItem(val name: String, val fullPath: String, val isDirectory: Boolean)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_axmledit)

        apkPath = intent.getStringExtra("apkPath") ?: ""
        if (apkPath.isEmpty()) {
            finish()
        }

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
                    appInfo.publicSourceDir = apkPath
                    val label = appInfo.loadLabel(pm).toString()
                    val icon = appInfo.loadIcon(pm)
                    
                    findViewById<TextView>(R.id.apk_label).text = label
                    findViewById<ImageView>(R.id.apk_icon).setImageDrawable(icon)
                    findViewById<TextView>(R.id.tv_filepath).text = apkPath
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            findViewById<TextView>(R.id.tv_filepath).text = apkPath
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
                    findViewById<TextView>(R.id.tv_filepath).text = if (currentPath.isEmpty()) apkPath else "$apkPath/$currentPath"
                    progressBar.visibility = View.GONE
                }
            } catch (e: Exception) {
                e.printStackTrace()
                runOnUiThread {
                    Toast.makeText(this, "Erro ao carregar arquivos: ${e.message}", Toast.LENGTH_SHORT).show()
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
                    item.name.endsWith(".xml") -> iconView.setImageResource(R.drawable.ic_file_xml)
                    item.name.endsWith(".dex") -> iconView.setImageResource(R.drawable.ic_file_dex)
                    item.name.endsWith(".smali") -> iconView.setImageResource(R.drawable.ic_file_smali)
                    item.name.endsWith(".htm") || item.name.endsWith(".html") -> iconView.setImageResource(R.drawable.ic_file_html)
                    item.name.endsWith(".rar") || item.name.endsWith(".zip") -> iconView.setImageResource(R.drawable.ic_file_zip)
                    item.name.endsWith(".properties") || item.name.endsWith(".css") || item.name.endsWith(".java") || item.name.endsWith(".js") || item.name.endsWith(".MF") || item.name.endsWith(".SF") || item.name.endsWith(".txt") -> iconView.setImageResource(R.drawable.ic_file_text)
                    item.name.endsWith(".apk") -> iconView.setImageResource(R.drawable.ic_file_apk)
                    item.name.endsWith(".ttf") -> iconView.setImageResource(R.drawable.ic_file_ttf)
                    else -> iconView.setImageResource(R.drawable.ic_file_unknown)
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

    private fun openFile(entryName: String) {
        progressBar.visibility = View.VISIBLE
        Thread {
            try {
                val zipFile = ZipFile(apkPath)
                val entry = zipFile.getEntry(entryName)
                val inputStream = zipFile.getInputStream(entry)
                
                val tempDir = File(cacheDir, "xml_edit")
                if (!tempDir.exists()) tempDir.mkdirs()
                val tempFile = File(tempDir, entryName.replace("/", "_"))
                
                val outputStream = FileOutputStream(tempFile)
                
                var success = false
                var errorLog: String? = null
                
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
                
                runOnUiThread {
                    progressBar.visibility = View.GONE
                    if (success) {
                        val activityClass = if (entryName.endsWith(".xml")) TextEditBigActivity::class.java else TextEditNormalActivity::class.java
                        val intent = Intent(this, activityClass)
                        intent.putExtra("filePath", tempFile.absolutePath)
                        intent.putExtra("fileName", entryName)
                        startActivityForResult(intent, 100)
                        
                        modifiedFiles[entryName] = tempFile.absolutePath
                    } else {
                        showErrorDialog("Falha ao processar arquivo", errorLog ?: "Erro desconhecido")
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                runOnUiThread {
                    progressBar.visibility = View.GONE
                    showErrorDialog("Erro de I/O", e.stackTraceToString())
                }
            }
        }.start()
    }

    private fun showErrorDialog(title: String, log: String) {
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(log)
            .setPositiveButton("Fechar", null)
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
