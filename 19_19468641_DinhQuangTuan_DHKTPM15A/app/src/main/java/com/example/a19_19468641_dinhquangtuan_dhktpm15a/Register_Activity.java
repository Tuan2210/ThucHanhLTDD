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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register_Activity extends AppCompatActivity {
    private FirebaseAuth auth;
    private DatabaseReference reference;

    EditText edtHoTen, edtEmailRegister;
    TextInputEditText edtMKRegister;
    TextView tvDNNgay;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtHoTen = findViewById(R.id.edtHoTen);
        edtEmailRegister = findViewById(R.id.edtEmailRegister);
        edtMKRegister = findViewById(R.id.edtMKRegister);
        tvDNNgay = findViewById(R.id.tvDNNgay);
        btnRegister = findViewById(R.id.btnRegister);

        auth = FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangKy();
            }
        });

        tvDNNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register_Activity.this, Login_MainActivity.class));
            }
        });
    }

    private void dangKy() {
        String txtHoTenDK = edtHoTen.getText().toString().trim(),
                txtEmailDK = edtEmailRegister.getText().toString().trim(),
                txtMkDK = edtMKRegister.getText().toString().trim();
        if(txtHoTenDK.equals("") || txtEmailDK.equals("") || txtMkDK.equals(""))
            Toast.makeText(Register_Activity.this, "Vui lòng nhập chỗ trống", Toast.LENGTH_SHORT).show();
        else{
            reference = FirebaseDatabase.getInstance().getReference("Thông tin sách");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    auth.createUserWithEmailAndPassword(txtEmailDK, txtMkDK).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Account acc=new Account(txtEmailDK, txtMkDK);
                                addData(acc);

                                startActivity(new Intent(Register_Activity.this, QLSach_Activity.class));
                                Toast.makeText(Register_Activity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                edtHoTen.requestFocus();
                                edtHoTen.setText("");
                                edtEmailRegister.setText("");
                                edtMKRegister.setText("");
                            }
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    private void addData(Account acc) {
        reference = FirebaseDatabase.getInstance().getReference("Thông tin sách");
        reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Tài khoản").setValue(acc);
    }
}