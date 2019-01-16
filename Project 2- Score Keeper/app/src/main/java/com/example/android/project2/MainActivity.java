package com.example.android.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int team2FoulTrack = 1;
    private int team1FoulTrack = 1;
    private int team1goal = 1;
    private int team2goal = 1;
    private int reset = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void reset(View view) {
        displaygoalteam2(reset);
        displaygoalteam1(reset);
        displayFoulteam1(reset);
        display(reset);
    }

    public void foulTeam2(View view) {

        display(team2FoulTrack++);
    }

    private void display(int number) {
        TextView Team2FoulTextView = (TextView) findViewById(R.id.team2_foul_view);
        Team2FoulTextView.setText(String.valueOf(number));
    }

    public void foulTeam1(View view) {
        displayFoulteam1(team1FoulTrack++);
    }

    private void displayFoulteam1(int number) {
        TextView Team1FoulTextView = (TextView) findViewById(R.id.team1_foul_view);
        Team1FoulTextView.setText(String.valueOf(number));
    }

    public void goalTeam1(View view) {
        displaygoalteam1(team1goal++);
    }

    private void displaygoalteam1(int number) {
        TextView Team1goalTextView = (TextView) findViewById(R.id.team1_goal_view);
        Team1goalTextView.setText(String.valueOf(number));
    }

    public void goalTeam2(View view) {
        displaygoalteam2(team2goal++);
    }

    private void displaygoalteam2(int number) {
        TextView Team2goalTextView = (TextView) findViewById(R.id.team2_goal_view);
        Team2goalTextView.setText(String.valueOf(number));
    }
}
