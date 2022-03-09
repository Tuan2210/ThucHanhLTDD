package com.example.lap03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

public class activity_3c_screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3c_screen2);

        ViewStub viewStub_VSmartWhite = findViewById(R.id.viewStub_VSmartWhite),
                 viewStub_VSmartRed = findViewById(R.id.viewStub_VSmartRed),
                 viewStub_VSmartBlack = findViewById(R.id.viewStub_VSmartBlack),
                 viewStub_VSmartBlue = findViewById(R.id.viewStub_VSmartBlue);
        viewStub_VSmartBlue.inflate();
        viewStub_VSmartBlue.setVisibility(View.INVISIBLE);

        findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                viewStub_VSmartWhite.setVisibility(View.INVISIBLE);
                viewStub_VSmartRed.setVisibility(View.INVISIBLE);
                viewStub_VSmartBlack.setVisibility(View.INVISIBLE);
                viewStub_VSmartBlue.setVisibility(View.INVISIBLE);
            }
        });

        //chon mau trang
        findViewById(R.id.viewWhite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewStub_VSmartWhite.setVisibility(View.VISIBLE);
            }
        });

        //chon mau do
        findViewById(R.id.viewRed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewStub_VSmartRed.setVisibility(View.VISIBLE);
            }
        });

        //chon mau den
        findViewById(R.id.viewBlack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewStub_VSmartBlack.setVisibility(View.VISIBLE);
            }
        });

        //chon mau xanh
        findViewById(R.id.viewBlue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewStub_VSmartBlue.setVisibility(View.VISIBLE);
            }
        });
    }
}