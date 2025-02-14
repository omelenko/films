package com.omelenko.films.film;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.LoadState;
import androidx.paging.LoadStateAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.omelenko.films.R;
import com.omelenko.films.databinding.LoadStateItemBinding;

public class FilmLoadStateAdapter extends LoadStateAdapter<FilmLoadStateAdapter.LoadStateViewHolder> {
    private View.OnClickListener retryCallback;

    public FilmLoadStateAdapter(View.OnClickListener retryCallback)
    {
        this.retryCallback = retryCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmLoadStateAdapter.LoadStateViewHolder holder, @NonNull LoadState loadState) {
        holder.bind(loadState);
    }

    @NonNull
    @Override
    public FilmLoadStateAdapter.LoadStateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, @NonNull LoadState loadState) {
        return new LoadStateViewHolder(viewGroup, retryCallback);
    }

    public static class LoadStateViewHolder extends RecyclerView.ViewHolder
    {
        private ProgressBar progressBar;
        private TextView errorMsg;
        private Button retry;

        LoadStateViewHolder(@NonNull ViewGroup parent, @NonNull View.OnClickListener retryCallback) {
            super(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.load_state_item, parent, false));
            LoadStateItemBinding binding = LoadStateItemBinding.bind(itemView);
            progressBar = binding.progressBar;
            errorMsg = binding.errorMsg;
            retry = binding.retryButton;
            retry.setOnClickListener(retryCallback);
        }



        public void bind(LoadState loadState) {

            if (loadState instanceof LoadState.Error) {

                LoadState.Error loadStateError = (LoadState.Error) loadState;

                errorMsg.setText(loadStateError.getError().getLocalizedMessage());
            }

            progressBar.setVisibility(loadState instanceof LoadState.Loading
                    ? View.VISIBLE : View.GONE);
            retry.setVisibility(loadState instanceof LoadState.Error
                    ? View.VISIBLE : View.GONE);
            errorMsg.setVisibility(loadState instanceof LoadState.Error
                    ? View.VISIBLE : View.GONE);
        }
    }
}
