package com.omelenko.films.dagger;

import com.omelenko.films.MainActivity;
import com.omelenko.films.film.FilmPagingDataAdapter;
import com.omelenko.films.film.FilmPagingSource;
import com.omelenko.films.film.FilmRepository;
import com.omelenko.films.viewmodel.ListViewModel;

import dagger.Component;

@Component(dependencies = {FilmRepository.class})
public interface AppComponent {
    void injectsMainActivity(MainActivity mainActivity);
    void injectsFilmPagingSource(FilmPagingSource filmPagingSource);
}
