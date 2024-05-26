package com.example.moviestreamingapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviestreamingapp.MovieDetails;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.dataclasses.ChildRecyclerViewDataClass;

import java.util.List;

public class ChildRecyclerViewAdapter extends RecyclerView.Adapter<ChildRecyclerViewAdapter.ChildRecyclerViewHolder> {

   Context context;
   List<ChildRecyclerViewDataClass> categoryItemList;

    public ChildRecyclerViewAdapter(Context context, List<ChildRecyclerViewDataClass> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public ChildRecyclerViewAdapter.ChildRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChildRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.child_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChildRecyclerViewAdapter.ChildRecyclerViewHolder holder, int position) {
        Glide.with(context).load(categoryItemList.get(position).getImageUrl()).into(holder.childItemImageView);
        holder.childItemImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MovieDetails.class);
                i.putExtra("movieId",categoryItemList.get(position).getId());
                i.putExtra("movieName",categoryItemList.get(position).getMovieName());
                i.putExtra("movieImageUrl",categoryItemList.get(position).getImageUrl());
                i.putExtra("movieFile",categoryItemList.get(position).getFileUrl());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public class ChildRecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView childItemImageView;
        public ChildRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            childItemImageView=itemView.findViewById(R.id.childItemImageView);
        }
    }
}
