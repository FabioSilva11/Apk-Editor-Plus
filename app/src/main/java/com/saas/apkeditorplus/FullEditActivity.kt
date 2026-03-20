package com.saas.apkeditorplus

import android.os.Bundle
import android.widget.ListView
import android.widget.ProgressBar

class FullEditActivity : BaseActivity() {

    private lateinit var listView: ListView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fulledit)
        
        listView = findViewById(R.id.application_list)
        progressBar = findViewById(R.id.progress_bar)
        
        val apkPath = intent.getStringExtra("apkPath")
        // No momento a lista está vazia como solicitado
    }

    override fun setupActionBar() {
        super.setupActionBar()
        supportActionBar?.let { actionBar ->
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setTitle(R.string.full_edit)
        }
    }

    override fun shouldHideActionBar(): Boolean = false
}
