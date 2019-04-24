package com.thanksmister.things.wallpanel.utils;

import android.app.Dialog;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import com.thanksmister.things.wallpanel.R;
import com.thanksmister.things.wallpanel.ui.views.NetworkSettingsView;
import com.thanksmister.things.wallpanel.ui.views.ScreenSaverView;
import timber.log.Timber;

/**
 * * Dialog utils
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J(\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0015J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u0010!\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\"\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cJ*\u0010#\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u001c2\u0006\u0010&\u001a\u00020\'J\u001e\u0010(\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010)\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020*R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/thanksmister/things/wallpanel/utils/DialogUtils;", "Landroid/content/ContextWrapper;", "Landroid/arch/lifecycle/LifecycleObserver;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alertDialog", "Landroid/support/v7/app/AlertDialog;", "dialog", "Landroid/app/Dialog;", "progressDialog", "screenSaverDialog", "buildImmersiveDialog", "context", "Landroid/support/v7/app/AppCompatActivity;", "cancelable", "", "view", "Landroid/view/View;", "fullscreen", "clearDialogs", "", "hideAlertDialog", "hideDialog", "hideProgressDialog", "hideScreenSaverDialog", "showAlertDialog", "message", "", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "activity", "title", "showAlertDialogCancel", "showAlertDialogToDismiss", "showNetworkSettingsDialog", "name", "password", "listener", "Lcom/thanksmister/things/wallpanel/ui/views/NetworkSettingsView$ViewListener;", "showProgressDialog", "showScreenSaver", "Landroid/view/View$OnClickListener;", "app_devDebug"})
public final class DialogUtils extends android.content.ContextWrapper implements android.arch.lifecycle.LifecycleObserver {
    private android.app.Dialog screenSaverDialog;
    private android.support.v7.app.AlertDialog alertDialog;
    private android.app.Dialog dialog;
    private android.support.v7.app.AlertDialog progressDialog;
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_DESTROY)
    public final void clearDialogs() {
    }
    
    public final void hideScreenSaverDialog() {
    }
    
    private final void hideDialog() {
    }
    
    private final void hideAlertDialog() {
    }
    
    public final void showAlertDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void showAlertDialog(@org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void showAlertDialogToDismiss(@org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void showAlertDialog(@org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void showAlertDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    android.content.DialogInterface.OnClickListener onClickListener) {
    }
    
    public final void showAlertDialogCancel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    android.content.DialogInterface.OnClickListener onClickListener) {
    }
    
    public final void showProgressDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String message, boolean cancelable) {
    }
    
    public final void hideProgressDialog() {
    }
    
    /**
     * * Show the screen saver only if the alarm isn't triggered. This shouldn't be an issue
     *     * with the alarm disabled because the disable time will be longer than this.
     */
    public final void showScreenSaver(@org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity activity, @org.jetbrains.annotations.NotNull()
    android.view.View.OnClickListener onClickListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.app.AlertDialog showNetworkSettingsDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.ui.views.NetworkSettingsView.ViewListener listener) {
        return null;
    }
    
    private final android.app.Dialog buildImmersiveDialog(android.support.v7.app.AppCompatActivity context, boolean cancelable, android.view.View view, boolean fullscreen) {
        return null;
    }
    
    public DialogUtils(@org.jetbrains.annotations.Nullable()
    android.content.Context base) {
        super(null);
    }
}