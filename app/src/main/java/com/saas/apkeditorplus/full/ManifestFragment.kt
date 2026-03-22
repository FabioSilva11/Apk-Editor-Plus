package com.saas.apkeditorplus.full

import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.saas.apkeditorplus.FullEditActivity
import com.saas.apkeditorplus.R
import com.saas.apkeditorplus.TextEditBigActivity

class ManifestFragment : Fragment() {
    private lateinit var apkPath: String
    private lateinit var manifestView: TextView
    private lateinit var keywordEdit: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var emptyView: TextView

    private var manifestText: String = ""
    private var manifestTempFile: java.io.File? = null

    private val editManifestLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val tempFile = manifestTempFile
            if (tempFile != null && tempFile.exists()) {
                manifestText = tempFile.readText()
                applyFilter(keywordEdit.text.toString())
                (activity as? FullEditActivity)?.registerModifiedFile(
                    FullEditRepository.MANIFEST_ENTRY,
                    tempFile.absolutePath
                )
            }
        }
    }

    companion object {
        private const val ARG_APK_PATH = "apk_path"

        fun newInstance(apkPath: String): ManifestFragment {
            return ManifestFragment().apply {
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
        return inflater.inflate(R.layout.fragment_full_manifest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apkPath = requireArguments().getString(ARG_APK_PATH).orEmpty()
        manifestView = view.findViewById(R.id.manifest_content)
        keywordEdit = view.findViewById(R.id.keyword_edit)
        progressBar = view.findViewById(R.id.progress_bar)
        emptyView = view.findViewById(R.id.empty_view)

        manifestView.typeface = Typeface.MONOSPACE
        manifestView.setTextIsSelectable(true)
        manifestView.setOnClickListener { openManifestEditor() }

        view.findViewById<Button>(R.id.search_button).setOnClickListener {
            applyFilter(keywordEdit.text.toString())
        }
        view.findViewById<Button>(R.id.open_editor_button).setOnClickListener {
            openManifestEditor()
        }

        loadManifest()
    }

    private fun loadManifest() {
        progressBar.visibility = View.VISIBLE
        emptyView.setText(R.string.loading)
        Thread {
            val result = runCatching {
                FullEditRepository.decodeManifest(apkPath)
            }
            if (!isAdded) {
                return@Thread
            }
            requireActivity().runOnUiThread {
                progressBar.visibility = View.GONE
                result.onSuccess { text ->
                    manifestText = text
                    applyFilter(keywordEdit.text.toString())
                }.onFailure { error ->
                    manifestText = ""
                    manifestView.text = ""
                    manifestView.visibility = View.GONE
                    emptyView.visibility = View.VISIBLE
                    emptyView.text = error.message ?: getString(R.string.failed)
                }
            }
        }.start()
    }

    private fun applyFilter(query: String) {
        if (manifestText.isBlank()) {
            manifestView.text = ""
            emptyView.visibility = View.VISIBLE
            manifestView.visibility = View.GONE
            return
        }
        val normalizedQuery = query.trim()
        val visibleText = if (normalizedQuery.isEmpty()) {
            manifestText
        } else {
            manifestText.lineSequence()
                .filter { it.contains(normalizedQuery, ignoreCase = true) }
                .joinToString(separator = "\n")
        }
        if (visibleText.isBlank()) {
            manifestView.text = ""
            manifestView.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
            emptyView.setText(R.string.not_found)
        } else {
            manifestView.text = visibleText
            manifestView.visibility = View.VISIBLE
            emptyView.visibility = View.GONE
        }
    }

    private fun openManifestEditor() {
        val existingTempFile = manifestTempFile
        if (existingTempFile != null && existingTempFile.exists()) {
            editManifestLauncher.launch(
                Intent(requireContext(), TextEditBigActivity::class.java).apply {
                    putExtra("filePath", existingTempFile.absolutePath)
                    putExtra("fileName", FullEditRepository.MANIFEST_ENTRY)
                }
            )
            return
        }
        progressBar.visibility = View.VISIBLE
        Thread {
            val result = runCatching {
                FullEditRepository.extractEntryForEditing(
                    requireContext(),
                    apkPath,
                    FullEditRepository.MANIFEST_ENTRY
                )
            }
            if (!isAdded) {
                return@Thread
            }
            requireActivity().runOnUiThread {
                progressBar.visibility = View.GONE
                result.onSuccess { tempFile ->
                    manifestTempFile = tempFile
                    editManifestLauncher.launch(
                        Intent(requireContext(), TextEditBigActivity::class.java).apply {
                            putExtra("filePath", tempFile.absolutePath)
                            putExtra("fileName", FullEditRepository.MANIFEST_ENTRY)
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
}
