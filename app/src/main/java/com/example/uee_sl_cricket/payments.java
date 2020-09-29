package com.example.uee_sl_cricket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class payments extends AppCompatActivity {

   private TextView displayTotal ;
   private EditText ed1 , ed2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_payments);

        final Button btn = findViewById(R.id.btn_thx);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        Intent intent = getIntent();
        String result = intent.getStringExtra("totValue");
        Toast.makeText(getApplicationContext(),"Result :- "+result,Toast.LENGTH_LONG).show();
        displayTotal = findViewById(R.id.TextViewTotal);
        displayTotal.setText(result);
        ed1 = findViewById(R.id.editTextTextPersonName);
        ed2 = findViewById(R.id.editTextTextPersonName3);
    }

    public void methodNotification(View view) {
        Intent intent = new Intent(this, Notification.class);
        startActivity(intent);
    }

    public void methodHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openDialog(){
        ThankyouPayment thankYou = new ThankyouPayment();
        thankYou.show(getSupportFragmentManager(),"thank you");
        ed1.setText("");
        ed2.setText("");
        displayTotal.setText("");
    }

}