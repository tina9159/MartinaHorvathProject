package hu.horvath.martina.project.data.repository.remote;


import javax.inject.Inject;

import hu.horvath.martina.project.data.api.MainService;

public class MainRemoteRepositoryImpl implements MainRemoteRepository {

    private MainService service;

    @Inject
    public MainRemoteRepositoryImpl(MainService service) {
        this.service = service;
    }


}
