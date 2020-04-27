package com.asrul.myapplication.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asrul.myapplication.Data.DataMovie;
import com.asrul.myapplication.Data.Movie;
import com.asrul.myapplication.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GridMovieAdapter extends RecyclerView.Adapter<GridMovieAdapter.GridViewHolder> {

    private ArrayList<Movie> movieList;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public GridMovieAdapter(ArrayList<Movie> list) {
        this.movieList = list;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_movie_item, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(movie.getPoster())
                .into(holder.imgPoster);
        holder.txtTitle.setText(movie.getTitle());
        holder.txtDirector.setText(movie.getDirector());
        holder.txtReleaseDate.setText(movie.getRelease_date());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(movieList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView txtTitle, txtDirector, txtReleaseDate;

        private GridViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDirector = itemView.findViewById(R.id.txt_name);
            txtReleaseDate = itemView.findViewById(R.id.txt_date);
            imgPoster = itemView.findViewById(R.id.img_poster);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Movie movie);
    }
}
