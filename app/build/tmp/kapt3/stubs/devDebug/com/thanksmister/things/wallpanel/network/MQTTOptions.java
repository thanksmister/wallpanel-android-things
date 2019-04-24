package com.thanksmister.things.wallpanel.network;

import android.text.TextUtils;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import java.util.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0006J\u0011\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014\u00a2\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u0006R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/thanksmister/things/wallpanel/network/MQTTOptions;", "", "configuration", "Lcom/thanksmister/things/wallpanel/persistence/Configuration;", "(Lcom/thanksmister/things/wallpanel/persistence/Configuration;)V", "brokerUrl", "", "getBrokerUrl", "()Ljava/lang/String;", "isValid", "", "()Z", "getBaseTopic", "getBroker", "getClientId", "getPassword", "getPort", "", "getStateTopic", "getStateTopics", "", "()[Ljava/lang/String;", "getTlsConnection", "getUsername", "Companion", "app_devDebug"})
public final class MQTTOptions {
    private final com.thanksmister.things.wallpanel.persistence.Configuration configuration = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SSL_BROKER_URL_FORMAT = "ssl://%s:%d";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TCP_BROKER_URL_FORMAT = "tcp://%s:%d";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HTTP_BROKER_URL_FORMAT = "%s:%d";
    public static final com.thanksmister.things.wallpanel.network.MQTTOptions.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBrokerUrl() {
        return null;
    }
    
    public final boolean isValid() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBroker() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClientId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBaseTopic() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStateTopic() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getStateTopics() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPassword() {
        return null;
    }
    
    public final int getPort() {
        return 0;
    }
    
    public final boolean getTlsConnection() {
        return false;
    }
    
    @javax.inject.Inject()
    public MQTTOptions(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.persistence.Configuration configuration) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/thanksmister/things/wallpanel/network/MQTTOptions$Companion;", "", "()V", "HTTP_BROKER_URL_FORMAT", "", "SSL_BROKER_URL_FORMAT", "TCP_BROKER_URL_FORMAT", "app_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}