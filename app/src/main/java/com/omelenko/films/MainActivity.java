package com.omelenko.films;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.omelenko.films.film.FilmComparator;
import com.omelenko.films.film.FilmPagingDataAdapter;
import com.omelenko.films.viewmodel.ListViewModel;

public class MainActivity extends AppCompatActivity {

    static ListViewModel viewModel;
    static FilmPagingDataAdapter adapter;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        viewModel = new ListViewModel();

        FilmComparator diffUtilCallback = new FilmComparator();

        adapter = new FilmPagingDataAdapter(diffUtilCallback, viewModel);

        viewModel.filmPagingDataFlowable.subscribe(filmPagingData -> adapter.submitData(getLifecycle(), filmPagingData));

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
    }
}