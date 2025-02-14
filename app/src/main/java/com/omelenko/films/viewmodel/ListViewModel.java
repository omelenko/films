package com.omelenko.films.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.omelenko.films.film.Film;
import com.omelenko.films.film.FilmPagingSource;

import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;

public class ListViewModel extends ViewModel {
    public Flowable<PagingData<Film>> filmPagingDataFlowable;

    public ListViewModel() {
        init();
    }

    public void init()
    {
        FilmPagingSource filmPagingSource = new FilmPagingSource();

        Pager<Integer, Film> pager = new Pager<>(
                new PagingConfig(20,
                        20,
                        false,
                        20 * 499),
                () -> filmPagingSource
        );

        filmPagingDataFlowable = PagingRx.getFlowable(pager);
        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        PagingRx.cachedIn(filmPagingDataFlowable, coroutineScope);
    }
}
