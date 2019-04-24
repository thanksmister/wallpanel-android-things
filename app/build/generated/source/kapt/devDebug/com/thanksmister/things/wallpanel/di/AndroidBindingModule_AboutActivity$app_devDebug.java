package com.thanksmister.things.wallpanel.di;

import android.app.Activity;
import com.thanksmister.things.wallpanel.ui.activities.AboutActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = AndroidBindingModule_AboutActivity$app_devDebug.AboutActivitySubcomponent.class
)
public abstract class AndroidBindingModule_AboutActivity$app_devDebug {
  private AndroidBindingModule_AboutActivity$app_devDebug() {}

  @Binds
  @IntoMap
  @ActivityKey(AboutActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      AboutActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface AboutActivitySubcomponent extends AndroidInjector<AboutActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AboutActivity> {}
  }
}
