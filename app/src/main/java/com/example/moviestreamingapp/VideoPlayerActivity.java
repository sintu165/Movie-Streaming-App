package com.example.moviestreamingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import android.media.browse.MediaBrowser;
import android.os.Bundle;



public class VideoPlayerActivity extends AppCompatActivity {

 PlayerView playerView;
 ExoPlayer exoPlayer;



   private static final String FILE_URL="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        playerView = findViewById(R.id.exo_player);

        setUpExoPlayer(getIntent().getStringExtra("url"));



    }
    private void setUpExoPlayer(String url){
         exoPlayer = new ExoPlayer.Builder(this).build();
         playerView.setPlayer(exoPlayer);
        MediaItem mediaItem = MediaItem.fromUri(url);
        exoPlayer.setMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.setPlayWhenReady(true);
        exoPlayer.play();
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (exoPlayer != null) {
            exoPlayer.release();
            exoPlayer = null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        exoPlayer.play();
    }
}