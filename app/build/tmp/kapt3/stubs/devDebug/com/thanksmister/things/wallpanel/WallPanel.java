package com.thanksmister.things.wallpanel;

import android.content.Context;
import android.support.multidex.MultiDex;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.thanksmister.things.wallpanel.di.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004H\u0014J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/thanksmister/things/wallpanel/WallPanel;", "Ldagger/android/support/DaggerApplication;", "()V", "applicationInjector", "Ldagger/android/AndroidInjector;", "attachBaseContext", "", "base", "Landroid/content/Context;", "onCreate", "app_devDebug"})
public final class WallPanel extends dagger.android.support.DaggerApplication {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected dagger.android.AndroidInjector<? extends dagger.android.support.DaggerApplication> applicationInjector() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    protected void attachBaseContext(@org.jetbrains.annotations.NotNull()
    android.content.Context base) {
    }
    
    public WallPanel() {
        super();
    }
}