package hu.horvath.martina.project.dagger.modul.activity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import hu.horvath.martina.project.dagger.modul.fragment.MainFragmentProvider;
import hu.horvath.martina.project.view.activity.MainActivity;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, MainFragmentProvider.class})
    abstract MainActivity bindMainActivity();
}