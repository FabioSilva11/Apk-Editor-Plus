package com.saas.apkeditorplus

import android.os.Bundle
import android.content.Intent
import com.saas.apkeditorplus.utils.Verify
import android.widget.TextView

class VerifyActivity : BaseActivity() {
    
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify)
        
        textView = findViewById(R.id.verify_text_view)
        
        // Abre o seletor de arquivos ao iniciar se for a primeira vez
        if (savedInstanceState == null) {
            val intent = Intent(this, FileListActivity::class.java)
            intent.putExtra("select_for_verify", true)
            startActivityForResult(intent, 1001)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001 && resultCode == RESULT_OK) {
            val apkPath = data?.getStringExtra("apkPath")
            if (apkPath != null) {
                verifyApk(apkPath)
            }
        } else if (requestCode == 1001 && resultCode == RESULT_CANCELED) {
            // Se o usuário cancelou a seleção sem escolher nada, fecha a atividade
            if (textView.text.isEmpty()) {
                finish()
            }
        }
    }

    private fun verifyApk(path: String) {
        textView.text = "Verifying...\n$path"
        
        // Executamos em uma thread separada para não travar a UI
        Thread {
            val result = Verify.verify(path)
            runOnUiThread {
                textView.text = result
            }
        }.start()
    }
}
