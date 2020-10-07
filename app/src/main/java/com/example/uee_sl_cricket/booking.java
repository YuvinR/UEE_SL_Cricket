package com.example.uee_sl_cricket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class booking extends AppCompatActivity {

    private Spinner spinner;
    private TextView output ;
    private Spinner nTickets;
    private int value ;
    private double total ;
    private double vipPrice = 1000.00;
    private double normalPrice = 500.00;
    private String type , tick, sendVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_booking);


        output = findViewById(R.id.total_output);
        nTickets = findViewById(R.id.ticket_num);
        spinner = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.cus_type, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = parent.getSelectedItem().toString();

                if(type.equals("VIP")){
                    total = value * vipPrice;
                    output.setText("LKR. " + String.valueOf(total));


                }else if(type.equals("Normal")){
                    total = value * normalPrice;
                    output.setText("LKR. " + String.valueOf(total));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> numAdapter = ArrayAdapter.createFromResource(this,R.array.num_ticket, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nTickets.setAdapter(numAdapter);

        nTickets.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tick = parent.getSelectedItem().toString();
                value = Integer.parseInt(tick);

                if(type.equals("VIP")){
                    total = value * vipPrice;
                    output.setText("LKR. " + String.valueOf(total));

                }else if(type.equals("Normal")){
                    total = value * normalPrice;
                    output.setText("LKR. " + String.valueOf(total));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*Intent intent = new Intent(this, payments.class);
        intent.putExtra("totValue", total);*/
    }

    public void methodNotification(View view) {
        Intent intent = new Intent(this, Notification.class);
        startActivity(intent);
    }

    public void methodHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void movePaymentGUI(View view){
        sendVal = String.valueOf(total);
        Intent intent = new Intent(this, payments.class);
        intent.putExtra("totValue", sendVal);
        startActivity(intent);
    }

}