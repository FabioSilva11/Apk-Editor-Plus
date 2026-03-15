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
import android.graphics.Typeface
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import io.github.rosemoe.sora.event.ContentChangeEvent
import io.github.rosemoe.sora.event.PublishSearchResultEvent
import io.github.rosemoe.sora.event.SelectionChangeEvent
import io.github.rosemoe.sora.langs.textmate.TextMateLanguage
import io.github.rosemoe.sora.langs.textmate.registry.FileProviderRegistry
import io.github.rosemoe.sora.langs.textmate.registry.ThemeRegistry
import io.github.rosemoe.sora.langs.textmate.registry.GrammarRegistry
import io.github.rosemoe.sora.langs.textmate.registry.provider.AssetsFileResolver
import io.github.rosemoe.sora.langs.textmate.registry.model.ThemeModel
import io.github.rosemoe.sora.langs.textmate.registry.model.DefaultGrammarDefinition
import io.github.rosemoe.sora.langs.textmate.TextMateColorScheme
import io.github.rosemoe.sora.text.LineSeparator
import io.github.rosemoe.sora.util.regex.RegexBackrefGrammar
import io.github.rosemoe.sora.widget.CodeEditor
import io.github.rosemoe.sora.widget.EditorSearcher
import io.github.rosemoe.sora.widget.subscribeAlways
import org.eclipse.tm4e.core.registry.IThemeSource
import org.eclipse.tm4e.core.registry.IGrammarSource
import java.io.File
import java.io.InputStreamReader
import java.util.regex.PatternSyntaxException

class TextEditBigActivity : BaseActivity() {

    private lateinit var editor: CodeEditor
    private lateinit var searchPanel: LinearLayout
    private lateinit var searchEditor: EditText
    private lateinit var replaceEditor: EditText
    private lateinit var positionDisplay: TextView
    private lateinit var searchOptionsButton: ImageView
    private lateinit var searchMenu: PopupMenu
    private var searchOptions = EditorSearcher.SearchOptions(EditorSearcher.SearchOptions.TYPE_NORMAL, true)
    
    private var filePath: String? = null
    private var originalText: String? = null
    private var undoItem: MenuItem? = null
    private var redoItem: MenuItem? = null

