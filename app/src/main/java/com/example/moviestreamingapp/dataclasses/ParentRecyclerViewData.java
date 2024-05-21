package com.example.moviestreamingapp.dataclasses;

import java.util.List;

public class ParentRecyclerViewData {
    String categoryTitle;
    Integer categoryId;

    List<ChildRecyclerViewDataClass> categoryItemList=null;

    public ParentRecyclerViewData( Integer categoryId,String categoryTitle, List<ChildRecyclerViewDataClass> categoryItemList) {
        this.categoryTitle = categoryTitle;
        this.categoryId = categoryId;
        this.categoryItemList = categoryItemList;
    }



    public void setCategoryItemList(List<ChildRecyclerViewDataClass> categoryItemList) {
        this.categoryItemList = categoryItemList;
    }

    public List<ChildRecyclerViewDataClass> getCategoryItemList() {
        return categoryItemList;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
