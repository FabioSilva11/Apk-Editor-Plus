package com.saas.apkeditorplus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class InfoActivity : BaseActivity() {

    private lateinit var adapter: CommitAdapter
    private lateinit var pbLoading: ProgressBar
    private val executor = Executors.newSingleThreadExecutor()
    private val mainHandler = android.os.Handler(android.os.Looper.getMainLooper())

    override fun shouldHideActionBar(): Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        
        initializeCommitsList()
        fetchCommits()
    }

    private fun initializeCommitsList() {
        val listView = findViewById<ListView>(R.id.application_list)
        pbLoading = findViewById(R.id.progress_bar)
        adapter = CommitAdapter(this)
        listView.adapter = adapter
    }

    private fun fetchCommits() {
        pbLoading.visibility = View.VISIBLE
        
        executor.execute {
            try {
                val url = URL("https://api.github.com/repos/FabioSilva11/Apk-Editor-PLus/commits?per_page=10")
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.setRequestProperty("Accept", "application/vnd.github.v3+json")
                connection.connectTimeout = 10000
                connection.readTimeout = 10000

                if (connection.responseCode == 200) {
                    val reader = BufferedReader(InputStreamReader(connection.inputStream))
                    val response = reader.readText()
                    reader.close()

                    val listType = object : TypeToken<List<GitHubCommit>>() {}.type
                    val commits: List<GitHubCommit> = Gson().fromJson(response, listType)

                    mainHandler.post {
                        pbLoading.visibility = View.GONE
                        adapter.setCommits(commits)
                    }
                } else {
                    mainHandler.post {
                        pbLoading.visibility = View.GONE
                        Toast.makeText(this, getString(R.string.error_loading_commits, connection.responseCode), Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                mainHandler.post {
                    pbLoading.visibility = View.GONE
                    Toast.makeText(this, getString(R.string.connection_error), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
