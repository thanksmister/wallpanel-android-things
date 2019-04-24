package com.thanksmister.things.wallpanel.ui.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.gms.vision.CameraSource;
import java.io.IOException;
import timber.log.Timber;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0003!\"#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0014J\u0006\u0010\u001c\u001a\u00020\u0015J\u0018\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u001f\u001a\u00020\u0015H\u0003J\u0006\u0010 \u001a\u00020\u0015R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/views/CameraSourcePreview;", "Landroid/view/ViewGroup;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isPortraitMode", "", "()Z", "listener", "Lcom/thanksmister/things/wallpanel/ui/views/CameraSourcePreview$OnCameraPreviewListener;", "mCameraSource", "Lcom/google/android/gms/vision/CameraSource;", "mLayout", "Landroid/widget/LinearLayout;", "mStartRequested", "mSurfaceAvailable", "mSurfaceView", "Landroid/view/SurfaceView;", "onLayout", "", "changed", "left", "", "top", "right", "bottom", "release", "start", "cameraSource", "startIfReady", "stop", "Companion", "OnCameraPreviewListener", "SurfaceCallback", "app_devDebug"})
public final class CameraSourcePreview extends android.view.ViewGroup {
    private final android.widget.LinearLayout mLayout = null;
    private final android.view.SurfaceView mSurfaceView = null;
    private boolean mStartRequested;
    private boolean mSurfaceAvailable;
    private com.google.android.gms.vision.CameraSource mCameraSource;
    private com.thanksmister.things.wallpanel.ui.views.CameraSourcePreview.OnCameraPreviewListener listener;
    private final android.content.Context mContext = null;
    public static final com.thanksmister.things.wallpanel.ui.views.CameraSourcePreview.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final boolean isPortraitMode() {
        return false;
    }
    
    public final void start(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.vision.CameraSource cameraSource, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.ui.views.CameraSourcePreview.OnCameraPreviewListener listener) throws java.io.IOException {
    }
    
    public final void stop() {
    }
    
    public final void release() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void startIfReady() throws java.io.IOException {
    }
    
    @java.lang.Override()
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }
    
    public CameraSourcePreview(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/views/CameraSourcePreview$OnCameraPreviewListener;", "", "onCameraError", "", "app_devDebug"})
    public static abstract interface OnCameraPreviewListener {
        
        public abstract void onCameraError();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/views/CameraSourcePreview$SurfaceCallback;", "Landroid/view/SurfaceHolder$Callback;", "(Lcom/thanksmister/things/wallpanel/ui/views/CameraSourcePreview;)V", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surface", "surfaceDestroyed", "app_devDebug"})
    final class SurfaceCallback implements android.view.SurfaceHolder.Callback {
        
        @java.lang.Override()
        public void surfaceCreated(@org.jetbrains.annotations.NotNull()
        android.view.SurfaceHolder surface) {
        }
        
        @java.lang.Override()
        public void surfaceDestroyed(@org.jetbrains.annotations.NotNull()
        android.view.SurfaceHolder surface) {
        }
        
        @java.lang.Override()
        public void surfaceChanged(@org.jetbrains.annotations.NotNull()
        android.view.SurfaceHolder holder, int format, int width, int height) {
        }
        
        public SurfaceCallback() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/views/CameraSourcePreview$Companion;", "", "()V", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}