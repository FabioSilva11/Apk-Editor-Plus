package com.saas.apkeditorplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.widget.LinearLayout

class SettingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_activity)

        findViewById<LinearLayout>(R.id.btn_editor_settings).setOnClickListener {
            startActivity(Intent(this, SettingEditorActivity::class.java))
        }
    }
}
