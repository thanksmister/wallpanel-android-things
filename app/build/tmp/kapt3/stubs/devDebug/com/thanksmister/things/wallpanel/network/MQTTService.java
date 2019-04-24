package com.thanksmister.things.wallpanel.network;

import android.content.Context;
import android.text.TextUtils;
import com.thanksmister.things.wallpanel.R;
import com.thanksmister.things.wallpanel.utils.MqttUtils;
import com.thanksmister.things.wallpanel.utils.StringUtils;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import timber.log.Timber;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.concurrent.atomic.AtomicBoolean;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001d\u0010\u001e\u001a\u00020\u000f2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010 H\u0002\u00a2\u0006\u0002\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/thanksmister/things/wallpanel/network/MQTTService;", "Lcom/thanksmister/things/wallpanel/network/MQTTServiceInterface;", "context", "Landroid/content/Context;", "options", "Lcom/thanksmister/things/wallpanel/network/MQTTOptions;", "listener", "Lcom/thanksmister/things/wallpanel/network/MQTTService$MqttManagerListener;", "(Landroid/content/Context;Lcom/thanksmister/things/wallpanel/network/MQTTOptions;Lcom/thanksmister/things/wallpanel/network/MQTTService$MqttManagerListener;)V", "mReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mqttClient", "Lorg/eclipse/paho/android/service/MqttAndroidClient;", "mqttOptions", "close", "", "initialize", "initializeMqttClient", "isReady", "", "publish", "command", "", "payload", "reconfigure", "newOptions", "sendMessage", "mqttTopic", "mqttMessage", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "subscribeToTopics", "topicFilters", "", "([Ljava/lang/String;)V", "Companion", "MqttManagerListener", "app_devDebug"})
public final class MQTTService implements com.thanksmister.things.wallpanel.network.MQTTServiceInterface {
    private org.eclipse.paho.android.service.MqttAndroidClient mqttClient;
    private com.thanksmister.things.wallpanel.network.MQTTOptions mqttOptions;
    private final java.util.concurrent.atomic.AtomicBoolean mReady = null;
    private android.content.Context context;
    private com.thanksmister.things.wallpanel.network.MQTTService.MqttManagerListener listener;
    private static final boolean SHOULD_RETAIN = false;
    public static final com.thanksmister.things.wallpanel.network.MQTTService.Companion Companion = null;
    
    @java.lang.Override()
    public void reconfigure(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.network.MQTTOptions newOptions, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.network.MQTTService.MqttManagerListener listener) {
    }
    
    @java.lang.Override()
    public boolean isReady() {
        return false;
    }
    
    @java.lang.Override()
    public void close() throws org.eclipse.paho.client.mqttv3.MqttException {
    }
    
    @java.lang.Override()
    public void publish(@org.jetbrains.annotations.NotNull()
    java.lang.String command, @org.jetbrains.annotations.NotNull()
    java.lang.String payload) {
    }
    
    /**
     * * Initialize a Cloud IoT Endpoint given a set of configuration options.
     *     * @param options Cloud IoT configuration options.
     */
    private final void initialize(com.thanksmister.things.wallpanel.network.MQTTOptions options) {
    }
    
    private final void initializeMqttClient() throws org.eclipse.paho.client.mqttv3.MqttException, java.io.IOException, java.security.NoSuchAlgorithmException, java.security.spec.InvalidKeySpecException {
    }
    
    private final void sendMessage(java.lang.String mqttTopic, org.eclipse.paho.client.mqttv3.MqttMessage mqttMessage) throws org.eclipse.paho.client.mqttv3.MqttException {
    }
    
    private final void subscribeToTopics(java.lang.String[] topicFilters) {
    }
    
    public MQTTService(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.network.MQTTOptions options, @org.jetbrains.annotations.Nullable()
    com.thanksmister.things.wallpanel.network.MQTTService.MqttManagerListener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/thanksmister/things/wallpanel/network/MQTTService$MqttManagerListener;", "", "handleMqttConnected", "", "handleMqttDisconnected", "handleMqttException", "errorMessage", "", "subscriptionMessage", "id", "topic", "payload", "app_devDebug"})
    public static abstract interface MqttManagerListener {
        
        public abstract void subscriptionMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.NotNull()
        java.lang.String topic, @org.jetbrains.annotations.NotNull()
        java.lang.String payload);
        
        public abstract void handleMqttException(@org.jetbrains.annotations.NotNull()
        java.lang.String errorMessage);
        
        public abstract void handleMqttDisconnected();
        
        public abstract void handleMqttConnected();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/thanksmister/things/wallpanel/network/MQTTService$Companion;", "", "()V", "SHOULD_RETAIN", "", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}