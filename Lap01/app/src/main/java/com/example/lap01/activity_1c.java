package com.example.lap01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activity_1c extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1c);

        EditText edtOTP1 = findViewById(R.id.edtOTP_1),
                 edtOTP2 = findViewById(R.id.edtOTP_2),
                 edtOTP3 = findViewById(R.id.edtOTP_3),
                 edtOTP4 = findViewById(R.id.edtOTP_4),
                 edtOTP5 = findViewById(R.id.edtOTP_5),
                 edtOTP6 = findViewById(R.id.edtOTP_6);

        findViewById(R.id.btnVer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtOTP1.getText().toString().equals("") && edtOTP2.getText().toString().equals("") &&
                        edtOTP3.getText().toString().equals("") && edtOTP4.getText().toString().equals("") &&
                        edtOTP5.getText().toString().equals("") && edtOTP6.getText().toString().equals("")){
                            Toast.makeText(activity_1c.this, "OTP are empty", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(activity_1c.this, "Verify code successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}