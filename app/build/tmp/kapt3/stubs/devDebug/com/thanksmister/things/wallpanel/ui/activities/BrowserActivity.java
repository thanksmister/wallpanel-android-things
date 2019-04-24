package com.thanksmister.things.wallpanel.ui.activities;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Toast;
import com.thanksmister.things.wallpanel.network.WallPanelService;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import com.thanksmister.things.wallpanel.utils.DialogUtils;
import com.thanksmister.things.wallpanel.utils.ScreenUtils;
import dagger.android.support.DaggerAppCompatActivity;
import timber.log.Timber;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00102\u001a\u000203H$J\b\u00104\u001a\u000203H$J\u0010\u00105\u001a\u0002032\u0006\u00106\u001a\u000207H$J\u0010\u00108\u001a\u0002032\u0006\u00109\u001a\u000207H$J\b\u0010:\u001a\u000203H\u0016J\u0006\u0010;\u001a\u000203J\u0006\u0010<\u001a\u000203J\u0010\u0010=\u001a\u0002032\u0006\u0010>\u001a\u000207H$J\u0012\u0010?\u001a\u0002032\b\u0010@\u001a\u0004\u0018\u00010AH\u0015J\b\u0010B\u001a\u000203H\u0014J\b\u0010C\u001a\u000203H\u0014J\b\u0010D\u001a\u000203H\u0014J\b\u0010E\u001a\u000203H\u0014J\b\u0010F\u001a\u000203H\u0016J\u0015\u0010G\u001a\u0002032\u0006\u0010>\u001a\u000207H\u0000\u00a2\u0006\u0002\bHJ\b\u0010I\u001a\u000203H$J\b\u0010J\u001a\u000203H\u0002J\r\u0010K\u001a\u000203H\u0000\u00a2\u0006\u0002\bLJ\u0012\u0010M\u001a\u0002032\b\b\u0002\u0010N\u001a\u00020\u0012H\u0016J\b\u0010O\u001a\u000203H\u0016J\u0006\u0010P\u001a\u000203R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\'\u0010(\u001a\u0004\b%\u0010&R\u000e\u0010)\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u0006R"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/activities/BrowserActivity;", "Ldagger/android/support/DaggerAppCompatActivity;", "()V", "configuration", "Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "getConfiguration", "()Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "setConfiguration", "(Lcom/thanksmister/things/wallpanel/persistence/Configuration;)V", "decorView", "Landroid/view/View;", "dialogUtils", "Lcom/thanksmister/things/wallpanel/utils/DialogUtils;", "getDialogUtils", "()Lcom/thanksmister/things/wallpanel/utils/DialogUtils;", "setDialogUtils", "(Lcom/thanksmister/things/wallpanel/utils/DialogUtils;)V", "displayProgress", "", "getDisplayProgress", "()Z", "setDisplayProgress", "(Z)V", "inactivityCallback", "Ljava/lang/Runnable;", "inactivityHandler", "Landroid/os/Handler;", "mBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "mOnScrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "getMOnScrollChangedListener", "()Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "setMOnScrollChangedListener", "(Landroid/view/ViewTreeObserver$OnScrollChangedListener;)V", "screenUtils", "Lcom/thanksmister/things/wallpanel/utils/ScreenUtils;", "getScreenUtils", "()Lcom/thanksmister/things/wallpanel/utils/ScreenUtils;", "screenUtils$delegate", "Lkotlin/Lazy;", "userPresent", "wallPanelService", "Landroid/content/Intent;", "zoomLevel", "", "getZoomLevel", "()F", "setZoomLevel", "(F)V", "clearCache", "", "complete", "configureWebSettings", "userAgent", "", "evaluateJavascript", "js", "hideScreenSaver", "launchAbout", "launchSettings", "loadUrl", "url", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onUserInteraction", "pageLoadComplete", "pageLoadComplete$app_devDebug", "reload", "resetInactivityTimer", "resetScreen", "resetScreen$app_devDebug", "resetScreenBrightness", "screenSaver", "showScreenSaver", "stopDisconnectTimer", "Companion", "app_devDebug"})
public abstract class BrowserActivity extends dagger.android.support.DaggerAppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.utils.DialogUtils dialogUtils;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.persistence.Configuration configuration;
    private final kotlin.Lazy screenUtils$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private android.view.ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;
    private android.content.Intent wallPanelService;
    private android.view.View decorView;
    private final android.os.Handler inactivityHandler = null;
    private boolean userPresent;
    private boolean displayProgress;
    private float zoomLevel;
    private final android.content.BroadcastReceiver mBroadcastReceiver = null;
    private final java.lang.Runnable inactivityCallback = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_ACTION_LOAD_URL = "BROADCAST_ACTION_LOAD_URL";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_ACTION_JS_EXEC = "BROADCAST_ACTION_JS_EXEC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_ACTION_CLEAR_BROWSER_CACHE = "BROADCAST_ACTION_CLEAR_BROWSER_CACHE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_ACTION_RELOAD_PAGE = "BROADCAST_ACTION_RELOAD_PAGE";
    public static final com.thanksmister.things.wallpanel.ui.activities.BrowserActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.thanksmister.things.wallpanel.utils.DialogUtils getDialogUtils() {
        return null;
    }
    
    public final void setDialogUtils(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.utils.DialogUtils p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.thanksmister.things.wallpanel.persistence.Configuration getConfiguration() {
        return null;
    }
    
    public final void setConfiguration(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.persistence.Configuration p0) {
    }
    
    private final com.thanksmister.things.wallpanel.utils.ScreenUtils getScreenUtils() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.ViewTreeObserver.OnScrollChangedListener getMOnScrollChangedListener() {
        return null;
    }
    
    public final void setMOnScrollChangedListener(@org.jetbrains.annotations.Nullable()
    android.view.ViewTreeObserver.OnScrollChangedListener p0) {
    }
    
    public final boolean getDisplayProgress() {
        return false;
    }
    
    public final void setDisplayProgress(boolean p0) {
    }
    
    public final float getZoomLevel() {
        return 0.0F;
    }
    
    public final void setZoomLevel(float p0) {
    }
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onUserInteraction() {
    }
    
    public final void launchSettings() {
    }
    
    public final void launchAbout() {
    }
    
    public final void resetScreen$app_devDebug() {
    }
    
    public final void pageLoadComplete$app_devDebug(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    private final void resetInactivityTimer() {
    }
    
    public final void stopDisconnectTimer() {
    }
    
    public void hideScreenSaver() {
    }
    
    /**
     * * Show the screen saver only if the alarm isn't triggered. This shouldn't be an issue
     *     * with the alarm disabled because the disable time will be longer than this.
     */
    public void showScreenSaver() {
    }
    
    public void resetScreenBrightness(boolean screenSaver) {
    }
    
    protected abstract void configureWebSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userAgent);
    
    protected abstract void loadUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    protected abstract void evaluateJavascript(@org.jetbrains.annotations.NotNull()
    java.lang.String js);
    
    protected abstract void clearCache();
    
    protected abstract void reload();
    
    protected abstract void complete();
    
    public BrowserActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/activities/BrowserActivity$Companion;", "", "()V", "BROADCAST_ACTION_CLEAR_BROWSER_CACHE", "", "BROADCAST_ACTION_JS_EXEC", "BROADCAST_ACTION_LOAD_URL", "BROADCAST_ACTION_RELOAD_PAGE", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}