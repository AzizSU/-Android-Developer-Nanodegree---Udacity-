package com.example.android.project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import static com.example.android.project4.R.layout.allsongs;

public class AllSongs  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(allsongs);
        Button nowPlaying = (Button) findViewById(R.id.nowPlaying1);
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlaying = new Intent(AllSongs.this, NowPlaying.class);
                startActivity(nowPlaying);
            }
        });
        Button home = (Button) findViewById(R.id.home1);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(AllSongs.this, MainActivity.class);
                startActivity(home);
            }
        });
    }
}
