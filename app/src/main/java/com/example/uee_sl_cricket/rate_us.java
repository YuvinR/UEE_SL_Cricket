package com.example.uee_sl_cricket;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class rate_us extends AppCompatActivity {
    private  Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("test","Fuck Okk");
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_rate_us);

        final Button btn = findViewById(R.id.btn_submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialopg();
            }
        });

    }

    public void methodNotification(View view) {
        Intent intent = new Intent(this, Notification.class);
        startActivity(intent);

    }

    public void methodHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void openDialopg(){
        ThankYou thankYou = new ThankYou();
        thankYou.show(getSupportFragmentManager(),"thank you");
    }


}