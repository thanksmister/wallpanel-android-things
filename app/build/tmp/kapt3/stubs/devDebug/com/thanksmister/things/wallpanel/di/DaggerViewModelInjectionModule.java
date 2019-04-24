package com.thanksmister.things.wallpanel.di;

import android.arch.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H!\u00a2\u0006\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/thanksmister/things/wallpanel/di/DaggerViewModelInjectionModule;", "", "()V", "bindViewModelFactory", "Landroid/arch/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/thanksmister/things/wallpanel/di/DaggerViewModelFactory;", "bindViewModelFactory$app_devDebug", "app_devDebug"})
@dagger.Module()
public abstract class DaggerViewModelInjectionModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract android.arch.lifecycle.ViewModelProvider.Factory bindViewModelFactory$app_devDebug(@org.jetbrains.annotations.NotNull()
    com.thanksmister.things.wallpanel.di.DaggerViewModelFactory factory);
    
    public DaggerViewModelInjectionModule() {
        super();
    }
}