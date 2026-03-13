package com.saas.apkeditorplus.engine.axml

import java.io.IOException
import java.io.InputStream

class BinaryReader(private val inputStream: InputStream) {

    var position = 0

    @Throws(IOException::class)
    fun readInt(): Int {
        val bArr = ByteArray(4)
        val read = inputStream.read(bArr)
        if (read != 4) throw IOException("Failed to read 4 bytes")
        position += 4
        return (bArr[0].toInt() and 0xFF) or
               ((bArr[1].toInt() and 0xFF) shl 8) or
               ((bArr[2].toInt() and 0xFF) shl 16) or
               ((bArr[3].toInt() and 0xFF) shl 24)
    }

    @Throws(IOException::class)
    fun readBytes(bArr: ByteArray) {
        var totalRead = 0
        while (totalRead < bArr.size) {
            val n = inputStream.read(bArr, totalRead, bArr.size - totalRead)
            if (n == -1) break
            if (n > 0) {
                position += n
                totalRead += n
            }
        }
    }

    @Throws(IOException::class)
    fun readIntArray(count: Int): IntArray {
        val array = IntArray(count)
        for (i in 0 until count) {
            array[i] = readInt()
        }
        return array
    }

    @Throws(IOException::class)
    fun skip(n: Int) {
        val skipped = inputStream.skip(n.toLong())
        position += skipped.toInt()
    }
}
