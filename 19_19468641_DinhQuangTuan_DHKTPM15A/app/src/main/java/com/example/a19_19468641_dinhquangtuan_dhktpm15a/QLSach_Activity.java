package com.example.a19_19468641_dinhquangtuan_dhktpm15a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class QLSach_Activity extends AppCompatActivity {
    private FirebaseAuth auth;
    private DatabaseReference reference;

    EditText edtTenSach, edtTheLoai, edtGia;
    Button btnSignout, btnLuu, btnXoa, btnCapNhat, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlsach);

        edtTenSach = findViewById(R.id.edtTenSach);
        edtTheLoai = findViewById(R.id.edtTheLoai);
        edtGia = findViewById(R.id.edtGia);

        btnLuu = findViewById(R.id.btnLuu);
        btnXoa = findViewById(R.id.btnXoa);
        btnCapNhat = findViewById(R.id.btnCapNhat);
        btnHuy = findViewById(R.id.btnHuy);
        btnSignout = findViewById(R.id.btnSignout);
        
        auth = FirebaseAuth.getInstance();
        btnSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangXuat();
            }
        });
    }

    private void dangXuat() {
        auth.signOut();
        startActivity(new Intent(QLSach_Activity.this, Login_MainActivity.class));
        Toast.makeText(this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
    }
}