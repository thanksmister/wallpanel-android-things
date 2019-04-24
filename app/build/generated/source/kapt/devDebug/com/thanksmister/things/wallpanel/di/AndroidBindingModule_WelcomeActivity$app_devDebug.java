package com.thanksmister.things.wallpanel.di;

import android.app.Activity;
import com.thanksmister.things.wallpanel.ui.activities.WelcomeActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      AndroidBindingModule_WelcomeActivity$app_devDebug.WelcomeActivitySubcomponent.class
)
public abstract class AndroidBindingModule_WelcomeActivity$app_devDebug {
  private AndroidBindingModule_WelcomeActivity$app_devDebug() {}

  @Binds
  @IntoMap
  @ActivityKey(WelcomeActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      WelcomeActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface WelcomeActivitySubcomponent extends AndroidInjector<WelcomeActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<WelcomeActivity> {}
  }
}
