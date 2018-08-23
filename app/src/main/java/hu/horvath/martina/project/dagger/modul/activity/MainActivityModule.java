package hu.horvath.martina.project.dagger.modul.activity;

import dagger.Module;
import dagger.Provides;
import hu.horvath.martina.project.presenter.MainActivityPresenter;
import hu.horvath.martina.project.view.activity.MainActivity;
import hu.horvath.martina.project.view.interfaces.MainActivityView;

@Module
public class MainActivityModule {

    @Provides
    MainActivityView provideMainView(MainActivity mainActivity) {
        return mainActivity;
    }

    @Provides
    MainActivityPresenter provideMainPresenter(MainActivityView mainActivityView) {
        return new MainActivityPresenter(mainActivityView);
    }
}
