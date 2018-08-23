package hu.horvath.martina.project.presenter;

import javax.inject.Inject;

import hu.horvath.martina.project.data.repository.remote.MainRemoteRepositoryImpl;
import hu.horvath.martina.project.view.interfaces.MainFragmentView;

public class MainFragmentPresenter {

    //TODO Interface for presenter

    @Inject
    MainRemoteRepositoryImpl mainRemoteRepository;

    MainFragmentView view;

    @Inject
    public MainFragmentPresenter(MainFragmentView view) {
        this.view = view;
    }

    public void getAll() {

    }
}