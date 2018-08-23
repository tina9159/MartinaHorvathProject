package hu.horvath.martina.project.dagger.modul.fragment;

import dagger.Module;
import dagger.Provides;
import hu.horvath.martina.project.view.fragment.MainFragment;
import hu.horvath.martina.project.view.fragment.MovieDetailFragment;
import hu.horvath.martina.project.view.interfaces.MainFragmentView;
import hu.horvath.martina.project.view.interfaces.MovieDetailFragmentView;

@Module
public class MovieDetailFragmentModule {

    @Provides
    MovieDetailFragmentView provideDetailFragmentView(MovieDetailFragment movieDetailFragment) {
        return movieDetailFragment;
    }

}


