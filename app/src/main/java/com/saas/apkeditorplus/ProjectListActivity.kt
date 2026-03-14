package com.saas.apkeditorplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProjectListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projectlist)
        
        val toolbar = findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.header_layout)
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.title = getString(R.string.action_prj)
    }
}
