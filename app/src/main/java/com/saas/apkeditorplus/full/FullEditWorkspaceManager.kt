package com.saas.apkeditorplus.full

import android.content.Context
import android.util.Xml
import com.reandroid.apk.ApkModule
import com.reandroid.apk.ApkModuleXmlDecoder
import com.reandroid.apk.ApkModuleXmlEncoder
import com.reandroid.apk.ApkUtil
import com.reandroid.apk.DexDecoder
import com.reandroid.apk.DexFileInputSource
import com.reandroid.arsc.chunk.PackageBlock
import com.reandroid.arsc.chunk.TableBlock
import java.io.File
import java.security.MessageDigest
import java.util.Locale
import kotlin.io.use
import org.xmlpull.v1.XmlPullParser

internal object FullEditWorkspaceManager {
    private const val WORKSPACE_DIR = "full_edit_workspace"
    private const val WORKSPACE_MARKER = ".decoded"
    private const val OVERRIDE_STRINGS_FILE = "zz_strings_full_edit.xml"
    private val hiddenStringPrefixes = listOf(
        "abc_",
        "androidx_",
        "bottomsheet_",
        "character_counter_",
        "clear_text_end_icon_",
        "common_google_play_services_",
        "error_icon_content_description",
        "exposed_dropdown_menu_",
        "fallback_menu_item_",
        "m3_",
        "material_",
        "material_clock_",
        "material_timepicker_",
        "mtrl_",
        "nav_app_bar_",
        "password_toggle_",
        "path_password_",
        "search_menu_",
        "searchbar_",
        "searchview_",
        "side_sheet_",
        "status_bar_",
        "v7_preference_"
    )
    private val hiddenStringPatterns = listOf(
        Regex("^APKTOOL_.*$"),
        Regex("^default_res_0x[0-9a-fA-F]+$"),
        Regex("^string_[0-9a-fA-F]+$"),
        Regex("^mr_.*$")
    )

    data class WorkspaceInfo(
        val rootDir: File,
        val manifestFile: File,
        val resDir: File,
        val key: String
    )

    private data class StringValue(
        val name: String,
        val value: String
    )

    private object NoOpDexDecoder : DexDecoder {
        override fun decodeDex(dexFileInputSource: DexFileInputSource, mainDirectory: File) = Unit
    }

    fun getWorkspace(context: Context, apkPath: String): WorkspaceInfo {
        val apkFile = File(apkPath)
        require(apkFile.isFile) { "APK file not found" }
        val key = workspaceKey(apkFile)
        val rootDir = File(context.cacheDir, "$WORKSPACE_DIR${File.separator}$key")
        val marker = File(rootDir, WORKSPACE_MARKER)
        if (!marker.exists()) {
            decodeWorkspace(apkFile, rootDir)
            marker.parentFile?.mkdirs()
            marker.writeText("decoded")
        }
        return locateWorkspace(rootDir, key)
    }

    fun getManifestFile(context: Context, apkPath: String): File {
        return getWorkspace(context, apkPath).manifestFile
    }

    fun listStringLocales(context: Context, apkPath: String): List<String> {
        val resDir = getWorkspace(context, apkPath).resDir
        return ApkUtil.listValuesDirectory(resDir)
            .mapNotNull { valuesDir ->
                if (containsStringResource(valuesDir)) {
                    qualifierFromValuesDirectory(valuesDir.name)
                } else {
                    null
                }
            }
            .distinct()
            .sortedWith(
                compareBy<String>({ if (it.isEmpty()) 0 else 1 }, { it.lowercase(Locale.ROOT) })
            )
    }

    fun readStringResources(
        context: Context,
        apkPath: String,
        localeQualifier: String
    ): List<FullEditRepository.StringResourceItem> {
        val valuesDir = valuesDirectoryForQualifier(getWorkspace(context, apkPath).resDir, localeQualifier)
        val merged = linkedMapOf<String, String>()
        stringXmlFiles(valuesDir).forEach { file ->
            readStringValues(file).forEach { value ->
                merged[value.name] = value.value
            }
        }
        return merged.entries
            .filter { (name, _) -> isDisplayableString(name) }
            .map { (name, value) ->
                FullEditRepository.StringResourceItem(
                    name = name,
                    value = value,
                    localeQualifier = localeQualifier
                )
            }
            .sortedBy { it.name.lowercase(Locale.ROOT) }
    }

