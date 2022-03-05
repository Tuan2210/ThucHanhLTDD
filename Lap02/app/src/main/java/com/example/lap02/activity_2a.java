package com.example.lap02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_2a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2a);

        Button btnLogin  = findViewById(R.id.btnLogin);
        EditText edtName = findViewById(R.id.edtName);
        EditText edtPass = findViewById(R.id.edtPass);
        TextView lblForgotPass = findViewById(R.id.lblForgotPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtName.getText().toString().equals("") || edtPass.getText().toString().equals("")) {
                    Toast.makeText(activity_2a.this, "Name or Password is empty", Toast.LENGTH_SHORT).show();
                }
                if (edtName.getText().toString().equals("admin") && edtPass.getText().toString().equals("admin")) {
                    Toast.makeText(activity_2a.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(activity_2a.this, activity_2b.class);
                    activity_2a.this.startActivity(intent);
                }
                if (!edtName.getText().toString().equals("admin") || !edtPass.getText().toString().equals("admin")) {
                    Toast.makeText(activity_2a.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lblForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_2a.this, activity_2c.class);
                activity_2a.this.startActivity(intent);
            }
        });
    }
}