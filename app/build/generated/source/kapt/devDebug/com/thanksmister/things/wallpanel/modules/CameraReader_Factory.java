// Generated by Dagger (https://google.github.io/dagger).
package com.thanksmister.things.wallpanel.modules;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CameraReader_Factory implements Factory<CameraReader> {
  private final Provider<Context> contextProvider;

  public CameraReader_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public CameraReader get() {
    return new CameraReader(contextProvider.get());
  }

  public static CameraReader_Factory create(Provider<Context> contextProvider) {
    return new CameraReader_Factory(contextProvider);
  }
}
