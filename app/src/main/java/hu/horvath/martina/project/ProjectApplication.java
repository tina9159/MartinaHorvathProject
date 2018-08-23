package hu.horvath.martina.project;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import hu.horvath.martina.project.dagger.component.DaggerAppComponent;


public class ProjectApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

}
