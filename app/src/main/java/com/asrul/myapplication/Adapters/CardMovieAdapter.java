package com.asrul.myapplication.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asrul.myapplication.Data.Movie;
import com.asrul.myapplication.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardMovieAdapter extends RecyclerView.Adapter<CardMovieAdapter.CardViewHolder> {

    private ArrayList<Movie> movieList;

    public CardMovieAdapter(ArrayList<Movie> list) {
        this.movieList = list;
    }

    @NonNull
    @Override
    public CardMovieAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_movie_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardMovieAdapter.CardViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(movieList.get(position).getPoster())
                .into(holder.imgPoster);
        holder.txtTitle.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        ImageView imgPoster;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            imgPoster = itemView.findViewById(R.id.img_poster);
        }
    }
}
