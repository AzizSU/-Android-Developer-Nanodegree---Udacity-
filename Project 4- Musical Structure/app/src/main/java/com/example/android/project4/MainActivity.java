package com.example.android.project4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView play = (TextView) findViewById(R.id.playListsMaster);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(MainActivity.this, PlayLists.class);
                startActivity(playIntent);
            }
        });

        TextView songs = (TextView) findViewById(R.id.allSongs);
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allSongs = new Intent(MainActivity.this, AllSongs.class);
                startActivity(allSongs);
            }
        });

        TextView buy = (TextView) findViewById(R.id.Buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buySongs = new Intent(MainActivity.this, Payment.class);
                startActivity(buySongs);
            }
        });

        Button nowPlaying = (Button) findViewById(R.id.nowPlaying1);
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlaying = new Intent(MainActivity.this, NowPlaying.class);
                startActivity(nowPlaying);
            }
        });
    }
}
