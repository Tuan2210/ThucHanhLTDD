package com.example.lap01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    }
}