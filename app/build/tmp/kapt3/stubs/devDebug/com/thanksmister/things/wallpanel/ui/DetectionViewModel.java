package com.thanksmister.things.wallpanel.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.hardware.Camera;
import android.util.Log;
import com.thanksmister.things.wallpanel.modules.CameraCallback;
import com.thanksmister.things.wallpanel.modules.CameraReader;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import com.thanksmister.things.wallpanel.ui.views.CameraSourcePreview;
import timber.log.Timber;
import java.util.*;
import javax.inject.Inject;

/**
 * * Created by Michael Ritchie on 6/28/18.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0016\u0010\u0012\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/DetectionViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "configuration", "Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "cameraReader", "Lcom/thanksmister/things/wallpanel/modules/CameraReader;", "(Landroid/app/Application;Lcom/thanksmister/things/wallpanel/persistence/Configuration;Lcom/thanksmister/things/wallpanel/modules/CameraReader;)V", "cameras", "Landroid/arch/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "", "getCameraList", "", "getCameras", "Landroid/arch/lifecycle/LiveData;", "onCleared", "setCameras", "startCameraPreview", "callback", "Lcom/thanksmister/things/wallpanel/modules/CameraCallback;", "preview", "Lcom/thanksmister/things/wallpanel/ui/views/CameraSourcePreview;", "Companion", "app_devDebug"})
public final class DetectionViewModel extends android.arch.lifecycle.AndroidViewModel {
    private final android.arch.lifecycle.MutableLiveData<java.util.ArrayList<java.lang.String>> cameras = null;
    private final com.thanksmister.things.wallpanel.persistence.Configuration configuration = null;
    private final com.thanksmister.things.wallpanel.modules.CameraReader cameraReader = null;
    public static final com.thanksmister.things.wallpanel.ui.DetectionViewModel.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.LiveData<java.util.ArrayList<java.lang.String>> getCameras() {
        return null;
    }
    
    private final void setCameras(java.util.ArrayList<java.lang.String> cameras) {
    }
    
    @java.lang.Override()
    public void onCleared() {
    }
    
    @kotlin.Suppress(names = {"DEPRECATION"})
    private final void getCameraList() {
    }
    
    public final void startCameraPreview(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.modules.CameraCallback callback, @org.jetbrains.annotations.Nullable()
    com.thanksmister.things.wallpanel.ui.views.CameraSourcePreview preview) {
    }
    
    @javax.inject.Inject()
    public DetectionViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.persistence.Configuration configuration, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.modules.CameraReader cameraReader) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/DetectionViewModel$Companion;", "", "()V", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}