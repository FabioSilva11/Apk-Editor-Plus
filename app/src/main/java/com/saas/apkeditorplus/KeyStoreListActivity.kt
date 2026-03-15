package com.saas.apkeditorplus

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import java.io.File
import java.util.*

class KeyStoreListActivity : BaseActivity() {

    private lateinit var listView: ListView
    private lateinit var tvEmpty: TextView
    private lateinit var adapter: KeyStoreAdapter
    private lateinit var manager: KeyStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keystore_list)

        manager = KeyStoreManager(this)
        listView = findViewById(R.id.list_view)
        tvEmpty = findViewById(R.id.tv_empty)
        
        setupToolbar()
        setupListView()
        
        findViewById<FloatingActionButton>(R.id.fab_add).setOnClickListener {
            showCreateDialog()
        }
    }

    private fun setupToolbar() {
        val toolbar = findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener { finish() }
    }

    private fun setupListView() {
        adapter = KeyStoreAdapter(manager.listKeyStores().toMutableList())
        listView.adapter = adapter
        updateEmptyState()

        listView.setOnItemClickListener { _, _, position, _ ->
            val file = adapter.getItem(position)
            Toast.makeText(this, "Key: ${file.name}", Toast.LENGTH_SHORT).show()
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            showDeleteConfirm(adapter.getItem(position), position)
            true
        }
    }

    private fun updateEmptyState() {
        if (adapter.count == 0) {
            tvEmpty.visibility = View.VISIBLE
            listView.visibility = View.GONE
        } else {
            tvEmpty.visibility = View.GONE
            listView.visibility = View.VISIBLE
        }
    }

    private fun showCreateDialog() {
        val view = layoutInflater.inflate(R.layout.dlg_create_keystore, null)
        val etName = view.findViewById<TextInputEditText>(R.id.et_name)
        val etKsPass = view.findViewById<TextInputEditText>(R.id.et_ks_pass)
        val etAlias = view.findViewById<TextInputEditText>(R.id.et_alias)
        val etKeyPass = view.findViewById<TextInputEditText>(R.id.et_key_pass)
        
        // Cert info
        val etCn = view.findViewById<TextInputEditText>(R.id.et_cn)
        val etOu = view.findViewById<TextInputEditText>(R.id.et_ou)
        val etO = view.findViewById<TextInputEditText>(R.id.et_o)
        val etL = view.findViewById<TextInputEditText>(R.id.et_l)
        val etS = view.findViewById<TextInputEditText>(R.id.et_s)
        val etC = view.findViewById<TextInputEditText>(R.id.et_c)

        AlertDialog.Builder(this)
            .setTitle(R.string.create_keystore)
            .setView(view)
            .setPositiveButton(R.string.create) { dialog, _ ->
                val name = etName.text.toString()
                val ksPass = etKsPass.text.toString()
                val alias = etAlias.text.toString()
                val keyPass = etKeyPass.text.toString()
                
                if (name.isEmpty() || ksPass.isEmpty() || alias.isEmpty() || keyPass.isEmpty()) {
                    Toast.makeText(this, getString(R.string.fill_all_required_fields), Toast.LENGTH_SHORT).show()
                    return@setPositiveButton
                }

                try {
                    val file = manager.createKeyStore(
                        name,
                        ksPass.toCharArray(),
                        alias,
                        etCn.text.toString(),
                        etOu.text.toString(),
                        etO.text.toString(),
                        etL.text.toString(),
                        etS.text.toString(),
                        etC.text.toString()
                    )
                    adapter.add(file)
                    updateEmptyState()
                    Toast.makeText(this, getString(R.string.key_created_successfully), Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Toast.makeText(this, "Erro: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
            .setNegativeButton(R.string.colormixer_cancel, null)
            .show()
    }

    private fun showDeleteConfirm(file: File, position: Int) {
        AlertDialog.Builder(this)
            .setTitle(R.string.delete_key)
            .setMessage(getString(R.string.confirm_delete_key, file.name))
            .setPositiveButton(R.string.delete) { dialog, _ ->
                if (file.delete()) {
                    adapter.removeAt(position)
                    updateEmptyState()
                    Toast.makeText(this, getString(R.string.deleted), Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(R.string.colormixer_cancel, null)
            .show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private inner class KeyStoreAdapter(private val list: MutableList<File>) : BaseAdapter() {
        override fun getCount(): Int = list.size
        override fun getItem(position: Int): File = list[position]
        override fun getItemId(position: Int): Long = position.toLong()

        fun add(file: File) {
            list.add(file)
            notifyDataSetChanged()
        }

        fun removeAt(position: Int) {
            list.removeAt(position)
            notifyDataSetChanged()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = convertView ?: layoutInflater.inflate(android.R.layout.simple_list_item_2, parent, false)
            val file = getItem(position)
            
            val text1 = view.findViewById<TextView>(android.R.id.text1)
            val text2 = view.findViewById<TextView>(android.R.id.text2)
            
            text1.text = file.name
            text2.text = getString(R.string.path_label, file.absolutePath)
            
            return view
        }
    }
}
