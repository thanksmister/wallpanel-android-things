package com.thanksmister.things.wallpanel.di;

import android.app.Activity;
import com.thanksmister.things.wallpanel.ui.activities.LiveCameraActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      AndroidBindingModule_LiveCameraActivity$app_devDebug.LiveCameraActivitySubcomponent.class
)
public abstract class AndroidBindingModule_LiveCameraActivity$app_devDebug {
  private AndroidBindingModule_LiveCameraActivity$app_devDebug() {}

  @Binds
  @IntoMap
  @ActivityKey(LiveCameraActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      LiveCameraActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface LiveCameraActivitySubcomponent extends AndroidInjector<LiveCameraActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LiveCameraActivity> {}
  }
}
