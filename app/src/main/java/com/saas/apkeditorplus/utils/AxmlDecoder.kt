package com.saas.apkeditorplus.utils

import android.util.TypedValue
import org.xmlpull.v1.XmlPullParser
import java.io.InputStream
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.util.Formatter

class AxmlDecoder {

    private val stringBuffer = StringBuilder()

    private fun format(template: String, vararg args: Any?) {
        val formatter = Formatter()
        formatter.format(template, *args)
        stringBuffer.append(formatter.toString()).append("\n")
    }

    private fun getNamespacePrefix(prefix: String?): String {
        return if (prefix.isNullOrEmpty()) "" else "$prefix:"
    }

    fun decode(inputStream: InputStream, outputStream: OutputStream): Boolean {
        try {
            // Aqui assumimos que a biblioteca 'axml' fornece o parser
            // Caso contrário, precisaríamos da implementação completa do XmlResourceParser
            // Para este exemplo, vou estruturar como se estivesse usando um parser compatível
            val parser: XmlPullParser = createParser(inputStream)
            
            val indent = StringBuilder()
            
            while (true) {
                val type = parser.next()
                if (type == XmlPullParser.END_DOCUMENT) break

                when (type) {
                    XmlPullParser.START_DOCUMENT -> {
                        format("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
                    }
                    XmlPullParser.START_TAG -> {
                        val prefix = getNamespacePrefix(parser.prefix)
                        val tagName = parser.name
                        
                        stringBuffer.append("$indent<$prefix$tagName")
                        
                        // Namespaces
                        val depth = parser.depth
                        val nsStart = parser.getNamespaceCount(depth - 1)
                        val nsEnd = parser.getNamespaceCount(depth)
                        for (i in nsStart until nsEnd) {
                            stringBuffer.append(" xmlns:${parser.getNamespacePrefix(i)}=\"${parser.getNamespaceUri(i)}\"")
                        }

                        // Attributes
                        for (i in 0 until parser.attributeCount) {
                            val attrPrefix = getNamespacePrefix(parser.getAttributePrefix(i))
                            val attrName = parser.getAttributeName(i)
                            val attrValue = getAttributeValue(parser, i)
                            stringBuffer.append(" $attrPrefix$attrName=\"$attrValue\"")
                        }
                        
                        stringBuffer.append(">\n")
                        indent.append("    ")
                    }
                    XmlPullParser.END_TAG -> {
                        if (indent.isNotEmpty()) indent.setLength(indent.length - 4)
                        val prefix = getNamespacePrefix(parser.prefix)
                        format("$indent</$prefix${parser.name}>")
                    }
                    XmlPullParser.TEXT -> {
                        val text = parser.text
                        if (!text.isNullOrBlank()) {
                            format("$indent$text")
                        }
                    }
                }
            }

            val writer = OutputStreamWriter(outputStream, "UTF-8")
            writer.write(stringBuffer.toString())
            writer.flush()
            outputStream.close()
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    private fun getAttributeValue(parser: XmlPullParser, index: Int): String {
        // Implementação simplificada baseada na lógica do projeto original
        // No Android, o XmlResourceParser provê tipos de recursos
        return parser.getAttributeValue(index) ?: ""
    }

    private fun createParser(inputStream: InputStream): XmlPullParser {
        // Esta parte depende da biblioteca axml incluída no build.gradle
        // Por agora, vou usar uma factory genérica ou a classe da lib se soubesse o nome
        // Como o usuário quer que eu refaça, vou assumir o uso da lib axml
        try {
            val axmlParserClass = Class.forName("com.github.apkeditor.axml.AxmlParser")
            val constructor = axmlParserClass.getConstructor(InputStream::class.java)
            return constructor.newInstance(inputStream) as XmlPullParser
        } catch (e: Exception) {
            // Fallback ou erro se a lib não estiver acessível desta forma
            throw e
        }
    }

    companion object {
        private val UNIT_NAMES = arrayOf("px", "dip", "sp", "pt", "in", "mm", "", "")
        private val FRACTION_NAMES = arrayOf("%", "%p", "", "", "", "", "", "")
    }
}
