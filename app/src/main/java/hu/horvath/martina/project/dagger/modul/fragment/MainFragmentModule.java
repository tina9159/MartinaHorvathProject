package hu.horvath.martina.project.dagger.modul.fragment;

import dagger.Module;
import dagger.Provides;
import hu.horvath.martina.project.view.fragment.MainFragment;
import hu.horvath.martina.project.view.interfaces.MainFragmentView;

@Module
public class MainFragmentModule {

    @Provides
    MainFragmentView provideDetailFragmentView(MainFragment mainFragment) {
        return mainFragment;
    }

}


