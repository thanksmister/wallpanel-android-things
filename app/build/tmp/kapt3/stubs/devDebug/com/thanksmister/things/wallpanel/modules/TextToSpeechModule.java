package com.thanksmister.things.wallpanel.modules;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.annotation.RequiresApi;
import timber.log.BuildConfig;
import timber.log.Timber;
import java.util.*;

/**
 * * Module to use Google Text-to-Speech to speak the payload of MQTT messages.
 */
@android.support.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\bJ\b\u0010\u0013\u001a\u00020\u000eH\u0007J\b\u0010\u0014\u001a\u00020\u000eH\u0007R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/thanksmister/things/wallpanel/modules/TextToSpeechModule;", "Landroid/content/ContextWrapper;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "Landroid/arch/lifecycle/LifecycleObserver;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "UTTERANCE_ID", "", "isInitialized", "", "textToSpeech", "Landroid/speech/tts/TextToSpeech;", "onInit", "", "status", "", "speakText", "message", "start", "stop", "app_devDebug"})
public final class TextToSpeechModule extends android.content.ContextWrapper implements android.speech.tts.TextToSpeech.OnInitListener, android.arch.lifecycle.LifecycleObserver {
    private android.speech.tts.TextToSpeech textToSpeech;
    private final java.lang.String UTTERANCE_ID = "timber.log.UTTERANCE_ID";
    private boolean isInitialized;
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_START)
    public final void start() {
    }
    
    @java.lang.Override()
    public void onInit(int status) {
    }
    
    public final void speakText(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @android.arch.lifecycle.OnLifecycleEvent(value = android.arch.lifecycle.Lifecycle.Event.ON_DESTROY)
    public final void stop() {
    }
    
    public TextToSpeechModule(@org.jetbrains.annotations.Nullable()
    android.content.Context base) {
        super(null);
    }
}