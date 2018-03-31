package com.macrealstudios.gunsafetyquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class reactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction);
        ImageView reactionGif = findViewById(R.id.reactionGif);

        Glide.with(this).load("https://media.giphy.com/media/4cUCFvwICarHq/giphy.gif").into(reactionGif);
    }
}
