package com.example.lap02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activity_2c extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2c);

        EditText edtPassGen = findViewById(R.id.edtPassGen);

        findViewById(R.id.btnGenPass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtPassGen.getText().toString().equals(""))
                    Toast.makeText(activity_2c.this, "New password is empty!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}