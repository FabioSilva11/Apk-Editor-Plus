package com.saas.apkeditorplus

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

import com.google.android.material.color.DynamicColors

open class BaseActivity : AppCompatActivity() {

    lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        // Aplica cores dinâmicas se disponível
        DynamicColors.applyToActivityIfAvailable(this)

        // Carrega as SharedPreferences
        prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)
        
        // Aplica o tema
        applyPersistedTheme()
        
        super.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        if (!shouldHideActionBar()) {
            setupActionBar()
        } else {
            supportActionBar?.hide()
        }
    }

    open fun shouldHideActionBar(): Boolean = false

    protected open fun setupActionBar() {
        supportActionBar?.let { actionBar ->
            actionBar.setDisplayHomeAsUpEnabled(true)
            // O ícone de voltar padrão do Android costuma ser ic_back ou similar
        }
    }

    private fun applyPersistedTheme() {
        val themeMode = prefs.getInt("theme_mode", AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        if (AppCompatDelegate.getDefaultNightMode() != themeMode) {
            AppCompatDelegate.setDefaultNightMode(themeMode)
        }
        setTheme(R.style.Theme_MyApp)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
