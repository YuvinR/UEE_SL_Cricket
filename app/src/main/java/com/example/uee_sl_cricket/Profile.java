package com.example.uee_sl_cricket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity implements  View.OnClickListener{
    private Button login, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_profile);
        login=(Button)findViewById(R.id.btn_login);
        logout=(Button)findViewById(R.id.btn_logout);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId())
        {

            case R.id.btn_login : i=new Intent(this,MainActivity2.class);startActivity(i);break;

            case R.id.btn_logout: FirebaseAuth.getInstance().signOut();
                finish();
                i=new Intent(this,MainActivity2.class);
                startActivity(i);
            default:break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Intent intent = new Intent(Profile.this,MainActivity2.class);
            startActivity(intent);
            finish();
            logout.setVisibility(View.INVISIBLE);
            login.setVisibility(View.VISIBLE);
        } else{
            logout.setVisibility(View.VISIBLE);
            login.setVisibility(View.INVISIBLE);
            // No user is signed in
        }
    }
    public void methodNotification(View view) {
        Intent intent = new Intent(this, Notification.class);
        startActivity(intent);
    }

    public void methodHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}