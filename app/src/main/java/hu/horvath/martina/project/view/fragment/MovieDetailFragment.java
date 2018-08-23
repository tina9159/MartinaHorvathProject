package hu.horvath.martina.project.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import hu.horvath.martina.project.R;
import hu.horvath.martina.project.data.model.Movie;
import hu.horvath.martina.project.presenter.MovieDetailFragmentPresenter;
import hu.horvath.martina.project.view.interfaces.MovieDetailFragmentView;

public class MovieDetailFragment extends DaggerFragment implements MovieDetailFragmentView {

    @Inject
    MovieDetailFragmentPresenter presenter;

    private View view;
    private Context context;
    private TextView detailedText;

    public static MovieDetailFragment newInstance() {
        Bundle args = new Bundle();
        MovieDetailFragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        context = getActivity();

        presenter.getMovieById("1726");

        initViews();

        return view;

    }

    private void initViews() {
        detailedText = view.findViewById(R.id.detailedText);
    }

    @Override
    public void loadMovie(Movie movie) {
        detailedText.setText(movie.getTitle());
    }
}
