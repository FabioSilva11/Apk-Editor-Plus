package com.saas.apkeditorplus

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fulledit)
        
        viewPager = findViewById(R.id.view_pager)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        
        setupViewPager()
        setupBottomNavigation()
        
        val apkPath = intent.getStringExtra("apkPath")
    }

    private fun setupViewPager() {
        val adapter = FullEditPagerAdapter(this)
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
                // Logic to build
                true
            }
            R.id.action_patch -> {
                // Logic for patch
                true
            }
            R.id.action_webserver -> {
                // Logic for webserver
                true
            }
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private inner class FullEditPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = 3
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> StringFragment()
                1 -> FilesFragment()
                2 -> ManifestFragment()
                else -> StringFragment()
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
