package com.thanksmister.things.wallpanel.modules;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;

/**
 * * Created by Michael Ritchie on 7/6/18.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/StreamingDetector;", "Lcom/google/android/gms/vision/Detector;", "Lcom/thanksmister/things/wallpanel/modules/Stream;", "()V", "detect", "Landroid/util/SparseArray;", "frame", "Lcom/google/android/gms/vision/Frame;", "Builder", "app_devDebug"})
public final class StreamingDetector extends com.google.android.gms.vision.Detector<com.thanksmister.things.wallpanel.modules.Stream> {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.util.SparseArray<com.thanksmister.things.wallpanel.modules.Stream> detect(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.vision.Frame frame) {
        return null;
    }
    
    private StreamingDetector() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/StreamingDetector$Builder;", "", "()V", "build", "Lcom/thanksmister/things/wallpanel/modules/StreamingDetector;", "app_devDebug"})
    public static final class Builder {
        
        @org.jetbrains.annotations.NotNull()
        public final com.thanksmister.things.wallpanel.modules.StreamingDetector build() {
            return null;
        }
        
        public Builder() {
            super();
        }
    }
}