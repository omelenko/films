package com.omelenko.films.dagger;

import com.omelenko.films.film.FilmPagingSource;
import com.omelenko.films.film.FilmRepository;

import dagger.Component;

@Component(dependencies = {FilmRepository.class})
public interface AppComponent {
    void injectsFilmPagingSource(FilmPagingSource filmPagingSource);
}
