package com.thanksmister.things.wallpanel.modules;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.ContextWrapper;
import com.thanksmister.things.wallpanel.network.MQTTOptions;
import com.thanksmister.things.wallpanel.network.MQTTService;
import org.eclipse.paho.client.mqttv3.MqttException;
import timber.log.Timber;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001#B\u001f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\u0012J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0012J\b\u0010\u001d\u001a\u00020\u0012H\u0003J\b\u0010\u001e\u001a\u00020\u0012H\u0003J \u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/MQTTModule;", "Landroid/content/ContextWrapper;", "Landroid/arch/lifecycle/LifecycleObserver;", "Lcom/thanksmister/things/wallpanel/network/MQTTService$MqttManagerListener;", "base", "Landroid/content/Context;", "mqttOptions", "Lcom/thanksmister/things/wallpanel/network/MQTTOptions;", "listener", "Lcom/thanksmister/things/wallpanel/modules/MQTTModule$MQTTListener;", "(Landroid/content/Context;Lcom/thanksmister/things/wallpanel/network/MQTTOptions;Lcom/thanksmister/things/wallpanel/modules/MQTTModule$MQTTListener;)V", "getMqttOptions", "()Lcom/thanksmister/things/wallpanel/network/MQTTOptions;", "setMqttOptions", "(Lcom/thanksmister/things/wallpanel/network/MQTTOptions;)V", "mqttService", "Lcom/thanksmister/things/wallpanel/network/MQTTService;", "handleMqttConnected", "", "handleMqttDisconnected", "handleMqttException", "errorMessage", "", "pause", "publish", "command", "message", "resetMQttOptions", "restart", "start", "stop", "subscriptionMessage", "id", "topic", "payload", "MQTTListener", "app_devDebug"})
public final class MQTTModule extends android.content.ContextWrapper implements android.arch.lifecycle.LifecycleObserver, com.thanksmister.things.wallpanel.network.MQTTService.MqttManagerListener {
    private com.thanksmister.things.wallpanel.network.MQTTService mqttService;
    @org.jetbrains.annotations.NotNull()
    private com.thanksmister.things.wallpanel.network.MQTTOptions mqttOptions;
    private final com.thanksmister.things.wallpanel.modules.MQTTModule.MQTTListener listener = null;
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_START)
    private final void start() {
    }
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_DESTROY)
    private final void stop() {
    }
    
    public final void restart() {
    }
    
    public final void pause() {
    }
    
    public final void publish(@org.jetbrains.annotations.NotNull()
    java.lang.String command, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void resetMQttOptions(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.network.MQTTOptions mqttOptions) {
    }
    
    @java.lang.Override()
    public void subscriptionMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    java.lang.String payload) {
    }
    
    @java.lang.Override()
    public void handleMqttException(@org.jetbrains.annotations.NotNull()
    java.lang.String errorMessage) {
    }
    
    @java.lang.Override()
    public void handleMqttDisconnected() {
    }
    
    @java.lang.Override()
    public void handleMqttConnected() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.thanksmister.things.wallpanel.network.MQTTOptions getMqttOptions() {
        return null;
    }
    
    public final void setMqttOptions(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.network.MQTTOptions p0) {
    }
    
    public MQTTModule(@org.jetbrains.annotations.Nullable()
    android.content.Context base, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.network.MQTTOptions mqttOptions, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.modules.MQTTModule.MQTTListener listener) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/MQTTModule$MQTTListener;", "", "onMQTTConnect", "", "onMQTTDisconnect", "onMQTTException", "message", "", "onMQTTMessage", "id", "topic", "payload", "app_devDebug"})
    public static abstract interface MQTTListener {
        
        public abstract void onMQTTConnect();
        
        public abstract void onMQTTDisconnect();
        
        public abstract void onMQTTException(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
        
        public abstract void onMQTTMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.NotNull()
        java.lang.String topic, @org.jetbrains.annotations.NotNull()
        java.lang.String payload);
    }
}