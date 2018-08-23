package hu.horvath.martina.project.presenter;

import javax.inject.Inject;

import hu.horvath.martina.project.data.model.Movie;
import hu.horvath.martina.project.data.repository.remote.MainRemoteRepositoryImpl;
import hu.horvath.martina.project.view.fragment.MovieDetailFragment;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class MovieDetailFragmentPresenter {

    @Inject
    MainRemoteRepositoryImpl mainRemoteRepository;

    MovieDetailFragment view;

    @Inject
    public MovieDetailFragmentPresenter(MovieDetailFragment view) {
        this.view = view;
    }

    public void getMovieById(String id) {
        mainRemoteRepository.getMovieById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<Movie>() {
                    @Override
                    public void onNext(Movie movie) {
                        view.loadMovie(movie);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
