package hu.horvath.martina.project.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import hu.horvath.martina.project.R;
import hu.horvath.martina.project.data.model.Movie;
import hu.horvath.martina.project.view.EmptyViewHolder;
import hu.horvath.martina.project.view.MovieListViewHolder;

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final List<Movie> movies;

    private static final int VIEW_TYPE_EMPTY = 0;
    private static final int VIEW_TYPE_NAME = 1;

    public MoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case VIEW_TYPE_EMPTY:
                view = LayoutInflater.from(context).inflate(R.layout.listitem_empty, parent, false);
                viewHolder = new EmptyViewHolder(view);
                break;
            case VIEW_TYPE_NAME:
                view = LayoutInflater.from(context).inflate(R.layout.listitem_movie, parent, false);
                viewHolder = new MovieListViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return movies.isEmpty() ? VIEW_TYPE_EMPTY : VIEW_TYPE_NAME;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MovieListViewHolder) {
            Movie currentMovie = movies.get(position);

            MovieListViewHolder movieListViewHolder = ((MovieListViewHolder) holder);

            movieListViewHolder.title.setText(currentMovie.getTitle());
            Glide.with(context).load("http://image.tmdb.org/t/p/w92/" + currentMovie.getPoster()).into(movieListViewHolder.image);
        }
    }

    @Override
    public int getItemCount() {
        return movies.isEmpty() ? 1 : movies.size();
    }


}
