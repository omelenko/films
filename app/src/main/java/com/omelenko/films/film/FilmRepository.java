package com.omelenko.films.film;

import java.util.List;

public interface FilmRepository {
    List<Film> getFilms();
    Film getFilm(int position);
    int getIndexOf(Film film);
    void populateFilms();
    List<Film> getFilmsByPage(int page);
}
