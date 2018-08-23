package hu.horvath.martina.project.data.repository.remote;


import javax.inject.Inject;

import hu.horvath.martina.project.data.api.MovieService;
import hu.horvath.martina.project.data.model.Movie;
import hu.horvath.martina.project.data.model.MovieDetails;
import hu.horvath.martina.project.data.model.Response;
import io.reactivex.Flowable;

import static hu.horvath.martina.project.util.Constants.API_KEY;

public class MainRemoteRepositoryImpl implements MainRemoteRepository {

    private MovieService service;

    @Inject
    public MainRemoteRepositoryImpl(MovieService service) {
        this.service = service;
    }


    @Override
    public Flowable<Response> getMovies(String query) {
        //TODO Convert response to movie here
        return service.getMovies(API_KEY, query);
    }

    @Override
    public Flowable<MovieDetails> getMovieDetailsById(String id) {
        return service.getMovieDetailsById(id, API_KEY);
    }
}
