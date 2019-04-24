package com.thanksmister.things.wallpanel.di;

import android.support.v4.app.Fragment;
import com.thanksmister.things.wallpanel.ui.fragments.MqttSettingsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      AndroidBindingModule_MqttSettings$app_devDebug.MqttSettingsFragmentSubcomponent.class
)
public abstract class AndroidBindingModule_MqttSettings$app_devDebug {
  private AndroidBindingModule_MqttSettings$app_devDebug() {}

  @Binds
  @IntoMap
  @FragmentKey(MqttSettingsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      MqttSettingsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface MqttSettingsFragmentSubcomponent extends AndroidInjector<MqttSettingsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MqttSettingsFragment> {}
  }
}
