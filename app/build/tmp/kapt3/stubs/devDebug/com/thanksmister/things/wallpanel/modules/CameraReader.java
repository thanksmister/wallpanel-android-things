package com.thanksmister.things.wallpanel.modules;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.support.v8.renderscript.RenderScript;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.gms.vision.*;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import com.thanksmister.things.wallpanel.ui.views.CameraSourcePreview;
import io.github.silvaren.easyrs.tools.Nv21Image;
import timber.log.Timber;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u0000 12\u00020\u0001:\u0003012B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0#J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\'H\u0003J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\tH\u0002J\u0018\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0007J\"\u0010,\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0007J\"\u0010.\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0007J\u0006\u0010/\u001a\u00020\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/CameraReader;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bitmapComplete", "", "byteArray", "Landroid/arch/lifecycle/MutableLiveData;", "", "byteArrayCreateTask", "Lcom/thanksmister/things/wallpanel/modules/CameraReader$ByteArrayTask;", "cameraCallback", "Lcom/thanksmister/things/wallpanel/modules/CameraCallback;", "cameraOrientation", "", "cameraPreview", "Lcom/thanksmister/things/wallpanel/ui/views/CameraSourcePreview;", "cameraSource", "Lcom/google/android/gms/vision/CameraSource;", "multiDetector", "Lcom/google/android/gms/vision/MultiDetector;", "renderScript", "Landroid/support/v8/renderscript/RenderScript;", "streamDetector", "Lcom/thanksmister/things/wallpanel/modules/StreamingDetector;", "streamDetectorProcessor", "Lcom/google/android/gms/vision/MultiProcessor;", "Lcom/thanksmister/things/wallpanel/modules/Stream;", "buildCameraDetector", "", "configuration", "Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "buildDetectors", "getJpeg", "Landroid/arch/lifecycle/LiveData;", "initCamera", "camerId", "fsp", "", "setJpeg", "value", "startCamera", "callback", "startCameraPreview", "preview", "startCameraPreviewSolo", "stopCamera", "ByteArrayTask", "Companion", "OnCompleteListener", "app_devDebug"})
public final class CameraReader {
    private final android.support.v8.renderscript.RenderScript renderScript = null;
    private com.thanksmister.things.wallpanel.modules.CameraCallback cameraCallback;
    private com.google.android.gms.vision.MultiDetector multiDetector;
    private com.thanksmister.things.wallpanel.modules.StreamingDetector streamDetector;
    private com.google.android.gms.vision.CameraSource cameraSource;
    private com.google.android.gms.vision.MultiProcessor<com.thanksmister.things.wallpanel.modules.Stream> streamDetectorProcessor;
    private final android.arch.lifecycle.MutableLiveData<byte[]> byteArray = null;
    private boolean bitmapComplete;
    private com.thanksmister.things.wallpanel.modules.CameraReader.ByteArrayTask byteArrayCreateTask;
    private int cameraOrientation;
    private com.thanksmister.things.wallpanel.ui.views.CameraSourcePreview cameraPreview;
    private final android.content.Context context = null;
    public static final com.thanksmister.things.wallpanel.modules.CameraReader.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.LiveData<byte[]> getJpeg() {
        return null;
    }
    
    private final void setJpeg(byte[] value) {
    }
    
    public final void stopCamera() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void startCamera(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.modules.CameraCallback callback, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.persistence.Configuration configuration) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void startCameraPreview(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.modules.CameraCallback callback, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.persistence.Configuration configuration, @org.jetbrains.annotations.Nullable()
    com.thanksmister.things.wallpanel.ui.views.CameraSourcePreview preview) throws java.io.IOException {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void startCameraPreviewSolo(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.modules.CameraCallback callback, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.persistence.Configuration configuration, @org.jetbrains.annotations.Nullable()
    com.thanksmister.things.wallpanel.ui.views.CameraSourcePreview preview) throws java.io.IOException {
    }
    
    private final void buildCameraDetector(com.thanksmister.things.wallpanel.persistence.Configuration configuration) {
    }
    
    private final void buildDetectors(com.thanksmister.things.wallpanel.persistence.Configuration configuration) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final com.google.android.gms.vision.CameraSource initCamera(int camerId, float fsp) {
        return null;
    }
    
    @javax.inject.Inject()
    public CameraReader(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/CameraReader$OnCompleteListener;", "", "onComplete", "", "byteArray", "", "app_devDebug"})
    public static abstract interface OnCompleteListener {
        
        public abstract void onComplete(@org.jetbrains.annotations.Nullable()
        byte[] byteArray);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ#\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0010\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0014R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/CameraReader$ByteArrayTask;", "Landroid/os/AsyncTask;", "", "Ljava/lang/Void;", "", "context", "Landroid/content/Context;", "renderScript", "Landroid/support/v8/renderscript/RenderScript;", "onCompleteListener", "Lcom/thanksmister/things/wallpanel/modules/CameraReader$OnCompleteListener;", "(Landroid/content/Context;Landroid/support/v8/renderscript/RenderScript;Lcom/thanksmister/things/wallpanel/modules/CameraReader$OnCompleteListener;)V", "contextRef", "Ljava/lang/ref/WeakReference;", "doInBackground", "params", "", "([Ljava/lang/Object;)[B", "onPostExecute", "", "result", "app_devDebug"})
    public static final class ByteArrayTask extends android.os.AsyncTask<java.lang.Object, java.lang.Void, byte[]> {
        private final java.lang.ref.WeakReference<android.content.Context> contextRef = null;
        private final android.support.v8.renderscript.RenderScript renderScript = null;
        private final com.thanksmister.things.wallpanel.modules.CameraReader.OnCompleteListener onCompleteListener = null;
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        protected byte[] doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.Object... params) {
            return null;
        }
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.Nullable()
        byte[] result) {
        }
        
        public ByteArrayTask(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.support.v8.renderscript.RenderScript renderScript, @org.jetbrains.annotations.NotNull()
        com.thanksmister.things.wallpanel.modules.CameraReader.OnCompleteListener onCompleteListener) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/CameraReader$Companion;", "", "()V", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}