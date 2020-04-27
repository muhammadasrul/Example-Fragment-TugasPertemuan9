package com.asrul.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.asrul.myapplication.Adapters.GridMovieAdapter;
import com.asrul.myapplication.Data.DataMovie;
import com.asrul.myapplication.Data.Movie;

import java.util.ArrayList;

public class MoreMovieActivity extends AppCompatActivity {

    RecyclerView rvMore;
    ArrayList<Movie> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_movie);

        rvMore = findViewById(R.id.rv_more);
        list.addAll(DataMovie.getMovieList());
        showGridView();
    }

    private void showGridView() {
        rvMore.setLayoutManager(new GridLayoutManager(getApplicationContext() ,2));
        GridMovieAdapter gridMovieAdapter = new GridMovieAdapter(list);
        rvMore.setAdapter(gridMovieAdapter);
    }
}
