package hu.horvath.martina.project.presenter;

import javax.inject.Inject;

import hu.horvath.martina.project.view.interfaces.MainActivityView;

public class MainActivityPresenter {

    //TODO Interface for presenter

    MainActivityView view;

    @Inject
    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

}
