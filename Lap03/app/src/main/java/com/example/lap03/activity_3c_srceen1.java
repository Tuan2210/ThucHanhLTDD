package com.example.lap03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_3c_srceen1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3c_srceen1);

        findViewById(R.id.btnChonMau).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_3c_srceen1.this, activity_3c_screen2.class);
                activity_3c_srceen1.this.startActivity(intent);
            }
        });

    }
}