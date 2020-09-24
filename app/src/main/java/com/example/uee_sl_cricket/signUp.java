package com.example.uee_sl_cricket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signUp extends AppCompatActivity {

    private EditText email;
    private EditText pwrd;
    private EditText cprwd;
    private Button create;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth= FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.editText7);
        pwrd = (EditText) findViewById(R.id.editText13);
        cprwd = (EditText)findViewById(R.id.editText14);
        create = (Button)findViewById(R.id.button2);

        create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String emailx =email.getText().toString();
                String pwrdx =pwrd.getText().toString();
                String cpwrdx =pwrd.getText().toString();


                if(!TextUtils.isEmpty(emailx) && !TextUtils.isEmpty(pwrdx) && !TextUtils.isEmpty(cpwrdx)){
                    if(pwrdx.equals(cpwrdx)){

                        mAuth.createUserWithEmailAndPassword(emailx, pwrdx).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    sendToMain();
                                }else{
                                    String errormsg =task.getException().getMessage();
                                    Toast.makeText(signUp.this,"Error :"+errormsg,Toast.LENGTH_LONG).show();
                                }
                            }
                        });


                    }
                    else{
                        Toast.makeText(signUp.this,"Passwords are mismatch",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    private void sendToMain() {
        Intent mainIntent= new Intent(signUp.this,MainActivity.class);
        startActivity(mainIntent);

        finish();

    }
    protected void onStart() {
        super.onStart();
        FirebaseUser cuser = mAuth.getCurrentUser();
        if(cuser != null){
            sendToMain();

        }

}
}