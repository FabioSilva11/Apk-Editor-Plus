package com.saas.apkeditorplus

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import io.github.rosemoe.sora.widget.CodeEditor
import java.io.File

class TextEditBigActivity : BaseActivity() {

    private lateinit var editor: CodeEditor
    private var filePath: String? = null
    private var originalText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_edit_big_activity)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        filePath = intent.getStringExtra("filePath")
        val fileName = intent.getStringExtra("fileName") ?: "Sem nome"
        supportActionBar?.title = fileName

        editor = findViewById(R.id.editor)
        setupEditor()
        loadFile()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_text_edit, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                showSearchDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showSearchDialog() {
        val input = EditText(this)
        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        input.layoutParams = lp
        input.hint = "Termo de busca"

        AlertDialog.Builder(this)
            .setTitle("Buscar")
            .setView(input)
            .setPositiveButton("Próximo") { _, _ ->
                val query = input.text.toString()
                if (query.isNotEmpty()) {
                    findNext(query)
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun findNext(query: String) {
        try {
            val text = editor.text.toString()
            val regex = Regex(Regex.escape(query), RegexOption.IGNORE_CASE)
            
            val startIndex = editor.cursor.right
            
            var match = regex.find(text, startIndex)
            if (match == null) {
                match = regex.find(text, 0)
            }
            
            if (match != null) {
                editor.setSelection(match.range.first, match.range.last + 1)
                editor.ensureSelectionVisible()
            } else {
                Toast.makeText(this, "Não encontrado", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Erro na busca: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        if (originalText != editor.text.toString()) {
            AlertDialog.Builder(this)
                .setTitle("Salvar alterações?")
                .setMessage("Você fez modificações que ainda não foram salvas.")
                .setPositiveButton("Salvar") { _, _ ->
                    saveFile()
                    finish()
                }
                .setNegativeButton("Descartar") { _, _ ->
                    finish()
                }
                .setNeutralButton("Cancelar", null)
                .show()
        } else {
            super.onBackPressed()
        }
    }

    private fun copyToClipboard() {
        if (editor.cursor.left != editor.cursor.right) {
            editor.copyText()
            Toast.makeText(this, "Copiado para a área de transferência", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Nada selecionado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun pasteFromClipboard() {
        // O SoraEditor lida com o clipboard internamente no pasteText()
        editor.pasteText()
    }

    private fun setupEditor() {
        editor.setTextSize(12f)
        editor.requestFocus()
    }

    private fun loadFile() {
        filePath?.let { path ->
            val file = File(path)
            if (file.exists()) {
                val content = file.readText()
                editor.setText(content)
                originalText = content
            }
        }
    }

    private fun saveFile() {
        filePath?.let { path ->
            try {
                val currentText = editor.text.toString()
                File(path).writeText(currentText)
                originalText = currentText
                Toast.makeText(this, "Arquivo salvo!", Toast.LENGTH_SHORT).show()
                setResult(RESULT_OK)
            } catch (e: Exception) {
                Toast.makeText(this, "Erro ao salvar: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun shouldHideActionBar(): Boolean = false
}
