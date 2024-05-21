package com.example.moviestreamingapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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
