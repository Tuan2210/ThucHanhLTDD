package com.example.lap01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_1a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1a);

        //kotlin
//        //sk nút login
//        val btnLogin1a = findViewById<Button>(R.id.btnLogin1)
//                btnLogin1a.setOnClickListener {
//            val intent = Intent(this, MainActivity_1d::class.java)
//            startActivity(intent)
//        }
//
//        //sk nút sign up
//        findViewById<Button>(R.id.btnSignUp).setOnClickListener {
//            val intent = Intent(this, MainActivity_1e::class.java)
//            startActivity(intent)
//        }

        //sk nút login
        Button btnLogin1a = (Button)this.findViewById(R.id.btnLogin1);
        btnLogin1a.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)activity_1a.this, activity_1d.class);
                activity_1a.this.startActivity(intent);
            }
        }));

        //sk nút sign up
        findViewById(R.id.btnSignUp).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)activity_1a.this, activity_1e.class);
                activity_1a.this.startActivity(intent);
            }
        }));
    }
}