package com.thanksmister.things.wallpanel.persistence;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.thanksmister.things.wallpanel.R;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b@\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u0083\u00012\u00020\u0001:\u0002\u0083\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010y\u001a\u00020\u00112\u0006\u0010z\u001a\u00020$2\u0006\u0010{\u001a\u00020$H\u0002J\u0018\u0010|\u001a\u00020\b2\u0006\u0010z\u001a\u00020$2\u0006\u0010{\u001a\u00020$H\u0002J\u0006\u0010}\u001a\u00020\u0011J\u0006\u0010~\u001a\u00020\u007fJ\u0017\u0010\u0080\u0001\u001a\u00020\u007f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0003\u0010\u0081\u0001J\u0017\u0010\u0082\u0001\u001a\u00020\u007f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0003\u0010\u0081\u0001R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\nR$\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u001aR\u0011\u0010 \u001a\u00020!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R$\u0010%\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020$8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R$\u0010*\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u001aR$\u0010-\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020!8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010#\"\u0004\b/\u00100R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u00101\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b2\u0010\u0013R\u0011\u00103\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b4\u0010\u0013R\u0011\u00105\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u0013R\u0011\u00107\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b8\u0010\'R\u0011\u00109\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b:\u0010\'R\u0011\u0010;\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b<\u0010\u0013R\u0011\u0010=\u001a\u00020>8F\u00a2\u0006\u0006\u001a\u0004\b?\u0010@R\u0011\u0010A\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\bA\u0010\u0013R$\u0010B\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bB\u0010\u0013\"\u0004\bC\u0010\u001aR$\u0010D\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bE\u0010\u0013\"\u0004\bF\u0010\u001aR\u0011\u0010G\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010\'R\u0011\u0010I\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bJ\u0010\nR\u0011\u0010K\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bL\u0010\nR\u0011\u0010M\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bN\u0010\nR\u0011\u0010O\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\bP\u0010\u0013R\u0011\u0010Q\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bR\u0010\nR\u0011\u0010S\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\bT\u0010\'R\u0011\u0010U\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\bV\u0010\'R\u0011\u0010W\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\bX\u0010\u0013R\u0011\u0010Y\u001a\u00020\b8G\u00a2\u0006\u0006\u001a\u0004\bZ\u0010\nR\u0011\u0010[\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\\\u0010\nR(\u0010]\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b^\u0010\n\"\u0004\b_\u0010\u000fR(\u0010`\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\ba\u0010\n\"\u0004\bb\u0010\u000fR$\u0010c\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020$8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bd\u0010\'\"\u0004\be\u0010)R$\u0010f\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020$8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bg\u0010\'\"\u0004\bh\u0010)R\u0011\u0010i\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\bj\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010k\u001a\u00020!8F\u00a2\u0006\u0006\u001a\u0004\bl\u0010#R$\u0010m\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020$8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bn\u0010\'\"\u0004\bo\u0010)R$\u0010p\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bq\u0010\n\"\u0004\br\u0010\u000fR$\u0010s\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bt\u0010\u0013\"\u0004\bu\u0010\u001aR$\u0010v\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bw\u0010\u0013\"\u0004\bx\u0010\u001a\u00a8\u0006\u0084\u0001"}, d2 = {"Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "", "context", "Landroid/content/Context;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/Context;Landroid/content/SharedPreferences;)V", "androidBrowserType", "", "getAndroidBrowserType", "()Ljava/lang/String;", "launchUrl", "appLaunchUrl", "getAppLaunchUrl", "setAppLaunchUrl", "(Ljava/lang/String;)V", "appPreventSleep", "", "getAppPreventSleep", "()Z", "appShowActivity", "getAppShowActivity", "value", "browserRefresh", "getBrowserRefresh", "setBrowserRefresh", "(Z)V", "browserUserAgent", "getBrowserUserAgent", "cameraEnabled", "getCameraEnabled", "setCameraEnabled", "cameraFPS", "", "getCameraFPS", "()F", "", "cameraId", "getCameraId", "()I", "setCameraId", "(I)V", "cameraPermissionsShown", "getCameraPermissionsShown", "setCameraPermissionsShown", "cameraRotate", "getCameraRotate", "setCameraRotate", "(F)V", "hasScreenSaver", "getHasScreenSaver", "httpEnabled", "getHttpEnabled", "httpMJPEGEnabled", "getHttpMJPEGEnabled", "httpMJPEGMaxStreams", "getHttpMJPEGMaxStreams", "httpPort", "getHttpPort", "httpRestEnabled", "getHttpRestEnabled", "inactivityTime", "", "getInactivityTime", "()J", "isFirstTime", "isPortraitMode", "setPortraitMode", "motionEnabled", "getMotionEnabled", "setMotionEnabled", "motionResetTime", "getMotionResetTime", "mqttBaseTopic", "getMqttBaseTopic", "mqttBroker", "getMqttBroker", "mqttClientId", "getMqttClientId", "mqttEnabled", "getMqttEnabled", "mqttPassword", "getMqttPassword", "mqttSensorFrequency", "getMqttSensorFrequency", "mqttServerPort", "getMqttServerPort", "mqttTlsEnabled", "getMqttTlsEnabled", "mqttUrl", "getMqttUrl", "mqttUsername", "getMqttUsername", "networkId", "getNetworkId", "setNetworkId", "networkPassword", "getNetworkPassword", "setNetworkPassword", "screenBrightness", "getScreenBrightness", "setScreenBrightness", "screenScreenSaverBrightness", "getScreenScreenSaverBrightness", "setScreenScreenSaverBrightness", "sensorsEnabled", "getSensorsEnabled", "testZoomLevel", "getTestZoomLevel", "timeFormat", "getTimeFormat", "setTimeFormat", "timeZone", "getTimeZone", "setTimeZone", "useTimeServer", "getUseTimeServer", "setUseTimeServer", "writeScreenPermissionsShown", "getWriteScreenPermissionsShown", "setWriteScreenPermissionsShown", "getBoolPref", "resId", "defId", "getStringPref", "hasCameraDetections", "reset", "", "setFirstTime", "(Ljava/lang/Boolean;)V", "setHttpMJPEGEnabled", "Companion", "app_devDebug"})
public final class Configuration {
    private final android.content.Context context = null;
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_FIRST_TIME = "pref_first_time";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_WRITE_SCREEN_PERMISSIONS = "pref_write_screen_permissions";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_CAMERA_PERMISSIONS = "pref_camera_permissions";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_CAMERA_ROTATE = "pref_camera_rotate";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_NETWORK_ID = "pref_network_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_NETWORK_PASSWORD = "pref_network_pass";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_DEVICE_SCREEN_POTRAIT = "pref_screen_portrait";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_DEVICE_TIME_SERVER = "pref_device_time_server";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_DEVICE_TIME_FORMAT = "pref_device_time_format_local";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_DEVICE_TIME = "pref_device_time";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_DEVICE_TIME_ZONE = "pref_device_time_zone";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_DEVICE_SCREEN_BRIGHTNESS = "pref_screen_brightness";
    public static final double PREF_BRIGHTNESS_FACTOR = 0.1;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_BROWSER_LEGACY = "Legacy";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_BROWSER_NATIVE = "Native";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_BROWSER_AUTO = "Auto";
    public static final com.thanksmister.things.wallpanel.persistence.Configuration.Companion Companion = null;
    
    public final boolean isFirstTime() {
        return false;
    }
    
    public final boolean getAppPreventSleep() {
        return false;
    }
    
    public final boolean getWriteScreenPermissionsShown() {
        return false;
    }
    
    public final void setWriteScreenPermissionsShown(boolean value) {
    }
    
    public final boolean getCameraPermissionsShown() {
        return false;
    }
    
    public final void setCameraPermissionsShown(boolean value) {
    }
    
    public final float getCameraRotate() {
        return 0.0F;
    }
    
    public final void setCameraRotate(float value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAppLaunchUrl() {
        return null;
    }
    
    public final void setAppLaunchUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String launchUrl) {
    }
    
    public final boolean getAppShowActivity() {
        return false;
    }
    
    public final boolean getCameraEnabled() {
        return false;
    }
    
    public final void setCameraEnabled(boolean value) {
    }
    
    public final int getCameraId() {
        return 0;
    }
    
    public final void setCameraId(int value) {
    }
    
    public final boolean getMotionEnabled() {
        return false;
    }
    
    public final void setMotionEnabled(boolean value) {
    }
    
    public final int getMotionResetTime() {
        return 0;
    }
    
    public final boolean getHttpEnabled() {
        return false;
    }
    
    public final int getHttpPort() {
        return 0;
    }
    
    public final boolean getHttpRestEnabled() {
        return false;
    }
    
    public final boolean getHttpMJPEGEnabled() {
        return false;
    }
    
    public final void setHttpMJPEGEnabled(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean value) {
    }
    
    public final int getHttpMJPEGMaxStreams() {
        return 0;
    }
    
    public final boolean getMqttEnabled() {
        return false;
    }
    
    public final boolean getMqttTlsEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"DefaultLocale"})
    public final java.lang.String getMqttUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMqttBroker() {
        return null;
    }
    
    public final int getMqttServerPort() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMqttBaseTopic() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMqttClientId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMqttUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMqttPassword() {
        return null;
    }
    
    public final int getMqttSensorFrequency() {
        return 0;
    }
    
    public final boolean getSensorsEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAndroidBrowserType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBrowserUserAgent() {
        return null;
    }
    
    public final boolean getBrowserRefresh() {
        return false;
    }
    
    public final void setBrowserRefresh(boolean value) {
    }
    
    public final float getCameraFPS() {
        return 0.0F;
    }
    
    public final float getTestZoomLevel() {
        return 0.0F;
    }
    
    public final long getInactivityTime() {
        return 0L;
    }
    
    public final boolean getHasScreenSaver() {
        return false;
    }
    
    public final int getScreenBrightness() {
        return 0;
    }
    
    public final void setScreenBrightness(int value) {
    }
    
    public final int getScreenScreenSaverBrightness() {
        return 0;
    }
    
    public final void setScreenScreenSaverBrightness(int value) {
    }
    
    public final boolean hasCameraDetections() {
        return false;
    }
    
    private final java.lang.String getStringPref(int resId, int defId) {
        return null;
    }
    
    private final boolean getBoolPref(int resId, int defId) {
        return false;
    }
    
    public final void setFirstTime(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean value) {
    }
    
    public final int getTimeFormat() {
        return 0;
    }
    
    public final void setTimeFormat(int value) {
    }
    
    public final boolean getUseTimeServer() {
        return false;
    }
    
    public final void setUseTimeServer(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTimeZone() {
        return null;
    }
    
    public final void setTimeZone(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final boolean isPortraitMode() {
        return false;
    }
    
    public final void setPortraitMode(boolean value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNetworkId() {
        return null;
    }
    
    public final void setNetworkId(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNetworkPassword() {
        return null;
    }
    
    public final void setNetworkPassword(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    public final void reset() {
    }
    
    @javax.inject.Inject()
    public Configuration(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences sharedPreferences) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/thanksmister/things/wallpanel/persistence/Configuration$Companion;", "", "()V", "PREF_BRIGHTNESS_FACTOR", "", "PREF_BROWSER_AUTO", "", "PREF_BROWSER_LEGACY", "PREF_BROWSER_NATIVE", "PREF_CAMERA_PERMISSIONS", "PREF_CAMERA_ROTATE", "PREF_DEVICE_SCREEN_BRIGHTNESS", "PREF_DEVICE_SCREEN_POTRAIT", "PREF_DEVICE_TIME", "PREF_DEVICE_TIME_FORMAT", "PREF_DEVICE_TIME_SERVER", "PREF_DEVICE_TIME_ZONE", "PREF_FIRST_TIME", "PREF_NETWORK_ID", "PREF_NETWORK_PASSWORD", "PREF_WRITE_SCREEN_PERMISSIONS", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}