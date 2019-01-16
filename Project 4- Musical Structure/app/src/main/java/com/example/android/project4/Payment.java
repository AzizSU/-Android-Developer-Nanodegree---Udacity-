package com.example.android.project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        Button nowPlaying = (Button) findViewById(R.id.nowPlaying3);
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlaying = new Intent(Payment.this, NowPlaying.class);
                startActivity(nowPlaying);
            }
        });
        Button home3 = (Button) findViewById(R.id.home3);
        home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlaying = new Intent(Payment.this, MainActivity.class);
                startActivity(nowPlaying);
            }
        });
    }
}