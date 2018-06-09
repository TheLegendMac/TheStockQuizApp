package com.macrealstudios.gunsafetyquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;



public class QuestionActivity extends AppCompatActivity {


    private static final Object DEFAULT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_activity);

        //Declaring the question card object that was initialized below

        //Setting notification bar color
        setNotificationBarcolor();

        //Declaring the done button and what will happen when it is clicked
        Button submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });
    }


    public void setNotificationBarcolor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }


    public int quizScore = 0;

    /**
     *When the user taps on the "Submit" button it will check the answers and based on the score will show either a happy or sad emoji.
     */

    public void checkAnswers() {
        if (getQuestion1()) {
            quizScore += 1;
        }
        if (getQuestion2()) {
            quizScore += 1;
        }
        if (getQuestion3()) {
            quizScore += 1;
        }
        if (getQuestion4()) {
            quizScore += 1;
        }
        if (getQuestion5()) {
            quizScore += 1;
        }
        if (getQuestion6()) {
            quizScore += 1;
        }
        // Will show this toast message if the user incorrectly answered all of the questions
        if (quizScore == 0) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(QuestionActivity.this);
            String capture_username_editbox = sharedPreferences.getString("username", "hello");
            Toast.makeText(this, getString(R.string.try_again_toast, capture_username_editbox), Toast.LENGTH_LONG).show();

            // Score Toast displays total quiz score when check answers is pressed
        } else {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            if (quizScore == 6) {
                editor.putBoolean("activity_excuted", true);
                editor.apply();

            } else {
                editor.putBoolean("activity_excuted", false);
                editor.apply();
            }

            editor.putString("get_score_message", getString(R.string.reaction_text,quizScore));
            editor.putInt("get_quiz_score", quizScore);
            editor.apply();
            Intent i = new Intent(this, ReactionActivity.class);
            startActivity(i);
            Toast.makeText(this,getString(R.string.quiz_score_toast, quizScore), Toast.LENGTH_LONG).show();
            quizScore = 0;
        }
    }



    public Boolean getQuestion1() {
        RadioButton questionOne = findViewById(R.id.rbOne);
        return questionOne.isChecked();
    }

    public Boolean getQuestion2() {
        RadioButton questionTwo = findViewById(R.id.rgTwoRbThree);
        return questionTwo.isChecked();
    }

    public Boolean getQuestion3() {
        RadioButton questionThree = findViewById(R.id.rgThreeRbThree);
        return questionThree.isChecked();
    }

    public Boolean getQuestion4() {
        RadioButton questionFour = findViewById(R.id.rgFourRbOne);
        return questionFour.isChecked();
    }

    public Boolean getQuestion5() {
        RadioButton questionFive = findViewById(R.id.rgFiveRbTwo);
        return questionFive.isChecked();
    }

    /**
     * Checks answers for question 6, compares to set of correct answers
     *
     * @return boolean true for all 3 correct answers and no incorrect answers.
     */

    public Boolean getQuestion6() {
        Set<Integer> answerQuestion6 = new HashSet<>();
        answerQuestion6.add(R.id.chk_one);
        answerQuestion6.add(R.id.chk_two);
        answerQuestion6.add(R.id.chk_four);
        Set<Integer> submittedAnswersQuestion6 = new HashSet<>();

        CheckBox questionOne = findViewById(R.id.chk_one);
        if (questionOne.isChecked()) {
            submittedAnswersQuestion6.add(R.id.chk_one);
        }

        CheckBox questionTwo = findViewById(R.id.chk_two);
        if (questionTwo.isChecked()) {
            submittedAnswersQuestion6.add(R.id.chk_two);
        }

        CheckBox questionThree = findViewById(R.id.chk_three);
        if (questionThree.isChecked()) {
            submittedAnswersQuestion6.add(R.id.chk_three);
        }

        CheckBox questionFive = findViewById(R.id.chk_four);
        if (questionFive.isChecked()) {
            submittedAnswersQuestion6.add(R.id.chk_four);
        }
        return submittedAnswersQuestion6.equals(answerQuestion6);
    }
}
