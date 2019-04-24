/*
 * Copyright (c) 2019 ThanksMister LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.thanksmister.things.wallpanel.ui.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.thanksmister.things.wallpanel.R
import com.thanksmister.things.wallpanel.network.WallPanelService
import com.thanksmister.things.wallpanel.persistence.Configuration
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_about.*
import timber.log.Timber
import javax.inject.Inject

class AboutActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var configuration: Configuration

    private var versionNumber: String? = null

    public override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_about)

        if (supportActionBar != null) {
            supportActionBar!!.show()
            supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            supportActionBar!!.setDisplayShowHomeEnabled(false)
            supportActionBar!!.title = getString(R.string.pref_about_title)
        }

        // Stop our service for performance reasons and to pick up changes
        val wallPanelService = Intent(this, WallPanelService::class.java)
        stopService(wallPanelService)

        try {
            val packageInfo = packageManager.getPackageInfo(packageName, 0)
            versionNumber = " v" + packageInfo.versionName
            versionName.text = versionNumber
        } catch (e: PackageManager.NameNotFoundException) {
            Timber.e(e.message)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_dashboard, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
            onBrowserButton()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onBrowserButton() {
        val intent = Intent(this@AboutActivity, BrowserActivityNative::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }

    companion object {
        const val SUPPORT_URL:String = "https://thanksmister.com/wallpanel-android/"
        const val GOOGLE_PLAY_RATING = "com.thanksmister.iot.wallpanel"
        const val GITHUB_URL = "https://github.com/thanksmister/wallpanel-android"
        const val EMAIL_ADDRESS = "mister@thanksmister.com"
    }
}