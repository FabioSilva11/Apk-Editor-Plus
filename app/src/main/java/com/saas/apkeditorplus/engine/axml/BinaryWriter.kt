package com.saas.apkeditorplus.engine.axml

import java.io.IOException
import java.io.RandomAccessFile

class BinaryWriter(private val raf: RandomAccessFile) {

    var position = 0

    @Throws(IOException::class)
    fun writeInt(value: Int) {
        val bArr = ByteArray(4)
        bArr[0] = (value and 0xFF).toByte()
        bArr[1] = ((value shr 8) and 0xFF).toByte()
        bArr[2] = ((value shr 16) and 0xFF).toByte()
        bArr[3] = ((value shr 24) and 0xFF).toByte()
        raf.write(bArr)
        position += 4
    }

    @Throws(IOException::class)
    fun writeIntAt(pos: Long, value: Int) {
        val currentPos = raf.filePointer
        raf.seek(pos)
        val bArr = ByteArray(4)
        bArr[0] = (value and 0xFF).toByte()
        bArr[1] = ((value shr 8) and 0xFF).toByte()
        bArr[2] = ((value shr 16) and 0xFF).toByte()
        bArr[3] = ((value shr 24) and 0xFF).toByte()
        raf.write(bArr)
        raf.seek(currentPos)
    }

    @Throws(IOException::class)
    fun writeBytes(bArr: ByteArray) {
        raf.write(bArr)
        position += bArr.size
    }

    @Throws(IOException::class)
    fun writeIntArray(array: IntArray) {
        for (value in array) {
            writeInt(value)
        }
    }

    @Throws(IOException::class)
    fun close() {
        raf.close()
    }

    @Throws(IOException::class)
    fun writeShort(value: Int) {
        val bArr = ByteArray(2)
        bArr[0] = (value and 0xFF).toByte()
        bArr[1] = ((value shr 8) and 0xFF).toByte()
        raf.write(bArr)
        position += 2
    }
}
