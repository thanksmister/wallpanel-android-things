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

package com.thanksmister.things.wallpanel.utils

import android.content.Context
import android.content.ContextWrapper
import android.provider.Settings
import android.view.Window
import android.view.WindowManager
import com.thanksmister.things.wallpanel.persistence.Configuration
import com.thanksmister.things.wallpanel.utils.MqttUtils.Companion.COMMAND_SUN_ABOVE_HORIZON
import com.thanksmister.things.wallpanel.utils.MqttUtils.Companion.COMMAND_SUN_BELOW_HORIZON
import timber.log.Timber

class ScreenUtils(base: Context) : ContextWrapper(base) {

    fun resetScreenBrightness(screenSaver: Boolean = false, configuration: Configuration, window: Window) {
        var brightness = DeviceUtils.convertScreenBrightnessToFloat(5)
        if (configuration.screenBrightness in 1..5 && !screenSaver) {
            if(configuration.sunValue == COMMAND_SUN_BELOW_HORIZON) {
                brightness = DeviceUtils.convertScreenBrightnessToFloat(configuration.screenNightBrightness)
            } else {
                brightness = DeviceUtils.convertScreenBrightnessToFloat(configuration.screenBrightness)
            }
        } else if (configuration.screenBrightness in 1..5 && screenSaver) {
            if(configuration.sunValue == COMMAND_SUN_BELOW_HORIZON) {
                brightness = DeviceUtils.getScreenBrightnessDimmed(configuration.screenNightBrightness)
            } else {
                brightness = DeviceUtils.getScreenBrightnessDimmed(configuration.screenBrightness)
            }
        }

        try {
            Timber.d("ScreenBrightness: $brightness")
            val lp: WindowManager.LayoutParams = window.attributes;
            lp.screenBrightness = brightness;
            window.attributes = lp
        } catch (e: IllegalStateException) {
            Timber.e("resetScreenBrightness ${e.message}")
        }
    }

    fun setScreenBrightness(brightValue: Int, configuration: Configuration, window: Window) {
        var brightness = DeviceUtils.convertScreenBrightnessToFloat(configuration.screenBrightness)
        if (brightValue in 1..5) {
            brightness = DeviceUtils.convertScreenBrightnessToFloat(brightValue)
            configuration.screenBrightness = brightValue
            configuration.screenNightBrightness = DeviceUtils.getScreenBrightnessNight(brightValue)
        }
        try {
            Timber.d("ScreenBrightness: $brightness")
            val lp: WindowManager.LayoutParams = window.attributes;
            lp.screenBrightness = brightness;
            window.attributes = lp
        } catch (e: IllegalStateException) {
            Timber.e("setScreenBrightness ${e.message}")
        }
    }

    private fun canWriteScreenSetting(): Boolean {
        Timber.d("canWriteScreenSetting")
        return Settings.System.canWrite(applicationContext)
    }
}