package com.thanksmister.things.wallpanel.utils;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import timber.log.Timber;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/thanksmister/things/wallpanel/utils/DeviceUtils;", "", "()V", "uuIdHash", "", "getUuIdHash", "()Ljava/lang/String;", "convertScreenBrightnessToFloat", "", "currentBrightness", "", "getScreenBrightnessBasedOnDayTime", "startTime", "endTime", "getScreenBrightnessNightMode", "md5", "s", "app_devDebug"})
public final class DeviceUtils {
    public static final com.thanksmister.things.wallpanel.utils.DeviceUtils INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUuIdHash() {
        return null;
    }
    
    public final float convertScreenBrightnessToFloat(int currentBrightness) {
        return 0.0F;
    }
    
    /**
     * * Returns the adjusted brightness depending when its night mode
     */
    public final float getScreenBrightnessNightMode(int currentBrightness) {
        return 0.0F;
    }
    
    /**
     * * Returns the adjusted brightness depending on the time of day (less bright at night)
     *     * @param currentBrightness
     *     * @return
     */
    public final float getScreenBrightnessBasedOnDayTime(int currentBrightness, float startTime, float endTime) {
        return 0.0F;
    }
    
    private final java.lang.String md5(java.lang.String s) {
        return null;
    }
    
    private DeviceUtils() {
        super();
    }
}