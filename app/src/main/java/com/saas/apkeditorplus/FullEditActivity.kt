package com.saas.apkeditorplus

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.saas.apkeditorplus.full.FilesFragment
import com.saas.apkeditorplus.full.ManifestFragment
import com.saas.apkeditorplus.full.StringFragment
import java.io.File

class FullEditActivity : BaseActivity() {

    private lateinit var rootView: View
    private lateinit var headerContainer: View
    private lateinit var bottomTabsContainer: View
    private lateinit var viewPager: ViewPager2
    private lateinit var apkIconView: ImageView
    private lateinit var apkTitleView: TextView
    private lateinit var apkPackageView: TextView
    private lateinit var actionWebserverButton: ImageButton
    private lateinit var actionPatchButton: ImageButton
    private lateinit var actionBuildButton: TextView
    private lateinit var tabString: TextView
    private lateinit var tabFiles: TextView
    private lateinit var tabManifest: TextView
    private lateinit var apkPath: String
    private val modifiedFiles = linkedMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fulledit)

        apkPath = intent.getStringExtra("apkPath") ?: ""
        if (apkPath.isBlank()) {
            Toast.makeText(this, getString(R.string.apk_path_not_found), Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        rootView = findViewById(R.id.full_edit_root)
        headerContainer = findViewById(R.id.header_container)
        bottomTabsContainer = findViewById(R.id.bottom_tabs_container)
        viewPager = findViewById(R.id.view_pager)
        apkIconView = findViewById(R.id.apk_icon)
        apkTitleView = findViewById(R.id.apk_title)
        apkPackageView = findViewById(R.id.apk_package)
        actionWebserverButton = findViewById(R.id.action_webserver_button)
        actionPatchButton = findViewById(R.id.action_patch_button)
        actionBuildButton = findViewById(R.id.action_build_button)
        tabString = findViewById(R.id.tab_string)
        tabFiles = findViewById(R.id.tab_files)
        tabManifest = findViewById(R.id.tab_manifest)

        setupViewPager()
        setupTabs()
        setupActions()
        applyWindowInsets()
        loadHeader()
    }

    private fun setupViewPager() {
        viewPager.adapter = FullEditPagerAdapter(apkPath)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateTabSelection(position)
            }
        })
        updateTabSelection(0)
    }

    private fun setupTabs() {
        tabString.setOnClickListener { viewPager.currentItem = 0 }
        tabFiles.setOnClickListener { viewPager.currentItem = 1 }
        tabManifest.setOnClickListener { viewPager.currentItem = 2 }
    }

    private fun setupActions() {
        actionBuildButton.setOnClickListener { buildModifiedApk() }
        actionPatchButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.not_available), Toast.LENGTH_SHORT).show()
        }
        actionWebserverButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.not_available), Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateTabSelection(position: Int) {
        listOf(tabString, tabFiles, tabManifest).forEachIndexed { index, tabView ->
            tabView.isSelected = index == position
        }
    }

    fun registerModifiedFile(entryName: String, tempFilePath: String) {
        modifiedFiles[entryName] = tempFilePath
    }

    private fun buildModifiedApk() {
        if (modifiedFiles.isEmpty()) {
            Toast.makeText(this, getString(R.string.no_change_detected), Toast.LENGTH_SHORT).show()
            return
        }
        val bundle = Bundle().apply {
            modifiedFiles.forEach { (entryName, tempFilePath) ->
                putString(entryName, tempFilePath)
            }
        }
        startActivity(
            android.content.Intent(this, ApkCreateActivity::class.java).apply {
                putExtra("apkPath", apkPath)
                putExtra("modifiedFiles", bundle)
            }
        )
    }

    private fun loadHeader() {
        val archiveInfo = runCatching {
            packageManager.getPackageArchiveInfo(apkPath, 0)
        }.getOrNull()
        val appInfo = archiveInfo?.applicationInfo?.also {
            it.sourceDir = apkPath
            it.publicSourceDir = apkPath
        }

        val title = runCatching {
            appInfo?.loadLabel(packageManager)?.toString()
        }.getOrNull()
        val packageName = archiveInfo?.packageName
        val icon = runCatching {
            appInfo?.loadIcon(packageManager)
        }.getOrNull()

        apkTitleView.text = title?.takeIf { it.isNotBlank() } ?: File(apkPath).nameWithoutExtension
        apkPackageView.text = packageName ?: getString(R.string.package_name_not_identified)
        if (icon != null) {
            apkIconView.setImageDrawable(icon)
        } else {
            apkIconView.setImageDrawable(
                AppCompatResources.getDrawable(this, R.drawable.apk_icon)
            )
        }
    }

    private fun applyWindowInsets() {
        val initialHeaderTop = headerContainer.paddingTop
        val initialTabsBottom = bottomTabsContainer.paddingBottom

        ViewCompat.setOnApplyWindowInsetsListener(rootView) { _, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            headerContainer.updatePadding(top = initialHeaderTop + systemBars.top)
            bottomTabsContainer.updatePadding(bottom = initialTabsBottom + systemBars.bottom)
            insets
        }
        ViewCompat.requestApplyInsets(rootView)
    }

    private inner class FullEditPagerAdapter(
        private val apkPath: String
    ) : FragmentStateAdapter(this@FullEditActivity) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> StringFragment.newInstance(apkPath)
                1 -> FilesFragment.newInstance(apkPath)
                2 -> ManifestFragment.newInstance(apkPath)
                else -> StringFragment.newInstance(apkPath)
            }
        }
    }

    override fun shouldHideActionBar(): Boolean = true
}
