package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;

public class StopWatch extends AppCompatActivity {
    Button button, btn_stop;
    Animation animation;
    ImageView imageview;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        imageview = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        btn_stop = findViewById(R.id.button2);
        chronometer = findViewById(R.id.ch_t);
        btn_stop.setAlpha(0);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageview.startAnimation(animation);
                btn_stop.animate().alpha(1).setDuration(1000);
                button.animate().alpha(0).setDuration(1000);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_stop.animate().alpha(0).setDuration(1000);
                button.animate().alpha(1).setDuration(1000);
                imageview.clearAnimation();
                chronometer.stop();

            }
        });
    }
}
