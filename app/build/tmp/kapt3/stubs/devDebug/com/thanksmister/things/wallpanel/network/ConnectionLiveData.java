package com.thanksmister.things.wallpanel.network;

import android.arch.lifecycle.MutableLiveData;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import timber.log.Timber;
import java.util.concurrent.atomic.AtomicBoolean;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\r\u000eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/thanksmister/things/wallpanel/network/ConnectionLiveData;", "Landroid/arch/lifecycle/MutableLiveData;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connCallbackListener", "Lcom/thanksmister/things/wallpanel/network/ConnectionLiveData$ConnCallbackListener;", "connectionReceiver", "Landroid/content/BroadcastReceiver;", "onActive", "", "onInactive", "Companion", "ConnCallbackListener", "app_devDebug"})
public final class ConnectionLiveData extends android.arch.lifecycle.MutableLiveData<java.lang.Boolean> {
    private com.thanksmister.things.wallpanel.network.ConnectionLiveData.ConnCallbackListener connCallbackListener;
    private final android.content.BroadcastReceiver connectionReceiver = null;
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private static java.util.concurrent.atomic.AtomicBoolean hasNetwork;
    public static final com.thanksmister.things.wallpanel.network.ConnectionLiveData.Companion Companion = null;
    
    @java.lang.Override()
    protected void onActive() {
    }
    
    @java.lang.Override()
    protected void onInactive() {
    }
    
    public ConnectionLiveData(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/thanksmister/things/wallpanel/network/ConnectionLiveData$ConnCallbackListener;", "", "networkConnect", "", "networkDisconnect", "app_devDebug"})
    public static abstract interface ConnCallbackListener {
        
        public abstract void networkConnect();
        
        public abstract void networkDisconnect();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/thanksmister/things/wallpanel/network/ConnectionLiveData$Companion;", "", "()V", "hasNetwork", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getHasNetwork", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setHasNetwork", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "app_devDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.concurrent.atomic.AtomicBoolean getHasNetwork() {
            return null;
        }
        
        public final void setHasNetwork(@org.jetbrains.annotations.NotNull()
        java.util.concurrent.atomic.AtomicBoolean p0) {
        }
        
        private Companion() {
            super();
        }
    }
}