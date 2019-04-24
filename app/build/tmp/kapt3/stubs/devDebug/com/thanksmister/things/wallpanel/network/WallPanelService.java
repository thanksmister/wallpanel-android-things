package com.thanksmister.things.wallpanel.network;

import android.arch.lifecycle.LifecycleService;
import android.arch.lifecycle.Observer;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.*;
import android.provider.Settings;
import android.support.v4.content.LocalBroadcastManager;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.thanksmister.things.wallpanel.R;
import com.thanksmister.things.wallpanel.modules.*;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import com.thanksmister.things.wallpanel.utils.MqttUtils;
import com.thanksmister.things.wallpanel.utils.NotificationUtils;
import com.thanksmister.things.wallpanel.utils.ScreenUtils;
import dagger.android.AndroidInjection;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00e6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u0096\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0096\u0001\u0097\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u0006H\u0002J\u0010\u0010\\\u001a\u00020Z2\u0006\u0010]\u001a\u00020AH\u0002J\b\u0010^\u001a\u00020ZH\u0002J\b\u0010_\u001a\u00020ZH\u0002J\b\u0010`\u001a\u00020ZH\u0002J\b\u0010a\u001a\u00020ZH\u0002J\b\u0010b\u001a\u00020ZH\u0002J\b\u0010c\u001a\u00020ZH\u0002J\b\u0010d\u001a\u00020ZH\u0002J\b\u0010e\u001a\u00020ZH\u0002J\b\u0010f\u001a\u00020ZH\u0002J\u0010\u0010g\u001a\u00020Z2\u0006\u0010h\u001a\u00020\u0006H\u0002J\b\u0010i\u001a\u00020ZH\u0002J\b\u0010j\u001a\u00020ZH\u0002J\b\u0010!\u001a\u00020\nH\u0002J\u0012\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010m\u001a\u00020nH\u0016J\b\u0010o\u001a\u00020ZH\u0016J\b\u0010p\u001a\u00020ZH\u0016J\b\u0010q\u001a\u00020ZH\u0016J\b\u0010r\u001a\u00020ZH\u0016J\u0010\u0010s\u001a\u00020Z2\u0006\u0010t\u001a\u00020\u0006H\u0016J \u0010u\u001a\u00020Z2\u0006\u0010v\u001a\u00020\u00062\u0006\u0010w\u001a\u00020\u00062\u0006\u0010x\u001a\u00020\u0006H\u0016J\b\u0010y\u001a\u00020ZH\u0016J\b\u0010z\u001a\u00020ZH\u0016J\u0010\u0010{\u001a\u00020Z2\u0006\u0010|\u001a\u00020\u0006H\u0002J\u0010\u0010}\u001a\u00020\n2\u0006\u0010~\u001a\u00020\u0006H\u0002J\u0010\u0010}\u001a\u00020\n2\u0006\u0010\u007f\u001a\u00020SH\u0002J\t\u0010\u0080\u0001\u001a\u00020ZH\u0002J\u0019\u0010\u0081\u0001\u001a\u00020Z2\u0006\u0010~\u001a\u00020\u00062\u0006\u0010t\u001a\u00020\u0006H\u0002J\u001a\u0010\u0081\u0001\u001a\u00020Z2\u0006\u0010~\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u00020SH\u0002J\t\u0010\u0083\u0001\u001a\u00020ZH\u0002J\t\u0010\u0084\u0001\u001a\u00020ZH\u0002J\u0011\u0010\u0085\u0001\u001a\u00020Z2\u0006\u0010t\u001a\u00020\u0006H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020Z2\u0006\u0010t\u001a\u00020\u0006H\u0002J\t\u0010\u0087\u0001\u001a\u00020ZH\u0002J\u0013\u0010\u0088\u0001\u001a\u00020Z2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J\u0011\u0010\u008b\u0001\u001a\u00020Z2\u0006\u0010t\u001a\u00020\u0006H\u0002J\t\u0010\u008c\u0001\u001a\u00020ZH\u0002J\t\u0010\u008d\u0001\u001a\u00020ZH\u0002J\t\u0010\u008e\u0001\u001a\u00020ZH\u0002J\u0012\u0010\u008e\u0001\u001a\u00020Z2\u0007\u0010\u008f\u0001\u001a\u00020/H\u0002J\t\u0010\u0090\u0001\u001a\u00020ZH\u0002J\t\u0010\u0091\u0001\u001a\u00020ZH\u0002J\t\u0010\u0092\u0001\u001a\u00020ZH\u0002J\t\u0010\u0093\u0001\u001a\u00020ZH\u0002J\u0013\u0010\u0093\u0001\u001a\u00020Z2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00060*R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u00108\u001a\u0002098\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u00020A8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010CR\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bF\u0010GR\u000e\u0010J\u001a\u00020KX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010L\u001a\u00020M8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020S8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bT\u0010UR\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0098\u0001"}, d2 = {"Lcom/thanksmister/things/wallpanel/network/WallPanelService;", "Landroid/arch/lifecycle/LifecycleService;", "Lcom/thanksmister/things/wallpanel/modules/MQTTModule$MQTTListener;", "Lcom/thanksmister/things/wallpanel/modules/MotionSensor$MotionListener;", "()V", "appLaunchUrl", "", "appStateClearHandler", "Landroid/os/Handler;", "appStatePublished", "", "audioPlayer", "Landroid/media/MediaPlayer;", "audioPlayerBusy", "brightTimer", "cameraDetectorCallback", "Lcom/thanksmister/things/wallpanel/modules/CameraCallback;", "cameraReader", "Lcom/thanksmister/things/wallpanel/modules/CameraReader;", "getCameraReader", "()Lcom/thanksmister/things/wallpanel/modules/CameraReader;", "setCameraReader", "(Lcom/thanksmister/things/wallpanel/modules/CameraReader;)V", "configuration", "Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "getConfiguration", "()Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "setConfiguration", "(Lcom/thanksmister/things/wallpanel/persistence/Configuration;)V", "connectionLiveData", "Lcom/thanksmister/things/wallpanel/network/ConnectionLiveData;", "dimScreen", "Ljava/lang/Runnable;", "hasNetwork", "Ljava/util/concurrent/atomic/AtomicBoolean;", "httpServer", "Lcom/koushikdutta/async/http/server/AsyncHttpServer;", "isScreenOn", "()Z", "localBroadCastManager", "Landroid/support/v4/content/LocalBroadcastManager;", "mBinder", "Lcom/thanksmister/things/wallpanel/network/WallPanelService$WallPanelServiceBinder;", "mBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "mJpegSockets", "Ljava/util/ArrayList;", "Lcom/koushikdutta/async/http/server/AsyncHttpServerResponse;", "motionClearHandler", "motionDetected", "motionSensorModule", "Lcom/thanksmister/things/wallpanel/modules/MotionSensor;", "mqttAlertMessageShown", "mqttConnected", "mqttModule", "Lcom/thanksmister/things/wallpanel/modules/MQTTModule;", "mqttOptions", "Lcom/thanksmister/things/wallpanel/network/MQTTOptions;", "getMqttOptions", "()Lcom/thanksmister/things/wallpanel/network/MQTTOptions;", "setMqttOptions", "(Lcom/thanksmister/things/wallpanel/network/MQTTOptions;)V", "reconnectHandler", "restartMqttRunnable", "screenBrightness", "", "getScreenBrightness", "()I", "screenUtils", "Lcom/thanksmister/things/wallpanel/utils/ScreenUtils;", "getScreenUtils", "()Lcom/thanksmister/things/wallpanel/utils/ScreenUtils;", "screenUtils$delegate", "Lkotlin/Lazy;", "sensorCallback", "Lcom/thanksmister/things/wallpanel/modules/SensorCallback;", "sensorReader", "Lcom/thanksmister/things/wallpanel/modules/SensorReader;", "getSensorReader", "()Lcom/thanksmister/things/wallpanel/modules/SensorReader;", "setSensorReader", "(Lcom/thanksmister/things/wallpanel/modules/SensorReader;)V", "state", "Lorg/json/JSONObject;", "getState", "()Lorg/json/JSONObject;", "textToSpeechModule", "Lcom/thanksmister/things/wallpanel/modules/TextToSpeechModule;", "timerActive", "browseUrl", "", "url", "changeScreenBrightness", "brightness", "clearAlertMessage", "clearBrowserCache", "clearMotionDetected", "clearPublishApplicationState", "configureAudioPlayer", "configureCamera", "configureMotion", "configureMqtt", "configureTextToSpeech", "evalJavascript", "js", "handleNetworkConnect", "handleNetworkDisconnect", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onMQTTConnect", "onMQTTDisconnect", "onMQTTException", "message", "onMQTTMessage", "id", "topic", "payload", "onMotionDetected", "onMotionStopped", "playAudio", "audioUrl", "processCommand", "command", "commandJson", "publishApplicationState", "publishMessage", "data", "publishMotionDetected", "reloadPage", "sendAlertMessage", "sendToastMessage", "sendWakeScreen", "setVolume", "vol", "", "speakMessage", "startForeground", "startHttp", "startMJPEG", "response", "startSensors", "stopHttp", "stopMJPEG", "switchScreenOn", "wakeTime", "", "Companion", "WallPanelServiceBinder", "app_devDebug"})
public final class WallPanelService extends android.arch.lifecycle.LifecycleService implements com.thanksmister.things.wallpanel.modules.MQTTModule.MQTTListener, com.thanksmister.things.wallpanel.modules.MotionSensor.MotionListener {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.persistence.Configuration configuration;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.modules.CameraReader cameraReader;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.modules.SensorReader sensorReader;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.thanksmister.things.wallpanel.network.MQTTOptions mqttOptions;
    private final kotlin.Lazy screenUtils$delegate = null;
    private final java.util.ArrayList<com.koushikdutta.async.http.server.AsyncHttpServerResponse> mJpegSockets = null;
    private android.media.MediaPlayer audioPlayer;
    private boolean audioPlayerBusy;
    private final android.os.Handler brightTimer = null;
    private boolean timerActive;
    private com.koushikdutta.async.http.server.AsyncHttpServer httpServer;
    private final com.thanksmister.things.wallpanel.network.WallPanelService.WallPanelServiceBinder mBinder = null;
    private final android.os.Handler motionClearHandler = null;
    private final android.os.Handler appStateClearHandler = null;
    private com.thanksmister.things.wallpanel.modules.TextToSpeechModule textToSpeechModule;
    private com.thanksmister.things.wallpanel.modules.MotionSensor motionSensorModule;
    private com.thanksmister.things.wallpanel.modules.MQTTModule mqttModule;
    private com.thanksmister.things.wallpanel.network.ConnectionLiveData connectionLiveData;
    private java.util.concurrent.atomic.AtomicBoolean hasNetwork;
    private boolean motionDetected;
    private boolean appStatePublished;
    private final android.os.Handler reconnectHandler = null;
    private java.lang.String appLaunchUrl;
    private android.support.v4.content.LocalBroadcastManager localBroadCastManager;
    private boolean mqttAlertMessageShown;
    private boolean mqttConnected;
    
    /**
     * * Dim screen, most devices won't go below 5
     */
    private final java.lang.Runnable dimScreen = null;
    private final java.lang.Runnable restartMqttRunnable = null;
    private final android.content.BroadcastReceiver mBroadcastReceiver = null;
    private final com.thanksmister.things.wallpanel.modules.SensorCallback sensorCallback = null;
    private final com.thanksmister.things.wallpanel.modules.CameraCallback cameraDetectorCallback = null;
    public static final int ONGOING_NOTIFICATION_ID = 1;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_EVENT_URL_CHANGE = "BROADCAST_EVENT_URL_CHANGE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_EVENT_SCREEN_TOUCH = "BROADCAST_EVENT_SCREEN_TOUCH";
    public static final long SCREEN_WAKE_TIME = 30000L;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_ALERT_MESSAGE = "BROADCAST_ALERT_MESSAGE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_CLEAR_ALERT_MESSAGE = "BROADCAST_CLEAR_ALERT_MESSAGE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_TOAST_MESSAGE = "BROADCAST_TOAST_MESSAGE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_SCREEN_WAKE = "BROADCAST_SCREEN_WAKE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BROADCAST_SCREEN_BRIGHTNESS_CHANGE = "BROADCAST_SCREEN_BRIGHTNESS_CHANGE";
    public static final com.thanksmister.things.wallpanel.network.WallPanelService.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.thanksmister.things.wallpanel.persistence.Configuration getConfiguration() {
        return null;
    }
    
    public final void setConfiguration(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.persistence.Configuration p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.thanksmister.things.wallpanel.modules.CameraReader getCameraReader() {
        return null;
    }
    
    public final void setCameraReader(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.modules.CameraReader p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.thanksmister.things.wallpanel.modules.SensorReader getSensorReader() {
        return null;
    }
    
    public final void setSensorReader(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.modules.SensorReader p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.thanksmister.things.wallpanel.network.MQTTOptions getMqttOptions() {
        return null;
    }
    
    public final void setMqttOptions(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.network.MQTTOptions p0) {
    }
    
    private final com.thanksmister.things.wallpanel.utils.ScreenUtils getScreenUtils() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override()
    public void onMotionDetected() {
    }
    
    @java.lang.Override()
    public void onMotionStopped() {
    }
    
    private final boolean isScreenOn() {
        return false;
    }
    
    private final int getScreenBrightness() {
        return 0;
    }
    
    private final org.json.JSONObject getState() {
        return null;
    }
    
    private final void startForeground() {
    }
    
    private final void handleNetworkConnect() {
    }
    
    private final void handleNetworkDisconnect() {
    }
    
    private final boolean hasNetwork() {
        return false;
    }
    
    private final void startSensors() {
    }
    
    private final void configureMqtt() {
    }
    
    @java.lang.Override()
    public void onMQTTConnect() {
    }
    
    @java.lang.Override()
    public void onMQTTDisconnect() {
    }
    
    @java.lang.Override()
    public void onMQTTException(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onMQTTMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    java.lang.String payload) {
    }
    
    private final void publishMessage(java.lang.String command, org.json.JSONObject data) {
    }
    
    private final void publishMessage(java.lang.String command, java.lang.String message) {
    }
    
    private final void configureMotion() {
    }
    
    private final void configureCamera() {
    }
    
    private final void configureTextToSpeech() {
    }
    
    private final void configureAudioPlayer() {
    }
    
    private final void startHttp() {
    }
    
    private final void stopHttp() {
    }
    
    private final void startMJPEG() {
    }
    
    private final void stopMJPEG() {
    }
    
    private final void startMJPEG(com.koushikdutta.async.http.server.AsyncHttpServerResponse response) {
    }
    
    private final boolean processCommand(org.json.JSONObject commandJson) {
        return false;
    }
    
    private final boolean processCommand(java.lang.String command) {
        return false;
    }
    
    private final void browseUrl(java.lang.String url) {
    }
    
    private final void playAudio(java.lang.String audioUrl) {
    }
    
    private final void setVolume(float vol) {
    }
    
    private final void speakMessage(java.lang.String message) {
    }
    
    private final void switchScreenOn() {
    }
    
    private final void switchScreenOn(long wakeTime) {
    }
    
    private final void changeScreenBrightness(int brightness) {
    }
    
    private final void evalJavascript(java.lang.String js) {
    }
    
    private final void reloadPage() {
    }
    
    private final void clearBrowserCache() {
    }
    
    private final void publishMotionDetected() {
    }
    
    private final void publishApplicationState() {
    }
    
    private final void clearPublishApplicationState() {
    }
    
    private final void clearMotionDetected() {
    }
    
    private final void sendAlertMessage(java.lang.String message) {
    }
    
    private final void clearAlertMessage() {
    }
    
    private final void sendWakeScreen() {
    }
    
    private final void sendToastMessage(java.lang.String message) {
    }
    
    public WallPanelService() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/thanksmister/things/wallpanel/network/WallPanelService$WallPanelServiceBinder;", "Landroid/os/Binder;", "(Lcom/thanksmister/things/wallpanel/network/WallPanelService;)V", "service", "Lcom/thanksmister/things/wallpanel/network/WallPanelService;", "getService", "()Lcom/thanksmister/things/wallpanel/network/WallPanelService;", "app_devDebug"})
    public final class WallPanelServiceBinder extends android.os.Binder {
        
        @org.jetbrains.annotations.NotNull()
        public final com.thanksmister.things.wallpanel.network.WallPanelService getService() {
            return null;
        }
        
        public WallPanelServiceBinder() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/thanksmister/things/wallpanel/network/WallPanelService$Companion;", "", "()V", "BROADCAST_ALERT_MESSAGE", "", "BROADCAST_CLEAR_ALERT_MESSAGE", "BROADCAST_EVENT_SCREEN_TOUCH", "BROADCAST_EVENT_URL_CHANGE", "BROADCAST_SCREEN_BRIGHTNESS_CHANGE", "BROADCAST_SCREEN_WAKE", "BROADCAST_TOAST_MESSAGE", "ONGOING_NOTIFICATION_ID", "", "SCREEN_WAKE_TIME", "", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}