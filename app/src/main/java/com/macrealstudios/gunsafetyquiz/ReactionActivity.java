package com.macrealstudios.gunsafetyquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import static com.macrealstudios.gunsafetyquiz.R.drawable.happy_face;
import static com.macrealstudios.gunsafetyquiz.R.drawable.sad_face;

public class ReactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction);

        setNotificationBarcolor();

        setReaction();

        setButtons();
    }

    public void setNotificationBarcolor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    public void setReaction() {

        ImageView reaction_image = findViewById(R.id.reaction_image);
        TextView reaction_text = findViewById(R.id.reaction_text);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String getReactionTxt = prefs.getString("get_score_message", "hello");
        reaction_text.setText(getReactionTxt);
        boolean previouslyStarted = prefs.getBoolean("activity_excuted", false);
        if (previouslyStarted == true) {
            int id = getResources().getIdentifier(String.valueOf(happy_face), "drawable", getPackageName());
            reaction_image.setImageResource(id);
        } else {
            int id = getResources().getIdentifier(String.valueOf(sad_face), "drawable", getPackageName());
            reaction_image.setImageResource(id);
        }
    }

    public void setButtons() {

        Button new_button = findViewById(R.id.new_quiz_button);
        Button share_button = findViewById(R.id.share_button);

        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ReactionActivity.this, StartActivity.class);
                startActivity(i);
            }
        });

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use an intent to launch an email app.
                // Send the order summary in the email body.
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ReactionActivity.this);
                int getScore = prefs.getInt("get_quiz_score", 0);
                Intent intent = new Intent(Intent.ACTION_SENDTO)
                        .setData(Uri.parse("mailto:"))
                        .putExtra(Intent.EXTRA_SUBJECT, "The Stock Quiz Test Score")
                        .putExtra(Intent.EXTRA_TEXT, "I scored " + getScore + " out of 6 points on \"The Stock Quiz\"!");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
