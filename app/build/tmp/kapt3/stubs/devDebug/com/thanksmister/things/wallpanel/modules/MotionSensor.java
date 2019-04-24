package com.thanksmister.things.wallpanel.modules;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.GpioCallback;
import com.google.android.things.pio.PeripheralManager;

/**
 * * Modified by Michael Ritchie 2018
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/MotionSensor;", "Landroid/arch/lifecycle/LifecycleObserver;", "motionListener", "Lcom/thanksmister/things/wallpanel/modules/MotionSensor$MotionListener;", "motionSensorPinNumber", "", "(Lcom/thanksmister/things/wallpanel/modules/MotionSensor$MotionListener;Ljava/lang/String;)V", "gpiCallback", "Lcom/google/android/things/pio/GpioCallback;", "motionSensorGpioPin", "Lcom/google/android/things/pio/Gpio;", "start", "", "stop", "Companion", "MotionListener", "app_devDebug"})
public final class MotionSensor implements android.arch.lifecycle.LifecycleObserver {
    private com.google.android.things.pio.Gpio motionSensorGpioPin;
    private final com.google.android.things.pio.GpioCallback gpiCallback = null;
    private final com.thanksmister.things.wallpanel.modules.MotionSensor.MotionListener motionListener = null;
    private final java.lang.String motionSensorPinNumber = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MOTION_SENSOR_GPIO_PIN = "BCM27";
    public static final com.thanksmister.things.wallpanel.modules.MotionSensor.Companion Companion = null;
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_CREATE)
    public final void start() {
    }
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_DESTROY)
    public final void stop() {
    }
    
    public MotionSensor(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.modules.MotionSensor.MotionListener motionListener, @org.jetbrains.annotations.NotNull()
    java.lang.String motionSensorPinNumber) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/MotionSensor$MotionListener;", "", "onMotionDetected", "", "onMotionStopped", "app_devDebug"})
    public static abstract interface MotionListener {
        
        public abstract void onMotionDetected();
        
        public abstract void onMotionStopped();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/MotionSensor$Companion;", "", "()V", "MOTION_SENSOR_GPIO_PIN", "", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}