package com.saas.apkeditorplus.full

import java.util.Locale

internal object FullEditLanguageCatalog {
    private val codes = arrayOf(
        "-af", "-sq", "-ar", "-hy", "-az", "-eu", "-be", "-bn", "-bs", "-bg",
        "-ca", "-ny", "-zh-rCN", "-zh-rTW", "-hr", "-cs", "-da", "-nl", "-en", "-eo",
        "-et", "-tl", "-fi", "-fr", "-gl", "-ka", "-de", "-el", "-gu", "-ht",
        "-ha", "-iw", "-hi", "-hu", "-is", "-ig", "-id", "-ga", "-it", "-ja",
        "-kn", "-kk", "-km", "-ko", "-lo", "-la", "-lv", "-lt", "-mk", "-mg",
        "-ms", "-ml", "-mt", "-mi", "-mr", "-mn", "-my", "-ne", "-no", "-fa",
        "-pl", "-pt", "-pa", "-ro", "-ru", "-sr", "-st", "-si", "-sk", "-sl",
        "-so", "-es", "-su", "-sw", "-sv", "-tg", "-ta", "-te", "-th", "-tr",
        "-uk", "-ur", "-uz", "-vi", "-cy", "-yi", "-yo", "-zu"
    )

    private val languages = arrayOf(
        "Afrikaans", "Albanian", "Arabic", "Armenian", "Azerbaijani", "Basque",
        "Belarusian", "Bengali", "Bosnian", "Bulgarian", "Catalan", "Chichewa",
        "Chinese (Simplified)", "Chinese (Traditional)", "Croatian", "Czech", "Danish",
        "Dutch", "English", "Esperanto", "Estonian", "Filipino", "Finnish", "French",
        "Galician", "Georgian", "German", "Greek", "Gujarati", "Haitian Creole",
        "Hausa", "Hebrew", "Hindi", "Hungarian", "Icelandic", "Igbo", "Indonesian",
        "Irish", "Italian", "Japanese", "Kannada", "Kazakh", "Khmer", "Korean",
        "Lao", "Latin", "Latvian", "Lithuanian", "Macedonian", "Malagasy", "Malay",
        "Malayalam", "Maltese", "Maori", "Marathi", "Mongolian", "Myanmar (Burmese)",
        "Nepali", "Norwegian", "Persian", "Polish", "Portuguese", "Punjabi", "Romanian",
        "Russian", "Serbian", "Sesotho", "Sinhala", "Slovak", "Slovenian", "Somali",
        "Spanish", "Sundanese", "Swahili", "Swedish", "Tajik", "Tamil", "Telugu",
        "Thai", "Turkish", "Ukrainian", "Urdu", "Uzbek", "Vietnamese", "Welsh",
        "Yiddish", "Yoruba", "Zulu"
    )

    fun languageNames(): List<String> = languages.toList()

    fun codeAt(index: Int): String = codes.getOrElse(index) { "-en" }

    fun indexOfBestMatch(qualifier: String): Int {
        if (qualifier.isBlank()) {
            return codes.indexOf("-${Locale.getDefault().language}").takeIf { it >= 0 } ?: 0
        }
        val normalized = qualifier.substringBefore("-r")
        return codes.indexOf(qualifier).takeIf { it >= 0 }
            ?: codes.indexOf(normalized).takeIf { it >= 0 }
            ?: 0
    }

    fun labelForQualifier(qualifier: String): String {
        if (qualifier.isBlank()) {
            return "[ Default ]"
        }
        val shortCode = qualifier.substringBefore("-r")
        val index = codes.indexOf(shortCode).takeIf { it >= 0 } ?: codes.indexOf(qualifier)
        return if (index >= 0) {
            "${languages[index]} ($qualifier)"
        } else {
            "($qualifier)"
        }
    }
}
