package com.thanksmister.things.wallpanel.di;

import android.arch.lifecycle.ViewModel;
import com.thanksmister.things.wallpanel.ui.*;
import com.thanksmister.things.wallpanel.ui.activities.*;
import com.thanksmister.things.wallpanel.ui.fragments.*;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H!\u00a2\u0006\u0002\b\u0005J\r\u0010\u0006\u001a\u00020\u0007H!\u00a2\u0006\u0002\b\bJ\r\u0010\t\u001a\u00020\nH!\u00a2\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\rH!\u00a2\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\u0010H!\u00a2\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\'J\r\u0010\u0016\u001a\u00020\u0017H!\u00a2\u0006\u0002\b\u0018J\r\u0010\u0019\u001a\u00020\u001aH!\u00a2\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u001dH!\u00a2\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020 H!\u00a2\u0006\u0002\b!J\r\u0010\"\u001a\u00020#H!\u00a2\u0006\u0002\b$J\r\u0010%\u001a\u00020&H!\u00a2\u0006\u0002\b\'J\r\u0010(\u001a\u00020)H!\u00a2\u0006\u0002\b*J\r\u0010+\u001a\u00020,H!\u00a2\u0006\u0002\b-\u00a8\u0006."}, d2 = {"Lcom/thanksmister/things/wallpanel/di/AndroidBindingModule;", "", "()V", "aboutActivity", "Lcom/thanksmister/things/wallpanel/ui/activities/AboutActivity;", "aboutActivity$app_devDebug", "baseSettingsFragment", "Lcom/thanksmister/things/wallpanel/ui/fragments/BaseSettingsFragment;", "baseSettingsFragment$app_devDebug", "browserActivity", "Lcom/thanksmister/things/wallpanel/ui/activities/BrowserActivity;", "browserActivity$app_devDebug", "browserActivityNative", "Lcom/thanksmister/things/wallpanel/ui/activities/BrowserActivityNative;", "browserActivityNative$app_devDebug", "cameraSettings", "Lcom/thanksmister/things/wallpanel/ui/fragments/CameraSettingsFragment;", "cameraSettings$app_devDebug", "cameraViewModel", "Landroid/arch/lifecycle/ViewModel;", "viewModel", "Lcom/thanksmister/things/wallpanel/ui/DetectionViewModel;", "deviceSettings", "Lcom/thanksmister/things/wallpanel/ui/fragments/DeviceSettingsFragment;", "deviceSettings$app_devDebug", "httpSettings", "Lcom/thanksmister/things/wallpanel/ui/fragments/HttpSettingsFragment;", "httpSettings$app_devDebug", "liveCameraActivity", "Lcom/thanksmister/things/wallpanel/ui/activities/LiveCameraActivity;", "liveCameraActivity$app_devDebug", "mqttSettings", "Lcom/thanksmister/things/wallpanel/ui/fragments/MqttSettingsFragment;", "mqttSettings$app_devDebug", "sensorsSettings", "Lcom/thanksmister/things/wallpanel/ui/fragments/SensorsSettingsFragment;", "sensorsSettings$app_devDebug", "settingsActivity", "Lcom/thanksmister/things/wallpanel/ui/activities/SettingsActivity;", "settingsActivity$app_devDebug", "settingsFragment", "Lcom/thanksmister/things/wallpanel/ui/fragments/SettingsFragment;", "settingsFragment$app_devDebug", "welcomeActivity", "Lcom/thanksmister/things/wallpanel/ui/activities/WelcomeActivity;", "welcomeActivity$app_devDebug", "app_devDebug"})
@dagger.Module()
public abstract class AndroidBindingModule {
    
    @org.jetbrains.annotations.NotNull()
    @ViewModelKey(value = com.thanksmister.things.wallpanel.ui.DetectionViewModel.class)
    @dagger.multibindings.IntoMap()
    @dagger.Binds()
    public abstract android.arch.lifecycle.ViewModel cameraViewModel(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.ui.DetectionViewModel viewModel);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.activities.WelcomeActivity welcomeActivity$app_devDebug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.activities.SettingsActivity settingsActivity$app_devDebug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.activities.BrowserActivity browserActivity$app_devDebug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.activities.AboutActivity aboutActivity$app_devDebug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.activities.BrowserActivityNative browserActivityNative$app_devDebug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.activities.LiveCameraActivity liveCameraActivity$app_devDebug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.fragments.BaseSettingsFragment baseSettingsFragment$app_devDebug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.fragments.SettingsFragment settingsFragment$app_devDebug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.fragments.CameraSettingsFragment cameraSettings$app_devDebug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.fragments.MqttSettingsFragment mqttSettings$app_devDebug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.fragments.HttpSettingsFragment httpSettings$app_devDebug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.fragments.DeviceSettingsFragment deviceSettings$app_devDebug();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract com.thanksmister.things.wallpanel.ui.fragments.SensorsSettingsFragment sensorsSettings$app_devDebug();
    
    public AndroidBindingModule() {
        super();
    }
}