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

package com.thanksmister.things.wallpanel.persistence

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.thanksmister.things.wallpanel.R
import javax.inject.Inject

class Configuration @Inject
constructor(private val context: Context, private val sharedPreferences: SharedPreferences) {

    // APP
    val isFirstTime: Boolean
        get() = sharedPreferences.getBoolean(PREF_FIRST_TIME, true)

    val appPreventSleep: Boolean
        get() = getBoolPref(R.string.key_setting_app_preventsleep,
                R.string.default_setting_app_preventsleep)

    var writeScreenPermissionsShown: Boolean
        get() = sharedPreferences.getBoolean(PREF_WRITE_SCREEN_PERMISSIONS, false)
        set(value) {
            sharedPreferences.edit().putBoolean(PREF_WRITE_SCREEN_PERMISSIONS, value).apply()
        }

    var cameraPermissionsShown: Boolean
        get() = sharedPreferences.getBoolean(PREF_CAMERA_PERMISSIONS, false)
        set(value) {
            sharedPreferences.edit().putBoolean(PREF_CAMERA_PERMISSIONS, value).apply()
        }

    var cameraRotate: Float
        get() = this.sharedPreferences.getString(PREF_CAMERA_ROTATE, "0f").toFloat()
        set(value) = this.sharedPreferences.edit().putString(PREF_CAMERA_ROTATE, value.toString()).apply()

    var appLaunchUrl: String
        get() = getStringPref(R.string.key_setting_app_launchurl,
                R.string.default_setting_app_launchurl)
        set(launchUrl) {
            sharedPreferences.edit().putString(context.getString(R.string.key_setting_app_launchurl), launchUrl).apply()
        }

    val appShowActivity: Boolean
        get() = getBoolPref(R.string.key_setting_app_showactivity,
                R.string.default_setting_app_showactivity)

    var cameraEnabled: Boolean
        get() = getBoolPref(R.string.key_setting_camera_enabled, R.string.default_setting_camera_enabled)
        set(value) {
            sharedPreferences.edit().putBoolean(context.getString(R.string.key_setting_camera_enabled), value).apply()
        }

    var cameraId: Int
        get() = getStringPref(R.string.key_setting_camera_cameraid,
                R.string.default_setting_camera_cameraid).trim().toInt()
        set(value) {
            sharedPreferences.edit().putInt(context.getString(R.string.key_setting_camera_cameraid), value).apply()
        }

    var motionEnabled: Boolean
        get() = getBoolPref(R.string.key_setting_camera_motionenabled, R.string.default_setting_camera_motionenabled)
        set(value) {
            sharedPreferences.edit().putBoolean(context.getString(R.string.key_setting_camera_motionenabled), value).apply()
        }

    val motionResetTime: Int
        get() = getStringPref(R.string.key_setting_motion_clear,
                R.string.default_motion_clear).trim().toInt()

    val httpEnabled: Boolean
        get() = httpRestEnabled || httpMJPEGEnabled

    val httpPort: Int
        get() = getStringPref(R.string.key_setting_http_port,
                R.string.default_setting_http_port).trim().toInt()

    val httpRestEnabled: Boolean
        get() = getBoolPref(R.string.key_setting_http_restenabled,
                R.string.default_setting_http_restenabled)

    val httpMJPEGEnabled: Boolean
        get() = getBoolPref(R.string.key_setting_http_mjpegenabled,
                R.string.default_setting_http_mjpegenabled)

    fun setHttpMJPEGEnabled(value: Boolean?) {
        sharedPreferences.edit().putBoolean(context.getString(R.string.key_setting_http_mjpegenabled), value!!).apply()
    }

    val httpMJPEGMaxStreams: Int
        get() = getStringPref(R.string.key_setting_http_mjpegmaxstreams, R.string.default_setting_http_mjpegmaxstreams).trim().toInt()

    val mqttEnabled: Boolean
        get() = getBoolPref(R.string.key_setting_mqtt_enabled, R.string.default_setting_mqtt_enabled)

    val mqttTlsEnabled: Boolean
        get() = getBoolPref(R.string.key_setting_mqtt_tls_enabled, R.string.default_setting_mqtt_tts_enabled)

    val mqttUrl: String
        @SuppressLint("DefaultLocale")
        get() = String.format("tcp://%s:%d", mqttBroker, mqttServerPort)

    val mqttBroker: String
        get() = getStringPref(R.string.key_setting_mqtt_servername, R.string.default_setting_mqtt_servername)

    val mqttServerPort: Int
        get() = getStringPref(R.string.key_setting_mqtt_serverport, R.string.default_setting_mqtt_serverport).trim().toInt()

    val mqttBaseTopic: String
        get() = getStringPref(R.string.key_setting_mqtt_basetopic,
                R.string.default_setting_mqtt_basetopic)

    val mqttClientId: String
        get() = getStringPref(R.string.key_setting_mqtt_clientid,
                R.string.default_setting_mqtt_clientid)

    val mqttUsername: String
        get() = getStringPref(R.string.key_setting_mqtt_username,
                R.string.default_setting_mqtt_username)

    val mqttPassword: String
        get() = getStringPref(R.string.key_setting_mqtt_password,
                R.string.default_setting_mqtt_password)

    val mqttSensorFrequency: Int
        get() = getStringPref(R.string.key_setting_mqtt_sensorfrequency,
                R.string.default_setting_mqtt_sensorfrequency).trim().toInt()

    val sensorsEnabled: Boolean
        get() = getBoolPref(R.string.key_setting_sensors_enabled,
                R.string.default_setting_sensors_value)

    val androidBrowserType: String
        get() = getStringPref(R.string.key_setting_android_browsertype,
                R.string.default_setting_android_browsertype)

    val browserUserAgent: String
        get() = getStringPref(R.string.key_setting_browser_user_agent,
                R.string.default_browser_user_agent)

    var browserRefresh: Boolean
        get() = getBoolPref(R.string.key_pref_browser_refresh, R.string.default_browser_refresh)
        set(value) {
            sharedPreferences.edit().putBoolean(context.getString(R.string.key_pref_browser_refresh), value).apply()
        }

    val cameraFPS: Float
        get() = try {
            getStringPref(R.string.key_setting_camera_fps, R.string.default_camera_fps).trim().toFloat()
        } catch (e: Exception) {
            15.0F
        }

    val testZoomLevel: Float
        get() = getStringPref(R.string.key_setting_test_zoomlevel, R.string.default_setting_test_zoomlevel).trim().toFloat()

    val inactivityTime: Long
        get() = getStringPref(R.string.key_inactivity_time, R.string.default_inactivity_time).trim().toLong()

    val hasScreenSaver: Boolean
        get() = getBoolPref(R.string.key_screensaver, R.string.default_screensaver)

    var screenBrightness: Int
        get() = sharedPreferences.getInt(context.getString(R.string.key_setting_screen_brightness), 3)
        set(value) {
            sharedPreferences.edit().putInt(context.getString(R.string.key_setting_screen_brightness), value).apply()
        }

    var screenScreenSaverBrightness: Int
        get() = sharedPreferences.getInt(context.getString(R.string.key_setting_screensaver_brightness), 1)
        set(value) {
            sharedPreferences.edit().putInt(context.getString(R.string.key_setting_screensaver_brightness), value).apply()
        }

    fun hasCameraDetections() : Boolean {
        return cameraEnabled && (motionEnabled || httpMJPEGEnabled)
    }

    private fun getStringPref(resId: Int, defId: Int): String {
        val def = context.getString(defId)
        val pref = sharedPreferences.getString(context.getString(resId), "")
        return if (pref!!.isEmpty()) def else pref
    }

    private fun getBoolPref(resId: Int, defId: Int): Boolean {
        return sharedPreferences.getBoolean(
                context.getString(resId),
                java.lang.Boolean.valueOf(context.getString(defId))
        )
    }

    fun setFirstTime(value: Boolean?) {
        sharedPreferences.edit().putBoolean(PREF_FIRST_TIME, value!!).apply()
    }

    var timeFormat: Int
        get() = sharedPreferences.getInt(PREF_DEVICE_TIME_FORMAT, 12)
        set(value) = sharedPreferences.edit().putInt(PREF_DEVICE_TIME_FORMAT, value).apply()

    var useTimeServer: Boolean
        get() = sharedPreferences.getBoolean(PREF_DEVICE_TIME_SERVER, true)
        set(value) = sharedPreferences.edit().putBoolean(PREF_DEVICE_TIME_SERVER, value).apply()

    var timeZone: String
        get() = this.sharedPreferences.getString(PREF_DEVICE_TIME_ZONE, "America/Los_Angeles")
        set(value) = this.sharedPreferences.edit().putString(PREF_DEVICE_TIME_ZONE, value).apply()

    var isPortraitMode: Boolean
        get() = this.sharedPreferences.getBoolean(PREF_DEVICE_SCREEN_POTRAIT, false)
        set(value) = this.sharedPreferences.edit().putBoolean(PREF_DEVICE_SCREEN_POTRAIT, value).apply()

    var networkId: String?
        get() = this.sharedPreferences.getString(PREF_NETWORK_ID, null)
        set(value) = this.sharedPreferences.edit().putString(PREF_NETWORK_ID, value).apply()

    var networkPassword: String?
        get() = this.sharedPreferences.getString(PREF_NETWORK_PASSWORD, null)
        set(value) = this.sharedPreferences.edit().putString(PREF_NETWORK_PASSWORD, value).apply()


    fun reset() {
        sharedPreferences.edit().clear().apply()
    }

    companion object {
        const val PREF_FIRST_TIME = "pref_first_time"
        const val PREF_WRITE_SCREEN_PERMISSIONS = "pref_write_screen_permissions"
        const val PREF_CAMERA_PERMISSIONS = "pref_camera_permissions"
        const val PREF_CAMERA_ROTATE = "pref_camera_rotate"
        const val PREF_NETWORK_ID = "pref_network_id"
        const val PREF_NETWORK_PASSWORD = "pref_network_pass"
        const val PREF_DEVICE_SCREEN_POTRAIT = "pref_screen_portrait"
        const val PREF_DEVICE_TIME_SERVER = "pref_device_time_server"
        const val PREF_DEVICE_TIME_FORMAT = "pref_device_time_format_local"
        const val PREF_DEVICE_TIME = "pref_device_time"
        const val PREF_DEVICE_TIME_ZONE = "pref_device_time_zone"
        const val PREF_DEVICE_SCREEN_BRIGHTNESS = "pref_screen_brightness"
        const val PREF_BRIGHTNESS_FACTOR = .10
        const val PREF_BROWSER_LEGACY = "Legacy"
        const val PREF_BROWSER_NATIVE = "Native"
        const val PREF_BROWSER_AUTO = "Auto"
    }
}
