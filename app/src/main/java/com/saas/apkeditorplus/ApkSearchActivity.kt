package com.saas.apkeditorplus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ApkSearchActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apksearch)
        
        val toolbar = findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.header_layout)
        toolbar.setNavigationOnClickListener { finish() }
        
        // Se houver lógica de busca, o subtítulo pode ser atualizado via:
        // toolbar.subtitle = "Buscando por: $keyword"
    }
}
