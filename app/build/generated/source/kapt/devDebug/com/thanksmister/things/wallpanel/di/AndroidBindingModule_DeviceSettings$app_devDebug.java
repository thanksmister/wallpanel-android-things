package com.thanksmister.things.wallpanel.di;

import android.support.v4.app.Fragment;
import com.thanksmister.things.wallpanel.ui.fragments.DeviceSettingsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      AndroidBindingModule_DeviceSettings$app_devDebug.DeviceSettingsFragmentSubcomponent.class
)
public abstract class AndroidBindingModule_DeviceSettings$app_devDebug {
  private AndroidBindingModule_DeviceSettings$app_devDebug() {}

  @Binds
  @IntoMap
  @FragmentKey(DeviceSettingsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      DeviceSettingsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface DeviceSettingsFragmentSubcomponent
      extends AndroidInjector<DeviceSettingsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DeviceSettingsFragment> {}
  }
}
