package com.thanksmister.things.wallpanel.di;

import android.support.v4.app.Fragment;
import com.thanksmister.things.wallpanel.ui.fragments.BaseSettingsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      AndroidBindingModule_BaseSettingsFragment$app_devDebug.BaseSettingsFragmentSubcomponent.class
)
public abstract class AndroidBindingModule_BaseSettingsFragment$app_devDebug {
  private AndroidBindingModule_BaseSettingsFragment$app_devDebug() {}

  @Binds
  @IntoMap
  @FragmentKey(BaseSettingsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      BaseSettingsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface BaseSettingsFragmentSubcomponent extends AndroidInjector<BaseSettingsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseSettingsFragment> {}
  }
}
