package com.saas.apkeditorplus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class EditModeDialog(
    private val context: Context,
    private val apkPath: String,
    private val onModeSelected: (mode: Int, path: String) -> Unit
) {
    companion object {
        const val FULL_EDIT = 0
        const val SIMPLE_EDIT = 1
        const val COMMON_EDIT = 2
        const val XML_FILE_EDIT = 4
    }

    private var dialog: AlertDialog? = null

    fun show() {
        val view = LayoutInflater.from(context).inflate(R.layout.dlg_editmode, null)
        
        val builder = AlertDialog.Builder(context)
            .setTitle(R.string.edit_mode)
            .setView(view)
            .setNegativeButton(R.string.colormixer_cancel, null)

        dialog = builder.create()

        view.findViewById<TextView>(R.id.full_edit).setOnClickListener {
            onModeSelected(0, apkPath)
            dialog?.dismiss()
        }
        
        view.findViewById<TextView>(R.id.simple_edit).setOnClickListener {
            onModeSelected(1, apkPath)
            dialog?.dismiss()
        }
        
        view.findViewById<TextView>(R.id.common_edit).setOnClickListener {
            onModeSelected(2, apkPath)
            dialog?.dismiss()
        }
        
        view.findViewById<TextView>(R.id.xml_edit).setOnClickListener {
            onModeSelected(4, apkPath)
            dialog?.dismiss()
        }
        
        // Se houver um item de edição de dados, pode ser configurado aqui
        val dataEdit = view.findViewById<TextView>(R.id.data_edit)
        dataEdit?.visibility = View.GONE 

        dialog?.show()
    }
}
