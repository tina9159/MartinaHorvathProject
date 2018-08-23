package hu.horvath.martina.project.dagger.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import hu.horvath.martina.project.ProjectApplication;
import hu.horvath.martina.project.dagger.modul.activity.ActivityBuilderModule;
import hu.horvath.martina.project.dagger.modul.AllModule;
import hu.horvath.martina.project.dagger.modul.AppModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilderModule.class,
        AllModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(ProjectApplication app);

}
