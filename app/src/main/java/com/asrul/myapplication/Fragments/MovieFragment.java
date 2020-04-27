package com.asrul.myapplication.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asrul.myapplication.Adapters.CardMovieAdapter;
import com.asrul.myapplication.Adapters.ListMovieAdapter;
import com.asrul.myapplication.Data.DataMovie;
import com.asrul.myapplication.Data.Movie;
import com.asrul.myapplication.MoreMovieActivity;
import com.asrul.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private RecyclerView recyclerView, rvComingSoon;
    private ArrayList<Movie> list = new ArrayList<>();
    private TextView txtMore, txtPopularMore;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtMore = view.findViewById(R.id.txt_view_all);
        txtMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MoreMovieActivity.class);
                startActivity(intent);
            }
        });

        txtPopularMore = view.findViewById(R.id.txt_view_all_popular);
        txtPopularMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent more = new Intent(getContext(), MoreMovieActivity.class);
                startActivity(more);
            }
        });

        recyclerView = view.findViewById(R.id.rv_popular);
        rvComingSoon = view.findViewById(R.id.rv_coming_soon);
        list.addAll(DataMovie.getMovieList());
        showMovieList();
        showMovieCard();
    }

    private void showMovieList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(list);
        recyclerView.setAdapter(listMovieAdapter);
    }

    private void showMovieCard() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvComingSoon.setLayoutManager(layoutManager);
        CardMovieAdapter cardMovieAdapter = new CardMovieAdapter(list);
        rvComingSoon.setAdapter(cardMovieAdapter);
    }
}
