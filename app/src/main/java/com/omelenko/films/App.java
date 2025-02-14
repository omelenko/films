package com.omelenko.films;

import android.app.Application;

import com.omelenko.films.dagger.AppComponent;
import com.omelenko.films.dagger.DaggerAppComponent;
import com.omelenko.films.film.FilmComparator;
import com.omelenko.films.film.FilmPagingDataAdapter;
import com.omelenko.films.film.FilmRepository;
import com.omelenko.films.film.FilmRepositoryImpl;
import com.omelenko.films.viewmodel.ListViewModel;

public class App extends Application {
    private static AppComponent component;
    static FilmRepository filmRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        filmRepository = new FilmRepositoryImpl();

        component = DaggerAppComponent.builder().
                    filmRepository(filmRepository).
                    build();
    }

    public static AppComponent getComponent()
    {
        return component;
    }
}
