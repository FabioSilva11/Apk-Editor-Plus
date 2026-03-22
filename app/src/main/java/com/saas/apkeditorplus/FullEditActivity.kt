package com.saas.apkeditorplus

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.saas.apkeditorplus.full.FilesFragment
import com.saas.apkeditorplus.full.ManifestFragment
import com.saas.apkeditorplus.full.StringFragment

class FullEditActivity : BaseActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigation: BottomNavigationView
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

        viewPager = findViewById(R.id.view_pager)
        bottomNavigation = findViewById(R.id.bottom_navigation)

        setupViewPager()
        setupBottomNavigation()
        updateActionBar()
    }

    private fun setupViewPager() {
        val adapter = FullEditPagerAdapter(this, apkPath)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNavigation.menu.getItem(position).isChecked = true
            }
        })
    }

    private fun setupBottomNavigation() {
        bottomNavigation.isItemActiveIndicatorEnabled = true
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_string -> {
                    viewPager.currentItem = 0
                    true
                }
                R.id.action_files -> {
                    viewPager.currentItem = 1
                    true
                }
                R.id.action_manifest -> {
                    viewPager.currentItem = 2
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_fulledit_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_build -> {
                buildModifiedApk()
                true
            }
            R.id.action_patch -> {
                Toast.makeText(this, getString(R.string.not_available), Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_webserver -> {
                Toast.makeText(this, getString(R.string.not_available), Toast.LENGTH_SHORT).show()
                true
            }
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
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

    private fun updateActionBar() {
        val title = runCatching {
            packageManager.getPackageArchiveInfo(apkPath, 0)?.applicationInfo?.let { appInfo ->
                appInfo.sourceDir = apkPath
                appInfo.publicSourceDir = apkPath
                appInfo.loadLabel(packageManager)?.toString()
            }
        }.getOrNull()

        supportActionBar?.title = title ?: getString(R.string.full_edit)
        supportActionBar?.subtitle = apkPath
    }

    private inner class FullEditPagerAdapter(
        activity: AppCompatActivity,
        private val apkPath: String
    ) : FragmentStateAdapter(activity) {
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

    override fun setupActionBar() {
        super.setupActionBar()
        supportActionBar?.let { actionBar ->
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setTitle(R.string.full_edit)
        }
    }

    override fun shouldHideActionBar(): Boolean = false
}
