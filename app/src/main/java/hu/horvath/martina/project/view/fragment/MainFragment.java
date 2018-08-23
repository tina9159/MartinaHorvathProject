package hu.horvath.martina.project.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import hu.horvath.martina.project.R;
import hu.horvath.martina.project.data.model.Movie;
import hu.horvath.martina.project.presenter.MainFragmentPresenter;
import hu.horvath.martina.project.view.interfaces.MainFragmentView;

public class MainFragment extends DaggerFragment implements MainFragmentView {

    @Inject
    MainFragmentPresenter presenter;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        presenter.getMovies("iron");
        presenter.getMovieById("1726");

        return view;


    }

    @Override
    public void refreshMovies(List<Movie> results) {
        System.out.println(results);
    }

    @Override
    public void loadMovie(Movie movie) {
        System.out.println(movie);
    }
}
