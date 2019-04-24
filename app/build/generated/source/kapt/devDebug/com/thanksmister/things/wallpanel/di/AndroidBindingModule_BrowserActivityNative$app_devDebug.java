package com.thanksmister.things.wallpanel.di;

import android.app.Activity;
import com.thanksmister.things.wallpanel.ui.activities.BrowserActivityNative;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      AndroidBindingModule_BrowserActivityNative$app_devDebug.BrowserActivityNativeSubcomponent
          .class
)
public abstract class AndroidBindingModule_BrowserActivityNative$app_devDebug {
  private AndroidBindingModule_BrowserActivityNative$app_devDebug() {}

  @Binds
  @IntoMap
  @ActivityKey(BrowserActivityNative.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      BrowserActivityNativeSubcomponent.Builder builder);

  @Subcomponent
  public interface BrowserActivityNativeSubcomponent
      extends AndroidInjector<BrowserActivityNative> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BrowserActivityNative> {}
  }
}
