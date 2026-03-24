package com.saas.apkeditorplus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

enum class MainMenuDestination {
    APK_FILE,
    INSTALLED_APP,
    COMMON_EDIT,
    PROJECTS,
    SIGN_APK,
    VERIFY_SIGNATURE,
    SIGNATURE_KEYS,
    GIT_STATUS,
    SETTINGS,
    EXIT
}

data class MainMenuItem(
    val titleRes: Int,
    val subtitleRes: Int,
    val iconRes: Int,
    val destination: MainMenuDestination
)

class MainMenuAdapter(
    context: Context,
    private val items: List<MainMenuItem>
) : BaseAdapter() {

    private val inflater = LayoutInflater.from(context)

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): MainMenuItem = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater.inflate(R.layout.item_main_menu, parent, false).also {
            it.tag = ViewHolder(
                iconView = it.findViewById(R.id.main_menu_icon),
                titleView = it.findViewById(R.id.main_menu_title),
                subtitleView = it.findViewById(R.id.main_menu_subtitle)
            )
        }

        val holder = view.tag as ViewHolder
        val item = getItem(position)
        holder.iconView.setImageResource(item.iconRes)
        holder.titleView.setText(item.titleRes)
        holder.subtitleView.setText(item.subtitleRes)
        return view
    }

    private data class ViewHolder(
        val iconView: ImageView,
        val titleView: TextView,
        val subtitleView: TextView
    )
}