    fun exportStringEditorFile(
        context: Context,
        apkPath: String,
        localeQualifier: String
    ): File {
        val values = readStringResources(context, apkPath, localeQualifier)
            .associate { it.name to it.value.orEmpty() }
        val outputDir = File(context.cacheDir, "full_edit_strings_workspace").apply { mkdirs() }
        val workspace = getWorkspace(context, apkPath)
        val outputFile = File(outputDir, "${workspace.key}_${safeLocaleSuffix(localeQualifier)}_strings.xml")
        writeStringsXml(outputFile, values)
        return outputFile
    }

    fun saveSingleStringOverride(
        context: Context,
        apkPath: String,
        localeQualifier: String,
        name: String,
        newValue: String
    ): File {
        val currentValues = readStringResources(context, apkPath, localeQualifier)
            .associate { it.name to it.value.orEmpty() }
            .toMutableMap()
        currentValues[name] = newValue
        return writeLocaleSnapshotAndCompile(context, apkPath, localeQualifier, currentValues)
    }

    fun applyEditedStringsFile(
        context: Context,
        apkPath: String,
        localeQualifier: String,
        editedStringsXml: File
    ): File {
        require(editedStringsXml.isFile) { "Edited strings file not found" }
        val parsedValues = readStringValues(editedStringsXml)
            .associate { it.name to it.value }
        return writeLocaleSnapshotAndCompile(context, apkPath, localeQualifier, parsedValues)
    }

    fun createLocaleFromDefault(
        context: Context,
        apkPath: String,
        localeQualifier: String
    ): File {
        require(localeQualifier.isNotBlank()) { "Invalid locale qualifier" }
        val workspace = getWorkspace(context, apkPath)
        val targetDir = valuesDirectoryForQualifier(workspace.resDir, localeQualifier)
        if (targetDir.exists() && containsStringResource(targetDir)) {
            error("Locale already exists")
        }
        val defaultValues = readStringResources(context, apkPath, "")
            .associate { it.name to it.value.orEmpty() }
        return writeLocaleSnapshotAndCompile(context, apkPath, localeQualifier, defaultValues)
    }

    private fun writeLocaleSnapshotAndCompile(
        context: Context,
        apkPath: String,
        localeQualifier: String,
        values: Map<String, String>
    ): File {
        val workspace = getWorkspace(context, apkPath)
        val valuesDir = valuesDirectoryForQualifier(workspace.resDir, localeQualifier)
        if (!valuesDir.exists()) {
            valuesDir.mkdirs()
        }
        val overrideFile = File(valuesDir, OVERRIDE_STRINGS_FILE)
        writeStringsXml(overrideFile, values)
        return compileResources(context, apkPath, workspace)
    }

    private fun compileResources(
        context: Context,
        apkPath: String,
        workspace: WorkspaceInfo
    ): File {
        ApkModule.loadApkFile(File(apkPath)).use { apkModule ->
            val encoder = ApkModuleXmlEncoder(apkModule, apkModule.tableBlock)
            encoder.scanDirectory(workspace.rootDir)
            val outputDir = File(context.cacheDir, "full_edit_workspace_resources").apply { mkdirs() }
            val outputFile = File(outputDir, "${workspace.key}_resources.arsc")
            val inputSource = apkModule.getInputSource(TableBlock.FILE_NAME)
                ?: error("Failed to rebuild resources.arsc")
            inputSource.write(outputFile)
            return outputFile
        }
    }

    private fun decodeWorkspace(apkFile: File, rootDir: File) {
        if (rootDir.exists()) {
            rootDir.deleteRecursively()
        }
        rootDir.mkdirs()
        ApkModule.loadApkFile(apkFile).use { apkModule ->
            val decoder = ApkModuleXmlDecoder(apkModule)
            decoder.setDexDecoder(NoOpDexDecoder)
            decoder.decode(rootDir)
        }
    }

