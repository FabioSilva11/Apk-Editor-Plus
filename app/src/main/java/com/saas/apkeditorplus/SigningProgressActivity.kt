package com.saas.apkeditorplus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.File

class SigningProgressActivity : BaseActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var tvStatus: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var layoutButtons: View
    private lateinit var btnViewOutput: Button
    private lateinit var btnFinish: Button

    private var inputPath: String? = null
    private var outputPath: String? = null
    private var ksPath: String? = null
    private var ksPass: String? = null
    private var alias: String? = null
    private var keyPass: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signing_progress)

        // Inicializa views
        tvTitle = findViewById(R.id.tv_title)
        tvStatus = findViewById(R.id.tv_status)
        progressBar = findViewById(R.id.progress_bar)
        layoutButtons = findViewById(R.id.layout_buttons)
        btnViewOutput = findViewById(R.id.btn_view_output)
        btnFinish = findViewById(R.id.btn_finish)

        // Pega dados da Intent
        inputPath = intent.getStringExtra("inputPath")
        outputPath = intent.getStringExtra("outputPath")
        ksPath = intent.getStringExtra("ksPath")
        ksPass = intent.getStringExtra("ksPass")
        alias = intent.getStringExtra("alias")
        keyPass = intent.getStringExtra("keyPass")

        btnFinish.setOnClickListener { finish() }
        btnViewOutput.setOnClickListener { openOutputFolder() }

        startSigning()
    }

    private fun startSigning() {
        val inFile = File(inputPath ?: return)
        val outFile = File(outputPath ?: return)
        val ksFile = File(ksPath ?: return)
        
        Thread {
            val signer = ApkSignerManager()
            signer.signApk(
                inFile,
                outFile,
                ksFile,
                ksPass?.toCharArray() ?: charArrayOf(),
                alias ?: "",
                keyPass?.toCharArray() ?: charArrayOf(),
                object : ApkSignerManager.SignerListener {
                    override fun onStart() {
                        updateUI(getString(R.string.signing_started), false)
                    }

                    override fun onProgress(message: String) {
                        updateUI(message, false)
                    }

                    override fun onSuccess() {
                        updateUI(getString(R.string.success_apk_signed), true)
                    }

                    override fun onError(message: String) {
                        updateUI(getString(R.string.error_label, message), true, isError = true)
                    }
                }
            )
        }.start()
    }

    private fun updateUI(message: String, isFinished: Boolean, isError: Boolean = false) {
        runOnUiThread {
            tvStatus.text = message
            if (isFinished) {
                progressBar.visibility = View.GONE
                layoutButtons.visibility = View.VISIBLE
                if (isError) {
                    tvTitle.text = getString(R.string.signing_failed)
                    btnViewOutput.visibility = View.GONE
                } else {
                    tvTitle.text = getString(R.string.signing_completed)
                }
            }
        }
    }

    private fun openOutputFolder() {
        val file = File(outputPath ?: return)
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        val uri = Uri.parse(file.parent)
        intent.setDataAndType(uri, "*/*")
        // Como o Android pode não ter um gerenciador de arquivos padrão que aceite isso bem,
        // vamos tentar abrir o diretório usando o FileListActivity do próprio app se possível,
        // ou apenas terminar e deixar o usuário ver na lista.
        // Mas por requisição do usuário "ver a pasta de saída", vamos tentar o FileListActivity.
        
        val resultIntent = Intent()
        resultIntent.putExtra("targetPath", file.parent)
        setResult(RESULT_OK, resultIntent)
        finish()
    }
}
