package com.omelenko.films.film;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.LiveData;
import androidx.paging.PagingData;
import androidx.paging.PagingSource;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import kotlinx.coroutines.flow.Flow;

public interface FilmRepository {
    List<Film> getFilms();
    Film getFilm(int position);
    int getIndexOf(Film film);
    void populateFilms();
    List<Film> getFilmsByPage(int page);
}
