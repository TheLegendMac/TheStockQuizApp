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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CaptureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        //Setting that edit text field will be above the soft keyboard no matter the screen size
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        //Setting notification bar color
        setNotificationBarColor();

        //Getting email stored in editBox
        EditText email_edit_text = findViewById(R.id.usernameEditBox);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email_edit_text.getText().toString());

        //Initializing and creating what happens when the user clicks the next button
        Button nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declaring radio buttons
                initializeRadioButton();
            }
        });

    }

    //Creating method for setting the notification bar color declaring it in the onCreate method
    public void setNotificationBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    //Creating the Are you ready radio button and then declaring it in the onCreate method
    private void initializeRadioButton() {
        //Initializing and declaring the yes and are you ready radio buttons
        RadioGroup radioGroup = findViewById(R.id.areYouReadyGroup);
        RadioButton yesRadio = findViewById(R.id.yes_radio);

        int checkedRadioId = radioGroup.getCheckedRadioButtonId();

        RadioButton checkedRadioBtn = findViewById(checkedRadioId);

        //If the yes radio button is clicked then preform this below
        if (checkedRadioBtn == yesRadio) {
            Intent i = new Intent(CaptureActivity.this, QuestionActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(CaptureActivity.this, R.string.terms_toast, Toast.LENGTH_SHORT).show();
        }
    }
}
