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
import hu.horvath.martina.project.data.model.MovieDetails;
import hu.horvath.martina.project.presenter.MovieDetailFragmentPresenter;
import hu.horvath.martina.project.view.interfaces.MovieDetailFragmentView;

public class MovieDetailFragment extends DaggerFragment implements MovieDetailFragmentView {

    public final static String ID_KEY = "id";

    @Inject
    MovieDetailFragmentPresenter presenter;

    private View view;
    private Context context;
    private TextView detailedText;
    private TextView date;
    private TextView budget;
    private TextView overView;


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

        if (getArguments() != null) {
            presenter.getMovieDetailsById(getArguments().getString(ID_KEY));
        }

        initViews();

        return view;

    }

    private void initViews() {
        detailedText = view.findViewById(R.id.detailedText);
        date = view.findViewById(R.id.date);
        budget = view.findViewById(R.id.budget);
        overView = view.findViewById(R.id.overView);

    }

    @Override
    public void loadMovie(MovieDetails movie) {
        detailedText.setText(getString(R.string.titleText) + movie.getTitle());
        date.setText(getString(R.string.dateText) +movie.getReleaseDate());
        budget.setText(getString(R.string.budgetText) +movie.getBudget());
        overView.setText(getString(R.string.overviewText) +movie.getOverview());
    }
}
