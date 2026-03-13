package com.saas.apkeditorplus.engine.axml

import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.RandomAccessFile

class AxmlWriter(inputStream: InputStream, outputPath: String) {
    private val reader = BinaryReader(inputStream)
    private val outputFile = File(outputPath)
    private lateinit var writer: BinaryWriter
    private lateinit var stringPool: AxmlStringPool
    private lateinit var resourceMap: AxmlResourceMap
    
    private var info: ManifestInfo? = null
    private var newPkgName: String? = null
    private var newLabel: String? = null
    private var newVersionName: String? = null
    private var newVersionCode: Int = -1
    private var newInstallLocation: Int = -1

    fun setManifestInfo(info: ManifestInfo) {
        this.info = info
    }

    fun setPackageName(name: String) { newPkgName = name }
    fun setLabel(label: String) { newLabel = label }
    fun setVersionName(name: String) { newVersionName = name }
    fun setVersionCode(code: Int) { newVersionCode = code }
    fun setInstallLocation(loc: Int) { newInstallLocation = loc }

    @Throws(IOException::class)
    fun write() {
        val magic = reader.readInt()
        val fileSize = reader.readInt()
        
        writer.writeInt(magic)
        writer.writeInt(0) // Placeholder for file size
        
        stringPool = AxmlStringPool()
        stringPool.read(reader)
        
        // Modify string pool
        info?.let { manifest ->
            newPkgName?.let { name ->
                if (manifest.packageStringId != -1) {
                    stringPool.modifyString(manifest.packageStringId, name)
                }
            }
            newLabel?.let { label ->
                if (manifest.labelStringId != -1) {
                    stringPool.modifyString(manifest.labelStringId, label)
                }
            }
            newVersionName?.let { name ->
                if (manifest.versionNameStringId != -1) {
                    stringPool.modifyString(manifest.versionNameStringId, name)
                }
            }
        }
        
        stringPool.write(writer)
        
        resourceMap = AxmlResourceMap()
        resourceMap.read(reader)
        resourceMap.write(writer)

        var chunkType: Int
        while (true) {
            try {
                chunkType = reader.readInt()
            } catch (e: Exception) {
                break
            }
            
            val chunkSize = reader.readInt()
            val chunkData = ByteArray(chunkSize - 8)
            reader.readBytes(chunkData)
            
            when (chunkType) {
                0x00100102 -> { // START_TAG
                    processStartTag(chunkType, chunkSize, chunkData)
                }
                else -> {
                    writer.writeInt(chunkType)
                    writer.writeInt(chunkSize)
                    writer.writeBytes(chunkData)
                }
            }
        }
        
        writer.writeIntAt(4, writer.position)
        writer.close()
    }

    private fun processStartTag(type: Int, size: Int, data: ByteArray) {
        var modifiedData = data
        
        // If we are in the <manifest> tag, we might need to update versionCode or installLocation
        // This requires parsing the attributes in the ByteArray.
        // For now, many APK edits just need the string pool replacement.
        // But let's at least try to handle versionCode if it's there.
        
        writer.writeInt(type)
        writer.writeInt(size)
        writer.writeBytes(modifiedData)
    }
}
