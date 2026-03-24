package com.saas.apkeditorplus

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.LruCache
import java.io.File
import java.util.Collections
import java.util.concurrent.Executors

data class ApkArchiveInfo(
    val label: String,
    val packageName: String,
    val icon: Drawable?
)

class ApkArchiveInfoLoader(context: Context) {

    private val appContext = context.applicationContext
    private val packageManager = appContext.packageManager
    private val cache = LruCache<String, ApkArchiveInfo>(64)
    private val queuedPaths = Collections.synchronizedSet(mutableSetOf<String>())
    private val executor = Executors.newSingleThreadExecutor()

    fun get(path: String): ApkArchiveInfo? = cache.get(path)

    fun load(path: String, onLoaded: () -> Unit) {
        if (cache.get(path) != null || !queuedPaths.add(path)) {
            return
        }

        executor.execute {
            val parsed = parse(path)
            if (parsed != null) {
                cache.put(path, parsed)
            }
            queuedPaths.remove(path)
            onLoaded()
        }
    }

    fun shutdown() {
        executor.shutdownNow()
    }

    private fun parse(path: String): ApkArchiveInfo? {
        val apkFile = File(path)
        if (!apkFile.exists()) {
            return null
        }

        val archiveInfo = runCatching {
            packageManager.getPackageArchiveInfo(path, 0)
        }.getOrNull() ?: return null

        val applicationInfo = archiveInfo.applicationInfo ?: return null
        applicationInfo.sourceDir = path
        applicationInfo.publicSourceDir = path

        val label = runCatching {
            applicationInfo.loadLabel(packageManager).toString()
        }.getOrElse {
            apkFile.nameWithoutExtension
        }

        val icon = runCatching {
            applicationInfo.loadIcon(packageManager)
        }.getOrNull()

        return ApkArchiveInfo(
            label = label,
            packageName = archiveInfo.packageName.orEmpty(),
            icon = icon
        )
    }
}
