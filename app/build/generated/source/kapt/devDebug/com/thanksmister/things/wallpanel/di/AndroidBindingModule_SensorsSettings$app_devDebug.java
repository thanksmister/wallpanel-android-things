package com.thanksmister.things.wallpanel.di;

import android.support.v4.app.Fragment;
import com.thanksmister.things.wallpanel.ui.fragments.SensorsSettingsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      AndroidBindingModule_SensorsSettings$app_devDebug.SensorsSettingsFragmentSubcomponent.class
)
public abstract class AndroidBindingModule_SensorsSettings$app_devDebug {
  private AndroidBindingModule_SensorsSettings$app_devDebug() {}

  @Binds
  @IntoMap
  @FragmentKey(SensorsSettingsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      SensorsSettingsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface SensorsSettingsFragmentSubcomponent
      extends AndroidInjector<SensorsSettingsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SensorsSettingsFragment> {}
  }
}
