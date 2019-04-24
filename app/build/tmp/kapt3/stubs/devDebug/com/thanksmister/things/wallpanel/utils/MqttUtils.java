package com.thanksmister.things.wallpanel.utils;

import android.content.Context;
import android.text.TextUtils;
import com.thanksmister.things.wallpanel.network.MQTTService;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import timber.log.Timber;
import java.nio.charset.Charset;
import java.util.*;

/**
 * * Just a utility class to work with the specific settings of the MQTT
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/thanksmister/things/wallpanel/utils/MqttUtils;", "", "()V", "Companion", "app_devDebug"})
public final class MqttUtils {
    public static final int PORT = 1883;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOPIC_COMMAND = "command";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_STATE = "state";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VALUE = "value";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_SENSOR_FACE = "sensor/face";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_SENSOR_QR_CODE = "sensor/qrcode";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_SENSOR_MOTION = "sensor/motion";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATE_CURRENT_URL = "currentUrl";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATE_SCREEN_ON = "screenOn";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STATE_BRIGHTNESS = "brightness";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_SENSOR = "sensor/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_URL = "url";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_CAMERA = "camera";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_RELAUNCH = "relaunch";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_WAKE = "wake";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_WAKETIME = "wakeTime";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_BRIGHTNESS = "brightness";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_NOTIFICATION = "notification";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_RELOAD = "reload";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_CLEAR_CACHE = "clearCache";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_EVAL = "eval";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_AUDIO = "audio";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_SPEAK = "speak";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COMMAND_VOLUME = "volume";
    private static final java.util.ArrayList<java.lang.String> topicsList = null;
    public static final com.thanksmister.things.wallpanel.utils.MqttUtils.Companion Companion = null;
    
    public MqttUtils() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0007J\u0016\u0010\u001f\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004J%\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0.2\u0006\u00100\u001a\u00020\u00172\b\u00101\u001a\u0004\u0018\u000102\u00a2\u0006\u0002\u00103J\u000e\u00104\u001a\u0002052\u0006\u00100\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/thanksmister/things/wallpanel/utils/MqttUtils$Companion;", "", "()V", "COMMAND_AUDIO", "", "COMMAND_BRIGHTNESS", "COMMAND_CAMERA", "COMMAND_CLEAR_CACHE", "COMMAND_EVAL", "COMMAND_NOTIFICATION", "COMMAND_RELAUNCH", "COMMAND_RELOAD", "COMMAND_SENSOR", "COMMAND_SENSOR_FACE", "COMMAND_SENSOR_MOTION", "COMMAND_SENSOR_QR_CODE", "COMMAND_SPEAK", "COMMAND_STATE", "COMMAND_URL", "COMMAND_VOLUME", "COMMAND_WAKE", "COMMAND_WAKETIME", "PORT", "", "STATE_BRIGHTNESS", "STATE_CURRENT_URL", "STATE_SCREEN_ON", "TOPIC_COMMAND", "VALUE", "mqttConnectOptions", "Lorg/eclipse/paho/client/mqttv3/MqttConnectOptions;", "getMqttConnectOptions", "()Lorg/eclipse/paho/client/mqttv3/MqttConnectOptions;", "topicsList", "Ljava/util/ArrayList;", "getMqttAndroidClient", "Lorg/eclipse/paho/android/service/MqttAndroidClient;", "context", "Landroid/content/Context;", "serverUri", "clientId", "mqttCallbackExtended", "Lorg/eclipse/paho/client/mqttv3/MqttCallbackExtended;", "username", "password", "getMqttMessageListeners", "", "Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;", "length", "listener", "Lcom/thanksmister/things/wallpanel/network/MQTTService$MqttManagerListener;", "(ILcom/thanksmister/things/wallpanel/network/MQTTService$MqttManagerListener;)[Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;", "getQos", "", "app_devDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final org.eclipse.paho.client.mqttv3.MqttConnectOptions getMqttConnectOptions() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.eclipse.paho.client.mqttv3.MqttConnectOptions getMqttConnectOptions(@org.jetbrains.annotations.NotNull()
        java.lang.String username, @org.jetbrains.annotations.NotNull()
        java.lang.String password) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.eclipse.paho.android.service.MqttAndroidClient getMqttAndroidClient(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String serverUri, @org.jetbrains.annotations.NotNull()
        java.lang.String clientId, @org.jetbrains.annotations.NotNull()
        org.eclipse.paho.client.mqttv3.MqttCallbackExtended mqttCallbackExtended) {
            return null;
        }
        
        /**
         * * We need to make an array of listeners to pass to the subscribe topics.
         *         * @param length
         *         * @return
         */
        @org.jetbrains.annotations.NotNull()
        public final org.eclipse.paho.client.mqttv3.IMqttMessageListener[] getMqttMessageListeners(int length, @org.jetbrains.annotations.Nullable()
        com.thanksmister.things.wallpanel.network.MQTTService.MqttManagerListener listener) {
            return null;
        }
        
        /**
         * * Generate an array of QOS values for subscribing to multiple topics.
         *         * @param length
         *         * @return
         */
        @org.jetbrains.annotations.NotNull()
        public final int[] getQos(int length) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}