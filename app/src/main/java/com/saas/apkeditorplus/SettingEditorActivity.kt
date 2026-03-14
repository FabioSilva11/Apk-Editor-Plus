package com.saas.apkeditorplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup

class SettingEditorActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_editor_activity)

        findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener {
            finish()
        }

        val rgTheme = findViewById<RadioGroup>(R.id.rg_editor_theme)
        val cbLineNumbers = findViewById<CheckBox>(R.id.cb_show_line_numbers)

        // Carrega as configurações atuais do editor
        // Use "settings" shared preferences herdado de BaseActivity
        val currentTheme = prefs.getString("editor_theme", "darcula")
        if (currentTheme == "darcula") {
            findViewById<RadioButton>(R.id.rb_theme_darcula).isChecked = true
        } else {
            findViewById<RadioButton>(R.id.rb_theme_light).isChecked = true
        }

        rgTheme.setOnCheckedChangeListener { _, checkedId ->
            val themeName = if (checkedId == R.id.rb_theme_darcula) "darcula" else "light"
            prefs.edit().putString("editor_theme", themeName).apply()
        }

        cbLineNumbers.isChecked = prefs.getBoolean("editor_show_line_numbers", true)
        cbLineNumbers.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean("editor_show_line_numbers", isChecked).apply()
        }
    }
}
