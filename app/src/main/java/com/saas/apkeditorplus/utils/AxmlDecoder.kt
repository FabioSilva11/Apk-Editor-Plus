package com.saas.apkeditorplus.utils

import com.apk.axml.aXMLDecoder
import com.apk.axml.serializableItems.ResEntry
import java.io.InputStream
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.lang.Exception

class AxmlDecoder {

    /**
     * Decodifica um arquivo AXML (binário) para XML legível.
     * @param inputStream O stream do arquivo binário.
     * @param outputStream O stream onde o XML decodificado será gravado.
     * @return true se a decodificação for bem-sucedida.
     */
    fun decode(inputStream: InputStream, outputStream: OutputStream): Boolean {
        return try {
            val decoder = aXMLDecoder(inputStream)
            val decodedString = decoder.decodeAsString()
            
            if (decodedString != null) {
                val writer = OutputStreamWriter(outputStream, "UTF-8")
                writer.write(decodedString as String)
                writer.flush()
                true
            } else {
                false
            }
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
    
    /**
     * Decodifica um arquivo AXML usando uma tabela de recursos para resolver IDs.
     */
    @Suppress("UNCHECKED_CAST")
    fun decodeWithResources(inputStream: InputStream, outputStream: OutputStream, resources: List<*>?): Boolean {
        if (resources == null) return decode(inputStream, outputStream)
        
        return try {
            val decoder = aXMLDecoder(inputStream, resources as List<ResEntry>)
            val decodedString = decoder.decodeAsString()
            
            if (decodedString != null) {
                val writer = OutputStreamWriter(outputStream, "UTF-8")
                writer.write(decodedString as String)
                writer.flush()
                true
            } else {
                false
            }
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
