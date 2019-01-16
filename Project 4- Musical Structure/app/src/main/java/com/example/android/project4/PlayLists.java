package com.example.android.project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PlayLists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        Button home = (Button) findViewById(R.id.home4);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(PlayLists.this, MainActivity.class);
                startActivity(home);
            }
        });
        Button nowPlaying = (Button) findViewById(R.id.nowPlaying2);
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlaying = new Intent(PlayLists.this, NowPlaying.class);
                startActivity(nowPlaying);
            }
        });
    }
}
