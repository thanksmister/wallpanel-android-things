package com.thanksmister.things.wallpanel.modules;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.BatteryManager;
import android.os.Handler;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;
import java.util.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \'2\u00020\u0001:\u0001\'B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J\u001a\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\nJ\b\u0010$\u001a\u00020\u0019H\u0002J\u0006\u0010%\u001a\u00020\u0019J\b\u0010&\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/SensorReader;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "batteryHandler", "Landroid/os/Handler;", "batteryHandlerRunnable", "Ljava/lang/Runnable;", "callback", "Lcom/thanksmister/things/wallpanel/modules/SensorCallback;", "lightSensorEvent", "Landroid/hardware/SensorEvent;", "mSensorList", "Ljava/util/ArrayList;", "Landroid/hardware/Sensor;", "mSensorManager", "Landroid/hardware/SensorManager;", "sensorListener", "Landroid/hardware/SensorEventListener;", "sensorsPublished", "", "updateFrequencyMilliSeconds", "", "getBatteryReading", "", "getSensorName", "", "sensorType", "getSensorUnit", "publishSensorData", "sensorName", "sensorData", "Lorg/json/JSONObject;", "startReadings", "freqSeconds", "startSensorReadings", "stopReadings", "stopSensorReading", "Companion", "app_devDebug"})
public final class SensorReader {
    private final android.hardware.SensorManager mSensorManager = null;
    private final java.util.ArrayList<android.hardware.Sensor> mSensorList = null;
    private final android.os.Handler batteryHandler = null;
    private int updateFrequencyMilliSeconds;
    private com.thanksmister.things.wallpanel.modules.SensorCallback callback;
    private boolean sensorsPublished;
    private android.hardware.SensorEvent lightSensorEvent;
    private final java.lang.Runnable batteryHandlerRunnable = null;
    private final android.hardware.SensorEventListener sensorListener = null;
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BATTERY = "battery";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHARGING = "charging";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AC_PLUGGED = "acPlugged";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String USB_PLUGGED = "usbPlugged";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HUMIDITY = "humidity";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LIGHT = "light";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PRESSURE = "pressure";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TEMPERATURE = "temperature";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MAGNETIC_FIELD = "magneticField";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNIT_C = "\u00b0C";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNIT_PERCENTAGE = "%";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNIT_HPA = "hPa";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNIT_UT = "uT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNIT_LX = "lx";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VALUE = "value";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UNIT = "unit";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ID = "id";
    public static final com.thanksmister.things.wallpanel.modules.SensorReader.Companion Companion = null;
    
    public final void startReadings(int freqSeconds, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.modules.SensorCallback callback) {
    }
    
    public final void stopReadings() {
    }
    
    private final void publishSensorData(java.lang.String sensorName, org.json.JSONObject sensorData) {
    }
    
    private final java.lang.String getSensorName(int sensorType) {
        return null;
    }
    
    private final java.lang.String getSensorUnit(int sensorType) {
        return null;
    }
    
    /**
     * * Start all sensor readings.
     */
    private final void startSensorReadings() {
    }
    
    /**
     * * Stop all sensor readings.
     */
    private final void stopSensorReading() {
    }
    
    private final void getBatteryReading() {
    }
    
    @javax.inject.Inject()
    public SensorReader(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/SensorReader$Companion;", "", "()V", "AC_PLUGGED", "", "BATTERY", "CHARGING", "HUMIDITY", "ID", "LIGHT", "MAGNETIC_FIELD", "PRESSURE", "TEMPERATURE", "UNIT", "UNIT_C", "UNIT_HPA", "UNIT_LX", "UNIT_PERCENTAGE", "UNIT_UT", "USB_PLUGGED", "VALUE", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}