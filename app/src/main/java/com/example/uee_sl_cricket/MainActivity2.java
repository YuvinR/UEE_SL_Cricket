package com.example.uee_sl_cricket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {

    private EditText logingEmail;
    private EditText logingPass;
    private TextView signup;
    private Button logingbtn, crtBtn, logout;
    private ProgressBar logbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main2);


        mAuth = FirebaseAuth.getInstance();

        logingEmail = (EditText) findViewById(R.id.editText5);
        logingPass = (EditText) findViewById(R.id.editText6);

        logingbtn = (Button) findViewById(R.id.button9);


        crtBtn = (Button) findViewById(R.id.button8);


        logingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginEmailText = logingEmail.getText().toString();
                String loginPassText = logingPass.getText().toString();

                if (!TextUtils.isEmpty(loginEmailText) && !TextUtils.isEmpty(loginPassText)) {

//                    final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    mAuth.signInWithEmailAndPassword(loginEmailText, loginPassText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                sendToMain();
//                                vibe.vibrate(500);
                            } else {

                                String e = task.getException().getMessage();
//                                Toast.makeText(activ.this, "Error :" + e, Toast.LENGTH_LONG).show();

                            }


                        }
                    });


                }

            }

        });
        crtBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, signUp.class);
                startActivity(i);
            }
        });

    }



 @Override
    protected void onStart() {
        super.onStart();
       FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
           /* Intent mainIntent= new Intent(loginact.this,MainActivity.class);
            startActivity(mainIntent);
           finish();*/
            sendToMain();
        }
  }

    private void sendToMain() {
        Intent mainIntent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(mainIntent);
        finish();
    }


}
