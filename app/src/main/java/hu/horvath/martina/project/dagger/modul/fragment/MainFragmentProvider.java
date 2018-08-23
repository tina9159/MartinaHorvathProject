package hu.horvath.martina.project.dagger.modul.fragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import hu.horvath.martina.project.view.fragment.MainFragment;
import hu.horvath.martina.project.view.fragment.MovieDetailFragment;

@Module
public abstract class MainFragmentProvider {

    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment provideMovieFragmentFactory();

    @ContributesAndroidInjector(modules = MovieDetailFragmentModule.class)
    abstract MovieDetailFragment provideMovieDetailFragmentFactory();
}
