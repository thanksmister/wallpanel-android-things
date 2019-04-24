package com.thanksmister.things.wallpanel.di;

import android.app.Activity;
import com.thanksmister.things.wallpanel.ui.activities.BrowserActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      AndroidBindingModule_BrowserActivity$app_devDebug.BrowserActivitySubcomponent.class
)
public abstract class AndroidBindingModule_BrowserActivity$app_devDebug {
  private AndroidBindingModule_BrowserActivity$app_devDebug() {}

  @Binds
  @IntoMap
  @ActivityKey(BrowserActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      BrowserActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface BrowserActivitySubcomponent extends AndroidInjector<BrowserActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BrowserActivity> {}
  }
}
