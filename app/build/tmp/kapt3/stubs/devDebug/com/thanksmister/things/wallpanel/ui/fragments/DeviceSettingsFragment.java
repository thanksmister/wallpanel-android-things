package com.thanksmister.things.wallpanel.ui.fragments;

import android.os.Bundle;
import android.support.v14.preference.SwitchPreference;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.Preference.OnPreferenceClickListener;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.google.android.things.device.TimeManager;
import com.google.android.things.update.UpdateManager;
import com.google.android.things.update.UpdateManagerStatus;
import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;
import javax.inject.Inject;
import android.content.*;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.net.NetworkInfo;
import com.thanksmister.things.wallpanel.R;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import com.thanksmister.things.wallpanel.ui.activities.SettingsActivity;
import com.thanksmister.things.wallpanel.ui.views.NetworkSettingsView;
import com.thanksmister.things.wallpanel.utils.DialogUtils;
import com.thanksmister.things.wallpanel.utils.NetworkUtils;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-H\u0016J\u001c\u0010.\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020(H\u0016J\b\u00102\u001a\u00020(H\u0016J\u0018\u00103\u001a\u00020(2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000200H\u0016J\u001a\u00107\u001a\u00020(2\u0006\u00108\u001a\u0002092\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010:\u001a\u00020(H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n #*\u0004\u0018\u00010\"0\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/fragments/DeviceSettingsFragment;", "Landroid/support/v7/preference/PreferenceFragmentCompat;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "()V", "brightnessPreference", "Landroid/support/v7/preference/ListPreference;", "configuration", "Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "getConfiguration", "()Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "setConfiguration", "(Lcom/thanksmister/things/wallpanel/persistence/Configuration;)V", "dialogUtils", "Lcom/thanksmister/things/wallpanel/utils/DialogUtils;", "getDialogUtils", "()Lcom/thanksmister/things/wallpanel/utils/DialogUtils;", "setDialogUtils", "(Lcom/thanksmister/things/wallpanel/utils/DialogUtils;)V", "formatPreference", "Landroid/support/v14/preference/SwitchPreference;", "intentFilterForWifiConnectionReceiver", "Landroid/content/IntentFilter;", "getIntentFilterForWifiConnectionReceiver", "()Landroid/content/IntentFilter;", "networkPreference", "Landroid/support/v7/preference/Preference;", "notConnectedMessageShown", "", "portraitPreference", "Landroid/support/v7/preference/CheckBoxPreference;", "receiverRegistered", "resetPreference", "serverPreference", "timeManager", "Lcom/google/android/things/device/TimeManager;", "kotlin.jvm.PlatformType", "timeZonePreference", "wifiConnectionReceiver", "Landroid/content/BroadcastReceiver;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreatePreferences", "rootKey", "", "onPause", "onResume", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "onViewCreated", "view", "Landroid/view/View;", "showNetworkDialog", "app_devDebug"})
public final class DeviceSettingsFragment extends android.support.v7.preference.PreferenceFragmentCompat implements android.content.SharedPreferences.OnSharedPreferenceChangeListener {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.persistence.Configuration configuration;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.utils.DialogUtils dialogUtils;
    private android.support.v7.preference.CheckBoxPreference portraitPreference;
    private android.support.v14.preference.SwitchPreference serverPreference;
    private android.support.v14.preference.SwitchPreference formatPreference;
    private android.support.v7.preference.Preference resetPreference;
    private android.support.v7.preference.Preference networkPreference;
    private android.support.v7.preference.ListPreference brightnessPreference;
    private android.support.v7.preference.ListPreference timeZonePreference;
    private final com.google.android.things.device.TimeManager timeManager = null;
    private boolean notConnectedMessageShown;
    private boolean receiverRegistered;
    private final android.content.BroadcastReceiver wifiConnectionReceiver = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.thanksmister.things.wallpanel.persistence.Configuration getConfiguration() {
        return null;
    }
    
    public final void setConfiguration(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.persistence.Configuration p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.thanksmister.things.wallpanel.utils.DialogUtils getDialogUtils() {
        return null;
    }
    
    public final void setDialogUtils(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.utils.DialogUtils p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onCreatePreferences(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState, @org.jetbrains.annotations.Nullable()
    java.lang.String rootKey) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onSharedPreferenceChanged(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences sharedPreferences, @org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    private final void showNetworkDialog() {
    }
    
    private final android.content.IntentFilter getIntentFilterForWifiConnectionReceiver() {
        return null;
    }
    
    public DeviceSettingsFragment() {
        super();
    }
}