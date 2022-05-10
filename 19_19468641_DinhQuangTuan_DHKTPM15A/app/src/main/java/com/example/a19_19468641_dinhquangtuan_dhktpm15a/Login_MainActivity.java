package com.example.a19_19468641_dinhquangtuan_dhktpm15a;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Login_MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private DatabaseReference reference;

    EditText edtEmailLogin;
    TextInputEditText edtMKLogin;
    TextView tvDKNgay;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        edtEmailLogin = findViewById(R.id.edtEmailLogin);
        edtMKLogin = findViewById(R.id.edtMKLogin);
        tvDKNgay = findViewById(R.id.tvDKNgay);
        btnLogin = findViewById(R.id.btnLogin);

        auth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangNhap();
            }
        });

        tvDKNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_MainActivity.this, Register_Activity.class));
            }
        });
    }

    private void dangNhap() {
        String txtEmailDN = edtEmailLogin.getText().toString().trim(),
                txtMkDN = edtMKLogin.getText().toString().trim();
        if(!txtEmailDN.equals("") && !txtMkDN.equals("")){
            auth.signInWithEmailAndPassword(txtEmailDN, txtMkDN).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Account acc=new Account(txtEmailDN, txtMkDN);
                        Toast.makeText(Login_MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login_MainActivity.this, QLSach_Activity.class));

                        edtEmailLogin.requestFocus();
                        edtEmailLogin.setText("");
                        edtMKLogin.setText("");
                    }else
                        Toast.makeText(Login_MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}