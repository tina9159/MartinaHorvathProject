package hu.horvath.martina.project.data.repository.remote;



import java.util.List;

import hu.horvath.martina.project.data.model.Movie;
import hu.horvath.martina.project.data.model.Response;
import io.reactivex.Flowable;

public interface MainRemoteRepository {

    Flowable<Response> getMovies(String query);

    Flowable<Movie> getMovieById(String id);
}