    private fun locateWorkspace(rootDir: File, key: String): WorkspaceInfo {
        val manifestFile = File(rootDir, "AndroidManifest.xml")
        require(manifestFile.isFile) { "Manifest not decoded" }
        val resourcesRoot = File(rootDir, TableBlock.DIRECTORY_NAME)
        val packageDir = ApkUtil.listPackageDirectories(resourcesRoot).firstOrNull()
            ?: error("Decoded resources not found")
        val resDir = File(packageDir, PackageBlock.RES_DIRECTORY_NAME)
        require(resDir.isDirectory) { "Decoded res directory not found" }
        return WorkspaceInfo(
            rootDir = rootDir,
            manifestFile = manifestFile,
            resDir = resDir,
            key = key
        )
    }

    private fun valuesDirectoryForQualifier(resDir: File, qualifier: String): File {
        val directoryName = if (qualifier.isBlank()) {
            PackageBlock.VALUES_DIRECTORY_NAME
        } else {
            PackageBlock.VALUES_DIRECTORY_NAME + qualifier
        }
        return File(resDir, directoryName)
    }

    private fun qualifierFromValuesDirectory(directoryName: String): String {
        if (directoryName == PackageBlock.VALUES_DIRECTORY_NAME) {
            return ""
        }
        return directoryName.removePrefix(PackageBlock.VALUES_DIRECTORY_NAME)
            .takeIf { it.startsWith('-') }
            ?: ""
    }

    private fun stringXmlFiles(valuesDir: File): List<File> {
        if (!valuesDir.isDirectory) {
            return emptyList()
        }
        return valuesDir.listFiles()
            ?.filter { file -> file.isFile && file.extension.equals("xml", ignoreCase = true) }
            ?.sortedWith(
                compareBy<File>(
                    { if (it.name == OVERRIDE_STRINGS_FILE) 1 else 0 },
                    { it.name.lowercase(Locale.ROOT) }
                )
            )
            .orEmpty()
    }

    private fun containsStringResource(valuesDir: File): Boolean {
        return stringXmlFiles(valuesDir).any { file -> readStringValues(file).isNotEmpty() }
    }

    private fun readStringValues(file: File): List<StringValue> {
        if (!file.isFile) {
            return emptyList()
        }
        return runCatching {
            val parser = Xml.newPullParser()
            file.inputStream().use { input ->
                parser.setInput(input, Charsets.UTF_8.name())
                val values = mutableListOf<StringValue>()
                var event = parser.eventType
                while (event != XmlPullParser.END_DOCUMENT) {
                    if (event == XmlPullParser.START_TAG && parser.name == "string") {
                        val name = parser.getAttributeValue(null, "name")
                        val value = parser.nextText()
                        if (!name.isNullOrBlank()) {
                            values.add(StringValue(name, value))
                        }
                    }
                    event = parser.next()
                }
                values
            }
        }.getOrDefault(emptyList())
    }

    private fun writeStringsXml(file: File, values: Map<String, String>) {
        file.parentFile?.mkdirs()
        file.outputStream().use { outputStream ->
            val serializer = Xml.newSerializer()
            serializer.setOutput(outputStream, Charsets.UTF_8.name())
            serializer.startDocument(Charsets.UTF_8.name(), true)
            serializer.text("\n")
            serializer.startTag(null, "resources")
            values.toSortedMap(String.CASE_INSENSITIVE_ORDER).forEach { (name, value) ->
                serializer.text("\n    ")
                serializer.startTag(null, "string")
                serializer.attribute(null, "name", name)
                serializer.text(value)
                serializer.endTag(null, "string")
            }
            serializer.text("\n")
            serializer.endTag(null, "resources")
            serializer.text("\n")
            serializer.endDocument()
        }
    }

    private fun isDisplayableString(name: String): Boolean {
        return hiddenStringPrefixes.none { prefix -> name.startsWith(prefix) } &&
            hiddenStringPatterns.none { pattern -> pattern.matches(name) }
    }

    private fun safeLocaleSuffix(localeQualifier: String): String {
        return if (localeQualifier.isBlank()) {
            "default"
        } else {
            localeQualifier.removePrefix("-").replace("-r", "_").replace('-', '_')
        }
    }

    private fun workspaceKey(apkFile: File): String {
        val identity = "${apkFile.absolutePath}|${apkFile.length()}|${apkFile.lastModified()}"
        val digest = MessageDigest.getInstance("SHA-1").digest(identity.toByteArray(Charsets.UTF_8))
        return digest.joinToString("") { byte -> "%02x".format(byte) }
    }
}
