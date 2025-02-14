package com.omelenko.films.film;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.omelenko.films.App;
import com.omelenko.films.R;
import com.omelenko.films.databinding.ListViewBinding;
import com.omelenko.films.viewmodel.ListViewModel;

public class FilmPagingDataAdapter extends PagingDataAdapter<Film, FilmPagingDataAdapter.FilmViewHolder> {
    public static final int LOADING_ITEM = 0;
    public static final int FILM_ITEM = 1;
    private ListViewModel viewModel;
    public FilmPagingDataAdapter(FilmComparator diffUtilCallback, ListViewModel listViewModel)
    {
        super(diffUtilCallback);
        this.viewModel = listViewModel;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_view, parent, false);
        return new FilmPagingDataAdapter.FilmViewHolder(binding);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        //App.makeObservable();
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        return position == getItemCount() ? FILM_ITEM : LOADING_ITEM;
    }

    public class FilmViewHolder extends  RecyclerView.ViewHolder {
        ListViewBinding binding;
        public FilmViewHolder(@NonNull ListViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Film film)
        {
            binding.setFilm(film);
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }
    }
}
