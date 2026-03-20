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

        val cbLineNumbers = findViewById<CheckBox>(R.id.cb_show_line_numbers)

        cbLineNumbers.isChecked = prefs.getBoolean("editor_show_line_numbers", true)
        cbLineNumbers.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean("editor_show_line_numbers", isChecked).apply()
        }
    }
}
