package com.example.lap08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity_start_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start_screen);

        //btnSignIn
        findViewById(R.id.btnSignIn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity_start_screen.this.startActivity(new Intent(MainActivity_start_screen.this, MainActivity_sign_in_screen.class));
            }
        });

        //btnRegister
        findViewById(R.id.btnRegister1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity_start_screen.this.startActivity(new Intent(MainActivity_start_screen.this, MainActivity_register_screen.class));
            }
        });
    }
}