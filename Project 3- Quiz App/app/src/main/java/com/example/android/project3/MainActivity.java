package com.example.android.project3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import static com.example.android.project3.R.id.eight;
import static com.example.android.project3.R.id.immutable;
import static com.example.android.project3.R.id.seven;

public class MainActivity extends AppCompatActivity {

    private int scoreCount;
    private String toastText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case eight:
                if (checked)
                    scoreCount++;
                    break;
            case seven:
                if (checked)
                    break;
        }
    }

    public void q2answered(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case immutable:
                if (checked)
                    scoreCount++;
                break;
            case R.id.data_type:
                if (checked)
                    break;
        }
    }

    public void onCheckboxClicked(View view) {
        CheckBox intData =  (CheckBox) findViewById(R.id.int_data);
        CheckBox doubleData =  (CheckBox) findViewById(R.id.double_data);
        CheckBox stringD =  (CheckBox) findViewById(R.id.String);
        if(doubleData.isChecked()&& intData.isChecked() && !stringD.isChecked())
                     this.scoreCount++;
    }

    public void q4Answerd(View v) {
        EditText q4A = (EditText) findViewById(R.id.ans_q4);
        String answer = q4A.getText().toString().toLowerCase();
             if(answer.equals("inheritance"))
                 scoreCount++;
    }

    public void q5Answerd(View v) {
        EditText q5A = (EditText) findViewById(R.id.ans_q5);
        String answer = q5A.getText().toString().toLowerCase();
        if(answer.equals("encapsulation"))
            scoreCount++;
    }

    public void q6Answerd(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.no:
                if (checked)
                    scoreCount++;
                break;
            case R.id.yes:
                if (checked)
                    break;
        }
    }

    private void displayScore(int number) {
        if (number >=4) {
            toastText= String.valueOf(number)+" out of 6. Good job!";
        }
        else {
            toastText = String.valueOf(number)+" out of 6. Try again : ) ";
        }
        Toast toast = Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT);
        toast.show();
    }

    private void resetAndCalculate() {
        RadioButton eight= (RadioButton) findViewById(R.id.eight);
        RadioButton seven= (RadioButton) findViewById(R.id.seven);
        onRadioButtonClicked(eight);
        onRadioButtonClicked(seven);
        eight.setChecked(false);
        seven.setChecked(false);
        RadioButton data= (RadioButton) findViewById(R.id.data_type);
        RadioButton immutable= (RadioButton) findViewById(R.id.immutable);
        q2answered(data);
        q2answered(immutable);
        data.setChecked(false);
        immutable.setChecked(false);
        CheckBox intData =  (CheckBox) findViewById(R.id.int_data);
        CheckBox doubleData =  (CheckBox) findViewById(R.id.double_data);
        CheckBox stringD =  (CheckBox) findViewById(R.id.String);
        onCheckboxClicked(intData);
        intData.setChecked(false);
        doubleData.setChecked(false);
        stringD.setChecked(false);
        EditText qFour = (EditText) findViewById(R.id.ans_q4);
        EditText qFive = (EditText) findViewById(R.id.ans_q5);
        q4Answerd(qFour);
        q5Answerd(qFive);
        qFour.setText("");
        qFive.setText("");
        RadioButton yes= (RadioButton) findViewById(R.id.yes);
        RadioButton no= (RadioButton) findViewById(R.id.no);
        q6Answerd(yes);
        q6Answerd(no);
        yes.setChecked(false);
        no.setChecked(false);
    }

    public void showScore(View view) {
        resetAndCalculate();
        displayScore(scoreCount);
        scoreCount=0;
    }
}
