package com.example.moviestreamingapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.dataclasses.ChildRecyclerViewDataClass;
import com.example.moviestreamingapp.dataclasses.ParentRecyclerViewData;

import java.util.List;

public class ParentRecyclerViewAdapter extends RecyclerView.Adapter <ParentRecyclerViewAdapter.ParentRecyclerViewHolder>{
    Context context;
    List<ParentRecyclerViewData> parentRecyclerViewDataList;

    public ParentRecyclerViewAdapter(Context context, List<ParentRecyclerViewData> parentRecyclerViewDataList) {
        this.context = context;
        this.parentRecyclerViewDataList = parentRecyclerViewDataList;
    }

    @NonNull
    @Override
    public ParentRecyclerViewAdapter.ParentRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ParentRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.parent_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ParentRecyclerViewAdapter.ParentRecyclerViewHolder holder, int position) {
      holder.movieCategoryName.setText(parentRecyclerViewDataList.get(position).getCategoryTitle());
     setChildItemRecyclerView(holder.childRecyclerView,parentRecyclerViewDataList.get(position).getCategoryItemList());
    }

    @Override
    public int getItemCount() {
        return parentRecyclerViewDataList.size();
    }

    public class ParentRecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView movieCategoryName;
        RecyclerView childRecyclerView;
        public ParentRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            movieCategoryName=itemView.findViewById(R.id.movieCategoryName);
            childRecyclerView=itemView.findViewById(R.id.childRecyclerView);
        }
    }
    public void setChildItemRecyclerView(RecyclerView childItemRecyclerView, List<ChildRecyclerViewDataClass>childRecyclerViewDataClassList){
        ChildRecyclerViewAdapter childRecyclerViewAdapter = new ChildRecyclerViewAdapter(context,childRecyclerViewDataClassList);
        childItemRecyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        childItemRecyclerView.setAdapter(childRecyclerViewAdapter);
    }
}
