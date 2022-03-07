package com.example.lap01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class activity_1e extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1e);

        EditText edtName = findViewById(R.id.edtName),
                 edtPhone = findViewById(R.id.edtPhone),
                 edtEmailRegister = findViewById(R.id.edtEmailRegister),
                 edtPassRegister = findViewById(R.id.edtPassRegister),
                 edtBirthday = findViewById(R.id.edtBirthday);

        RadioButton rdoMale = findViewById(R.id.rdoMale),
                    rdoFemale = findViewById(R.id.rdoFemale);

        //sk btnRegister
        findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtName.getText().toString().equals("") || edtPhone.getText().toString().equals("") || edtEmailRegister.getText().toString().equals("") ||
                        edtPassRegister.getText().toString().equals("") || edtBirthday.getText().toString().equals(""))
                    Toast.makeText(activity_1e.this, "Form needs to be filled out!", Toast.LENGTH_SHORT).show();
                if(!rdoMale.isChecked() && !rdoFemale.isChecked())
                    Toast.makeText(activity_1e.this, "Please tick Male or Female", Toast.LENGTH_SHORT).show();
                if(!edtName.getText().toString().equals("") && !edtPhone.getText().toString().equals("") && !edtEmailRegister.getText().toString().equals("") &&
                        !edtPassRegister.getText().toString().equals("") && !edtBirthday.getText().toString().equals(""))
                    Toast.makeText(activity_1e.this, "Register Successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}