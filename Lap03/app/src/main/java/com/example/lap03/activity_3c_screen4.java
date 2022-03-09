package com.example.lap03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_3c_screen4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3c_screen4);

        findViewById(R.id.btnChonMau).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_3c_screen4.this, activity_3c_screen3.class);
                activity_3c_screen4.this.startActivity(intent);
            }
        });
    }
}