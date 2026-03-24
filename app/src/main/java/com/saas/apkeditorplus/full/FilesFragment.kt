package com.saas.apkeditorplus.full

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.saas.apkeditorplus.FullEditActivity
import com.saas.apkeditorplus.R
import com.saas.apkeditorplus.TextEditBigActivity
import java.io.File

class FilesFragment : Fragment() {
    private lateinit var apkPath: String
    private lateinit var pathView: TextView
    private lateinit var listView: ListView
    private lateinit var keywordEdit: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var emptyView: TextView

    private var currentArchivePath: String = ""
    private var currentSmaliPath: String = ""
    private var currentSmaliWorkspace: FullEditRepository.SmaliWorkspace? = null
    private var allItems = emptyList<FullEditRepository.ArchiveItem>()
    private var visibleItems = emptyList<FullEditRepository.ArchiveItem>()
    private var lastEditedRegistrationEntry: String? = null
    private var lastEditedRegistrationPath: String? = null

    private val editFileLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val entryName = lastEditedRegistrationEntry
            val registrationPath = lastEditedRegistrationPath
            if (entryName != null && registrationPath != null && File(registrationPath).exists()) {
                (activity as? FullEditActivity)?.registerModifiedFile(entryName, registrationPath)
                Toast.makeText(requireContext(), getString(R.string.file_saved), Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val ARG_APK_PATH = "apk_path"

        fun newInstance(apkPath: String): FilesFragment {
            return FilesFragment().apply {
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
        return inflater.inflate(R.layout.fragment_full_files, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apkPath = requireArguments().getString(ARG_APK_PATH).orEmpty()
        pathView = view.findViewById(R.id.current_path)
        listView = view.findViewById(R.id.file_list)
        keywordEdit = view.findViewById(R.id.keyword_edit)
        progressBar = view.findViewById(R.id.progress_bar)
        emptyView = view.findViewById(R.id.empty_view)

        listView.emptyView = emptyView
        listView.adapter = FilesAdapter()

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
        view.findViewById<View>(R.id.home_button).setOnClickListener {
            currentArchivePath = ""
            currentSmaliPath = ""
            currentSmaliWorkspace = null
            loadFiles()
        }
        view.findViewById<View>(R.id.add_file_button).setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.not_available), Toast.LENGTH_SHORT).show()
        }
        view.findViewById<View>(R.id.add_folder_button).setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.not_available), Toast.LENGTH_SHORT).show()
        }

        loadFiles()
    }

    private fun loadFiles() {
        progressBar.visibility = View.VISIBLE
        emptyView.setText(R.string.loading)
        val smaliWorkspace = currentSmaliWorkspace
        Thread {
            val result = runCatching {
                if (smaliWorkspace != null) {
                    FullEditRepository.listSmaliDirectory(smaliWorkspace, currentSmaliPath)
                } else {
                    FullEditRepository.listDirectory(apkPath, currentArchivePath)
                }
            }
            if (!isAdded) {
                return@Thread
            }
            requireActivity().runOnUiThread {
                progressBar.visibility = View.GONE
                result.onSuccess { items ->
                    allItems = items
                    val currentPathLabel = buildCurrentPathLabel(smaliWorkspace)
                    pathView.text = currentPathLabel
                    pathView.isVisible = currentPathLabel.isNotBlank()
                    applyFilter(keywordEdit.text.toString())
                    emptyView.setText(R.string.not_found)
                }.onFailure { error ->
                    allItems = emptyList()
                    visibleItems = emptyList()
                    (listView.adapter as BaseAdapter).notifyDataSetChanged()
                    emptyView.text = error.message ?: getString(R.string.general_error, "")
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
                item.displayName.contains(normalizedQuery, ignoreCase = true) ||
                    item.entryName.contains(normalizedQuery, ignoreCase = true)
            }
        }
        (listView.adapter as BaseAdapter).notifyDataSetChanged()
    }

    private fun openItem(item: FullEditRepository.ArchiveItem) {
        val smaliWorkspace = currentSmaliWorkspace
        if (smaliWorkspace != null) {
            openSmaliItem(smaliWorkspace, item)
        } else {
            openArchiveItem(item)
        }
    }

    private fun openArchiveItem(item: FullEditRepository.ArchiveItem) {
        if (item.isDirectory) {
            currentArchivePath = item.entryName
            loadFiles()
            return
        }
        if (FullEditRepository.isDexEntry(item.entryName)) {
            openDexAsSmali(item)
            return
        }
        if (!FullEditRepository.isEditableTextEntry(item.entryName)) {
            Toast.makeText(
                requireContext(),
                getString(R.string.full_edit_unsupported_file),
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        progressBar.visibility = View.VISIBLE
        Thread {
            val result = runCatching {
                FullEditRepository.extractEntryForEditing(requireContext(), apkPath, item.entryName)
            }
            if (!isAdded) {
                return@Thread
            }
            requireActivity().runOnUiThread {
                progressBar.visibility = View.GONE
                result.onSuccess { tempFile ->
                    launchEditor(
                        fileToEdit = tempFile,
                        displayName = item.displayName,
                        registrationEntry = item.entryName,
                        registrationPath = tempFile.absolutePath
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

    private fun openDexAsSmali(item: FullEditRepository.ArchiveItem) {
        progressBar.visibility = View.VISIBLE
        Thread {
            val result = runCatching {
                FullEditRepository.prepareDexSmaliWorkspace(requireContext(), apkPath, item.entryName)
            }
            if (!isAdded) {
                return@Thread
            }
            requireActivity().runOnUiThread {
                progressBar.visibility = View.GONE
                result.onSuccess { workspace ->
                    currentSmaliWorkspace = workspace
                    currentSmaliPath = ""
                    loadFiles()
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

    private fun openSmaliItem(
        workspace: FullEditRepository.SmaliWorkspace,
        item: FullEditRepository.ArchiveItem
    ) {
        if (item.isDirectory) {
            if (item.displayName == ".." && currentSmaliPath.isBlank()) {
                currentSmaliWorkspace = null
                currentSmaliPath = ""
                currentArchivePath = workspace.returnArchivePath
            } else {
                currentSmaliPath = item.entryName
            }
            loadFiles()
            return
        }

        val smaliFile = FullEditRepository.resolveSmaliWorkspaceFile(workspace, item.entryName)
        if (!smaliFile.exists()) {
            Toast.makeText(
                requireContext(),
                getString(R.string.full_edit_unsupported_file),
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        launchEditor(
            fileToEdit = smaliFile,
            displayName = item.displayName,
            registrationEntry = workspace.dexEntryName,
            registrationPath = workspace.rootDir.absolutePath
        )
    }

    private fun launchEditor(
        fileToEdit: File,
        displayName: String,
        registrationEntry: String,
        registrationPath: String
    ) {
        lastEditedRegistrationEntry = registrationEntry
        lastEditedRegistrationPath = registrationPath
        editFileLauncher.launch(
            Intent(requireContext(), TextEditBigActivity::class.java).apply {
                putExtra("filePath", fileToEdit.absolutePath)
                putExtra("fileName", displayName)
            }
        )
    }

    private fun buildCurrentPathLabel(
        smaliWorkspace: FullEditRepository.SmaliWorkspace?
    ): String {
        if (smaliWorkspace == null) {
            val relativePath = currentArchivePath.removeSuffix("/")
            return if (relativePath.isBlank()) "" else "/$relativePath"
        }

        val relative = currentSmaliPath.removeSuffix("/")
        return if (relative.isBlank()) {
            "/${smaliWorkspace.dexEntryName}!/smali"
        } else {
            "/${smaliWorkspace.dexEntryName}!/smali/$relative"
        }
    }

    private inner class FilesAdapter : BaseAdapter() {
        override fun getCount(): Int = visibleItems.size

        override fun getItem(position: Int): Any = visibleItems[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowView = convertView
                ?: layoutInflater.inflate(R.layout.item_zipfile, parent, false)
            val item = visibleItems[position]
            rowView.findViewById<TextView>(R.id.filename).text = item.displayName
            val detailView = rowView.findViewById<TextView>(R.id.detail1)
            detailView.text = ""
            detailView.visibility = View.GONE
            rowView.findViewById<View>(R.id.selection_indicator).visibility =
                if (item.displayName == "..") View.INVISIBLE else View.VISIBLE

            val iconBadge = rowView.findViewById<View>(R.id.file_icon_badge)
            val icon = rowView.findViewById<ImageView>(R.id.file_icon)
            val iconRes = when {
                item.isDirectory && item.displayName == ".." -> R.drawable.ic_back
                item.isDirectory -> R.drawable.ic_folder
                item.entryName.endsWith(".xml", ignoreCase = true) -> R.drawable.ic_edit_4
                item.entryName.endsWith(".smali", ignoreCase = true) -> R.drawable.ic_characters
                item.entryName.endsWith(".dex", ignoreCase = true) -> R.drawable.ic_edit_3
                else -> R.drawable.ic_edit_2
            }
            val badgeRes = when {
                item.isDirectory -> R.drawable.full_edit_badge_folder
                item.entryName.endsWith(".xml", ignoreCase = true) -> R.drawable.full_edit_badge_manifest
                item.entryName.endsWith(".dex", ignoreCase = true) -> R.drawable.full_edit_badge_dex
                else -> R.drawable.full_edit_badge_generic
            }
            iconBadge.background = ContextCompat.getDrawable(requireContext(), badgeRes)
            icon.setImageResource(iconRes)

            rowView.setOnClickListener { openItem(item) }
            return rowView
        }
    }
}
