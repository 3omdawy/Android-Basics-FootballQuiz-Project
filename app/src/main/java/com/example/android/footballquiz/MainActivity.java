package com.example.android.footballquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz (View v){

        // Initial checks
        String name = ((EditText)findViewById(R.id.name_text_view)).getText().toString();
        if (name.trim() == "")
        {
            Toast.makeText(this, "Please enter your name above ",
                    Toast.LENGTH_LONG).show();
            return;
        }

        double score = 0;
        final int NUMBER_OF_QUESTIONS = 5;

        // Check answer for question 1
        RadioButton rb = (RadioButton)findViewById(R.id.q1_answer);
        if(rb.isChecked()){
            score++;
        }
        // Check answer for question 2
        rb = (RadioButton)findViewById(R.id.q2_answer);
        if(rb.isChecked()){
            score++;
        }
        // Check answer for question 3
        rb = (RadioButton)findViewById(R.id.q3_answer);
        if(rb.isChecked()){
            score++;
        }
        // Check answer for question 4
        rb = (RadioButton)findViewById(R.id.q4_answer);
        if(rb.isChecked()){
            score++;
        }

        // Check answer for question 5
        double scoreQ5 = 0;
        CheckBox cb = (CheckBox) findViewById(R.id.q5_answer_c1);
        if(cb.isChecked()){
            scoreQ5 += 0.5;
        }
        cb = (CheckBox) findViewById(R.id.q5_answer_c2);
        if(cb.isChecked()){
            scoreQ5 += 0.5;
        }
        cb = (CheckBox) findViewById(R.id.q5_answer_w1);
        if(cb.isChecked()){
            scoreQ5 -= 0.5;
        }
        if (scoreQ5 > 0)
            score += scoreQ5;

        // Display the score
        if (score > 0.75 * NUMBER_OF_QUESTIONS){
            Toast.makeText(this, "Good job " + name + " ! Your score is " + score + " / " +
                    NUMBER_OF_QUESTIONS, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Try again harder " + name + " ! Your score is " +
                    score + " / " + NUMBER_OF_QUESTIONS, Toast.LENGTH_LONG).show();
        }
    }
}
