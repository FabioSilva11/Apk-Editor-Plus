package com.saas.apkeditorplus.full

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.saas.apkeditorplus.FullEditActivity
import com.saas.apkeditorplus.R
import com.saas.apkeditorplus.TextEditBigActivity
import java.io.File

class StringFragment : Fragment() {
    private lateinit var apkPath: String
    private lateinit var languageSpinner: Spinner
    private lateinit var listView: ListView
    private lateinit var progressBar: ProgressBar
    private lateinit var keywordEdit: EditText
    private lateinit var emptyView: TextView

    private var allItems = emptyList<FullEditRepository.StringResourceItem>()
    private var visibleItems = emptyList<FullEditRepository.StringResourceItem>()
    private var stringsEditorTempFile: File? = null
    private var modifiedResourcesFile: File? = null

    private val editStringsLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val editorFile = stringsEditorTempFile ?: return@registerForActivityResult
            if (!editorFile.exists()) {
                return@registerForActivityResult
            }
            progressBar.visibility = View.VISIBLE
            Thread {
                val compileResult = runCatching {
                    FullEditRepository.buildResourcesArscFromEditedStrings(
                        requireContext(),
                        apkPath,
                        editorFile
                    )
                }
                if (!isAdded) {
                    return@Thread
                }
                requireActivity().runOnUiThread {
                    progressBar.visibility = View.GONE
                    compileResult.onSuccess { resourcesFile ->
                        modifiedResourcesFile = resourcesFile
                        (activity as? FullEditActivity)?.registerModifiedFile(
                            FullEditRepository.RESOURCES_ENTRY,
                            resourcesFile.absolutePath
                        )
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
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, _, _ ->
            openStringsEditor()
        }

        languageSpinner.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            listOf(getString(R.string.default_language))
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        languageSpinner.isEnabled = false

        view.findViewById<Button>(R.id.search_button).setOnClickListener {
            applyFilter(keywordEdit.text.toString())
        }
        view.findViewById<Button>(R.id.open_editor_button).setOnClickListener {
            openStringsEditor()
        }

        loadStrings()
    }

    private fun loadStrings() {
        progressBar.visibility = View.VISIBLE
        emptyView.setText(R.string.loading)
        Thread {
            val result = runCatching {
                val resourcesFile = modifiedResourcesFile
                if (resourcesFile != null && resourcesFile.exists()) {
                    FullEditRepository.parseStringResourcesFromArscFile(resourcesFile)
                } else {
                    FullEditRepository.parseStringResources(apkPath)
                }
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

    private fun openStringsEditor() {
        progressBar.visibility = View.VISIBLE
        Thread {
            val result = runCatching {
                FullEditRepository.exportStringResourcesEditorFile(
                    requireContext(),
                    apkPath,
                    modifiedResourcesFile
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
