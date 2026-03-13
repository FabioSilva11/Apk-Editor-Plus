package com.saas.apkeditorplus.engine.axml

import java.io.IOException
import java.nio.ByteBuffer
import java.nio.charset.Charset

class AxmlStringPool {
    private val utf16Decoder = Charset.forName("UTF-16LE").newDecoder()
    private val utf8Decoder = Charset.forName("UTF-8").newDecoder()

    var chunkSize: Int = 0
    var stringCount: Int = 0
    var styleCount: Int = 0
    var flags: Int = 0
    var stringDataOffset: Int = 0
    var styleDataOffset: Int = 0
    var isUtf8: Boolean = false
    
    var strings: Array<String> = emptyArray()
    var stringData: Array<ByteArray> = emptyArray()
    var styles: IntArray? = null
    var styleData: IntArray? = null
    
    val modifiedIndices = mutableListOf<Int>()
    private val header = ByteArray(28)

    @Throws(IOException::class)
    fun read(reader: BinaryReader) {
        reader.readBytes(header)
        chunkSize = getInt(header, 4)
        stringCount = getInt(header, 8)
        styleCount = getInt(header, 12)
        flags = getInt(header, 16)
        stringDataOffset = getInt(header, 20)
        styleDataOffset = getInt(header, 24)
        isUtf8 = (flags and 0x100) != 0

        val stringOffsets = reader.readIntArray(stringCount)
        if (styleCount != 0) {
            styles = reader.readIntArray(styleCount)
        }

        val padding = stringDataOffset - ((stringCount * 4) + 28 + (styleCount * 4))
        if (padding > 0) {
            reader.skip(padding)
        }

        val dataSize = (if (styleDataOffset == 0) chunkSize else styleDataOffset) - stringDataOffset
        val allData = ByteArray(dataSize)
        reader.readBytes(allData)

        if (styleDataOffset > 0) {
            val sDataSize = chunkSize - styleDataOffset
            styleData = IntArray(sDataSize / 4)
            // Lógica simplificada: não estamos processando estilos profundamente por enquanto
            reader.skip(sDataSize)
        }

        strings = Array(stringCount) { "" }
        stringData = Array(stringCount) { byteArrayOf() }

        for (i in 0 until stringCount) {
            val offset = stringOffsets[i]
            if (isUtf8) {
                val len1 = allData[offset].toInt() and 0xFF
                val lenOffset = if (len1 and 0x80 != 0) 2 else 1
                val len2 = allData[offset + lenOffset].toInt() and 0xFF
                val dataOffset = if (len2 and 0x80 != 0) lenOffset + 2 else lenOffset + 1
                
                var actualLen = 0
                while (allData[offset + dataOffset + actualLen] != 0.toByte()) {
                    actualLen++
                }
                
                stringData[i] = ByteArray(actualLen + dataOffset + 1)
                System.arraycopy(allData, offset, stringData[i], 0, actualLen + dataOffset + 1)
                strings[i] = String(allData, offset + dataOffset, actualLen, Charset.forName("UTF-8"))
            } else {
                val len1 = (allData[offset].toInt() and 0xFF) or ((allData[offset + 1].toInt() and 0xFF) shl 8)
                val lenOffset = if (len1 and 0x8000 != 0) 4 else 2
                val actualLen = (if (len1 and 0x8000 != 0) {
                    ((allData[offset + 3].toInt() and 0xFF) shl 8) or (allData[offset + 2].toInt() and 0xFF)
                } else len1) shl 1
                
                stringData[i] = ByteArray(actualLen)
                System.arraycopy(allData, offset + lenOffset, stringData[i], 0, actualLen)
                strings[i] = utf16Decoder.decode(ByteBuffer.wrap(allData, offset + lenOffset, actualLen)).toString()
            }
        }
    }

    @Throws(IOException::class)
    fun write(writer: BinaryWriter) {
        val stringOffsets = IntArray(stringCount)
        var currentOffset = 0
        for (i in 0 until stringCount) {
            stringOffsets[i] = currentOffset
            val len = stringData[i].size
            currentOffset += if (isUtf8) len else (if (len / 2 <= 32767) 2 else 4) + len + 2
        }

        chunkSize = (if (styleData != null) styleData!!.size * 4 else 0) + 
                    (if (styleCount > 0) styleCount * 4 else 0) + 
                    (stringCount * 4) + 28 + currentOffset
        
        val padding = (4 - (chunkSize % 4)) % 4
        chunkSize += padding

        setInt(header, 4, chunkSize)
        if (styleDataOffset > 0) {
            styleDataOffset = chunkSize - (styleData?.size ?: 0) * 4
            setInt(header, 24, styleDataOffset)
        }

        writer.writeBytes(header)
        writer.writeIntArray(stringOffsets)
        if (styles != null) {
            writer.writeIntArray(styles!!)
        }

        for (i in 0 until stringCount) {
            val data = stringData[i]
            if (isUtf8) {
                writer.writeBytes(data)
            } else {
                val len = data.size / 2
                if (len > 32767) {
                    writer.writeShort((len shr 15) or 0x8000)
                    writer.writeShort(len and 0x7FFF)
                } else {
                    writer.writeShort(len)
                }
                writer.writeBytes(data)
                writer.writeShort(0)
            }
        }

        if (padding > 0) {
            writer.writeBytes(ByteArray(padding))
        }

        if (styleData != null) {
            for (v in styleData!!) {
                writer.writeInt(v)
            }
        }
    }

    fun modifyString(index: Int, newString: String) {
        strings[index] = newString
        stringData[index] = encodeString(newString)
    }

    private fun encodeString(str: String): ByteArray {
        return if (isUtf8) {
            val bytes = str.toByteArray(Charset.forName("UTF-8"))
            val len1 = str.length
            val len2 = bytes.size
            val b1 = encodeLen(len1)
            val b2 = encodeLen(len2)
            val result = ByteArray(b1.size + b2.size + bytes.size + 1)
            System.arraycopy(b1, 0, result, 0, b1.size)
            System.arraycopy(b2, 0, result, b1.size, b2.size)
            System.arraycopy(bytes, 0, result, b1.size + b2.size, bytes.size)
            result
        } else {
            str.toByteArray(Charset.forName("UTF-16LE"))
        }
    }

    private fun encodeLen(len: Int): ByteArray {
        return if (len >= 128) {
            byteArrayOf(((len and 0x7F) or 0x80).toByte(), (len shr 7).toByte())
        } else {
            byteArrayOf(len.toByte())
        }
    }

    private fun getInt(bArr: ByteArray, offset: Int): Int {
        return (bArr[offset].toInt() and 0xFF) or
               ((bArr[offset + 1].toInt() and 0xFF) shl 8) or
               ((bArr[offset + 2].toInt() and 0xFF) shl 16) or
               ((bArr[offset + 3].toInt() and 0xFF) shl 24)
    }

    private fun setInt(bArr: ByteArray, offset: Int, value: Int) {
        bArr[offset] = (value and 0xFF).toByte()
        bArr[offset + 1] = ((value shr 8) and 0xFF).toByte()
        bArr[offset + 2] = ((value shr 16) and 0xFF).toByte()
        bArr[offset + 3] = ((value shr 24) and 0xFF).toByte()
    }
}
