package hu.horvath.martina.project.data.repository.remote;



import java.util.List;

import javax.inject.Inject;

import hu.horvath.martina.project.data.api.MovieService;
import hu.horvath.martina.project.data.model.Movie;
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
        return service.getMovies(API_KEY, query);
    }

    @Override
    public Flowable<Movie> getMovieById(String id) {
        return service.getMovieById(id, API_KEY);
    }
}
