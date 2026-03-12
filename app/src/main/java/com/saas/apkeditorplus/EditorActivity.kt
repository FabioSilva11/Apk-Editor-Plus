package com.saas.apkeditorplus

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import io.github.rosemoe.sora.langs.textmate.TextMateColorScheme
import io.github.rosemoe.sora.langs.textmate.TextMateLanguage
import io.github.rosemoe.sora.langs.textmate.registry.GrammarRegistry
import io.github.rosemoe.sora.langs.textmate.registry.ThemeRegistry
import io.github.rosemoe.sora.widget.CodeEditor
import java.io.File

class EditorActivity : BaseActivity() {

    private lateinit var editor: CodeEditor
    private lateinit var fileNameText: TextView
    private lateinit var saveBtn: ImageView
    private var filePath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editorutil_main)

        filePath = intent.getStringExtra("filePath")
        val fileName = intent.getStringExtra("fileName") ?: "Editor"

        editor = findViewById(R.id.editor)
        fileNameText = findViewById(R.id.filename)
        saveBtn = findViewById(R.id.saveBtn)

        fileNameText.text = fileName

        setupEditor()
        loadFile()

        saveBtn.setOnClickListener {
            saveFile()
        }
    }

    private fun setupEditor() {
        // Configuração básica do Sora Editor
        try {
            // Em 0.23.5, as configurações de TextMate são feitas via GrammarRegistry e ThemeRegistry
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun loadFile() {
        filePath?.let { path ->
            val file = File(path)
            if (file.exists()) {
                editor.setText(file.readText())
            }
        }
    }

    private fun saveFile() {
        filePath?.let { path ->
            try {
                // Na v0.23.5, usamos getText() e convertemos para string
                File(path).writeText(editor.getText().toString())
                Toast.makeText(this, "Arquivo salvo com sucesso!", Toast.LENGTH_SHORT).show()
                setResult(RESULT_OK)
            } catch (e: Exception) {
                Toast.makeText(this, "Erro ao salvar: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
