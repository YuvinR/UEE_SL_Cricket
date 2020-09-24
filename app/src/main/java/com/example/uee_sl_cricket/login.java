package com.example.uee_sl_cricket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
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

public class login extends AppCompatActivity {

    //Testing Values. 
    private EditText logingEmail;
    private EditText logingPass;
    private TextView signup;
    private Button logingbtn, crtBtn, logout;
    private ProgressBar logbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        logingEmail = (EditText) findViewById(R.id.editText5);
        logingPass = (EditText) findViewById(R.id.editText6);

        logingbtn = (Button) findViewById(R.id.button9);


        crtBtn = (Button) findViewById(R.id.button8);
        /*signup.setOnClickListener(this);
        bt.setOnClickListener(this);*/

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
                                System.out.println("done");
                                sendToMain();
//                                vibe.vibrate(500);
                            } else {

                                String e = task.getException().getMessage();
                                Toast.makeText(login.this, "Error :" + e, Toast.LENGTH_LONG).show();

                            }


                        }
                    });


                }

            }
        });


        crtBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this, signUp.class);
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
        Intent mainIntent = new Intent(login.this, MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
}