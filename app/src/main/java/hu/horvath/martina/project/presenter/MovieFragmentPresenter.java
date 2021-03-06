package hu.horvath.martina.project.presenter;

import javax.inject.Inject;

import hu.horvath.martina.project.data.model.Movie;
import hu.horvath.martina.project.data.model.Response;
import hu.horvath.martina.project.data.repository.remote.MainRemoteRepositoryImpl;
import hu.horvath.martina.project.view.interfaces.MainFragmentView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class MovieFragmentPresenter {

    //TODO Interface for presenter

    @Inject
    MainRemoteRepositoryImpl mainRemoteRepository;

    MainFragmentView view;

    @Inject
    public MovieFragmentPresenter(MainFragmentView view) {
        this.view = view;
    }

    public void getMovies(String query) {
        mainRemoteRepository.getMovies(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<Response>() {
                    @Override
                    public void onNext(Response response) {
                        view.refreshMovies(response.getResults());
                    }

                    @Override
                    public void onError(Throwable t) {
                        //TODO Handle error
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}