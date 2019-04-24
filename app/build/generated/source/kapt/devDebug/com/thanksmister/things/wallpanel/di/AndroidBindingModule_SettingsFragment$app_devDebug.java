package com.thanksmister.things.wallpanel.di;

import android.support.v4.app.Fragment;
import com.thanksmister.things.wallpanel.ui.fragments.SettingsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      AndroidBindingModule_SettingsFragment$app_devDebug.SettingsFragmentSubcomponent.class
)
public abstract class AndroidBindingModule_SettingsFragment$app_devDebug {
  private AndroidBindingModule_SettingsFragment$app_devDebug() {}

  @Binds
  @IntoMap
  @FragmentKey(SettingsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      SettingsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface SettingsFragmentSubcomponent extends AndroidInjector<SettingsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SettingsFragment> {}
  }
}
