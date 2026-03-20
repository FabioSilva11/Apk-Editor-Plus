package com.saas.apkeditorplus

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.LruCache
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.io.File
import java.util.*

class FileAdapter(private val context: Context, private var currentDir: File) : BaseAdapter() {

    private var files: Array<File> = arrayOf()
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val iconCache = LruCache<String, Drawable>(64)

    init {
        refresh()
    }

    fun refresh() {
        val allFiles = currentDir.listFiles() ?: arrayOf()
        // Ordena: pastas primeiro, depois arquivos por nome
        files = allFiles.sortedWith(compareBy({ !it.isDirectory }, { it.name.lowercase(Locale.getDefault()) })).toTypedArray()
        notifyDataSetChanged()
    }

    fun setDir(dirPath: String) {
        val newDir = File(dirPath)
        if (newDir.exists() && newDir.isDirectory) {
            currentDir = newDir
            refresh()
        }
    }

    fun getCurrentDir(): File = currentDir

    override fun getCount(): Int = files.size + (if (currentDir.parentFile != null) 1 else 0)

    override fun getItem(position: Int): Any? {
        if (currentDir.parentFile != null) {
            if (position == 0) return File(currentDir.parent, "..")
            return files[position - 1]
        }
        return files[position]
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: inflater.inflate(R.layout.item_file, parent, false)
        val icon: ImageView = view.findViewById(R.id.file_icon)
        val name: TextView = view.findViewById(R.id.file_name)
        val info: TextView = view.findViewById(R.id.file_details)

        val file = getItem(position) as File
        name.text = file.name
        
        // Resolve a cor do tema para tintar os ícones do sistema
        val typedValue = android.util.TypedValue()
        context.theme.resolveAttribute(R.attr.iconPrimary, typedValue, true)
        val iconTintColor = typedValue.data

        if (file.isDirectory) {
            icon.setImageResource(R.drawable.ic_folder)
            icon.setColorFilter(iconTintColor)
            info.text = "Pasta"
        } else {
            if (file.name.endsWith(".apk", true)) {
                icon.clearColorFilter() // Remove qualquer tint para mostrar o ícone real colorid
                val cachedIcon = iconCache.get(file.path)
                if (cachedIcon != null) {
                    icon.setImageDrawable(cachedIcon)
                } else {
                    try {
                        val packageManager = context.packageManager
                        val archiveInfo = packageManager.getPackageArchiveInfo(file.path, 0)
                        val appInfo = archiveInfo?.applicationInfo
                        if (appInfo != null) {
                            appInfo.sourceDir = file.path
                            appInfo.publicSourceDir = file.path
                            val iconDrawable = appInfo.loadIcon(packageManager)
                            iconCache.put(file.path, iconDrawable)
                            icon.setImageDrawable(iconDrawable)
                        } else {
                            icon.setImageResource(R.drawable.apk_icon)
                        }
                    } catch (e: Exception) {
                        icon.setImageResource(R.drawable.apk_icon)
                    }
                }
            } else {
                icon.setImageResource(R.drawable.ic_file_unknown)
                icon.setColorFilter(iconTintColor)
            }
            info.text = formatFileSize(file.length())
        }

        return view
    }

    private fun formatFileSize(size: Long): String {
        if (size <= 0) return "0 B"
        val units = arrayOf("B", "KB", "MB", "GB", "TB")
        val digitGroups = (Math.log10(size.toDouble()) / Math.log10(1024.0)).toInt()
        return String.format("%.1f %s", size / Math.pow(1024.0, digitGroups.toDouble()), units[digitGroups])
    }
}
