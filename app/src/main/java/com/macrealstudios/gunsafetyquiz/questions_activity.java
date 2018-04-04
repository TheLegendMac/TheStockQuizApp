package com.macrealstudios.gunsafetyquiz;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class questions_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_activity);

        //Declaring the question card object that was initialized below
        questionCards();

        //Setting notification bar color
        setNotificationBarcolor();

        //Declaring the done button and what will happen when it is clicked
        Button doneBtn = findViewById(R.id.doneBtn);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //When clicking this button I want it to check what was clicked for each radiogroup and then compare it to the answers to see if it was correct or not
                // I've added the answers to the string file
            }
        });
    }


    public void setNotificationBarcolor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    //Initializing and creating what happens when the user clicks the next button
    private void questionCards() {
        ArrayList<Questions> questionText = new ArrayList<Questions>();
        //Initializing the elements of the array with the question text and then the answer examples
        questionText.add(new Questions("If you buy a companies stock you...", "Own a part of that company", "Are liable for the companies debt", "Not sure"));
        questionText.add(new Questions("Which type of bond is the safest?", "Corporate bond", "Not sure bond", "U.S. Treasury bond"));
        questionText.add(new Questions("Which of the following organizations insures you against your losses in the stock market?", "NRA", "SEC", "None of the above"));
        questionText.add(new Questions("You invest $500 to buy $1,000 worth of stock on margin. The value of the stock drops by 50%. You sell it. Approximately how much of your original $500 investment are you left with in the end?", "$0", "$250", "$500"));
        questionText.add(new Questions("Which is the best definition of \"selling short\"?", "Selling shares of a stock at a loss", "Selling borrowed shares of a stock", "Selling shares of a stock before it has reached its peak"));

        //Logging statements to verbose Logcat
        Log.v("Question Activity", "Question ArrayList created with a total of " + questionText.size());

        QuestionsAdapter questionsAdapter = new QuestionsAdapter(this, questionText);


        //Using the custom array adapter, QuestionAdapter.java, to show the listview
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(questionsAdapter);

    }
}
