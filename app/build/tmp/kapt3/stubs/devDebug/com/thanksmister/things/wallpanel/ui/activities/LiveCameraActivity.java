package com.thanksmister.things.wallpanel.ui.activities;

import android.Manifest;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;
import com.thanksmister.things.wallpanel.R;
import com.thanksmister.things.wallpanel.modules.CameraCallback;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import com.thanksmister.things.wallpanel.ui.DetectionViewModel;
import com.thanksmister.things.wallpanel.ui.views.CameraSourcePreview;
import dagger.android.support.DaggerAppCompatActivity;
import timber.log.Timber;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u0000 82\u00020\u0001:\u00018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\"H\u0016J\u0010\u0010\'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0016J+\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u000200H\u0016\u00a2\u0006\u0002\u00101J\b\u00102\u001a\u00020\"H\u0016J\b\u00103\u001a\u00020\"H\u0016J\b\u00104\u001a\u00020\"H\u0016J\b\u00105\u001a\u00020\"H\u0002J\b\u00106\u001a\u00020\"H\u0002J\b\u00107\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u00069"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/activities/LiveCameraActivity;", "Ldagger/android/support/DaggerAppCompatActivity;", "()V", "cameraCallback", "Lcom/thanksmister/things/wallpanel/modules/CameraCallback;", "configuration", "Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "getConfiguration", "()Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "setConfiguration", "(Lcom/thanksmister/things/wallpanel/persistence/Configuration;)V", "interval", "", "preview", "Lcom/thanksmister/things/wallpanel/ui/views/CameraSourcePreview;", "removeTextCountdown", "", "toast", "Landroid/widget/Toast;", "toastShown", "", "updateHandler", "Landroid/os/Handler;", "updatePicture", "Ljava/lang/Runnable;", "viewModel", "Lcom/thanksmister/things/wallpanel/ui/DetectionViewModel;", "viewModelFactory", "Landroid/arch/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroid/arch/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroid/arch/lifecycle/ViewModelProvider$Factory;)V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "onStop", "requestCameraPermission", "startUpdatePicture", "stopUpdatePicture", "Companion", "app_devDebug"})
public final class LiveCameraActivity extends dagger.android.support.DaggerAppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public android.arch.lifecycle.ViewModelProvider.Factory viewModelFactory;
    private com.thanksmister.things.wallpanel.ui.DetectionViewModel viewModel;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.persistence.Configuration configuration;
    private android.os.Handler updateHandler;
    private int removeTextCountdown;
    private final long interval = 66L;
    private com.thanksmister.things.wallpanel.ui.views.CameraSourcePreview preview;
    private boolean toastShown;
    private android.widget.Toast toast;
    private final java.lang.Runnable updatePicture = null;
    private final com.thanksmister.things.wallpanel.modules.CameraCallback cameraCallback = null;
    public static final int PERMISSIONS_REQUEST_CAMERA = 201;
    public static final com.thanksmister.things.wallpanel.ui.activities.LiveCameraActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.ViewModelProvider.Factory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull()
    android.arch.lifecycle.ViewModelProvider.Factory p0) {
    }
    
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
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void requestCameraPermission() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void startUpdatePicture() {
    }
    
    private final void stopUpdatePicture() {
    }
    
    public LiveCameraActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/activities/LiveCameraActivity$Companion;", "", "()V", "PERMISSIONS_REQUEST_CAMERA", "", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}