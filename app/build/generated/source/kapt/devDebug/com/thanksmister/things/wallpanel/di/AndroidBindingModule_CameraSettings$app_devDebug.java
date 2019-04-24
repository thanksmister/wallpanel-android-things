package com.thanksmister.things.wallpanel.di;

import android.support.v4.app.Fragment;
import com.thanksmister.things.wallpanel.ui.fragments.CameraSettingsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      AndroidBindingModule_CameraSettings$app_devDebug.CameraSettingsFragmentSubcomponent.class
)
public abstract class AndroidBindingModule_CameraSettings$app_devDebug {
  private AndroidBindingModule_CameraSettings$app_devDebug() {}

  @Binds
  @IntoMap
  @FragmentKey(CameraSettingsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      CameraSettingsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface CameraSettingsFragmentSubcomponent
      extends AndroidInjector<CameraSettingsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CameraSettingsFragment> {}
  }
}
