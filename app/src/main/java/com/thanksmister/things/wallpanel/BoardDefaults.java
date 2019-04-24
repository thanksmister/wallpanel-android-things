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

package com.thanksmister.things.wallpanel;

import android.os.Build;

/**
 * From the Android Things samples https://github.com/intel-iot-devkit/android-things-samples
 */
@SuppressWarnings("WeakerAccess")
public class BoardDefaults {
    private static final String DEVICE_EDISON_ARDUINO = "edison_arduino";
    private static final String DEVICE_EDISON = "edison";
    private static final String DEVICE_JOULE = "joule";
    private static final String DEVICE_RPI3 = "rpi3";
    private static final String DEVICE_IMX6UL_PICO = "imx6ul_pico";
    private static final String DEVICE_IMX6UL_VVDN = "imx6ul_iopb";
    private static final String DEVICE_IMX7D_PICO = "imx7d_pico";
    private static String sBoardVariant = "";

    public static String getPwmPin() {
        switch (getBoardVariant()) {
            case DEVICE_EDISON_ARDUINO:
                return "IO3";
            case DEVICE_EDISON:
                return "GP13";
            case DEVICE_JOULE:
                return "PWM_0";
            case DEVICE_RPI3:
                return "PWM1";
            case DEVICE_IMX6UL_PICO:
                return "PWM8";
            case DEVICE_IMX6UL_VVDN:
                return "PWM3";
            case DEVICE_IMX7D_PICO:
                return "PWM2";
            default:
                throw new UnsupportedOperationException("Unknown device: " + Build.DEVICE);
        }
    }

    private static String getBoardVariant() {
        if (!sBoardVariant.isEmpty()) {
            return sBoardVariant;
        }
        sBoardVariant = Build.DEVICE;

        return sBoardVariant;
    }
}