package com.macrealstudios.gunsafetyquiz;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting notification bar color
        setNotificationBarcolor();

        //Calling method when user clicks the "Lets begin" button
        nextClick();

    }


    //Setting the notification bar color
    public void setNotificationBarcolor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
    //When tapping the next button the app goes to the Capture Activity
    public void nextClick() {
        Button helloBtn = findViewById(R.id.helloBtn);

        helloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StartActivity.this, CaptureActivity.class);
                startActivity(i);
            }
        });
    }
}
