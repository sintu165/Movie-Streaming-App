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

        //Romantic Movies
        List<ChildRecyclerViewDataClass>HomeCateegoryItem4 =new ArrayList<>();
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(1,"The Proposal","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/romantic%20movies%2Fthe%20proposal.jpg?alt=media&token=769bf811-62e0-4d26-894a-ad3ed5cdbe3d",""));
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(2,"La La Land","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/romantic%20movies%2Fla-la-land.jpg?alt=media&token=d9ca0412-1502-4a5f-9cef-ce3d9beb7d80",""));
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(3,"Meet Joe Black","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/romantic%20movies%2FMeet%20joe%20Black.jpg?alt=media&token=9fc8eb0b-e3e6-4229-84b0-202132c4891e",""));
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(4,"The NoteBook","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/romantic%20movies%2FThe%20NoteBook.jpg?alt=media&token=b219e901-e79e-4f4e-9d06-071a5e1d254e",""));
        HomeCateegoryItem4.add(new ChildRecyclerViewDataClass(5,"Titanic","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/romantic%20movies%2Ftitanic.jpg?alt=media&token=46d01707-f993-45ce-8b4e-02432cafd15f",""));

        //Action and Thriller
        List<ChildRecyclerViewDataClass>HomeCateegoryItem5 =new ArrayList<>();
        HomeCateegoryItem5.add(new ChildRecyclerViewDataClass(1,"Mad Max:Fury Road","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Action%20and%20Thriller%20Movies%2FMad%20Max%20Fury%20Road.jpg?alt=media&token=f2917557-c347-4dfd-8540-148cc1687973",""));
        HomeCateegoryItem5.add(new ChildRecyclerViewDataClass(2,"No Time To Die","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Action%20and%20Thriller%20Movies%2FNo%20time%20to%20die.jpeg?alt=media&token=1c83142c-e740-49cc-b7fa-40c0462dcaea",""));
        HomeCateegoryItem5.add(new ChildRecyclerViewDataClass(3,"American Sniper","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Action%20and%20Thriller%20Movies%2Famerican%20sniper.jpg?alt=media&token=f66ed644-5ec0-4aaf-bcad-fed328390410",""));
        HomeCateegoryItem5.add(new ChildRecyclerViewDataClass(4,"Inception","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Action%20and%20Thriller%20Movies%2Finception.jpg?alt=media&token=7ce209b9-a606-48c9-9595-6bd4f2ab6f16",""));
        HomeCateegoryItem5.add(new ChildRecyclerViewDataClass(5,"John Wick 4","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Action%20and%20Thriller%20Movies%2Fjohn%20wick%204.jpeg?alt=media&token=0e7e54eb-1801-4b0e-ba1a-708e58eb31fe",""));

        //Top-rated IMDb movies
        List<ChildRecyclerViewDataClass>HomeCateegoryItem6 =new ArrayList<>();
        HomeCateegoryItem6.add(new ChildRecyclerViewDataClass(1,"The Godfather","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Top-rated%20IMDb%2FThe%20godfather.jpg?alt=media&token=0eb53ca2-e2dc-4672-ae32-72d7577ec281",""));
        HomeCateegoryItem6.add(new ChildRecyclerViewDataClass(2,"The Load of the ring:The return of the King","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Top-rated%20IMDb%2FThe%20load%20of%20the%20ring%20the%20return%20of%20the%20king.jpg?alt=media&token=2c22643f-0fff-4639-ac74-86c491b7a62c",""));
        HomeCateegoryItem6.add(new ChildRecyclerViewDataClass(3,"Forrest-Gump","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Top-rated%20IMDb%2Fforrest-gump.jpg?alt=media&token=6a074fa7-44d2-4132-804c-3a46dd6f7e85",""));
        HomeCateegoryItem6.add(new ChildRecyclerViewDataClass(4,"Goodfellas","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Top-rated%20IMDb%2Fgoodfellas.jpg?alt=media&token=da16502a-f4d3-4967-825a-80b413b300c7",""));
        HomeCateegoryItem6.add(new ChildRecyclerViewDataClass(5,"Matrix","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Top-rated%20IMDb%2Fmatrix.jpg?alt=media&token=c27af84a-2acd-456b-87cc-163cb555c670",""));

        //Documentries movies
        List<ChildRecyclerViewDataClass>HomeCateegoryItem7 =new ArrayList<>();
        HomeCateegoryItem7.add(new ChildRecyclerViewDataClass(1,"Schindler's  list","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Documentry%20%20movies%2Fschindler's%20list.jpeg?alt=media&token=4e0bae84-8463-48ef-bc75-5a59595539ce",""));
        HomeCateegoryItem7.add(new ChildRecyclerViewDataClass(2,"Pearl harbor","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Documentry%20%20movies%2Fpearl%20harbor.jpg?alt=media&token=aa4647a5-7d69-4c8d-8d35-4dc847c03ba8",""));
        HomeCateegoryItem7.add(new ChildRecyclerViewDataClass(3,"Gravity","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Documentry%20%20movies%2Fgravity.jpg?alt=media&token=279f707b-ba1b-49db-8b79-ec0757593212",""));
        HomeCateegoryItem7.add(new ChildRecyclerViewDataClass(4,"Senna","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Documentry%20%20movies%2FSenna.jpg?alt=media&token=05a751ae-4764-4d18-b62d-c8c419227d71",""));
        HomeCateegoryItem7.add(new ChildRecyclerViewDataClass(5,"Borat","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Documentry%20%20movies%2FBorat.jpg?alt=media&token=a73af302-6553-4323-bc85-9be2a27b2d56",""));

        //Up Coming Movies
        List<ChildRecyclerViewDataClass>HomeCateegoryItem8 =new ArrayList<>();
        HomeCateegoryItem8.add(new ChildRecyclerViewDataClass(1,"Civil War","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Up%20%20Coming%20Movies%2FCivil%20War.jpg?alt=media&token=a5452176-5c64-455a-bf8f-5b4b4a05fabb",""));
        HomeCateegoryItem8.add(new ChildRecyclerViewDataClass(2,"Kalki 2898-AD","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Up%20%20Coming%20Movies%2FKalki%202898.jpg?alt=media&token=4e371016-597d-4461-95cc-c618bd62e0f0",""));
        HomeCateegoryItem8.add(new ChildRecyclerViewDataClass(3,"Kingdom of the planet of the Apes","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Up%20%20Coming%20Movies%2FKingdom%20of%20the%20planet%20of%20%20the%20apes.jpeg?alt=media&token=49e4562b-c963-4d09-9b65-79e261668158",""));
        HomeCateegoryItem8.add(new ChildRecyclerViewDataClass(4,"The idea of you","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Up%20%20Coming%20Movies%2FThe%20idea%20of%20the%20you.jpg?alt=media&token=3a877f24-a24a-4227-9e97-71a097a17f61",""));
        HomeCateegoryItem8.add(new ChildRecyclerViewDataClass(5,"Kung Fu Panda 4","https://firebasestorage.googleapis.com/v0/b/fir-project-de05e.appspot.com/o/Up%20%20Coming%20Movies%2Fkung%20fu%20panda.jpg?alt=media&token=e9215b80-f2c0-44ec-9014-9e6a3594afa7",""));


        allcategoryList =new ArrayList<>();
        allcategoryList.add(new ParentRecyclerViewData(1,"Trending Movies",HomeCateegoryItem1));
        allcategoryList.add(new ParentRecyclerViewData(2,"Movies in Hindi",HomeCateegoryItem2));
        allcategoryList.add(new ParentRecyclerViewData(3,"Kids and Family Movies",HomeCateegoryItem3));
        allcategoryList.add(new ParentRecyclerViewData(4,"Romantic Movies",HomeCateegoryItem4));
        allcategoryList.add(new ParentRecyclerViewData(5,"Action and Thriller",HomeCateegoryItem5));
        allcategoryList.add(new ParentRecyclerViewData(6,"Top-rated IMDb movies",HomeCateegoryItem6));
        allcategoryList.add(new ParentRecyclerViewData(7,"Documentries",HomeCateegoryItem7));
        allcategoryList.add(new ParentRecyclerViewData(8,"Up Coming Movies",HomeCateegoryItem8));
         


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