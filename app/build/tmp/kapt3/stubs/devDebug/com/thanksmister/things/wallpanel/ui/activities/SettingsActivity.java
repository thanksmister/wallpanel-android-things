package com.thanksmister.things.wallpanel.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import com.thanksmister.things.wallpanel.R;
import com.thanksmister.things.wallpanel.network.WallPanelService;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import com.thanksmister.things.wallpanel.ui.fragments.SettingsFragment;
import com.thanksmister.things.wallpanel.utils.DialogUtils;
import com.thanksmister.things.wallpanel.utils.ScreenUtils;
import dagger.android.support.DaggerAppCompatActivity;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/activities/SettingsActivity;", "Ldagger/android/support/DaggerAppCompatActivity;", "Lcom/thanksmister/things/wallpanel/ui/fragments/SettingsFragment$OnSettingsFragmentListener;", "()V", "configuration", "Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "getConfiguration", "()Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "setConfiguration", "(Lcom/thanksmister/things/wallpanel/persistence/Configuration;)V", "dialogUtils", "Lcom/thanksmister/things/wallpanel/utils/DialogUtils;", "getDialogUtils", "()Lcom/thanksmister/things/wallpanel/utils/DialogUtils;", "setDialogUtils", "(Lcom/thanksmister/things/wallpanel/utils/DialogUtils;)V", "screenUtils", "Lcom/thanksmister/things/wallpanel/utils/ScreenUtils;", "getScreenUtils", "()Lcom/thanksmister/things/wallpanel/utils/ScreenUtils;", "screenUtils$delegate", "Lkotlin/Lazy;", "onBrowserButton", "", "onCreate", "savedInstance", "Landroid/os/Bundle;", "onFinish", "onResume", "app_devDebug"})
public final class SettingsActivity extends dagger.android.support.DaggerAppCompatActivity implements com.thanksmister.things.wallpanel.ui.fragments.SettingsFragment.OnSettingsFragmentListener {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.persistence.Configuration configuration;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.utils.DialogUtils dialogUtils;
    private final kotlin.Lazy screenUtils$delegate = null;
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
    
    private final com.thanksmister.things.wallpanel.utils.ScreenUtils getScreenUtils() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onFinish() {
    }
    
    @java.lang.Override()
    public void onBrowserButton() {
    }
    
    public SettingsActivity() {
        super();
    }
}