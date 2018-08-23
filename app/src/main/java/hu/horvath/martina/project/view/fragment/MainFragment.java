package hu.horvath.martina.project.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;
import hu.horvath.martina.project.R;
import hu.horvath.martina.project.data.model.Movie;
import hu.horvath.martina.project.presenter.MainFragmentPresenter;
import hu.horvath.martina.project.view.adapter.MoviesAdapter;
import hu.horvath.martina.project.view.interfaces.MainFragmentView;

public class MainFragment extends DaggerFragment implements MainFragmentView {

    @Inject
    MainFragmentPresenter presenter;

    @BindView(R.id.searchView)
    SearchView searchView;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private Context context;
    private View view;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        context = getActivity();
        ButterKnife.bind(Objects.requireNonNull(getActivity()));

        presenter.getMovies("iron");
        presenter.getMovieById("1726");

        return view;

    }

    @Override
    public void refreshMovies(List<Movie> movies) {
        MoviesAdapter adapter = new MoviesAdapter(context, movies);

        RecyclerView rv = view.findViewById(R.id.recyclerView);

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public void loadMovie(Movie movie) {
        System.out.println(movie);
    }
}
