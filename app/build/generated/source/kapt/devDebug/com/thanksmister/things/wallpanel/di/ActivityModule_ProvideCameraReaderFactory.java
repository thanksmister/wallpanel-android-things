// Generated by Dagger (https://google.github.io/dagger).
package com.thanksmister.things.wallpanel.di;

import android.app.Application;
import com.thanksmister.things.wallpanel.modules.CameraReader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ActivityModule_ProvideCameraReaderFactory implements Factory<CameraReader> {
  private final Provider<Application> appProvider;

  public ActivityModule_ProvideCameraReaderFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public CameraReader get() {
    return Preconditions.checkNotNull(
        ActivityModule.provideCameraReader(appProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ActivityModule_ProvideCameraReaderFactory create(
      Provider<Application> appProvider) {
    return new ActivityModule_ProvideCameraReaderFactory(appProvider);
  }

  public static CameraReader proxyProvideCameraReader(Application app) {
    return Preconditions.checkNotNull(
        ActivityModule.provideCameraReader(app),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
