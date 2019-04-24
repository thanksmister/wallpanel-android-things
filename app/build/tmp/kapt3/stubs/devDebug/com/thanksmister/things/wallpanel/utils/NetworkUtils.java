package com.thanksmister.things.wallpanel.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import timber.log.Timber;

/**
 * * Network tools
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J \u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/thanksmister/things/wallpanel/utils/NetworkUtils;", "", "()V", "connectNetwork", "", "context", "Landroid/content/Context;", "networkSSID", "", "networkPassword", "getCurrentNetworkName", "getNetworkId", "", "networkList", "", "Landroid/net/wifi/WifiConfiguration;", "hasInternetAccess", "", "isConnectedToWifi", "isConnectionLte", "app_devDebug"})
public final class NetworkUtils {
    public static final com.thanksmister.things.wallpanel.utils.NetworkUtils INSTANCE = null;
    
    private final boolean hasInternetAccess(android.content.Context context) {
        return false;
    }
    
    public final boolean isConnectedToWifi(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final boolean isConnectionLte(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final void connectNetwork(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String networkSSID, @org.jetbrains.annotations.Nullable()
    java.lang.String networkPassword) {
    }
    
    private final int getNetworkId(java.lang.String networkSSID, java.util.List<? extends android.net.wifi.WifiConfiguration> networkList) {
        return 0;
    }
    
    /**
     * * Get the current network name.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentNetworkName(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    private NetworkUtils() {
        super();
    }
}