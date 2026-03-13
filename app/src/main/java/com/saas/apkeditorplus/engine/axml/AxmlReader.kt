package com.saas.apkeditorplus.engine.axml

import java.io.IOException
import java.io.InputStream

class AxmlReader(inputStream: InputStream) {
    private val reader = BinaryReader(inputStream)
    private val info = ManifestInfo()
    private lateinit var stringPool: AxmlStringPool
    private lateinit var resourceMap: AxmlResourceMap

    @Throws(IOException::class)
    fun parse(): ManifestInfo {
        val magic = reader.readInt()
        if (magic != 0x00080003) throw IOException("Not a valid AXML file")
        
        val fileSize = reader.readInt()
        
        stringPool = AxmlStringPool()
        stringPool.read(reader)
        
        for (s in stringPool.strings) {
            info.stringPool.add(s)
        }

        resourceMap = AxmlResourceMap()
        resourceMap.read(reader)

        var chunkType: Int
        while (true) {
            try {
                chunkType = reader.readInt()
            } catch (e: Exception) {
                break
            }
            
            val chunkSize = reader.readInt()
            val startPos = reader.position - 8
            
            when (chunkType) {
                0x00100102 -> { // START_TAG
                    processStartTag(chunkSize)
                }
                0x00100103 -> { // END_TAG
                    // Skip
                    reader.skip(chunkSize - 8)
                }
                0x00100100 -> { // START_NAMESPACE
                    reader.skip(chunkSize - 8)
                }
                0x00100101 -> { // END_NAMESPACE
                    reader.skip(chunkSize - 8)
                }
                0x00100104 -> { // TEXT
                    reader.skip(chunkSize - 8)
                }
                else -> {
                    if (chunkSize > 8) reader.skip(chunkSize - 8)
                }
            }
        }
        
        return info
    }

    private fun processStartTag(chunkSize: Int) {
        val lineNumber = reader.readInt()
        reader.readInt() // 0xFFFFFFFF
        val namespaceUri = reader.readInt()
        val name = reader.readInt()
        val flags = reader.readInt()
        val attributeCount = reader.readInt()
        val classAttribute = reader.readInt()
        
        val tagName = stringPool.strings[name]
        
        for (i in 0 until attributeCount) {
            val attrNamespaceUri = reader.readInt()
            val attrNameIndex = reader.readInt()
            val attrValueIndex = reader.readInt()
            val attrType = reader.readInt() shr 16
            val attrData = reader.readInt()
            
            val attrName = if (attrNameIndex != -1) stringPool.strings[attrNameIndex] else ""
            
            when (tagName) {
                "manifest" -> {
                    when (attrName) {
                        "versionCode" -> info.versionCode = attrData
                        "versionName" -> {
                            info.versionNameStringId = attrValueIndex
                            info.versionName = if (attrValueIndex != -1) stringPool.strings[attrValueIndex] else ""
                        }
                        "installLocation" -> info.installLocation = attrData
                        "package" -> {
                            info.packageStringId = attrValueIndex
                            info.packageName = if (attrValueIndex != -1) stringPool.strings[attrValueIndex] else ""
                        }
                    }
                }
                "application" -> {
                    when (attrName) {
                        "label" -> {
                            if (attrType == 3) { // String
                                info.labelStringId = attrValueIndex
                                info.label = if (attrValueIndex != -1) stringPool.strings[attrValueIndex] else ""
                            } else {
                                info.labelResourceId = attrData
                            }
                        }
                        "name" -> {
                            info.applicationName = if (attrValueIndex != -1) stringPool.strings[attrValueIndex] else ""
                        }
                        "icon" -> info.iconStringId = attrData // Simplified
                    }
                }
                "uses-sdk" -> {
                    when (attrName) {
                        "minSdkVersion" -> info.minSdkVersion = attrData
                        "targetSdkVersion" -> info.targetSdkVersion = attrData
                        "maxSdkVersion" -> info.maxSdkVersion = attrData
                    }
                }
                "uses-permission" -> {
                    if (attrName == "name") {
                        val perm = if (attrValueIndex != -1) stringPool.strings[attrValueIndex] else ""
                        info.usesPermissions.add(perm)
                    }
                }
                "provider" -> {
                    // Logic for providers could be added here if needed
                }
            }
        }
    }
}
