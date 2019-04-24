// Generated by Dagger (https://google.github.io/dagger).
package com.thanksmister.things.wallpanel.ui.activities;

import android.support.v4.app.Fragment;
import com.thanksmister.things.wallpanel.persistence.Configuration;
import com.thanksmister.things.wallpanel.utils.DialogUtils;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import javax.inject.Provider;

public final class BrowserActivity_MembersInjector implements MembersInjector<BrowserActivity> {
  private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;

  private final Provider<DispatchingAndroidInjector<android.app.Fragment>>
      frameworkFragmentInjectorProvider;

  private final Provider<DialogUtils> dialogUtilsProvider;

  private final Provider<Configuration> configurationProvider;

  public BrowserActivity_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<android.app.Fragment>> frameworkFragmentInjectorProvider,
      Provider<DialogUtils> dialogUtilsProvider,
      Provider<Configuration> configurationProvider) {
    this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
    this.frameworkFragmentInjectorProvider = frameworkFragmentInjectorProvider;
    this.dialogUtilsProvider = dialogUtilsProvider;
    this.configurationProvider = configurationProvider;
  }

  public static MembersInjector<BrowserActivity> create(
      Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<android.app.Fragment>> frameworkFragmentInjectorProvider,
      Provider<DialogUtils> dialogUtilsProvider,
      Provider<Configuration> configurationProvider) {
    return new BrowserActivity_MembersInjector(
        supportFragmentInjectorProvider,
        frameworkFragmentInjectorProvider,
        dialogUtilsProvider,
        configurationProvider);
  }

  @Override
  public void injectMembers(BrowserActivity instance) {
    DaggerAppCompatActivity_MembersInjector.injectSupportFragmentInjector(
        instance, supportFragmentInjectorProvider.get());
    DaggerAppCompatActivity_MembersInjector.injectFrameworkFragmentInjector(
        instance, frameworkFragmentInjectorProvider.get());
    injectDialogUtils(instance, dialogUtilsProvider.get());
    injectConfiguration(instance, configurationProvider.get());
  }

  public static void injectDialogUtils(BrowserActivity instance, DialogUtils dialogUtils) {
    instance.dialogUtils = dialogUtils;
  }

  public static void injectConfiguration(BrowserActivity instance, Configuration configuration) {
    instance.configuration = configuration;
  }
}
