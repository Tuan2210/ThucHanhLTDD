package com.example.lap01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_1d extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1d);

        //sk link Forget Password
        ((TextView)this.findViewById(R.id.txtLinkForgot)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)activity_1d.this, activity_1b.class);
                activity_1d.this.startActivity(intent);
            }
        }));

        EditText edtEmailLogin = findViewById(R.id.edtEmailLogin),
                 edtPassLogin = findViewById(R.id.edtPassLogin);
        //sk btnLogin
        findViewById(R.id.btnLogin2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtEmailLogin.getText().toString().equals("") || edtPassLogin.getText().toString().equals(""))
                    Toast.makeText(activity_1d.this, "Email or Password is empty!", Toast.LENGTH_SHORT).show();
                if(edtEmailLogin.getText().toString().equals("quangtuan496@gmail.com") || edtPassLogin.getText().toString().equals("tuan123"))
                    Toast.makeText(activity_1d.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                if(!edtEmailLogin.getText().toString().equals("") && !edtPassLogin.getText().toString().equals(""))
                    Toast.makeText(activity_1d.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}