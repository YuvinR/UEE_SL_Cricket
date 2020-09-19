package com.example.uee_sl_cricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class contact_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
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