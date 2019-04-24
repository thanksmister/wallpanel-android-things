package com.thanksmister.things.wallpanel.di;

import android.app.Activity;
import com.thanksmister.things.wallpanel.ui.activities.SettingsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      AndroidBindingModule_SettingsActivity$app_devDebug.SettingsActivitySubcomponent.class
)
public abstract class AndroidBindingModule_SettingsActivity$app_devDebug {
  private AndroidBindingModule_SettingsActivity$app_devDebug() {}

  @Binds
  @IntoMap
  @ActivityKey(SettingsActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      SettingsActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface SettingsActivitySubcomponent extends AndroidInjector<SettingsActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SettingsActivity> {}
  }
}
