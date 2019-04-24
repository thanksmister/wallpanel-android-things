package com.thanksmister.things.wallpanel.ui.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v14.preference.SwitchPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import com.thanksmister.things.wallpanel.R;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import com.thanksmister.things.wallpanel.ui.activities.SettingsActivity;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/fragments/BaseSettingsFragment;", "Landroid/support/v7/preference/PreferenceFragmentCompat;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "()V", "bindPreferenceSummaryToValueListener", "Landroid/support/v7/preference/Preference$OnPreferenceChangeListener;", "configuration", "Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "getConfiguration", "()Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "setConfiguration", "(Lcom/thanksmister/things/wallpanel/persistence/Configuration;)V", "bindPreferenceSummaryToValue", "", "preference", "Landroid/support/v7/preference/Preference;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "", "onPause", "onResume", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "Companion", "app_devDebug"})
public class BaseSettingsFragment extends android.support.v7.preference.PreferenceFragmentCompat implements android.content.SharedPreferences.OnSharedPreferenceChangeListener {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.persistence.Configuration configuration;
    private final android.support.v7.preference.Preference.OnPreferenceChangeListener bindPreferenceSummaryToValueListener = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUPPORT_URL = "https://thanksmister.com/wallpanel-android/";
    public static final com.thanksmister.things.wallpanel.ui.fragments.BaseSettingsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.thanksmister.things.wallpanel.persistence.Configuration getConfiguration() {
        return null;
    }
    
    public final void setConfiguration(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.persistence.Configuration p0) {
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
    public void onSharedPreferenceChanged(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences sharedPreferences, @org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    /**
     * * Binds a preference's summary to its value. More specifically, when the
     *     * preference's value is changed, its summary (line of text below the
     *     * preference title) is updated to reflect the value. The summary is also
     *     * immediately updated upon calling this method. The exact display format is
     *     * dependent on the type of preference.
     *     *
     *     * @see .sBindPreferenceSummaryToValueListener
     */
    public final void bindPreferenceSummaryToValue(@org.jetbrains.annotations.NotNull()
    android.support.v7.preference.Preference preference) {
    }
    
    public BaseSettingsFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/fragments/BaseSettingsFragment$Companion;", "", "()V", "SUPPORT_URL", "", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}