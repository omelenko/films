package com.omelenko.films.film;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;

import com.omelenko.films.App;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class FilmPagingSource extends RxPagingSource<Integer, Film> {

    @Inject
    FilmRepository repository;

    public FilmPagingSource()
    {
        App.getComponent().injectsFilmPagingSource(this);
    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NonNull PagingState<Integer, Film> pagingState) {
        return null;
    }

    @NonNull
    @Override
    public Single<LoadResult<Integer, Film>> loadSingle(@NonNull LoadParams<Integer> loadParams) {
        try
        {
            int page = loadParams.getKey() != null ? loadParams.getKey() : 1;
            List<Film> filmsToDisplay = repository.getFilmsByPage(page);

            if(filmsToDisplay != null)
            {
                return Single.create(single -> single.onSuccess(toLoadResult(filmsToDisplay, page)));
            }
            else
            {
                return Single.create(single -> {});
            }
         } catch (Exception e)
        {
            return Single.just(new LoadResult.Error<>(e));
        }
    }

    private LoadResult<Integer, Film> toLoadResult(List<Film> films, int page)
    {
        return new LoadResult.Page<>(films, page == 1 ? null : page - 1, page + 1);
    }


}
