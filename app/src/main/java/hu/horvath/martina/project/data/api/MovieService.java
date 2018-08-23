package hu.horvath.martina.project.data.api;


import hu.horvath.martina.project.data.model.MovieDetails;
import hu.horvath.martina.project.data.model.Response;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET("search/movie")
    Flowable<Response> getMovies(@Query("api_key") String apiKey,
                                 @Query("query") String query);

    @GET("movie/{movie_id}")
    Flowable<MovieDetails> getMovieDetailsById(@Path("movie_id") String id,
                                               @Query("api_key") String apiKey);

}