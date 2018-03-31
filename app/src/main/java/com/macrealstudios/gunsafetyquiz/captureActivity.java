package com.macrealstudios.gunsafetyquiz;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class captureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        //Setting notification bar color
        setNotificationBarColor();

        //Initializing next button
        Button nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Initializing radio buttons
                initializeRadioButton();
            }
        });

    }

    public void setNotificationBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    private void initializeRadioButton() {
        RadioGroup radioGroup = findViewById(R.id.areYouReadyGroup);
        RadioButton yesRadio = findViewById(R.id.yes_radio);

        int checkedRadioId = radioGroup.getCheckedRadioButtonId();

        RadioButton checkedRadioBtn = findViewById(checkedRadioId);
        if (checkedRadioBtn == yesRadio) {
            Intent i = new Intent(captureActivity.this, questions_activity.class);
            startActivity(i);
        } else {
            Toast.makeText(captureActivity.this, "You are not ready yet!", Toast.LENGTH_SHORT).show();
        }
    }
}
