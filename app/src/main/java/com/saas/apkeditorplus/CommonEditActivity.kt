package com.saas.apkeditorplus

import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import com.saas.apkeditorplus.engine.axml.AxmlReader
import com.saas.apkeditorplus.engine.axml.AxmlWriter
import com.saas.apkeditorplus.engine.axml.ManifestInfo
import java.io.File
import java.io.FileInputStream
import java.util.zip.ZipFile

class CommonEditActivity : BaseActivity(), View.OnClickListener {

    private lateinit var apkPath: String
    private var manifestInfo: ManifestInfo? = null
    
    // UI Components
    private lateinit var toolbar: com.google.android.material.appbar.MaterialToolbar
    private lateinit var ivLauncherIcon: ImageView
    private lateinit var etAppName: EditText
    private lateinit var etPkgName: EditText
    private lateinit var etVerCode: EditText
    private lateinit var etVerName: EditText
    private lateinit var etMinSdk: EditText
    private lateinit var etTargetSdk: EditText
    private lateinit var etMaxSdk: EditText
    private lateinit var spLocation: Spinner
    private lateinit var btnSave: Button
    private lateinit var btnClose: Button

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commonedit)

        apkPath = intent.getStringExtra("apkPath") ?: ""
        if (apkPath.isEmpty()) {
            Toast.makeText(this, getString(R.string.apk_path_not_found), Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        initViews()
        loadApkInfo()
    }

    private fun initViews() {
        toolbar = findViewById(R.id.header_layout)
        toolbar.setNavigationOnClickListener { finish() }
        
        ivLauncherIcon = findViewById(R.id.launcher_icon)
        etAppName = findViewById(R.id.et_appname)
        etPkgName = findViewById(R.id.et_pkgname)
        etVerCode = findViewById(R.id.et_vercode)
        etVerName = findViewById(R.id.et_vername)
        etMinSdk = findViewById(R.id.et_minSdkVersion)
        etTargetSdk = findViewById(R.id.et_targetSdkVersion)
        etMaxSdk = findViewById(R.id.et_maxSdkVersion)
        spLocation = findViewById(R.id.location_spinner)
        btnSave = findViewById(R.id.btn_save)
        btnClose = findViewById(R.id.btn_close)

        btnSave.setOnClickListener(this)
        btnClose.setOnClickListener(this)
        
        // Setup Spinner
        val locations = arrayOf("Auto", "Internal", "External", "Preference")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, locations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spLocation.adapter = adapter
    }

    private fun loadApkInfo() {
        Thread {
            try {
                val file = File(apkPath)
                val zipFile = ZipFile(file)
                val entry = zipFile.getEntry("AndroidManifest.xml")
                val inputStream = zipFile.getInputStream(entry)
                
                val reader = AxmlReader(inputStream)
                manifestInfo = reader.parse()
                
                zipFile.close()

                handler.post { updateUI() }
            } catch (e: Exception) {
                e.printStackTrace()
                handler.post {
                    Toast.makeText(this, getString(R.string.error_loading_apk_info, e.message), Toast.LENGTH_LONG).show()
                }
            }
        }.start()
    }

    private fun updateUI() {
        manifestInfo?.let { info ->
            toolbar.title = info.label ?: getString(R.string.unnamed)
            etAppName.setText(info.label)
            etPkgName.setText(info.packageName)
            etVerCode.setText(info.versionCode.toString())
            etVerName.setText(info.versionName)
            etMinSdk.setText(if (info.minSdkVersion != -1) info.minSdkVersion.toString() else "")
            etTargetSdk.setText(if (info.targetSdkVersion != -1) info.targetSdkVersion.toString() else "")
            etMaxSdk.setText(if (info.maxSdkVersion != -1) info.maxSdkVersion.toString() else "")
            
            if (info.installLocation >= 0 && info.installLocation < spLocation.adapter.count) {
                spLocation.setSelection(info.installLocation)
            }

            // Load icon
            try {
                val pm = packageManager
                val packageInfo = pm.getPackageArchiveInfo(apkPath, 0)
                if (packageInfo != null) {
                    val appInfo = packageInfo.applicationInfo
                    appInfo?.let {
                        it.sourceDir = apkPath
                        it.publicSourceDir = apkPath
                        
                        val icon = it.loadIcon(pm)
                        val label = it.loadLabel(pm).toString()
                        
                        ivLauncherIcon.setImageDrawable(icon)
                        
                        if (manifestInfo?.label.isNullOrEmpty()) {
                            toolbar.title = label
                            etAppName.setText(label)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_close -> finish()
            R.id.btn_save -> saveChanges()
        }
    }

    private fun saveChanges() {
        val newLabel = etAppName.text.toString()
        val newPkgName = etPkgName.text.toString()
        val newVerCode = etVerCode.text.toString().toIntOrNull() ?: -1
        
        Toast.makeText(this, getString(R.string.saving_changes), Toast.LENGTH_SHORT).show()
        
        Thread {
            try {
                // In binary edit, we usually create a temp file and then rebuild the APK
                val tempAxml = File(cacheDir, "AndroidManifest.xml")
                val zipFile = ZipFile(apkPath)
                val entry = zipFile.getEntry("AndroidManifest.xml")
                val inputStream = zipFile.getInputStream(entry)
                
                val writer = AxmlWriter(inputStream, tempAxml.absolutePath)
                manifestInfo?.let { writer.setManifestInfo(it) }
                writer.setLabel(newLabel)
                writer.setPackageName(newPkgName)
                writer.setVersionName(etVerName.text.toString())
                writer.setVersionCode(newVerCode)
                writer.write()
                
                zipFile.close()
                
                handler.post {
                    val modifiedFiles = Bundle()
                    modifiedFiles.putString("AndroidManifest.xml", tempAxml.absolutePath)
                    
                    val intent = android.content.Intent(this, ApkCreateActivity::class.java).apply {
                        putExtra("apkPath", apkPath)
                        putExtra("modifiedFiles", modifiedFiles)
                    }
                    startActivity(intent)
                    Toast.makeText(this, getString(R.string.axml_modified_rebuild), Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                handler.post {
                    Toast.makeText(this, getString(R.string.error_saving, e.message), Toast.LENGTH_LONG).show()
                }
            }
        }.start()
    }
}
