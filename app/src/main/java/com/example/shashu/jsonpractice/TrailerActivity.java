package com.example.shashu.jsonpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class TrailerActivity extends YouTubeBaseActivity {

    YouTubePlayerView youtubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);
        Intent intent = getIntent();
        final String t_name = intent.getExtras().getString("trailer_name");
        btnPlay = findViewById(R.id.btnPlay);
        youtubePlayerView = findViewById(R.id.youtubePlay);
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (t_name.equals("Ant-Man(2015)")) {
                    youTubePlayer.loadVideo("pWdKf3MneyI");
                } else if (t_name.equals("Iron-Man")) {
                    youTubePlayer.loadVideo("8hYlB38asDY");
                } else if (t_name.equals("The Incredible Hulk")) {
                    youTubePlayer.loadVideo("xbqNb2PFKKA");
                } else if (t_name.equals("Iron-Man 2")) {
                    youTubePlayer.loadVideo("BoohRoVA9WQ");
                } else if (t_name.equals("Thor(2011)")) {
                    youTubePlayer.loadVideo("JOddp-nlNvQ");
                } else if (t_name.equals("Captain-America:The First Avenger")) {
                    youTubePlayer.loadVideo("JerVrbLldXw");
                } else if (t_name.equals("Marvel's The Avengers")) {
                    youTubePlayer.loadVideo("eOrNdBpGMv8");
                } else if (t_name.equals("Iron-Man 3")) {
                    youTubePlayer.loadVideo("YLorLVa95Xo");
                } else if (t_name.equals("Thor:The Dark World")) {
                    youTubePlayer.loadVideo("npvJ9FTgZbM");
                } else if (t_name.equals("Captain-America:Winter Soldier")) {
                    youTubePlayer.loadVideo("7SlILk2WMTI");
                } else if (t_name.equals("Guardians of the Galaxy(2014)")) {
                    youTubePlayer.loadVideo("d96cjJhvlMA");
                } else if (t_name.equals("Avengers:Age of Ultron")) {
                    youTubePlayer.loadVideo("JAUoeqvedMo");
                } else if (t_name.equals("Captain-America:Civil War")) {
                    youTubePlayer.loadVideo("dKrVegVI0Us");
                } else if (t_name.equals("Doctor-Strange")) {
                    youTubePlayer.loadVideo("HSzx-zryEgM");
                } else if (t_name.equals("Guardians of the Galaxy Vol. 2")) {
                    youTubePlayer.loadVideo("2LIQ2-PZBC8");
                } else if (t_name.equals("Spider-Man: Homecoming")) {
                    youTubePlayer.loadVideo("n9DwoQ7HWvI");
                } else if (t_name.equals("Thor:Ragnarok")) {
                    youTubePlayer.loadVideo("ue80QwXMRHg");
                } else if (t_name.equals("Black Panther")) {
                    youTubePlayer.loadVideo("xjDjIWPwcPU");
                } else if (t_name.equals("Avengers: Infinity War")) {
                    youTubePlayer.loadVideo("6ZfuNTqbHE8");
                } else {
                    Log.d("Not", "Trailer Not Found");
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtubePlayerView.initialize(YoutubeConfig.getApi_key(), mOnInitializedListener);
            }
        });
    }
}
