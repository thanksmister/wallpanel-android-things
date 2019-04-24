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

package com.thanksmister.things.wallpanel.ui.fragments

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v14.preference.SwitchPreference
import android.support.v4.app.ActivityCompat
import android.support.v7.preference.EditTextPreference
import android.support.v7.preference.ListPreference
import android.support.v7.preference.Preference
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.Navigation
import com.thanksmister.things.wallpanel.R
import com.thanksmister.things.wallpanel.persistence.Configuration
import com.thanksmister.things.wallpanel.ui.activities.LiveCameraActivity
import com.thanksmister.things.wallpanel.ui.activities.SettingsActivity
import com.thanksmister.things.wallpanel.utils.CameraUtils
import dagger.android.support.AndroidSupportInjection
import timber.log.Timber

class CameraSettingsFragment : BaseSettingsFragment() {

    private var cameraTestPreference: Preference? = null
    private var cameraPreference: SwitchPreference? = null
    private var fpsPreference: EditTextPreference? = null
    private var cameraStreaming: Preference? = null
    private var rotatePreference: ListPreference? = null

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Set title bar
        if (activity is SettingsActivity) {
            val actionBar = (activity as SettingsActivity).supportActionBar
            with(actionBar) {
                this?.setDisplayHomeAsUpEnabled(true)
                this?.setDisplayShowHomeEnabled(true)
                this?.title = (getString(R.string.title_camera_settings))
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                view?.let { Navigation.findNavController(it).navigate(R.id.settings_action) }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref_camera)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        fpsPreference = findPreference(getString(R.string.key_setting_camera_fps)) as EditTextPreference
        cameraPreference = findPreference(getString(R.string.key_setting_camera_enabled)) as SwitchPreference

        rotatePreference = findPreference(Configuration.PREF_CAMERA_ROTATE) as ListPreference
        rotatePreference!!.setDefaultValue(configuration.cameraRotate)
        rotatePreference!!.value = configuration.cameraRotate.toString()
        if(configuration.cameraRotate == 0f) {
            rotatePreference!!.setValueIndex(0)
        } else if (configuration.cameraRotate == -90f) {
            rotatePreference!!.setValueIndex(1)
        } else if (configuration.cameraRotate == 90f) {
            rotatePreference!!.setValueIndex(2)
        } else if (configuration.cameraRotate == -180f) {
            rotatePreference!!.setValueIndex(3)
        }
        rotatePreference?.setOnPreferenceChangeListener { preference, newValue ->
            if (preference is ListPreference) {
                val valueFloat = rotatePreference!!.value
                val valueName = rotatePreference!!.entry.toString()
                rotatePreference!!.summary = getString(R.string.preference_camera_flip_summary, valueName)
                configuration.cameraRotate = valueFloat.toFloat()
            }
            true
        }

        bindPreferenceSummaryToValue(cameraPreference!!)
        bindPreferenceSummaryToValue(fpsPreference!!)

        cameraTestPreference = findPreference("button_key_camera_test")
        cameraTestPreference?.onPreferenceClickListener = Preference.OnPreferenceClickListener { preference ->
            startCameraTest(preference.context)
            false
        }

        cameraStreaming = findPreference("button_key_camera_streaming")
        cameraStreaming?.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            view.let { Navigation.findNavController(it).navigate(R.id.action_camera_fragment_to_http_fragment) }
            false
        }
    }

    private fun startCameraTest(c: Context) {
        startActivity(Intent(c, LiveCameraActivity::class.java))
    }
}