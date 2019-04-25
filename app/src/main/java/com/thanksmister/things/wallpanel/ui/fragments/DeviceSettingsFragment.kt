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

import android.os.Bundle
import android.support.v14.preference.SwitchPreference
import android.support.v7.preference.CheckBoxPreference
import android.support.v7.preference.ListPreference
import android.support.v7.preference.Preference
import android.support.v7.preference.Preference.OnPreferenceClickListener
import android.support.v7.preference.PreferenceFragmentCompat
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.google.android.things.device.TimeManager
import com.google.android.things.update.UpdateManager
import com.google.android.things.update.UpdateManagerStatus
import com.google.android.things.update.UpdatePolicy.POLICY_APPLY_AND_REBOOT

import dagger.android.support.AndroidSupportInjection
import timber.log.Timber
import javax.inject.Inject
import android.content.*
import android.net.ConnectivityManager
import android.net.wifi.WifiManager

import android.net.NetworkInfo
import android.view.MenuItem
import androidx.navigation.Navigation
import com.thanksmister.things.wallpanel.R
import com.thanksmister.things.wallpanel.persistence.Configuration
import com.thanksmister.things.wallpanel.persistence.Configuration.Companion.PREF_DEVICE_SCREEN_BRIGHTNESS
import com.thanksmister.things.wallpanel.persistence.Configuration.Companion.PREF_DEVICE_SCREEN_POTRAIT
import com.thanksmister.things.wallpanel.persistence.Configuration.Companion.PREF_DEVICE_TIME_SERVER
import com.thanksmister.things.wallpanel.persistence.Configuration.Companion.PREF_DEVICE_TIME_ZONE
import com.thanksmister.things.wallpanel.ui.activities.SettingsActivity
import com.thanksmister.things.wallpanel.ui.views.NetworkSettingsView
import com.thanksmister.things.wallpanel.utils.DialogUtils
import com.thanksmister.things.wallpanel.utils.NetworkUtils

class DeviceSettingsFragment : PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {

    @Inject lateinit var configuration: Configuration
    @Inject lateinit var dialogUtils: DialogUtils

    private var portraitPreference: CheckBoxPreference? = null

    private var serverPreference: SwitchPreference? = null
    private var formatPreference: SwitchPreference? = null
    private var resetPreference: Preference? = null
    private var networkPreference: Preference? = null

