package com.saas.apkeditorplus

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

open class BaseActivity : AppCompatActivity() {

    lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        // Carrega as SharedPreferences
        prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)
        
        // Aplica o tema
        applyPersistedTheme()

        if (shouldHideActionBar()) {
            supportRequestWindowFeature(android.view.Window.FEATURE_NO_TITLE)
            supportActionBar?.hide()
        }
        
        super.onCreate(savedInstanceState)
    }

    open fun shouldHideActionBar(): Boolean = true

    private fun applyPersistedTheme() {
        val themeMode = prefs.getInt("theme_mode", AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        if (AppCompatDelegate.getDefaultNightMode() != themeMode) {
            AppCompatDelegate.setDefaultNightMode(themeMode)
        }
        setTheme(R.style.Theme_ApkEditorPlus_NoActionBar)
    }
}
