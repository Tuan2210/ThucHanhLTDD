package com.example.lap08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity_sign_in_screen extends AppCompatActivity {

    TextInputEditText edtEmail, edtPass;
    Button btnSignIn;
    TextView tvForgotPass,tvSignInGG, tvRegisterHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_in_screen);

        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        btnSignIn = findViewById(R.id.btnSignIn2);
        tvForgotPass = findViewById(R.id.tvForgotPass);
        tvSignInGG = findViewById(R.id.tvSignInGG);
        tvRegisterHere = findViewById(R.id.tvRegisterHere);

        signIn();
        forgotPW();
        signInWithGG();
        registerHere();
    }

    public void signIn() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity_sign_in_screen.this.startActivity(new Intent(MainActivity_sign_in_screen.this, MainActivity_face_screen.class));
            }
        });
    }

    public void forgotPW() {
        tvForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void signInWithGG() {
        tvRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void registerHere() {
        tvRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity_sign_in_screen.this.startActivity(new Intent(MainActivity_sign_in_screen.this, MainActivity_register_screen.class));
            }
        });
    }
}