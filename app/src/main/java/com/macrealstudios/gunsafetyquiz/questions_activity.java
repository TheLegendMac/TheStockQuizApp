package com.macrealstudios.gunsafetyquiz;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;


public class questions_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_activity);

        //Calling the question card objects
        questionCards();
        setNotificationBarcolor();


    }

    public void setNotificationBarcolor(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    private void questionCards() {


        ArrayList<Questions> questionText = new ArrayList<Questions>();
        //Initializing the elements of the array
        questionText.add(new Questions("One","If you buy a companies stock you...","Own a part of that company","Are liable for the companies debt", "Not sure"));
        questionText.add(new Questions("Two","Which type of bond is the safest?","Corporate bond","Not sure bond", "U.S. Treasury bond"));
        questionText.add(new Questions("Three","Which of the following organizations insures you against your losses in the stock market?","NRA","SEC", "None of the above"));
        questionText.add(new Questions("Four","You invest $500 to buy $1,000 worth of stock on margin. The value of the stock drops by 50%. You sell it. Approximately how much of your original $500 investment are you left with in the end?","$0","$250", "$500"));
        questionText.add(new Questions("Five","Which is the best definition of \"selling short\"?","Selling shares of a stock at a loss","Selling borrowed shares of a stock", "Selling shares of a stock before it has reached its peak"));

        //Logging statements to verbose Logcat
        Log.v("Numbers Activity", "ArrayList created with a total of " + questionText.size());

        QuestionsAdapter adapter = new QuestionsAdapter(this,questionText);


        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
