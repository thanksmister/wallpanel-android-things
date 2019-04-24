package com.thanksmister.things.wallpanel.ui.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.thanksmister.things.wallpanel.R;
import com.thanksmister.things.wallpanel.network.WallPanelService;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import dagger.android.support.DaggerAppCompatActivity;
import kotlinx.android.synthetic.main.activity_about.*;
import timber.log.Timber;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/activities/AboutActivity;", "Ldagger/android/support/DaggerAppCompatActivity;", "()V", "configuration", "Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "getConfiguration", "()Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "setConfiguration", "(Lcom/thanksmister/things/wallpanel/persistence/Configuration;)V", "versionNumber", "", "onBrowserButton", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "Companion", "app_devDebug"})
public final class AboutActivity extends dagger.android.support.DaggerAppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.persistence.Configuration configuration;
    private java.lang.String versionNumber;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUPPORT_URL = "https://thanksmister.com/wallpanel-android/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GOOGLE_PLAY_RATING = "com.thanksmister.iot.wallpanel";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GITHUB_URL = "https://github.com/thanksmister/wallpanel-android";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EMAIL_ADDRESS = "mister@thanksmister.com";
    public static final com.thanksmister.things.wallpanel.ui.activities.AboutActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.thanksmister.things.wallpanel.persistence.Configuration getConfiguration() {
        return null;
    }
    
    public final void setConfiguration(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.persistence.Configuration p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void onBrowserButton() {
    }
    
    public AboutActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/activities/AboutActivity$Companion;", "", "()V", "EMAIL_ADDRESS", "", "GITHUB_URL", "GOOGLE_PLAY_RATING", "SUPPORT_URL", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}