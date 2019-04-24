package com.thanksmister.things.wallpanel.ui.views;

import android.content.Context;
import android.os.Handler;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import kotlinx.android.synthetic.main.dialog_screen_saver.view.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0002R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/thanksmister/things/wallpanel/ui/views/ScreenSaverView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "parentHeight", "", "parentWidth", "saverContext", "timeHandler", "Landroid/os/Handler;", "timeRunnable", "Ljava/lang/Runnable;", "init", "", "onDetachedFromWindow", "onFinishInflate", "setClockViews", "app_devDebug"})
public final class ScreenSaverView extends android.widget.RelativeLayout {
    private android.os.Handler timeHandler;
    private android.content.Context saverContext;
    private int parentWidth;
    private int parentHeight;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Calendar calendar = null;
    private final java.lang.Runnable timeRunnable = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Calendar getCalendar() {
        return null;
    }
    
    @java.lang.Override()
    protected void onDetachedFromWindow() {
    }
    
    public final void init() {
    }
    
    @java.lang.Override()
    protected void onFinishInflate() {
    }
    
    private final void setClockViews() {
    }
    
    public ScreenSaverView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public ScreenSaverView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs) {
        super(null);
    }
}