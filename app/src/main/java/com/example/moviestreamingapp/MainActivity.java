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
        bannerHomeList.add(new bannerMovies(1, "Bhaag Milka Bhaag","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/bollywood%20movies%2Fbhaag%20milka%20bhaag.jpg?alt=media&token=c4cfe5f5-3562-43ba-bc99-c85a6bc43daf","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/House%20of%20the%20Dragon%20Season%202%20_%20Official%20Trailer%20_%20Max.mp4?alt=media&token=d512177a-54f4-4466-a373-747afad0f70c"));
        bannerHomeList.add(new bannerMovies(2, "Haseena Dilduba",  "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/bollywood%20movies%2Fhaseen%20dillruba.jpg?alt=media&token=4f1ae0f6-6663-4f88-ad61-845be36f89bb",    "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/House%20of%20the%20Dragon%20Season%202%20_%20Official%20Trailer%20_%20Max.mp4?alt=media&token=d512177a-54f4-4466-a373-747afad0f70c"));
        bannerHomeList.add(new bannerMovies(3, "12th Fail",        "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/bollywood%20movies%2F12thfail.jpg?alt=media&token=74eadb26-1dc9-476b-9938-3d3d344aa4fe",             "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/House%20of%20the%20Dragon%20Season%202%20_%20Official%20Trailer%20_%20Max.mp4?alt=media&token=d512177a-54f4-4466-a373-747afad0f70c"));
        bannerHomeList.add(new bannerMovies(4, "Jennifer's Body",  "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/hollywood%2Fjennifers%20body.jpg?alt=media&token=69254b11-c8a0-4e42-9a70-932488aaf2a6",              "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/House%20of%20the%20Dragon%20Season%202%20_%20Official%20Trailer%20_%20Max.mp4?alt=media&token=d512177a-54f4-4466-a373-747afad0f70c"));
       bannerHomeList.add(new bannerMovies(5,  "Dune",             "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/hollywood%2Fdune.jpg?alt=media&token=2b7a9aa8-2675-4f37-81d8-9608eb7b3565",                          "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/House%20of%20the%20Dragon%20Season%202%20_%20Official%20Trailer%20_%20Max.mp4?alt=media&token=d512177a-54f4-4466-a373-747afad0f70c"));

       bannerTvList=new ArrayList<>();
       bannerTvList.add(new bannerMovies(1, "The Boys", "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/web%20series%2FThe%20boys.jpg?alt=media&token=7ba2bf61-7048-4b46-89da-a35083a0f122",""));
       bannerTvList.add(new bannerMovies(2, "Chernobyl","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/web%20series%2Fchernobyl.jpeg?alt=media&token=a4c988ad-2082-4a02-8070-92c4ab49efd2",""));
       bannerTvList.add(new bannerMovies(3, "Dark",     "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/web%20series%2Fdark.jpg?alt=media&token=466c835d-ecca-40dc-b838-0e3671c7d4de",""));
       bannerTvList.add(new bannerMovies(4, "Paatal Lok","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/web%20series%2Fpaatal%20lok.jpg?alt=media&token=6f26f499-0576-42b4-b69c-d294e828d532",""));
       bannerTvList.add(new bannerMovies(5, "Panchayat","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/web%20series%2Fpanchayat.jpg?alt=media&token=ddb378a5-c650-4d4c-bfd6-2edf94c209c0",""));

       bannerKidsList=new ArrayList<>();
        bannerKidsList.add(new bannerMovies(1, "Ice Age",                 "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/kids%2Fice%20age.jpg?alt=media&token=286410b9-c531-4754-9c83-4fc4a3f61edd",""));
        bannerKidsList.add(new bannerMovies(2, "Death Note",              "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/kids%2Fdeathnote.jpg?alt=media&token=2755d8c0-bf6b-4f99-a793-82a0b2e1b401",""));
        bannerKidsList.add(new bannerMovies(3, "Shaun the Sheep",         "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/kids%2Fshaun%20the%20sheep.jpg?alt=media&token=bca16c4e-84a9-4e68-a79f-305fa93f6909",""));
        bannerKidsList.add(new bannerMovies(4, "Ocean Wave",              "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/kids%2Focean%20wave.jpg?alt=media&token=db4d27a1-f634-40f3-8a2e-4f88bbc46292",""));
        bannerKidsList.add(new bannerMovies(5, "Oggy and the cockroackes","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/kids%2Foggy%20and%20the%20cockroackes.jpg?alt=media&token=c0185ce4-c954-4be1-ad4f-0a674521352b",""));

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

        // Trending Movies
        List<ChildRecyclerViewDataClass>HomeCateegoryItem1 =new ArrayList<>();
        HomeCateegoryItem1.add(new ChildRecyclerViewDataClass(1,"Dealpool vs Wolverine","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Trending%20Movies%2FDeadpool%20vs%20wolverine.jpeg?alt=media&token=259ba66e-c887-4dce-927b-f7d375e70900",""));
        HomeCateegoryItem1.add(new ChildRecyclerViewDataClass(2,"Dune 2",               "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Trending%20Movies%2Fdune%202.jpg?alt=media&token=596a9975-c5b7-4ce4-b7cf-6cba874f19c4",""));
        HomeCateegoryItem1.add(new ChildRecyclerViewDataClass(3,"Laapata Ladies",       "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Trending%20Movies%2Flaapataa%20ladies.jpeg?alt=media&token=7eb0056c-2e20-4902-be53-9d1dd325be3b",""));
        HomeCateegoryItem1.add(new ChildRecyclerViewDataClass(4,"Madame Web",           "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Trending%20Movies%2Fmadame%20web.jpeg?alt=media&token=e1b5acd1-377b-4dca-b557-a6af247f1f1c",""));
        HomeCateegoryItem1.add(new ChildRecyclerViewDataClass(5,"Spiderman into the Spider Verse","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Trending%20Movies%2Fspider%20Man%20into%20the%20Spider%20Verse.jpg?alt=media&token=08a20e5e-9dcb-4a24-93dc-710a2274f754",""));

        // Movies in Hindi
        List<ChildRecyclerViewDataClass>HomeCateegoryItem2 =new ArrayList<>();
        HomeCateegoryItem2.add(new ChildRecyclerViewDataClass(1,"Article 15",        "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/movies%20%20in%20hindi%2Farticle%2015.jpg?alt=media&token=a1009686-9366-401a-881b-284947924af1",""));
        HomeCateegoryItem2.add(new ChildRecyclerViewDataClass(2,"Haseena Dilruba",   "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/movies%20%20in%20hindi%2Fhaseen%20dillruba.jpg?alt=media&token=2b6529cf-5841-4d6d-8554-30063854ae48",""));
        HomeCateegoryItem2.add(new ChildRecyclerViewDataClass(3,"Laila Majnu",       "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/movies%20%20in%20hindi%2Flaila%20majnu.jpeg?alt=media&token=7e907555-6585-4154-bf2d-62d1398f2be8",""));
        HomeCateegoryItem2.add(new ChildRecyclerViewDataClass(4,"Laapata Ladies",    "https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Trending%20Movies%2Flaapataa%20ladies.jpeg?alt=media&token=7eb0056c-2e20-4902-be53-9d1dd325be3b",""));
        HomeCateegoryItem2.add(new ChildRecyclerViewDataClass(5,"Shawshank Redemtion","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/movies%20%20in%20hindi%2Fshawshank%20redamtion.jpg?alt=media&token=811f747c-52c1-461c-b06f-1546095a8f11",""));

        //  Kids and Family Movies
        List<ChildRecyclerViewDataClass>HomeCateegoryItem3 =new ArrayList<>();
        HomeCateegoryItem3.add(new ChildRecyclerViewDataClass(1,"Maidaan","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/kids%20and%20family%20movies%2FMaidaan.jpeg?alt=media&token=9395eff1-d382-45bc-b06a-eae76fb71a33",""));
        HomeCateegoryItem3.add(new ChildRecyclerViewDataClass(2,"Shaun the sheep","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/kids%20and%20family%20movies%2Fshaun%20the%20sheep.jpg?alt=media&token=3dfacf9d-2813-4aaf-8c73-5097154fe4ae",""));
        HomeCateegoryItem3.add(new ChildRecyclerViewDataClass(3,"Aavesham","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/kids%20and%20family%20movies%2Faavesham.jpg?alt=media&token=e1d557f7-f826-49ce-8abc-55839aaee05a",""));
        HomeCateegoryItem3.add(new ChildRecyclerViewDataClass(4,"12th Fail","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/kids%20and%20family%20movies%2F12thfail.jpg?alt=media&token=22c6bd7e-2f5d-4c36-92da-d6e37c1a9e4d",""));
        HomeCateegoryItem3.add(new ChildRecyclerViewDataClass(5,"House the Dragon","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/kids%20and%20family%20movies%2Fhouse%20of%20the%20%20dragon.jpg?alt=media&token=bc6c5b47-3f86-4ec3-9aae-48b7c5c4d3dd",""));

        //Up Coming Movies list
        List<ChildRecyclerViewDataClass>HomeCateegoryItem4 =new ArrayList<>();
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(1,"Dealpool vs Wolverine","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(2,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(3,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(4,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(5,"charnobyl","https://wallpapercave.com/wp/wp4457490.jpg",""));

        allcategoryList =new ArrayList<>();
        allcategoryList.add(new ParentRecyclerViewData(1,"Trending Movies",HomeCateegoryItem1));
        allcategoryList.add(new ParentRecyclerViewData(1,"Movies in Hindi",HomeCateegoryItem2));
        allcategoryList.add(new ParentRecyclerViewData(1,"Kids and Family Movies",HomeCateegoryItem3));
        allcategoryList.add(new ParentRecyclerViewData(1,"Up Coming Movies",HomeCateegoryItem4));

        setParentRecyclerView(allcategoryList);
    }

    private void setBannerMoviePageAdapter(List<bannerMovies>  bannerMoviesList){
        bannerMovieViewPager = findViewById(R.id.view_pager);
        bannerMoviePageAdapter =new BannerMoviePageAdapter(this,bannerMoviesList);
        bannerMovieViewPager.setAdapter(bannerMoviePageAdapter);
        tab_indicator.setupWithViewPager(bannerMovieViewPager);
        Timer sliderTimer  = new Timer();
        sliderTimer.schedule(new AutoSlider(),4000,6000);
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