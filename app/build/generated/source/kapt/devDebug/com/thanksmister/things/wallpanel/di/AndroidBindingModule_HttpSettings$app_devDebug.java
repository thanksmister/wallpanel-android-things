package com.thanksmister.things.wallpanel.di;

import android.support.v4.app.Fragment;
import com.thanksmister.things.wallpanel.ui.fragments.HttpSettingsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      AndroidBindingModule_HttpSettings$app_devDebug.HttpSettingsFragmentSubcomponent.class
)
public abstract class AndroidBindingModule_HttpSettings$app_devDebug {
  private AndroidBindingModule_HttpSettings$app_devDebug() {}

  @Binds
  @IntoMap
  @FragmentKey(HttpSettingsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      HttpSettingsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface HttpSettingsFragmentSubcomponent extends AndroidInjector<HttpSettingsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<HttpSettingsFragment> {}
  }
}
