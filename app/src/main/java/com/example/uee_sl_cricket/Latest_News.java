package com.example.uee_sl_cricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class Latest_News extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_latest__news);
    }

    public void methodNotification(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),"This Is Notification",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void methodHome(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),"This Is Home",Toast.LENGTH_SHORT);
        toast.show();
    }
}