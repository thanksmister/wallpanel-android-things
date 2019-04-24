// Generated by Dagger (https://google.github.io/dagger).
package com.thanksmister.things.wallpanel.di;

import android.app.Application;
import android.content.res.Resources;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ActivityModule_ProvidesResourcesFactory implements Factory<Resources> {
  private final Provider<Application> applicationProvider;

  public ActivityModule_ProvidesResourcesFactory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Resources get() {
    return Preconditions.checkNotNull(
        ActivityModule.providesResources(applicationProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ActivityModule_ProvidesResourcesFactory create(
      Provider<Application> applicationProvider) {
    return new ActivityModule_ProvidesResourcesFactory(applicationProvider);
  }

  public static Resources proxyProvidesResources(Application application) {
    return Preconditions.checkNotNull(
        ActivityModule.providesResources(application),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
