package com.omelenko.films.film;

import androidx.paging.LoadStateAdapter;
import androidx.paging.PagingSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;

public class FilmRepositoryImpl implements FilmRepository {
    List<Film> films;

    public FilmRepositoryImpl() {
        populateFilms();
    }

    @Override
    public List<Film> getFilms() {
        return films;
    }

    @Override
    public Film getFilm(int position) {
        return films.get(position);
    }

    @Override
    public int getIndexOf(Film film) {
        return films.indexOf(film);
    }

    public void populateFilms() {
        films = new ArrayList<>();
        films.add(new Film(0, "Inception", "Christopher Nolan", "Sci-Fi", 2010, 8.8));
        films.add(new Film(1, "The Dark Knight", "Christopher Nolan", "Action", 2008, 9.0));
        films.add(new Film(2, "The Shawshank Redemption", "Frank Darabont", "Drama", 1994, 9.3));
        films.add(new Film(3, "The Godfather", "Francis Ford Coppola", "Crime", 1972, 9.2));
        films.add(new Film(4, "Pulp Fiction", "Quentin Tarantino", "Crime", 1994, 8.9));
        films.add(new Film(5, "The Matrix", "The Wachowskis", "Sci-Fi", 1999, 8.7));
        films.add(new Film(6, "Fight Club", "David Fincher", "Drama", 1999, 8.8));
        films.add(new Film(7, "Forrest Gump", "Robert Zemeckis", "Drama", 1994, 8.8));
        films.add(new Film(8, "The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", "Fantasy", 2001, 8.8));
        films.add(new Film(9, "The Avengers", "Joss Whedon", "Action", 2012, 8.0));
        films.add(new Film(10, "Gladiator", "Ridley Scott", "Action", 2000, 8.5));
        films.add(new Film(11, "The Lion King", "Roger Allers, Rob Minkoff", "Animation", 1994, 8.5));
        films.add(new Film(12, "The Social Network", "David Fincher", "Biography", 2010, 8.0));
        films.add(new Film(13, "Parasite", "Bong Joon-ho", "Thriller", 2019, 8.6));
        films.add(new Film(14, "Interstellar", "Christopher Nolan", "Sci-Fi", 2014, 8.6));
        films.add(new Film(15, "Titanic", "James Cameron", "Romance", 1997, 7.8));
        films.add(new Film(16, "The Prestige", "Christopher Nolan", "Mystery", 2006, 8.5));
        films.add(new Film(17, "Whiplash", "Damien Chazelle", "Drama", 2014, 8.5));
        films.add(new Film(18, "Star Wars: Episode IV - A New Hope", "George Lucas", "Sci-Fi", 1977, 8.6));
        films.add(new Film(19, "Schindler's List", "Steven Spielberg", "Biography", 1993, 9.0));
    }

    @Override
    public List<Film> getFilmsByPage(int page) {
        int fromIndex = 0;
        int toIndex = 4;
        if (page > 1) {
            for (int i = 1; i < page; i++) {
                fromIndex += 4;
                toIndex += 4;
            }
        }
        if(toIndex <= films.size())
        {
            return films.subList(fromIndex, toIndex);
        }
        else
        {
            return null;
        }
    }
}
