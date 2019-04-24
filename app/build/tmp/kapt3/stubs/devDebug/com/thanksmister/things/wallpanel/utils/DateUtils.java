package com.thanksmister.things.wallpanel.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * * Date utils
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/thanksmister/things/wallpanel/utils/DateUtils;", "", "()V", "MINUTES_VALUE", "", "getMINUTES_VALUE", "()I", "setMINUTES_VALUE", "(I)V", "SECONDS_VALUE", "getSECONDS_VALUE", "setSECONDS_VALUE", "convertInactivityTime", "", "inactivityValue", "", "dayOfWeek", "apiTime", "generateCreatedAtDate", "getHourAndMinutesFromTimePicker", "", "timePickerValue", "getHourFromTimePicker", "timeValue", "getMinutesFromTimePicker", "padTimePickerOutput", "app_devDebug"})
public final class DateUtils {
    private static int SECONDS_VALUE;
    private static int MINUTES_VALUE;
    public static final com.thanksmister.things.wallpanel.utils.DateUtils INSTANCE = null;
    
    public final int getSECONDS_VALUE() {
        return 0;
    }
    
    public final void setSECONDS_VALUE(int p0) {
    }
    
    public final int getMINUTES_VALUE() {
        return 0;
    }
    
    public final void setMINUTES_VALUE(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateCreatedAtDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String padTimePickerOutput(@org.jetbrains.annotations.NotNull()
    java.lang.String timeValue) {
        return null;
    }
    
    public final int getHourFromTimePicker(@org.jetbrains.annotations.NotNull()
    java.lang.String timeValue) {
        return 0;
    }
    
    public final int getMinutesFromTimePicker(@org.jetbrains.annotations.NotNull()
    java.lang.String timeValue) {
        return 0;
    }
    
    public final float getHourAndMinutesFromTimePicker(@org.jetbrains.annotations.NotNull()
    java.lang.String timePickerValue) {
        return 0.0F;
    }
    
    /**
     * * This converts the milliseconds to a day of the week, but we try to account
     *     * for time that is shorter than expected from DarkSky API .
     *     * @param apiTime
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String dayOfWeek(long apiTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String convertInactivityTime(long inactivityValue) {
        return null;
    }
    
    private DateUtils() {
        super();
    }
}