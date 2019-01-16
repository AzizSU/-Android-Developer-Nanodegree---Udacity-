package com.example.android.project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nowplaying);
        Button allSongs = (Button) findViewById(R.id.allsongs3);
        allSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allSongs = new Intent(NowPlaying.this, AllSongs.class);
                startActivity(allSongs);
            }
        });
        Button home = (Button) findViewById(R.id.home2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(NowPlaying.this, MainActivity.class);
                startActivity(home);
            }
        });
    }
}
