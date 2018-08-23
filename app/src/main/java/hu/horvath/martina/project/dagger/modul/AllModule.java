package hu.horvath.martina.project.dagger.modul;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.horvath.martina.project.data.api.MovieService;
import hu.horvath.martina.project.util.Constants;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AllModule {

    public AllModule() {

    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(Converter.Factory factory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(factory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();
    }

    @Singleton
    @Provides
    MovieService provideMainService(Retrofit retrofit) {
        return retrofit.create(MovieService.class);
    }

    @Provides
    @Singleton
    Converter.Factory provideConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

}
