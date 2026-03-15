package com.saas.apkeditorplus

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : BaseActivity(), View.OnClickListener {

    override fun shouldHideActionBar(): Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Configura a Toolbar customizada
        setupToolbar()

        // Inicializa os botões e define os listeners
        setupClickListeners()

        // Verifica permissões iniciais
        checkStoragePermissions()
    }

    private val STORAGE_PERMISSION_CODE = 1

    private fun setupToolbar() {
        val toolbar = findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        
        toolbar.setNavigationOnClickListener {
            toggleTheme()
        }
    }

    private fun toggleTheme() {
        val currentMode = AppCompatDelegate.getDefaultNightMode()
        if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            prefs.edit().putInt("theme_mode", AppCompatDelegate.MODE_NIGHT_NO).apply()
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            prefs.edit().putInt("theme_mode", AppCompatDelegate.MODE_NIGHT_YES).apply()
        }
        recreate()
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                Toast.makeText(this, getString(R.string.action_future_update), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_clean -> {
                Toast.makeText(this, getString(R.string.cleanup_clicked), Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                startActivity(Intent(this, SettingActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    private fun setupClickListeners() {
        val buttonIds = intArrayOf(
            R.id.btn_apk, R.id.btn_app, R.id.btn_prj, R.id.btn_odex,
            R.id.btn_sign, R.id.btn_verify, R.id.btn_db, R.id.btn_info,
            R.id.btn_settings, R.id.btn_exit
        )

        for (id in buttonIds) {
            findViewById<View>(id)?.setOnClickListener(this)
        }
    }

    override fun onClick(v: View) {
        val intent: Intent? = when (v.id) {
            R.id.btn_apk -> Intent(this, FileListActivity::class.java)
            R.id.btn_app -> Intent(this, UserAppActivity::class.java)
            R.id.btn_prj -> Intent(this, ProjectListActivity::class.java)
            R.id.btn_odex -> Intent(this, OdexPatchActivity::class.java)
            R.id.btn_sign -> Intent(this, SelectFileActivity::class.java)
            R.id.btn_verify -> Intent(this, VerifyActivity::class.java)
            R.id.btn_db -> Intent(this, KeyStoreListActivity::class.java)
            R.id.btn_info -> Intent(this, InfoActivity::class.java)
            R.id.btn_settings -> Intent(this, SettingActivity::class.java)
            R.id.btn_exit -> {
                finish()
                null
            }
            else -> null
        }

        intent?.let { startActivity(it) }
    }

    private fun checkStoragePermissions() {
        val permissions = mutableListOf<String>()
        
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            // Android 13+ exige permissões de mídia específicas
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_MEDIA_IMAGES) 
                != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                permissions.add(android.Manifest.permission.READ_MEDIA_IMAGES)
            }
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_MEDIA_VIDEO) 
                != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                permissions.add(android.Manifest.permission.READ_MEDIA_VIDEO)
            }
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_MEDIA_AUDIO) 
                != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                permissions.add(android.Manifest.permission.READ_MEDIA_AUDIO)
            }
        } else {
            // Android 12 e anteriores
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) 
                != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                permissions.add(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) 
                != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                permissions.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }

        if (permissions.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                this,
                permissions.toTypedArray(),
                STORAGE_PERMISSION_CODE
            )
        } else {
            // Se as permissões básicas já foram concedidas, verifica o MANAGE_EXTERNAL_STORAGE no Android 11+
            checkAllFilesAccess()
        }
    }

    private fun checkAllFilesAccess() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            if (!android.os.Environment.isExternalStorageManager()) {
                // Mostra um diálogo explicativo antes de mandar para as configurações
                androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle(R.string.permission_needed)
                    .setMessage(R.string.permission_all_files_desc)
                    .setPositiveButton(R.string.settings_button) { _, _ ->
                        try {
                            val intent = Intent(android.provider.Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                            intent.addCategory("android.intent.category.DEFAULT")
                            intent.data = android.net.Uri.parse(String.format("package:%s", applicationContext.packageName))
                            startActivity(intent)
                        } catch (e: Exception) {
                            val intent = Intent(android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                            startActivity(intent)
                        }
                    }
                    .setNegativeButton(R.string.colormixer_cancel, null)
                    .show()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == STORAGE_PERMISSION_CODE) {
            val allGranted = grantResults.isNotEmpty() && grantResults.all { it == android.content.pm.PackageManager.PERMISSION_GRANTED }
            if (allGranted) {
                // Após conceder permissões básicas, verifica se precisa de acesso total
                checkAllFilesAccess()
            } else {
                Toast.makeText(this, getString(R.string.storage_permission_required), Toast.LENGTH_LONG).show()
            }
        }
    }
}
