package com.example.moviestreamingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.moviestreamingapp.adapter.BannerMoviePageAdapter;
import com.example.moviestreamingapp.adapter.ParentRecyclerViewAdapter;
import com.example.moviestreamingapp.dataclasses.ChildRecyclerViewDataClass;
import com.example.moviestreamingapp.dataclasses.ParentRecyclerViewData;
import com.example.moviestreamingapp.dataclasses.bannerMovies;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    BannerMoviePageAdapter bannerMoviePageAdapter;
    TabLayout tab_indicator,categoryTab;
    ViewPager bannerMovieViewPager;
    List<bannerMovies> bannerHomeList;
    List<bannerMovies> bannerTvList;
    List<bannerMovies> bannerKidsList;

    RecyclerView parentRecyclerView;
    ParentRecyclerViewAdapter parentRecyclerViewAdapter;
    List<ParentRecyclerViewData> allcategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_indicator =findViewById(R.id.tab_indicator);
        categoryTab=findViewById(R.id.categoryTab);


        bannerHomeList=new ArrayList<>();
        bannerHomeList.add(new bannerMovies(1, "test","https://wallpapercave.com/wp/wp4457490.jpg",""));
        bannerHomeList.add(new bannerMovies(2, "test","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlCLMg49aAPOv3zE-IIgF8YRGDlafWazdyPYpCk3JILhBry9R9uy3BVgh78Vu4qIddsfA&usqp=CAU",""));
        bannerHomeList.add(new bannerMovies(3, "test","https://rukminim1.flixcart.com/image/416/416/kffq2kw0-0/poster/v/d/e/medium-poster-death-note-41-death-note-anime-poster-flying-original-imafvvsfmf32gusb.jpeg?q=70",""));
        bannerHomeList.add(new bannerMovies(4, "test","https://cdn.shopify.com/s/files/1/0055/3382/7185/products/game-of-thrones-wallpaper-full-hd-1920x1080-383409.jpg?v=1579246630",""));
       bannerHomeList.add(new bannerMovies(5, "test","https://wallpapercave.com/wp/wp4457490.jpg",""));

       bannerTvList=new ArrayList<>();
       bannerTvList.add(new bannerMovies(1, "test","https://wallpapercave.com/wp/wp4457490.jpg",""));
       bannerTvList.add(new bannerMovies(2, "test","https://wallpapercave.com/wp/wp4457490.jpg",""));
       bannerTvList.add(new bannerMovies(3, "test","https://wallpapercave.com/wp/wp4457490.jpg",""));
       bannerTvList.add(new bannerMovies(4, "test","https://wallpapercave.com/wp/wp4457490.jpg",""));
       bannerTvList.add(new bannerMovies(5, "test","https://wallpapercave.com/wp/wp4457490.jpg",""));

       bannerKidsList=new ArrayList<>();
        bannerKidsList.add(new bannerMovies(1, "test","https://wallpapercave.com/wp/wp4457490.jpg",""));
        bannerKidsList.add(new bannerMovies(2, "test","https://wallpapercave.com/wp/wp4457490.jpg",""));
        bannerKidsList.add(new bannerMovies(3, "test","https://wallpapercave.com/wp/wp4457490.jpg",""));
        bannerKidsList.add(new bannerMovies(4, "test","https://wallpapercave.com/wp/wp4457490.jpg",""));
        bannerKidsList.add(new bannerMovies(5, "test","https://wallpapercave.com/wp/wp4457490.jpg",""));

        setBannerMoviePageAdapter(bannerHomeList);
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              switch (tab.getPosition()){
                  case 1:
                      setBannerMoviePageAdapter(bannerTvList);
                      return ;
                  case 2:
                      setBannerMoviePageAdapter(bannerKidsList);
                      return ;
                  default:
                      setBannerMoviePageAdapter(bannerHomeList);
              }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        List<ChildRecyclerViewDataClass>HomeCateegoryItem1 =new ArrayList<>();
        HomeCateegoryItem1.add(new ChildRecyclerViewDataClass(1,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem1.add(new ChildRecyclerViewDataClass(2,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem1.add(new ChildRecyclerViewDataClass(3,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem1.add(new ChildRecyclerViewDataClass(4,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem1.add(new ChildRecyclerViewDataClass(5,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));

        List<ChildRecyclerViewDataClass>HomeCateegoryItem2 =new ArrayList<>();
        HomeCateegoryItem2.add(new ChildRecyclerViewDataClass(1,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem2.add(new ChildRecyclerViewDataClass(2,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem2.add(new ChildRecyclerViewDataClass(3,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem2.add(new ChildRecyclerViewDataClass(4,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem2.add(new ChildRecyclerViewDataClass(5,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));

        List<ChildRecyclerViewDataClass>HomeCateegoryItem3 =new ArrayList<>();
        HomeCateegoryItem3.add(new ChildRecyclerViewDataClass(1,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem3.add(new ChildRecyclerViewDataClass(2,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem3.add(new ChildRecyclerViewDataClass(3,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem3.add(new ChildRecyclerViewDataClass(4,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem3.add(new ChildRecyclerViewDataClass(5,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));

        List<ChildRecyclerViewDataClass>HomeCateegoryItem4 =new ArrayList<>();
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(1,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(2,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(3,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(4,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(5,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        allcategoryList =new ArrayList<>();
        allcategoryList.add(new ParentRecyclerViewData(1,"Watch next TV and Movies",HomeCateegoryItem1));
        allcategoryList.add(new ParentRecyclerViewData(1,"Movies in Hindi",HomeCateegoryItem2));
        allcategoryList.add(new ParentRecyclerViewData(1,"Kids and family Movies",HomeCateegoryItem3));
        allcategoryList.add(new ParentRecyclerViewData(1,"Amazon original series",HomeCateegoryItem4));

        setParentRecyclerView(allcategoryList);
    }

    private void setBannerMoviePageAdapter(List<bannerMovies>  bannerMoviesList){
        bannerMovieViewPager = findViewById(R.id.view_pager);
        bannerMoviePageAdapter =new BannerMoviePageAdapter(this,bannerMoviesList);
        bannerMovieViewPager.setAdapter(bannerMoviePageAdapter);
        tab_indicator.setupWithViewPager(bannerMovieViewPager);
        Timer sliderTimer  = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(),4000,6000);
        tab_indicator.setupWithViewPager(bannerMovieViewPager,true);


    }

    class AutoSlider  extends TimerTask{
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(bannerMovieViewPager.getCurrentItem()<bannerHomeList.size()-1){
                        bannerMovieViewPager.setCurrentItem(bannerMovieViewPager.getCurrentItem()+1);
                    }
                    else{
                        bannerMovieViewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }

    public void setParentRecyclerView(List<ParentRecyclerViewData> allCategoryList) {
    parentRecyclerView=findViewById(R.id.parentRecyclerView);
    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
    parentRecyclerView.setLayoutManager(layoutManager);
    parentRecyclerViewAdapter = new ParentRecyclerViewAdapter(this,allCategoryList);
    parentRecyclerView.setAdapter(parentRecyclerViewAdapter);

    }
}