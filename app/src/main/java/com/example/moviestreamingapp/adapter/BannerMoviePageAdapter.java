package com.example.moviestreamingapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.moviestreamingapp.MovieDetails;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.dataclasses.bannerMovies;

import java.util.List;

public class BannerMoviePageAdapter  extends PagerAdapter {
    Context context;
    List<bannerMovies> bannerMoviesList;

    public BannerMoviePageAdapter(Context context, List<bannerMovies> bannerMoviesList) {
        this.context = context;
        this.bannerMoviesList = bannerMoviesList;
    }

    @Override
    public int getCount() {
        return bannerMoviesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_movie_layout,null);
        ImageView bannerImage = view.findViewById(R.id.banner_imageView);
        // here use glide library to fetch image from url
        Glide.with(context).load(bannerMoviesList.get(position).getImageUrl()).into(bannerImage);
        container.addView(view);

        bannerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context, MovieDetails.class);
                i.putExtra("movieId",bannerMoviesList.get(position).getId());
                i.putExtra("movieName",bannerMoviesList.get(position).getMovieName());
                i.putExtra("movieImageUrl",bannerMoviesList.get(position).getImageUrl());
                i.putExtra("movieFile",bannerMoviesList.get(position).getFileUrl());
                context.startActivity(i);
            }
        });

        return  view;
    }
}
