package com.example.uee_sl_cricket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class spalsh_screen extends AppCompatActivity {

    private static final long SPLASH_SCREEN_TIME_OUT = 2500;
    Animation topAnimation , bottomAnimation;
    ImageView img ;
    TextView h1 , h2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_spalsh_screen);

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        img = findViewById(R.id.imageView11);
        h1 = findViewById(R.id.header1);
        h2 = findViewById(R.id.header2);

        img.setAnimation(topAnimation);
        h1.setAnimation(bottomAnimation);
        h2.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(spalsh_screen.this, MainActivity2.class);
                startActivity(i);
                finish();
            };
        }, SPLASH_SCREEN_TIME_OUT);



    }
}