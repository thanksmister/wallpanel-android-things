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

package com.thanksmister.things.wallpanel.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import android.content.res.Resources;
import android.location.LocationManager;
import android.support.v7.preference.PreferenceManager;
import android.view.LayoutInflater;

import com.thanksmister.things.wallpanel.modules.SensorReader;
import com.thanksmister.things.wallpanel.network.MQTTOptions;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import com.thanksmister.things.wallpanel.utils.DialogUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class ActivityModule {

    @Provides
    static DialogUtils providesDialogUtils(Application application) {
        return new DialogUtils(application);
    }

    @Provides
    static Resources providesResources(Application application) {
        return application.getResources();
    }

    @Provides
    static LayoutInflater providesInflater(Application application) {
        return (LayoutInflater) application.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Provides
    static LocationManager provideLocationManager(Application application) {
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application app) {
        return PreferenceManager.getDefaultSharedPreferences(app.getApplicationContext());
    }

    @Provides
    static Configuration provideConfiguration(Application app, SharedPreferences sharedPreferences) {
        return new Configuration(app, sharedPreferences);
    }

    @Provides
    static SensorReader provideSensorReader(Application app) {
        return new SensorReader(app);
    }

    @Provides
    static MQTTOptions provideMQTTOptions(Configuration configuration) {
        return new MQTTOptions(configuration);
    }
}