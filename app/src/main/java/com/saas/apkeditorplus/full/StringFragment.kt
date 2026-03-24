package com.saas.apkeditorplus.full

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.saas.apkeditorplus.FullEditActivity
import com.saas.apkeditorplus.R
import com.saas.apkeditorplus.TextEditBigActivity
import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StringFragment : Fragment() {

    private data class LanguageOption(
        val qualifier: String,
        val label: String
    )

    private lateinit var languageSpinner: Spinner
    private lateinit var listView: ListView
    private lateinit var progressBar: ProgressBar
    private lateinit var keywordEdit: EditText
    private lateinit var emptyView: TextView
    private lateinit var languageAdapter: ArrayAdapter<String>

    private var languageOptions = emptyList<LanguageOption>()
    private var selectedQualifier: String = ""
    private var allItems = emptyList<FullEditRepository.StringResourceItem>()
    private var visibleItems = emptyList<FullEditRepository.StringResourceItem>()
    private var pendingEditorFile: File? = null

    private val editorLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val editedFile = pendingEditorFile ?: return@registerForActivityResult
        pendingEditorFile = null
        if (result.resultCode == Activity.RESULT_OK) {
            applyEditedStringsFile(editedFile)
        }
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
        languageSpinner = view.findViewById(R.id.language_spinner)
        listView = view.findViewById(R.id.string_list)
        progressBar = view.findViewById(R.id.progress_bar)
        keywordEdit = view.findViewById(R.id.keyword_edit)
        emptyView = view.findViewById(R.id.empty_view)

        listView.emptyView = emptyView
        listView.adapter = StringListAdapter()
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val item = visibleItems.getOrNull(position) ?: return@OnItemClickListener
            showEditValueDialog(item)
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
                val qualifier = languageOptions.getOrNull(position)?.qualifier ?: ""
                if (selectedQualifier != qualifier) {
                    selectedQualifier = qualifier
                    loadStrings()
                } else if (allItems.isEmpty()) {
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
            openCurrentLanguageInEditor()
        }

        loadLanguages()
    }

    private fun host(): FullEditActivity = requireActivity() as FullEditActivity

    private fun apkPath(): String = arguments?.getString(ARG_APK_PATH).orEmpty()

    private fun loadLanguages(targetQualifier: String? = selectedQualifier) {
        val context = requireContext().applicationContext
        val apkPath = apkPath()
        progressBar.visibility = View.VISIBLE
        emptyView.visibility = View.GONE

        viewLifecycleOwner.lifecycleScope.launch {
            val qualifiers = runCatching {
                withContext(Dispatchers.IO) {
                    FullEditWorkspaceManager.listStringLocales(context, apkPath)
                }
            }.getOrElse { error ->
                progressBar.visibility = View.GONE
                emptyView.visibility = View.VISIBLE
                emptyView.text = error.message ?: getString(R.string.failed)
                return@launch
            }

            languageOptions = qualifiers
                .ifEmpty { listOf("") }
                .map { qualifier ->
                    LanguageOption(
                        qualifier = qualifier,
                        label = FullEditLanguageCatalog.labelForQualifier(qualifier)
                    )
                }

            val targetIndex = languageOptions.indexOfFirst { it.qualifier == targetQualifier }
                .takeIf { it >= 0 }
                ?: 0
            selectedQualifier = languageOptions.getOrNull(targetIndex)?.qualifier.orEmpty()

            languageAdapter.clear()
            languageAdapter.addAll(languageOptions.map { it.label })
            languageAdapter.notifyDataSetChanged()
            languageSpinner.setSelection(targetIndex, false)
            loadStrings()
        }
    }

    private fun loadStrings() {
        val context = requireContext().applicationContext
        val apkPath = apkPath()
        progressBar.visibility = View.VISIBLE
        emptyView.visibility = View.GONE

        viewLifecycleOwner.lifecycleScope.launch {
            val items = runCatching {
                withContext(Dispatchers.IO) {
                    FullEditWorkspaceManager.readStringResources(context, apkPath, selectedQualifier)
                }
            }.getOrElse { error ->
                allItems = emptyList()
                visibleItems = emptyList()
                progressBar.visibility = View.GONE
                emptyView.visibility = View.VISIBLE
                emptyView.text = error.message ?: getString(R.string.failed)
                (listView.adapter as BaseAdapter).notifyDataSetChanged()
                return@launch
            }

            progressBar.visibility = View.GONE
            allItems = items
            applyFilter(keywordEdit.text.toString())
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

        emptyView.text = if (allItems.isEmpty()) {
            getString(R.string.full_edit_no_string_resources)
        } else {
            getString(R.string.not_found)
        }
        (listView.adapter as BaseAdapter).notifyDataSetChanged()
    }

    private fun showEditValueDialog(item: FullEditRepository.StringResourceItem) {
        val context = requireContext()
        val dialogView = layoutInflater.inflate(R.layout.dialog_string_value, null, false)
        val keyView = dialogView.findViewById<TextView>(R.id.key)
        val valueInput = dialogView.findViewById<EditText>(R.id.value)
        keyView.text = item.name
        valueInput.setText(item.value.orEmpty())
        valueInput.setSelection(valueInput.text?.length ?: 0)
        valueInput.inputType = InputType.TYPE_CLASS_TEXT or
            InputType.TYPE_TEXT_FLAG_MULTI_LINE or
            InputType.TYPE_TEXT_FLAG_CAP_SENTENCES

        AlertDialog.Builder(context)
            .setTitle(R.string.edit_string_value)
            .setView(dialogView)
            .setPositiveButton(R.string.save) { _, _ ->
                saveSingleValue(item.name, valueInput.text?.toString().orEmpty())
            }
            .setNeutralButton(R.string.copy_file_path) { _, _ ->
                copyKey(item.name)
            }
            .setNegativeButton(R.string.colormixer_cancel, null)
            .show()
    }

    private fun copyKey(key: String) {
        val clipboard = requireContext().getSystemService(android.content.Context.CLIPBOARD_SERVICE)
            as android.content.ClipboardManager
        clipboard.setPrimaryClip(android.content.ClipData.newPlainText(key, key))
        Toast.makeText(
            requireContext(),
            getString(R.string.copied_to_clipboard, key),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun saveSingleValue(name: String, newValue: String) {
        val context = requireContext().applicationContext
        val apkPath = apkPath()
        progressBar.visibility = View.VISIBLE

        viewLifecycleOwner.lifecycleScope.launch {
            val compiledFile = runCatching {
                withContext(Dispatchers.IO) {
                    FullEditWorkspaceManager.saveSingleStringOverride(
                        context = context,
                        apkPath = apkPath,
                        localeQualifier = selectedQualifier,
                        name = name,
                        newValue = newValue
                    )
                }
            }.getOrElse { error ->
                progressBar.visibility = View.GONE
                Toast.makeText(
                    requireContext(),
                    error.message ?: getString(R.string.failed),
                    Toast.LENGTH_SHORT
                ).show()
                return@launch
            }

            host().registerModifiedEntry(FullEditRepository.RESOURCES_ENTRY, compiledFile)
            Toast.makeText(
                requireContext(),
                getString(R.string.save_succeed_tip, 1),
                Toast.LENGTH_SHORT
            ).show()
            loadLanguages(selectedQualifier)
        }
    }

    private fun showAddLanguageDialog() {
        val context = requireContext()
        val container = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 12, 24, 4)
        }
        val spinner = Spinner(context)
        val codeInput = EditText(context).apply {
            inputType = InputType.TYPE_CLASS_TEXT
            setText(FullEditLanguageCatalog.codeAt(FullEditLanguageCatalog.indexOfBestMatch(selectedQualifier)))
            hint = "-pt-rBR"
        }
        val codeLabel = TextView(context).apply {
            text = "Qualifier"
            setPadding(0, 20, 0, 8)
        }
        val dialogAdapter = ArrayAdapter(
            context,
            android.R.layout.simple_spinner_item,
            FullEditLanguageCatalog.languageNames()
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.adapter = dialogAdapter
        spinner.setSelection(FullEditLanguageCatalog.indexOfBestMatch(selectedQualifier), false)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                codeInput.setText(FullEditLanguageCatalog.codeAt(position))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
        }
        container.addView(spinner)
        container.addView(codeLabel)
        container.addView(
            codeInput,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        val dialog = AlertDialog.Builder(context)
            .setTitle(R.string.add_a_language)
            .setView(container)
            .setNegativeButton(R.string.colormixer_cancel, null)
            .setPositiveButton(R.string.add, null)
            .create()
        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val qualifier = codeInput.text?.toString().orEmpty().trim()
                if (!qualifier.matches(Regex("^-([A-Za-z]{2,3})(-r[A-Za-z]{2})?$"))) {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.invalid_lang_code),
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                dialog.dismiss()
                createLanguage(qualifier)
            }
        }
        dialog.show()
    }

    private fun createLanguage(rawQualifier: String) {
        val qualifier = rawQualifier.trim()
        if (!qualifier.matches(Regex("^-([A-Za-z]{2,3})(-r[A-Za-z]{2})?$"))) {
            Toast.makeText(requireContext(), getString(R.string.invalid_lang_code), Toast.LENGTH_SHORT).show()
            return
        }

        val context = requireContext().applicationContext
        val apkPath = apkPath()
        progressBar.visibility = View.VISIBLE

        viewLifecycleOwner.lifecycleScope.launch {
            val compiledFile = runCatching {
                withContext(Dispatchers.IO) {
                    FullEditWorkspaceManager.addLanguageLikeOriginal(context, apkPath, qualifier)
                }
            }.getOrElse { error ->
                progressBar.visibility = View.GONE
                Toast.makeText(
                    requireContext(),
                    error.message ?: getString(R.string.lang_exist),
                    Toast.LENGTH_SHORT
                ).show()
                return@launch
            }

            host().registerModifiedEntry(FullEditRepository.RESOURCES_ENTRY, compiledFile)
            Toast.makeText(
                requireContext(),
                getString(R.string.file_added, qualifier),
                Toast.LENGTH_SHORT
            ).show()
            loadLanguages(qualifier)
        }
    }

    private fun openCurrentLanguageInEditor() {
        val context = requireContext().applicationContext
        val apkPath = apkPath()
        progressBar.visibility = View.VISIBLE

        viewLifecycleOwner.lifecycleScope.launch {
            val editorFile = runCatching {
                withContext(Dispatchers.IO) {
                    FullEditWorkspaceManager.exportStringEditorFile(
                        context = context,
                        apkPath = apkPath,
                        localeQualifier = selectedQualifier
                    )
                }
            }.getOrElse { error ->
                progressBar.visibility = View.GONE
                Toast.makeText(
                    requireContext(),
                    error.message ?: getString(R.string.failed),
                    Toast.LENGTH_SHORT
                ).show()
                return@launch
            }

            progressBar.visibility = View.GONE
            pendingEditorFile = editorFile
            editorLauncher.launch(
                Intent(requireContext(), TextEditBigActivity::class.java).apply {
                    putExtra("filePath", editorFile.absolutePath)
                    putExtra("fileName", editorFile.name)
                }
            )
        }
    }

    private fun applyEditedStringsFile(editedFile: File) {
        val context = requireContext().applicationContext
        val apkPath = apkPath()
        progressBar.visibility = View.VISIBLE

        viewLifecycleOwner.lifecycleScope.launch {
            val compiledFile = runCatching {
                withContext(Dispatchers.IO) {
                    FullEditWorkspaceManager.applyEditedStringsFile(
                        context = context,
                        apkPath = apkPath,
                        localeQualifier = selectedQualifier,
                        editedStringsXml = editedFile
                    )
                }
            }.getOrElse { error ->
                progressBar.visibility = View.GONE
                Toast.makeText(
                    requireContext(),
                    error.message ?: getString(R.string.failed),
                    Toast.LENGTH_SHORT
                ).show()
                return@launch
            }

            host().registerModifiedEntry(FullEditRepository.RESOURCES_ENTRY, compiledFile)
            Toast.makeText(requireContext(), getString(R.string.file_saved), Toast.LENGTH_SHORT).show()
            loadLanguages(selectedQualifier)
        }
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
            rowView.findViewById<TextView>(R.id.string_value).text = item.value.orEmpty()
            return rowView
        }
    }
}
