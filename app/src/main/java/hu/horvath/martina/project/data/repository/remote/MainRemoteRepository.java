package hu.horvath.martina.project.data.repository.remote;



import hu.horvath.martina.project.data.model.MovieDetails;
import hu.horvath.martina.project.data.model.Response;
import io.reactivex.Flowable;

public interface MainRemoteRepository {

    Flowable<Response> getMovies(String query);

    Flowable<MovieDetails> getMovieDetailsById(String id);
}
