// Generated by Dagger (https://google.github.io/dagger).
package com.thanksmister.things.wallpanel.di;

import android.app.Application;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ActivityModule_ProvideSharedPreferencesFactory
    implements Factory<SharedPreferences> {
  private final ActivityModule module;

  private final Provider<Application> appProvider;

  public ActivityModule_ProvideSharedPreferencesFactory(
      ActivityModule module, Provider<Application> appProvider) {
    this.module = module;
    this.appProvider = appProvider;
  }

  @Override
  public SharedPreferences get() {
    return Preconditions.checkNotNull(
        module.provideSharedPreferences(appProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ActivityModule_ProvideSharedPreferencesFactory create(
      ActivityModule module, Provider<Application> appProvider) {
    return new ActivityModule_ProvideSharedPreferencesFactory(module, appProvider);
  }

  public static SharedPreferences proxyProvideSharedPreferences(
      ActivityModule instance, Application app) {
    return Preconditions.checkNotNull(
        instance.provideSharedPreferences(app),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}