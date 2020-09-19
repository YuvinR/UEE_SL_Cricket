package com.example.uee_sl_cricket;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class rate_us extends AppCompatActivity {
    private  Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("test","Fuck Okk");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);

        final Button btn = findViewById(R.id.btn_submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test","Fuck Okk");
                openDialopg();
            }
        });

    }

    public void methodNotification(View view) {
        Log.d("test","Fuck Okk");
        Toast toast = Toast.makeText(getApplicationContext(),"This Is Notification",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void methodHome(View view) {
        Log.d("test","Fuck Okk");
        Toast toast = Toast.makeText(getApplicationContext(),"This Is Home",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void openDialopg(){
        ThankYou thankYou = new ThankYou();
        thankYou.show(getSupportFragmentManager(),"thank you");
    }


}