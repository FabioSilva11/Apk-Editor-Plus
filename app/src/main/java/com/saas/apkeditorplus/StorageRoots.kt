package com.saas.apkeditorplus

import android.content.Context
import android.os.Environment
import java.io.File

object StorageRoots {

    fun primary(context: Context): File {
        val externalStorage = Environment.getExternalStorageDirectory()
        if (externalStorage != null && externalStorage.exists()) {
            return externalStorage
        }

        return context.getExternalFilesDir(null)
            ?.let(::deriveRoot)
            ?: context.filesDir
    }

    fun external(context: Context): File? {
        val primaryRoot = primary(context)
        val roots = context.getExternalFilesDirs(null)
            .mapNotNull(::deriveRoot)

        return roots.firstOrNull { candidate ->
            runCatching { candidate.canonicalPath != primaryRoot.canonicalPath }
                .getOrDefault(candidate.absolutePath != primaryRoot.absolutePath)
        }
    }

    private fun deriveRoot(appSpecificDir: File?): File? {
        if (appSpecificDir == null) {
            return null
        }

        val marker = "${File.separator}Android${File.separator}data${File.separator}"
        val absolutePath = appSpecificDir.absolutePath
        val markerIndex = absolutePath.indexOf(marker)
        if (markerIndex == -1) {
            return appSpecificDir
        }

        return File(absolutePath.substring(0, markerIndex))
    }
}
