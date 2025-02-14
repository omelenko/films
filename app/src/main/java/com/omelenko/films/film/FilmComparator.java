package com.omelenko.films.film;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class FilmComparator extends DiffUtil.ItemCallback<Film> {

    @Override
    public boolean areItemsTheSame(@NonNull Film oldItem, @NonNull Film newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Film oldItem, @NonNull Film newItem) {
        return oldItem.equals(newItem);
    }
}
