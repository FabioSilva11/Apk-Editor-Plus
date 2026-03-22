package com.saas.apkeditorplus.full

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.saas.apkeditorplus.FullEditActivity
import com.saas.apkeditorplus.R
import com.saas.apkeditorplus.TextEditBigActivity
import java.io.File

class ManifestFragment : Fragment() {
    private data class ManifestLine(
        val index: Int,
        val text: String
    )

    private data class ManifestAttribute(
        val name: String,
        val value: String
    )

    private data class ParsedManifestLine(
        val indentation: String,
        val tagName: String,
        val selfClosing: Boolean,
        val attributes: List<ManifestAttribute>
    )

    private lateinit var apkPath: String
    private lateinit var listView: ListView
    private lateinit var keywordEdit: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var emptyView: TextView

    private var manifestText: String = ""
    private var manifestLines = emptyList<ManifestLine>()
    private var visibleLines = emptyList<ManifestLine>()
    private var manifestTempFile: File? = null

    private val editManifestLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val tempFile = manifestTempFile
            if (tempFile != null && tempFile.exists()) {
                setManifestText(tempFile.readText())
                registerManifestAsModified(tempFile)
            }
        }
    }

    companion object {
        private const val ARG_APK_PATH = "apk_path"
        private val ATTRIBUTE_REGEX = Regex("""([A-Za-z0-9_:\.-]+)\s*=\s*"([^"]*)"""")

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
        listView = view.findViewById(R.id.manifest_list)
        keywordEdit = view.findViewById(R.id.keyword_edit)
        progressBar = view.findViewById(R.id.progress_bar)
        emptyView = view.findViewById(R.id.empty_view)

        listView.emptyView = emptyView
        listView.adapter = ManifestLineAdapter()
        listView.onItemClickListener = android.widget.AdapterView.OnItemClickListener { _, _, position, _ ->
            visibleLines.getOrNull(position)?.let(::showLineEditor)
        }
        listView.onItemLongClickListener = android.widget.AdapterView.OnItemLongClickListener { _, _, position, _ ->
            visibleLines.getOrNull(position)?.let { line ->
                copyToClipboard(line.text)
                Toast.makeText(
                    requireContext(),
                    getString(R.string.copied_to_clipboard, line.text.trim()),
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }

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
                    setManifestText(text)
                }.onFailure { error ->
                    manifestText = ""
                    manifestLines = emptyList()
                    visibleLines = emptyList()
                    (listView.adapter as BaseAdapter).notifyDataSetChanged()
                    emptyView.visibility = View.VISIBLE
                    emptyView.text = error.message ?: getString(R.string.failed)
                }
            }
        }.start()
    }

    private fun setManifestText(text: String) {
        manifestText = text
        manifestLines = text.lineSequence()
            .mapIndexed { index, line -> ManifestLine(index, line) }
            .toList()
        applyFilter(keywordEdit.text.toString())
    }

    private fun applyFilter(query: String) {
        val normalizedQuery = query.trim()
        visibleLines = if (normalizedQuery.isEmpty()) {
            manifestLines
        } else {
            manifestLines.filter { it.text.contains(normalizedQuery, ignoreCase = true) }
        }
        (listView.adapter as BaseAdapter).notifyDataSetChanged()
        emptyView.visibility = if (visibleLines.isEmpty()) View.VISIBLE else View.GONE
        emptyView.setText(
            if (manifestLines.isEmpty()) {
                R.string.loading
            } else {
                R.string.not_found
            }
        )
    }

    private fun showLineEditor(line: ManifestLine) {
        val parsed = parseStructuredLine(line.text)
        val dialogView = layoutInflater.inflate(R.layout.dialog_manifest_line, null, false)
        val lineDataView = dialogView.findViewById<TextView>(R.id.line_data)
        val rawValueView = dialogView.findViewById<EditText>(R.id.line_value)
        val attributeContainer = dialogView.findViewById<LinearLayout>(R.id.attribute_container)
        val addAttributeButton = dialogView.findViewById<Button>(R.id.add_attribute_button)

        lineDataView.typeface = Typeface.MONOSPACE
        lineDataView.text = line.text

        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        if (parsed != null) {
            rawValueView.visibility = View.GONE
            addAttributeButton.visibility = View.VISIBLE
            val attributeRows = mutableListOf<View>()

            fun addAttributeRow(name: String = "", value: String = "") {
                val rowView = layoutInflater.inflate(
                    R.layout.item_manifest_attribute,
                    attributeContainer,
                    false
                )
                rowView.findViewById<EditText>(R.id.attribute_name).setText(name)
                rowView.findViewById<EditText>(R.id.attribute_value).setText(value)
                attributeContainer.addView(rowView)
                attributeRows.add(rowView)
            }

            parsed.attributes.forEach { attribute ->
                addAttributeRow(attribute.name, attribute.value)
            }
            if (parsed.attributes.isEmpty()) {
                addAttributeRow()
            }

            addAttributeButton.setOnClickListener {
                addAttributeRow()
            }

            dialogView.findViewById<View>(R.id.btn_line_ok).setOnClickListener {
                val attributes = mutableListOf<ManifestAttribute>()
                for (rowView in attributeRows) {
                    val name = rowView.findViewById<EditText>(R.id.attribute_name)
                        .text?.toString().orEmpty().trim()
                    val value = rowView.findViewById<EditText>(R.id.attribute_value)
                        .text?.toString().orEmpty()
                    if (name.isBlank()) {
                        if (value.isNotBlank()) {
                            Toast.makeText(
                                requireContext(),
                                getString(R.string.empty_key_tip),
                                Toast.LENGTH_SHORT
                            ).show()
                            return@setOnClickListener
                        }
                        continue
                    }
                    attributes.add(ManifestAttribute(name, value))
                }
                dialog.dismiss()
                updateManifestLine(line.index, buildStructuredLine(parsed, attributes))
            }
        } else {
            attributeContainer.visibility = View.GONE
            addAttributeButton.visibility = View.GONE
            rawValueView.visibility = View.VISIBLE
            rawValueView.setText(line.text)
            rawValueView.setSelection(rawValueView.text?.length ?: 0)

            dialogView.findViewById<View>(R.id.btn_line_ok).setOnClickListener {
                dialog.dismiss()
                updateManifestLine(line.index, rawValueView.text?.toString().orEmpty())
            }
        }

        dialogView.findViewById<View>(R.id.btn_line_cancel).setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun updateManifestLine(index: Int, newLine: String) {
        val currentLine = manifestLines.getOrNull(index)?.text ?: return
        if (currentLine == newLine) {
            return
        }

        manifestLines = manifestLines.map { line ->
            if (line.index == index) {
                line.copy(text = newLine)
            } else {
                line
            }
        }
        manifestText = manifestLines.joinToString(separator = "\n") { it.text }

        val tempFile = ensureManifestTempFile()
        tempFile.writeText(manifestText)
        registerManifestAsModified(tempFile)
        applyFilter(keywordEdit.text.toString())

        Toast.makeText(
            requireContext(),
            getString(R.string.file_saved),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun ensureManifestTempFile(): File {
        val existingFile = manifestTempFile
        if (existingFile != null && existingFile.exists()) {
            return existingFile
        }

        val outputDir = File(requireContext().cacheDir, "full_edit_manifest").apply { mkdirs() }
        return File(
            outputDir,
            "${apkPath.hashCode().toUInt().toString(16)}_${FullEditRepository.MANIFEST_ENTRY}"
        ).also { file ->
            file.writeText(manifestText)
            manifestTempFile = file
        }
    }

    private fun registerManifestAsModified(file: File) {
        manifestTempFile = file
        (activity as? FullEditActivity)?.registerModifiedFile(
            FullEditRepository.MANIFEST_ENTRY,
            file.absolutePath
        )
    }

    private fun openManifestEditor() {
        if (manifestText.isBlank()) {
            Toast.makeText(requireContext(), getString(R.string.failed), Toast.LENGTH_SHORT).show()
            return
        }
        val tempFile = ensureManifestTempFile()
        editManifestLauncher.launch(
            Intent(requireContext(), TextEditBigActivity::class.java).apply {
                putExtra("filePath", tempFile.absolutePath)
                putExtra("fileName", FullEditRepository.MANIFEST_ENTRY)
            }
        )
    }

    private fun parseStructuredLine(line: String): ParsedManifestLine? {
        val trimmedLine = line.trim()
        if (!trimmedLine.startsWith("<") ||
            trimmedLine.startsWith("</") ||
            trimmedLine.startsWith("<?") ||
            trimmedLine.startsWith("<!")
        ) {
            return null
        }

        val selfClosing = trimmedLine.endsWith("/>")
        if (!selfClosing && !trimmedLine.endsWith(">")) {
            return null
        }

        val inner = trimmedLine.substring(1, trimmedLine.length - if (selfClosing) 2 else 1).trim()
        if (inner.isBlank()) {
            return null
        }

        val tagName = inner.substringBefore(' ').trim()
        if (tagName.isBlank()) {
            return null
        }

        val attributeSource = inner.removePrefix(tagName).trim()
        val attributes = mutableListOf<ManifestAttribute>()
        var remaining = attributeSource
        while (remaining.isNotBlank()) {
            val match = ATTRIBUTE_REGEX.find(remaining) ?: return null
            if (match.range.first != 0) {
                return null
            }
            attributes.add(
                ManifestAttribute(
                    name = match.groupValues[1],
                    value = match.groupValues[2]
                )
            )
            remaining = remaining.substring(match.range.last + 1).trimStart()
        }

        return ParsedManifestLine(
            indentation = line.takeWhile { it == ' ' || it == '\t' },
            tagName = tagName,
            selfClosing = selfClosing,
            attributes = attributes
        )
    }

    private fun buildStructuredLine(
        parsed: ParsedManifestLine,
        attributes: List<ManifestAttribute>
    ): String {
        val attributesText = attributes.joinToString(separator = "") { attribute ->
            " ${attribute.name.trim()}=\"${escapeAttributeValue(attribute.value)}\""
        }
        return buildString {
            append(parsed.indentation)
            append('<')
            append(parsed.tagName)
            append(attributesText)
            append(if (parsed.selfClosing) " />" else ">")
        }
    }

    private fun escapeAttributeValue(value: String): String {
        return value
            .replace("&", "&amp;")
            .replace("\"", "&quot;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
    }

    private fun copyToClipboard(text: String) {
        val clipboardManager = requireContext().getSystemService(Context.CLIPBOARD_SERVICE)
            as ClipboardManager
        clipboardManager.setPrimaryClip(ClipData.newPlainText("manifest_line", text))
    }

    private inner class ManifestLineAdapter : BaseAdapter() {
        override fun getCount(): Int = visibleLines.size

        override fun getItem(position: Int): Any = visibleLines[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowView = convertView
                ?: layoutInflater.inflate(R.layout.item_manifest_line, parent, false)
            val lineView = rowView.findViewById<TextView>(R.id.line_data)
            lineView.typeface = Typeface.MONOSPACE
            lineView.text = visibleLines[position].text
            return rowView
        }
    }
}
