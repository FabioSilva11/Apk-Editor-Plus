package com.saas.apkeditorplus.utils

import android.content.Context
import com.apk.axml.aXMLEncoder
import java.io.InputStream
import java.io.OutputStream
import java.lang.Exception

class AxmlEncoder {

    /**
     * Codifica um XML legível para o formato AXML (binário).
     * @param xmlString O conteúdo XML em formato String.
     * @param context O contexto do Android (necessário para a biblioteca).
     * @return Os bytes do arquivo AXML codificado, ou null em caso de erro.
     */
    fun encode(xmlString: String, context: Context): ByteArray? {
        return try {
            val encoder = aXMLEncoder()
            // A assinatura real da biblioteca parece ser encodeString(context, xmlString)
            encoder.encodeString(context, xmlString)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * Codifica um XML legível e escreve no OutputStream.
     */
    fun encodeToStream(xmlString: String, outputStream: OutputStream, context: Context): Boolean {
        return try {
            val data = encode(xmlString, context)
            if (data != null) {
                outputStream.write(data as ByteArray)
                outputStream.flush()
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
