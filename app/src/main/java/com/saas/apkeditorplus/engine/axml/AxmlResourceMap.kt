package com.saas.apkeditorplus.engine.axml

import java.io.IOException

class AxmlResourceMap {
    var resourceIds: IntArray = intArrayOf()
    private var type: Int = 0
    private var size: Int = 0

    @Throws(IOException::class)
    fun read(reader: BinaryReader) {
        type = reader.readInt()
        size = reader.readInt()
        val count = (size - 8) / 4
        resourceIds = reader.readIntArray(count)
    }

    @Throws(IOException::class)
    fun write(writer: BinaryWriter) {
        writer.writeInt(type)
        writer.writeInt(size)
        writer.writeIntArray(resourceIds)
    }
}
