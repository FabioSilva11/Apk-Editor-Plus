package com.saas.apkeditorplus.full

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.text.InputType
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.saas.apkeditorplus.FullEditActivity
import com.saas.apkeditorplus.R
import com.saas.apkeditorplus.TextEditBigActivity
import java.io.File
import java.util.Locale

class StringFragment : Fragment() {
    private data class LanguageOption(
        val code: String,
        val label: String
    )

    private lateinit var apkPath: String
    private lateinit var languageSpinner: Spinner
    private lateinit var listView: ListView
    private lateinit var progressBar: ProgressBar
    private lateinit var keywordEdit: EditText
    private lateinit var emptyView: TextView
    private lateinit var languageAdapter: ArrayAdapter<String>

    private var allItems = emptyList<FullEditRepository.StringResourceItem>()
    private var visibleItems = emptyList<FullEditRepository.StringResourceItem>()
    private var stringsEditorTempFile: File? = null
    private var modifiedResourcesFile: File? = null
    private var availableLocales = emptyList<String>()
    private var selectedLocaleQualifier: String = ""
    private var updatingSpinnerSelection = false

    private val editStringsLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode != Activity.RESULT_OK) {
            return@registerForActivityResult
        }
        val editorFile = stringsEditorTempFile ?: return@registerForActivityResult
        if (!editorFile.exists()) {
            return@registerForActivityResult
        }
        progressBar.visibility = View.VISIBLE
        Thread {
            val compileResult = runCatching {
                FullEditWorkspaceManager.applyEditedStringsFile(
                    context = requireContext(),
                    apkPath = apkPath,
                    localeQualifier = selectedLocaleQualifier,
                    editedStringsXml = editorFile
                )
            }
            if (!isAdded) {
                return@Thread
            }
            requireActivity().runOnUiThread {
                progressBar.visibility = View.GONE
                compileResult.onSuccess { resourcesFile ->
                    modifiedResourcesFile = resourcesFile
                    registerModifiedResources(resourcesFile)
                    loadStrings()
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.file_saved),
                        Toast.LENGTH_SHORT
                    ).show()
                }.onFailure { error ->
                    Toast.makeText(
                        requireContext(),
                        error.message ?: getString(R.string.failed),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }.start()
    }

    companion object {
        private const val ARG_APK_PATH = "apk_path"

        fun newInstance(apkPath: String): StringFragment {
            return StringFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_APK_PATH, apkPath)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_full_strings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apkPath = requireArguments().getString(ARG_APK_PATH).orEmpty()
        languageSpinner = view.findViewById(R.id.language_spinner)
        listView = view.findViewById(R.id.string_list)
        progressBar = view.findViewById(R.id.progress_bar)
        keywordEdit = view.findViewById(R.id.keyword_edit)
        emptyView = view.findViewById(R.id.empty_view)

        listView.emptyView = emptyView
        listView.adapter = StringListAdapter()
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            visibleItems.getOrNull(position)?.let(::showEditDialog)
        }
        listView.onItemLongClickListener = AdapterView.OnItemLongClickListener { _, _, position, _ ->
            val item = visibleItems.getOrNull(position) ?: return@OnItemLongClickListener false
            copyToClipboard(item.name)
            true
        }

        languageAdapter = ArrayAdapter(
            requireContext(),
            R.layout.item_full_edit_spinner,
            mutableListOf<String>()
        ).apply {
            setDropDownViewResource(R.layout.item_full_edit_spinner_dropdown)
        }
        languageSpinner.adapter = languageAdapter
        languageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (updatingSpinnerSelection) {
                    return
                }
                val qualifier = availableLocales.getOrNull(position) ?: return
                if (selectedLocaleQualifier != qualifier) {
                    selectedLocaleQualifier = qualifier
                    loadStrings()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
        }

        keywordEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                applyFilter(s?.toString().orEmpty())
            }

            override fun afterTextChanged(s: Editable?) = Unit
        })

        view.findViewById<View>(R.id.search_button).setOnClickListener {
            applyFilter(keywordEdit.text.toString())
        }
        view.findViewById<View>(R.id.action_add_button).setOnClickListener {
            showAddLanguageDialog()
        }
        view.findViewById<View>(R.id.open_editor_button).setOnClickListener {
            openStringsEditor()
        }

        loadLocales()
    }

    private fun loadLocales() {
        progressBar.visibility = View.VISIBLE
        emptyView.setText(R.string.loading)
        Thread {
            val result = runCatching {
                FullEditWorkspaceManager.listStringLocales(requireContext(), apkPath)
            }
            if (!isAdded) {
                return@Thread
            }
            requireActivity().runOnUiThread {
                result.onSuccess { items ->
                    val locales = items.ifEmpty { listOf("") }
                    val resolvedLocale = resolveSelectedLocale(locales)
                    updateLanguageSpinner(locales, resolvedLocale)
                    selectedLocaleQualifier = resolvedLocale
                    loadStrings()
                }.onFailure { error ->
                    progressBar.visibility = View.GONE
                    allItems = emptyList()
                    visibleItems = emptyList()
                    availableLocales = emptyList()
                    languageAdapter.clear()
                    (listView.adapter as BaseAdapter).notifyDataSetChanged()
                    emptyView.text = error.message ?: getString(R.string.general_error, "")
                }
            }
        }.start()
    }

    private fun loadStrings() {
        progressBar.visibility = View.VISIBLE
        emptyView.setText(R.string.loading)
        Thread {
            val result = runCatching {
                FullEditWorkspaceManager.readStringResources(
                    requireContext(),
                    apkPath,
                    selectedLocaleQualifier
                )
            }
            if (!isAdded) {
                return@Thread
            }
            requireActivity().runOnUiThread {
                progressBar.visibility = View.GONE
                result.onSuccess { items ->
                    allItems = items
                    applyFilter(keywordEdit.text.toString())
                    emptyView.setText(
                        if (items.isEmpty()) {
                            R.string.full_edit_no_string_resources
                        } else {
                            R.string.not_found
                        }
                    )
                }.onFailure { error ->
                    allItems = emptyList()
                    visibleItems = emptyList()
                    (listView.adapter as BaseAdapter).notifyDataSetChanged()
                    emptyView.text = error.message ?: getString(R.string.general_error, "")
                }
            }
        }.start()
    }

    private fun showEditDialog(item: FullEditRepository.StringResourceItem) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_string_value, null, false)
        val keyView = dialogView.findViewById<TextView>(R.id.key)
        val valueEdit = dialogView.findViewById<EditText>(R.id.value)
        keyView.text = item.name
        keyView.setOnClickListener { copyToClipboard(item.name) }
        valueEdit.setText(item.value.orEmpty())
        valueEdit.setSelection(valueEdit.text.length)

        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.edit_string_value)
            .setView(dialogView)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(android.R.string.ok, null)
            .create()

        dialog.setOnShowListener {
            dialog.getButton(androidx.appcompat.app.AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val newValue = valueEdit.text.toString()
                if (newValue == item.value.orEmpty()) {
                    dialog.dismiss()
                    return@setOnClickListener
                }
                dialog.dismiss()
                saveStringValue(item, newValue)
            }
        }

        dialog.show()
    }

    private fun saveStringValue(
        item: FullEditRepository.StringResourceItem,
        newValue: String
    ) {
        progressBar.visibility = View.VISIBLE
        Thread {
            val result = runCatching {
                FullEditWorkspaceManager.saveSingleStringOverride(
                    context = requireContext(),
                    apkPath = apkPath,
                    localeQualifier = selectedLocaleQualifier,
                    name = item.name,
                    newValue = newValue
                )
            }
            if (!isAdded) {
                return@Thread
            }
            requireActivity().runOnUiThread {
                progressBar.visibility = View.GONE
                result.onSuccess { resourcesFile ->
                    modifiedResourcesFile = resourcesFile
                    registerModifiedResources(resourcesFile)
                    loadStrings()
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.file_saved),
                        Toast.LENGTH_SHORT
                    ).show()
                }.onFailure { error ->
                    Toast.makeText(
                        requireContext(),
                        error.message ?: getString(R.string.failed),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }.start()
    }

    private fun registerModifiedResources(resourcesFile: File) {
        (activity as? FullEditActivity)?.registerModifiedFile(
            FullEditRepository.RESOURCES_ENTRY,
            resourcesFile.absolutePath
        )
    }

    private fun openStringsEditor() {
        progressBar.visibility = View.VISIBLE
        Thread {
            val result = runCatching {
                FullEditWorkspaceManager.exportStringEditorFile(
                    requireContext(),
                    apkPath,
                    selectedLocaleQualifier
                )
            }
            if (!isAdded) {
                return@Thread
            }
            requireActivity().runOnUiThread {
                progressBar.visibility = View.GONE
                result.onSuccess { xmlFile ->
                    stringsEditorTempFile = xmlFile
                    editStringsLauncher.launch(
                        Intent(requireContext(), TextEditBigActivity::class.java).apply {
                            putExtra("filePath", xmlFile.absolutePath)
                            putExtra("fileName", "strings.xml")
                        }
                    )
                }.onFailure { error ->
                    Toast.makeText(
                        requireContext(),
                        error.message ?: getString(R.string.failed),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }.start()
    }

    private fun showAddLanguageDialog() {
        val options = buildLanguageOptions()
        val dialogContainer = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            val padding = (16 * resources.displayMetrics.density).toInt()
            setPadding(padding, padding, padding, 0)
        }

        val picker = Spinner(requireContext())
        val codeEdit = EditText(requireContext()).apply {
            hint = "pt or pt-rBR"
            inputType = InputType.TYPE_CLASS_TEXT
        }

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            options.map { it.label }
        )
        picker.adapter = adapter
        picker.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                codeEdit.setText(options.getOrNull(position)?.code.orEmpty())
                codeEdit.setSelection(codeEdit.text.length)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
        }

        dialogContainer.addView(picker)
        dialogContainer.addView(codeEdit)

        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.add_a_language)
            .setView(dialogContainer)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(R.string.create, null)
            .create()

        dialog.setOnShowListener {
            dialog.getButton(androidx.appcompat.app.AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val qualifier = normalizeLocaleInput(codeEdit.text.toString())
                if (qualifier == null) {
                    Toast.makeText(requireContext(), getString(R.string.invalid_lang_code), Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (qualifier in availableLocales) {
                    Toast.makeText(requireContext(), getString(R.string.lang_exist), Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                dialog.dismiss()
                progressBar.visibility = View.VISIBLE
                Thread {
                    val result = runCatching {
                        FullEditWorkspaceManager.createLocaleFromDefault(
                            context = requireContext(),
                            apkPath = apkPath,
                            localeQualifier = qualifier
                        )
                    }
                    if (!isAdded) {
                        return@Thread
                    }
                    requireActivity().runOnUiThread {
                        progressBar.visibility = View.GONE
                        result.onSuccess { resourcesFile ->
                            modifiedResourcesFile = resourcesFile
                            selectedLocaleQualifier = qualifier
                            registerModifiedResources(resourcesFile)
                            loadLocales()
                            Toast.makeText(requireContext(), getString(R.string.file_saved), Toast.LENGTH_SHORT).show()
                        }.onFailure { error ->
                            Toast.makeText(
                                requireContext(),
                                error.message ?: getString(R.string.failed),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }.start()
            }
        }
        dialog.show()
    }

    private fun buildLanguageOptions(): List<LanguageOption> {
        return Locale.getISOLanguages()
            .map { code ->
                val locale = Locale(code)
                val displayName = locale.getDisplayLanguage(Locale.ENGLISH)
                    .takeIf { it.isNotBlank() }
                    ?: code
                LanguageOption(
                    code = code.lowercase(Locale.ROOT),
                    label = "${displayName.replaceFirstChar { ch ->
                        if (ch.isLowerCase()) ch.titlecase(Locale.ENGLISH) else ch.toString()
                    }} (${code.lowercase(Locale.ROOT)})"
                )
            }
            .sortedBy { it.label.lowercase(Locale.ROOT) }
    }

    private fun normalizeLocaleInput(rawInput: String): String? {
        val normalized = rawInput.trim()
            .replace('_', '-')
            .removePrefix("-")
        if (normalized.isBlank()) {
            return null
        }
        val parts = normalized.split('-').filter { it.isNotBlank() }
        val language = parts.firstOrNull()?.lowercase(Locale.ROOT) ?: return null
        if (!Regex("^[a-z]{2,3}$").matches(language)) {
            return null
        }
        if (parts.size == 1) {
            return "-$language"
        }
        val regionPart = parts.drop(1)
            .joinToString("-")
            .removePrefix("r")
            .uppercase(Locale.ROOT)
        return when {
            Regex("^[A-Z]{2}$").matches(regionPart) -> "-$language-r$regionPart"
            Regex("^\\d{3}$").matches(regionPart) -> "-$language-r$regionPart"
            else -> null
        }
    }

    private fun applyFilter(query: String) {
        val normalizedQuery = query.trim()
        visibleItems = if (normalizedQuery.isEmpty()) {
            allItems
        } else {
            allItems.filter { item ->
                item.name.contains(normalizedQuery, ignoreCase = true) ||
                    item.value.orEmpty().contains(normalizedQuery, ignoreCase = true)
            }
        }
        (listView.adapter as BaseAdapter).notifyDataSetChanged()
    }

    private fun updateLanguageSpinner(locales: List<String>, selectedQualifier: String) {
        val orderedOptions = locales
            .distinct()
            .map { qualifier -> qualifier to formatLocaleLabel(qualifier) }
            .sortedBy { it.second.lowercase(Locale.ROOT) }

        availableLocales = orderedOptions.map { it.first }
        val labels = orderedOptions.map { it.second }
        val selectedIndex = availableLocales.indexOf(selectedQualifier).coerceAtLeast(0)

        updatingSpinnerSelection = true
        languageAdapter.clear()
        languageAdapter.addAll(labels)
        languageAdapter.notifyDataSetChanged()
        languageSpinner.setSelection(selectedIndex, false)
        updatingSpinnerSelection = false
    }

    private fun resolveSelectedLocale(locales: List<String>): String {
        if (selectedLocaleQualifier in locales) {
            return selectedLocaleQualifier
        }

        val deviceLocale = Locale.getDefault()
        val exactQualifier = buildString {
            append('-')
            append(deviceLocale.language)
            if (deviceLocale.country.isNotBlank()) {
                append("-r")
                append(deviceLocale.country.uppercase(Locale.ROOT))
            }
        }
        val languageOnlyQualifier = "-${deviceLocale.language}"

        return when {
            exactQualifier in locales -> exactQualifier
            languageOnlyQualifier in locales -> languageOnlyQualifier
            "" in locales -> ""
            else -> locales.first()
        }
    }

    private fun formatLocaleLabel(qualifier: String): String {
        if (qualifier.isBlank()) {
            return getString(R.string.default_language)
        }

        val languageTag = qualifier
            .removePrefix("-")
            .replace("-r", "-")
        val locale = Locale.forLanguageTag(languageTag)
        val displayLanguage = locale
            .getDisplayLanguage(Locale.ENGLISH)
            .takeIf { it.isNotBlank() }
            ?: languageTag

        return buildString {
            append(displayLanguage.replaceFirstChar { ch ->
                if (ch.isLowerCase()) {
                    ch.titlecase(Locale.ENGLISH)
                } else {
                    ch.toString()
                }
            })
            append(" (")
            append(qualifier)
            append(')')
        }
    }

    private fun copyToClipboard(text: String) {
        val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText("string_key", text))
        Toast.makeText(
            requireContext(),
            getString(R.string.copied_to_clipboard, text),
            Toast.LENGTH_SHORT
        ).show()
    }

    private inner class StringListAdapter : BaseAdapter() {
        override fun getCount(): Int = visibleItems.size

        override fun getItem(position: Int): Any = visibleItems[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowView = convertView
                ?: layoutInflater.inflate(R.layout.item_full_string, parent, false)
            val item = visibleItems[position]
            rowView.findViewById<TextView>(R.id.string_name).text = item.name
            rowView.findViewById<TextView>(R.id.string_value).text =
                item.value ?: getString(R.string.not_available)
            return rowView
        }
    }
}
