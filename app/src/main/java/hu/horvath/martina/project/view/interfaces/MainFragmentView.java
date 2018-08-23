package hu.horvath.martina.project.view.interfaces;


import java.util.List;

import hu.horvath.martina.project.data.model.Movie;

public interface MainFragmentView {
    void refreshMovies(List<Movie> results);

    void loadMovie(Movie movie);
}
