package com.thanksmister.things.wallpanel.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import timber.log.Timber;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u0011"}, d2 = {"Lcom/thanksmister/things/wallpanel/utils/ScreenUtils;", "Landroid/content/ContextWrapper;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "canWriteScreenSetting", "", "resetScreenBrightness", "", "screenSaver", "configuration", "Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "window", "Landroid/view/Window;", "setScreenBrightness", "brightValue", "", "app_devDebug"})
public final class ScreenUtils extends android.content.ContextWrapper {
    
    public final void resetScreenBrightness(boolean screenSaver, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.persistence.Configuration configuration, @org.jetbrains.annotations.NotNull()
    android.view.Window window) {
    }
    
    public final void setScreenBrightness(int brightValue, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.persistence.Configuration configuration, @org.jetbrains.annotations.NotNull()
    android.view.Window window) {
    }
    
    private final boolean canWriteScreenSetting() {
        return false;
    }
    
    public ScreenUtils(@org.jetbrains.annotations.NotNull()
    android.content.Context base) {
        super(null);
    }
}