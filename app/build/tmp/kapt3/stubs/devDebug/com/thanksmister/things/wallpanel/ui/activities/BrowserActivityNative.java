package com.thanksmister.things.wallpanel.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.*;
import android.webkit.*;
import android.widget.Toast;
import com.thanksmister.things.wallpanel.R;
import kotlinx.android.synthetic.main.activity_browser.*;
import timber.log.Timber;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0015J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001cH\u0014J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001cH\u0014J\u0012\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010#H\u0015J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010\'\u001a\u00020\u0018H\u0014J\b\u0010(\u001a\u00020\u0018H\u0014J\b\u0010)\u001a\u00020\u0018H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0012\u001a\n \b*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006*"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/activities/BrowserActivityNative;", "Lcom/thanksmister/things/wallpanel/ui/activities/BrowserActivity;", "Landroid/support/design/widget/NavigationView$OnNavigationItemSelectedListener;", "()V", "certPermissionsShown", "", "drawerLayout", "Landroid/support/v4/widget/DrawerLayout;", "kotlin.jvm.PlatformType", "getDrawerLayout", "()Landroid/support/v4/widget/DrawerLayout;", "drawerLayout$delegate", "Lkotlin/Lazy;", "navigationView", "Landroid/support/design/widget/NavigationView;", "getNavigationView", "()Landroid/support/design/widget/NavigationView;", "navigationView$delegate", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "webView$delegate", "clearCache", "", "complete", "configureWebSettings", "userAgent", "", "evaluateJavascript", "js", "loadUrl", "url", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationItemSelected", "item", "Landroid/view/MenuItem;", "onStart", "onStop", "reload", "app_devDebug"})
public final class BrowserActivityNative extends com.thanksmister.things.wallpanel.ui.activities.BrowserActivity implements android.support.design.widget.NavigationView.OnNavigationItemSelectedListener {
    private final kotlin.Lazy webView$delegate = null;
    private final kotlin.Lazy drawerLayout$delegate = null;
    private final kotlin.Lazy navigationView$delegate = null;
    private boolean certPermissionsShown;
    private java.util.HashMap _$_findViewCache;
    
    private final android.webkit.WebView getWebView() {
        return null;
    }
    
    private final android.support.v4.widget.DrawerLayout getDrawerLayout() {
        return null;
    }
    
    private final android.support.design.widget.NavigationView getNavigationView() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled", "ClickableViewAccessibility"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    protected void complete() {
    }
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    @java.lang.Override()
    protected void configureWebSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String userAgent) {
    }
    
    @java.lang.Override()
    protected void loadUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @java.lang.Override()
    protected void evaluateJavascript(@org.jetbrains.annotations.NotNull()
    java.lang.String js) {
    }
    
    @java.lang.Override()
    protected void clearCache() {
    }
    
    @java.lang.Override()
    protected void reload() {
    }
    
    @java.lang.Override()
    public boolean onNavigationItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public BrowserActivityNative() {
        super();
    }
}