    companion object {
        val SYMBOLS = arrayOf(
            "->", "{", "}", "(", ")",
            ",", ".", ";", "\"", "?",
            "+", "-", "*", "/", "<",
            ">", "[", "]", ":"
        )
        val SYMBOL_INSERT_TEXT = arrayOf(
            "\t", "{}", "}", "(", ")",
            ",", ".", ";", "\"", "?",
            "+", "-", "*", "/", "<",
            ">", "[", "]", ":"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_edit_big_activity)

        val toolbar = findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        filePath = intent.getStringExtra("filePath")
        val fileName = intent.getStringExtra("fileName") ?: getString(R.string.unnamed)
        supportActionBar?.title = fileName

        editor = findViewById(R.id.editor)
        searchPanel = findViewById(R.id.search_panel)
        searchEditor = findViewById(R.id.search_editor)
        replaceEditor = findViewById(R.id.replace_editor)
        positionDisplay = findViewById(R.id.position_display)
        searchOptionsButton = findViewById(R.id.search_options)

        setupEditor()
        setupSearchPanel()
        setupSymbolInput()
        loadFile()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_text_edit, menu)
        undoItem = menu?.findItem(R.id.text_undo)
        redoItem = menu?.findItem(R.id.text_redo)
        updateUndoRedoState()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.text_undo -> {
                editor.undo()
                true
            }
            R.id.text_redo -> {
                editor.redo()
                true
            }
            R.id.action_search_panel -> {
                toggleSearchPanel()
                true
            }
            R.id.action_save -> {
                saveFile()
                true
            }
            R.id.goto_end -> {
                editor.setSelection(editor.text.lineCount - 1, editor.text.getColumnCount(editor.text.lineCount - 1))
                true
            }
            R.id.move_up -> {
                editor.moveSelection(io.github.rosemoe.sora.widget.SelectionMovement.UP)
                true
            }
            R.id.move_down -> {
                editor.moveSelection(io.github.rosemoe.sora.widget.SelectionMovement.DOWN)
                true
            }
            R.id.home -> {
                editor.moveSelection(io.github.rosemoe.sora.widget.SelectionMovement.LINE_START)
                true
            }
            R.id.end -> {
                editor.moveSelection(io.github.rosemoe.sora.widget.SelectionMovement.LINE_END)
                true
            }
            R.id.text_wordwrap -> {
                item.isChecked = !item.isChecked
                editor.isWordwrap = item.isChecked
                true
            }
            R.id.editor_line_number -> {
                item.isChecked = !item.isChecked
                editor.isLineNumberEnabled = item.isChecked
                true
            }
            R.id.pin_line_number -> {
                item.isChecked = !item.isChecked
                editor.setPinLineNumber(item.isChecked)
                true
            }
            R.id.magnifier -> {
                item.isChecked = !item.isChecked
                editor.getComponent(io.github.rosemoe.sora.widget.component.Magnifier::class.java).isEnabled = item.isChecked
                true
            }
            R.id.switch_language -> {
                chooseLanguage()
                true
            }
            R.id.switch_colors -> {
                chooseTheme()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun chooseLanguage() {
        val languageOptions = arrayOf("XML", "Java", "Smali", "None")
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle(R.string.switch_language)
            .setItems(languageOptions) { _, which ->
                val scopeName = when (which) {
                    0 -> "text.xml"
                    1 -> "source.java"
                    2 -> "source.smali"
                    else -> null
                }
                if (scopeName != null) {
                    ensureTextmateTheme()
                    editor.setEditorLanguage(TextMateLanguage.create(scopeName, true))
                } else {
                    editor.setEditorLanguage(null)
                }
                resetColorScheme()
            }
            .show()
    }

    private fun ensureTextmateTheme() {
        editor.colorScheme = TextMateColorScheme.create(ThemeRegistry.getInstance())
    }

    private fun resetColorScheme() {
        val current = editor.colorScheme
        editor.colorScheme = current
    }

    private fun chooseTheme() {
        val themes = arrayOf("Darcula", "Light", "Ayu Dark", "Quiet Light", "Solarized Dark")
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle(R.string.switch_color_scheme)
            .setItems(themes) { _, which ->
                val themeName = when (which) {
                    0 -> "darcula"
                    1 -> "light"
                    2 -> "ayu-dark"
                    3 -> "quietlight"
                    4 -> "solarized_dark"
                    else -> "darcula"
                }
                ThemeRegistry.getInstance().setTheme(themeName)
                ensureTextmateTheme()
                // resetColorScheme() is no longer needed as ensureTextmateTheme sets a new scheme
                // Salvar a escolha do tema
                prefs.edit().putString("editor_theme", themeName).apply()
            }
            .show()
    }

    private fun setupSearchPanel() {
        findViewById<Button>(R.id.btn_goto_prev).setOnClickListener { editor.searcher.gotoPrevious() }
        findViewById<Button>(R.id.btn_goto_next).setOnClickListener { editor.searcher.gotoNext() }
        findViewById<Button>(R.id.btn_replace).setOnClickListener { 
            val query = searchEditor.text.toString()
            val replacement = replaceEditor.text.toString()
            if (query.isNotEmpty()) {
                editor.searcher.replaceCurrentMatch(replacement)
            }
        }
        findViewById<Button>(R.id.btn_replace_all).setOnClickListener { 
            val query = searchEditor.text.toString()
            val replacement = replaceEditor.text.toString()
            if (query.isNotEmpty()) {
                editor.searcher.replaceAll(replacement)
            }
        }

        searchEditor.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                updateSearch()
            }
        })

        searchMenu = PopupMenu(this, searchOptionsButton)
        searchMenu.inflate(R.menu.menu_search_options) // We'll need this menu or create it
        searchMenu.setOnMenuItemClickListener { item ->
            item.isChecked = !item.isChecked
            computeSearchOptions()
            updateSearch()
            true
        }
        searchOptionsButton.setOnClickListener { searchMenu.show() }
    }

    private fun computeSearchOptions() {
        val regex = searchMenu.menu.findItem(R.id.search_option_regex)?.isChecked ?: false
        val matchCase = searchMenu.menu.findItem(R.id.search_option_match_case)?.isChecked ?: true
        val wholeWord = searchMenu.menu.findItem(R.id.search_option_whole_word)?.isChecked ?: false

        var type = EditorSearcher.SearchOptions.TYPE_NORMAL
        if (regex) type = EditorSearcher.SearchOptions.TYPE_REGULAR_EXPRESSION
        if (wholeWord) type = EditorSearcher.SearchOptions.TYPE_WHOLE_WORD

        searchOptions = EditorSearcher.SearchOptions(type, !matchCase, RegexBackrefGrammar.DEFAULT)
    }

    private fun updateSearch() {
        val query = searchEditor.text.toString()
        if (query.isNotEmpty()) {
            try {
                editor.searcher.search(query, searchOptions)
            } catch (e: PatternSyntaxException) {
                // Ignore regex errors while typing
            }
        } else {
            editor.searcher.stopSearch()
        }
    }

    private fun toggleSearchPanel() {
        if (searchPanel.visibility == View.VISIBLE) {
            searchPanel.visibility = View.GONE
            editor.searcher.stopSearch()
        } else {
            searchPanel.visibility = View.VISIBLE
            searchEditor.requestFocus()
        }
    }

    private fun setupSymbolInput() {
        val symbolInput = findViewById<io.github.rosemoe.sora.widget.SymbolInputView>(R.id.symbol_input)
        symbolInput.bindEditor(editor)
        symbolInput.addSymbols(SYMBOLS, SYMBOL_INSERT_TEXT)
    }

    private fun updatePositionText() {
        val cursor = editor.cursor
        val content = editor.text
        val line = cursor.leftLine
        val column = cursor.leftColumn
        
        var text = "${line + 1}:${column};${cursor.left} "
        
        if (cursor.isSelected) {
            text += "(${cursor.right - cursor.left} chars)"
        } else {
            if (content.getColumnCount(line) == column) {
                text += "(<${content.getLine(line).lineSeparator.let { if (it == LineSeparator.NONE) "EOF" else it.name }}>)"
            } else {
                text += "(" + content.getLine(line).codePointStringAt(column).escapeCodePointIfNecessary() + ")"
            }
        }

        if (editor.searcher.hasQuery()) {
            val count = editor.searcher.matchedPositionCount
            val index = editor.searcher.currentMatchedPositionIndex
            text += if (count == 0) " (no match)" else " (${index + 1} of $count matches)"
        }

        positionDisplay.text = text
    }

    private fun updateUndoRedoState() {
        undoItem?.isEnabled = editor.canUndo()
        redoItem?.isEnabled = editor.canRedo()
    }

    override fun onBackPressed() {
        if (originalText != editor.text.toString()) {
            AlertDialog.Builder(this)
                .setTitle(R.string.save_changes)
                .setMessage(R.string.unsaved_changes_msg)
                .setPositiveButton(R.string.save) { _, _ ->
                    saveFile()
                    finish()
                }
                .setNegativeButton(R.string.discard) { _, _ ->
                    finish()
                }
                .setNeutralButton(R.string.colormixer_cancel, null)
                .show()
        } else {
            super.onBackPressed()
        }
    }

    private fun copyToClipboard() {
        if (editor.cursor.left != editor.cursor.right) {
            editor.copyText()
            Toast.makeText(this, getString(R.string.file_copied_toast), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.nothing_selected), Toast.LENGTH_SHORT).show()
        }
    }

    private fun pasteFromClipboard() {
        // O SoraEditor lida com o clipboard internamente no pasteText()
        editor.pasteText()
    }

    private fun setupEditor() {
        val fontSize = prefs.getFloat("editor_font_size", 14f)
        editor.setTextSize(fontSize)
        editor.requestFocus()
        
        // Configurações de exibição do editor
        editor.isLineNumberEnabled = prefs.getBoolean("editor_show_line_numbers", true)
        
        // Listeners do editor para atualizar UI
        editor.subscribeAlways<SelectionChangeEvent> { updatePositionText() }
        editor.subscribeAlways<PublishSearchResultEvent> { updatePositionText() }
        editor.subscribeAlways<ContentChangeEvent> { 
            updatePositionText()
            updateUndoRedoState()
        }
        
        try {
            // Inicializa o provedor de arquivos para o Assets
            FileProviderRegistry.getInstance().addFileProvider(AssetsFileResolver(assets))

            // Carregar temas utilizando ThemeModel e IThemeSource
            ThemeRegistry.getInstance().loadTheme(
                ThemeModel(
                    IThemeSource.fromInputStream(assets.open("textmate/darcula.json"), "darcula.json", null),
                    "darcula"
                ).apply { isDark = true }
            )
            ThemeRegistry.getInstance().loadTheme(
                ThemeModel(
                    IThemeSource.fromInputStream(assets.open("textmate/light.json"), "light.json", null),
                    "light"
                ).apply { isDark = false }
            )
            ThemeRegistry.getInstance().loadTheme(
                ThemeModel(
                    IThemeSource.fromInputStream(assets.open("textmate/ayu-dark.json"), "ayu-dark.json", null),
                    "ayu-dark"
                ).apply { isDark = true }
            )
            ThemeRegistry.getInstance().loadTheme(
                ThemeModel(
                    IThemeSource.fromInputStream(assets.open("textmate/quietlight.json"), "quietlight.json", null),
                    "quietlight"
                ).apply { isDark = false }
            )
            ThemeRegistry.getInstance().loadTheme(
                ThemeModel(
                    IThemeSource.fromInputStream(assets.open("textmate/solarized_dark.json"), "solarized_dark.json", null),
                    "solarized_dark"
                ).apply { isDark = true }
            )
            
            // Carregar gramáticas utilizando DefaultGrammarDefinition
            GrammarRegistry.getInstance().loadGrammar(
                DefaultGrammarDefinition.withGrammarSource(
                    IGrammarSource.fromInputStream(assets.open("textmate/xml.json"), "xml.json", null),
                    "xml",
                    "text.xml"
                )
            )
            GrammarRegistry.getInstance().loadGrammar(
                DefaultGrammarDefinition.withGrammarSource(
                    IGrammarSource.fromInputStream(assets.open("textmate/java.json"), "java.json", null),
                    "java",
                    "source.java"
                )
            )
            GrammarRegistry.getInstance().loadGrammar(
                DefaultGrammarDefinition.withGrammarSource(
                    IGrammarSource.fromInputStream(assets.open("textmate/smali.json"), "smali.json", null),
                    "smali",
                    "source.smali"
                )
            )

            // Identificação automática da linguagem pela extensão ou fallback para XML
            val ext = filePath?.substringAfterLast('.', "")?.lowercase() ?: ""
            val scopeName = when (ext) {
                "xml", "axml" -> "text.xml"
                "java" -> "source.java"
                "smali" -> "source.smali"
                else -> "text.xml" // Padrão solicitado: XML
            }

            if (scopeName != null) {
                val language = TextMateLanguage.create(scopeName, true)
                editor.setEditorLanguage(language)
            }
            
            // Aplicar o tema escolhido pelo usuário (DEPOIS de definir a linguagem)
            val userTheme = prefs.getString("editor_theme", "light") ?: "light"
            ThemeRegistry.getInstance().setTheme(userTheme)
            
            // Aplicar TextMateColorScheme ao editor
            ensureTextmateTheme()

        } catch (e: Exception) {
            e.printStackTrace()
            // Fallback para o tema padrão se o TextMate falhar
        }
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
                Toast.makeText(this, getString(R.string.file_saved_toast), Toast.LENGTH_SHORT).show()
                setResult(RESULT_OK)
            } catch (e: Exception) {
                Toast.makeText(this, getString(R.string.error_saving, e.message), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun shouldHideActionBar(): Boolean = false
}

fun CharSequence.codePointStringAt(index: Int): String {
    val cp = Character.codePointAt(this, index)
    return String(Character.toChars(cp))
}

fun String.escapeCodePointIfNecessary() =
    when (this) {
        "\n" -> "\\n"
        "\t" -> "\\t"
        "\r" -> "\\r"
        " " -> "<ws>"
        else -> this
    }

