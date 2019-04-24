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
import android.os.Bundle
import com.thanksmister.things.wallpanel.R
import com.thanksmister.things.wallpanel.network.WallPanelService
import com.thanksmister.things.wallpanel.persistence.Configuration
import com.thanksmister.things.wallpanel.ui.fragments.SettingsFragment
import com.thanksmister.things.wallpanel.utils.DialogUtils
import com.thanksmister.things.wallpanel.utils.ScreenUtils
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SettingsActivity : DaggerAppCompatActivity(), SettingsFragment.OnSettingsFragmentListener {

    @Inject
    lateinit var configuration: Configuration
    @Inject
    lateinit var dialogUtils: DialogUtils

    private val screenUtils by lazy {
        ScreenUtils(this@SettingsActivity)
    }

    public override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)

        setContentView(R.layout.activity_settings)

        // Stop our service for performance reasons and to pick up changes
        val wallPanelService = Intent(this, WallPanelService::class.java)
        stopService(wallPanelService)

        lifecycle.addObserver(dialogUtils)

        // Reset the screen brightness level
        screenUtils.resetScreenBrightness(false, configuration, window = window)
    }

    public override fun onResume() {
        super.onResume()
    }

    override fun onFinish() {
        this.finish()
    }

    override fun onBrowserButton() {
        val intent = Intent(this@SettingsActivity, BrowserActivityNative::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}