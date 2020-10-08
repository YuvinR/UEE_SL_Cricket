package com.example.uee_sl_cricket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private Button login,logout,search,profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.btn_login);
        logout=(Button)findViewById(R.id.btn_logout);
        search = (Button)findViewById(R.id.button10);
        profile = (Button)findViewById(R.id.button);
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
            case R.id.button10 :  i=new Intent(this,SearchAct.class);startActivity(i);break;

            default:break;
        }

    }


    public void methodNotification(View view) {
        Intent intent = new Intent(this, Notification.class);
        startActivity(intent);
    }

//    public void login(View view) {
//        Intent intent = new Intent(this, MainActivity2.class);
//        startActivity(intent);
//    }

    public void methodHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void profilePage(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
    public void latestNewsPage(View view) {
        Intent intent = new Intent(this, Latest_News.class);
        startActivity(intent);
    }
    public void pastMatchesPage(View view) {
        Intent intent = new Intent(this, match_history.class);
        startActivity(intent);
    }
    public void upComingMatchesPage(View view) {
        Intent intent = new Intent(this, Upcoming_Matches.class);
        startActivity(intent);
    }
    public void teamsPage(View view) {
        Intent intent = new Intent(this, teams.class);
        startActivity(intent);
    }

    public void boardPages(View view) {
        Intent intent = new Intent(this, Cricket_Board.class);
        startActivity(intent);
    }

    public void searchPage(View view) {
        /*Intent intent = new Intent();
        startActivity(intent);*/
    }

    public void galleryPage(View view) {
        Intent intent = new Intent(this, gallery.class);
        startActivity(intent);
    }

    public void rateUsPage(View view) {
        Intent intent = new Intent(this, rate_us.class);
        startActivity(intent);
    }

    public void contactUsPage(View view) {
        Intent intent = new Intent(this, contact_us.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
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


}