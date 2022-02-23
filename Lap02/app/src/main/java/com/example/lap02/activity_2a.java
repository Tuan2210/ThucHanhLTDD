package com.example.lap02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_2a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2a);

        Button btnLogin  = findViewById(R.id.btnLogin);
        EditText edtName = findViewById(R.id.edtName);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtName.getText().toString().equals("")){
                    Toast.makeText(activity_2a.this, "Nothing to show", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(activity_2a.this, edtName.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}