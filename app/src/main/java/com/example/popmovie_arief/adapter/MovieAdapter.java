package com.example.popmovie_arief.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.popmovie_arief.R;
import com.example.popmovie_arief.model.Result;

import java.util.List;

import retrofit2.Response;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyviewHolder> {
    private Context context;
    private Class<? extends Response> resultList;

    public MovieAdapter(Context context, Class<? extends Response> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public MovieAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_movie, parent, false);

        MovieAdapter.MyviewHolder viewHolder = new MovieAdapter.MyviewHolder(view);
        viewHolder.relativelayout.setOnClickListener(new View.OnClickListener())
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyviewHolder holder, int position) {
        holder.tvTitle.setText(resultList.get(position).getTitle());
        holder.tvDescription.setText(resultList.get(position).getOverview());
        Glide.with(context).
                load("https://image.tmdb.org/t/p/w185" +resultList.get(position).getPosterPath()).
                into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvDescription;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            imgPoster = itemView.findViewById(R.id.imgMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            RelativeLayout = itemView.findViewById(R.id.layoutMovie);
        }
    }
}