    private var brightnessPreference: ListPreference? = null
    private var timeZonePreference: ListPreference? = null
    private val timeManager = TimeManager.getInstance()
    private var notConnectedMessageShown = false
    private var receiverRegistered = false

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
                this?.title = (getString(R.string.title_device_settings))
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

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey : String?) {
        addPreferencesFromResource(R.xml.pref_device)
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
        if(receiverRegistered) {
            try {
                activity?.unregisterReceiver(wifiConnectionReceiver)
            } catch (e: IllegalArgumentException) {
                Timber.e(e.message)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        networkPreference = findPreference("pref_wifi_settings") as Preference
        networkPreference!!.isPersistent = false
        networkPreference!!.onPreferenceClickListener = OnPreferenceClickListener {
            showNetworkDialog()
            true
        }

        resetPreference = findPreference("pref_device_reset") as Preference
        resetPreference!!.isPersistent = false
        resetPreference!!.onPreferenceClickListener = OnPreferenceClickListener {
            configuration.reset()
            activity!!.finish();
            true
        }

        portraitPreference = findPreference(PREF_DEVICE_SCREEN_POTRAIT) as CheckBoxPreference
        portraitPreference!!.isChecked = configuration.isPortraitMode
        Timber.d("isPortraitMode ${configuration.isPortraitMode}")

        brightnessPreference = findPreference(PREF_DEVICE_SCREEN_BRIGHTNESS) as ListPreference
        brightnessPreference!!.value = configuration.screenBrightness.toString()
        brightnessPreference!!.summary = getString(R.string.pref_device_brightness_summary, configuration.screenBrightness.toString())

        val currentNetworkName = NetworkUtils.getCurrentNetworkName(context!!)
        if(!TextUtils.isEmpty(currentNetworkName)) {
            val prefix = getString(R.string.pref_wifi_settings_summary)
            networkPreference?.summary = getString(R.string.pref_wifi_settings_summary_filled, prefix, currentNetworkName)
        }

        timeZonePreference = findPreference(PREF_DEVICE_TIME_ZONE) as ListPreference
        timeZonePreference!!.setDefaultValue(configuration.timeZone)
        timeZonePreference!!.value = configuration.timeZone
        timeZonePreference!!.summary = configuration.timeZone

        timeManager.setTimeZone(configuration.timeZone)

        serverPreference = findPreference(PREF_DEVICE_TIME_SERVER) as SwitchPreference
        formatPreference = findPreference("key_device_time_format") as SwitchPreference
        serverPreference!!.isChecked = configuration.useTimeServer

        if(configuration.useTimeServer) {
            timeManager.setAutoTimeEnabled(configuration.useTimeServer)
        }

        if(configuration.timeFormat == TimeManager.FORMAT_12) {
            timeManager.setTimeFormat(TimeManager.FORMAT_12)
            formatPreference!!.summary = "1:00 PM"
            formatPreference!!.isChecked = false
        } else {
            timeManager.setTimeFormat(TimeManager.FORMAT_24)
            formatPreference!!.summary = "13:00"
            formatPreference!!.isChecked = true
        }
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        when (key) {
            "key_device_time_format" -> {
                if(formatPreference!!.isChecked) {
                    timeManager.setTimeFormat(TimeManager.FORMAT_24);
                    formatPreference!!.summary = "13:00"
                    configuration.timeFormat = TimeManager.FORMAT_24
                } else {
                    timeManager.setTimeFormat(TimeManager.FORMAT_12);
                    formatPreference!!.summary = "1:00 PM"
                    configuration.timeFormat = TimeManager.FORMAT_12
                }
            }
            PREF_DEVICE_TIME_SERVER -> {
                val checked = serverPreference!!.isChecked
                timeManager.setAutoTimeEnabled(checked)
                configuration.useTimeServer = checked
            }
            PREF_DEVICE_TIME_ZONE -> {
                val timezone = timeZonePreference!!.value
                configuration.timeZone = timezone
                timeManager.setTimeZone(timezone)
                timeZonePreference!!.summary = configuration.timeZone
            }
            PREF_DEVICE_SCREEN_BRIGHTNESS -> {
                val brightness = brightnessPreference!!.value.toInt()
                configuration.screenBrightness = brightness
                brightnessPreference!!.summary = getString(R.string.pref_device_brightness_summary, configuration.screenBrightness.toString())

            }
            PREF_DEVICE_SCREEN_POTRAIT -> {
                val checked = portraitPreference!!.isChecked
                configuration.isPortraitMode = checked
            }
        }
    }

    private fun showNetworkDialog() {
        val networkId: String? = configuration.networkId
        val networkPass: String? = configuration.networkPassword
        if (isAdded) {
            dialogUtils.showNetworkSettingsDialog(requireActivity(), networkId, networkPass, object: NetworkSettingsView.ViewListener {
                override fun onCancel() {
                    // na-da
                }
                override fun onComplete(id: String, pass: String) {
                    activity?.runOnUiThread {
                        if(!TextUtils.isEmpty(id) && !TextUtils.isEmpty(pass) ) {
                            if(networkId.equals(id) && networkPass.equals(pass) ) {
                                Toast.makeText(activity, getString(R.string.toast_network_settings_unchanged), Toast.LENGTH_LONG).show()
                            } else {
                                activity?.registerReceiver(wifiConnectionReceiver, intentFilterForWifiConnectionReceiver)
                                receiverRegistered = true
                                configuration.networkId = id
                                configuration.networkPassword = pass
                                NetworkUtils.connectNetwork(context!!, configuration.networkId, configuration.networkPassword)
                                notConnectedMessageShown = false
                                Toast.makeText(activity, getString(R.string.toast_connecting_network), Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(activity, R.string.text_error_blank_entry, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            })
        }
    }

    private val intentFilterForWifiConnectionReceiver: IntentFilter
        get() {
            val randomIntentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
            randomIntentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
            randomIntentFilter.addAction(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION)
            return randomIntentFilter
        }

    private val wifiConnectionReceiver: BroadcastReceiver = object: BroadcastReceiver()  {
        override fun onReceive(c: Context, intent: Intent) {
            val action = intent.action
            if (!TextUtils.isEmpty(action)) {
                when (action) {
                    WifiManager.NETWORK_STATE_CHANGED_ACTION -> {
                        val netInfo : NetworkInfo = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO)
                        val wifiManager = requireActivity().applicationContext.getSystemService (Context.WIFI_SERVICE) as WifiManager
                        val wifiInfo = wifiManager.connectionInfo
                        var wirelessNetworkName = wifiInfo?.ssid
                        wirelessNetworkName = wirelessNetworkName?.replace("\"", "");
                        Timber.d("Network Name $wirelessNetworkName")
                        val  connManager = requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                        val mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                        Timber.d("Network connected ${mWifi.isConnected}")
                        if (mWifi.isConnected && !TextUtils.isEmpty(wirelessNetworkName)) {
                            Toast.makeText(requireActivity(), getString(R.string.toast_connected_network, wirelessNetworkName), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}