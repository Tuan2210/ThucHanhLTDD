package com.example.lap08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity_register_screen extends AppCompatActivity {

    TextInputEditText edtRegisterName, edtRegisterEmail, edtRegisterPass, edtRegisterPassAgain;
    Button btnRegister2;
    TextView tvRegisterGG,tvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register_screen);

        edtRegisterName = findViewById(R.id.edtRegisterName);
        edtRegisterEmail = findViewById(R.id.edtRegisterEmail);
        edtRegisterPass = findViewById(R.id.edtRegisterPass);
        edtRegisterPassAgain = findViewById(R.id.edtRegisterPassAgain);
        btnRegister2 = findViewById(R.id.btnRegister2);
        tvRegisterGG = findViewById(R.id.tvRegisterGG);
        tvSignIn = findViewById(R.id.tvSignIn);

        register();
        signIn();
    }

    public void register() {
    }

    public void signIn() {
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity_register_screen.this.startActivity(new Intent(MainActivity_register_screen.this, MainActivity_sign_in_screen.class));
            }
        });
    }
}