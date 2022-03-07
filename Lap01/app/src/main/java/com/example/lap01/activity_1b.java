package com.example.lap01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_1b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1b);

        EditText edtEmailResetPass =findViewById(R.id.edtEmailResetPass);

        //sk nút next
        findViewById(R.id.btnNext).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                if(edtEmailResetPass.getText().toString().equals(""))
                    Toast.makeText(activity_1b.this, "Email is empty!", Toast.LENGTH_SHORT).show();
                if(edtEmailResetPass.getText().toString().equals("quangtuan496@gmail.com")){
                    Intent intent = new Intent((Context) activity_1b.this, activity_1c.class);
                    activity_1b.this.startActivity(intent);
                }
                if(!edtEmailResetPass.getText().toString().equals(""))
                    Toast.makeText(activity_1b.this, "Email is error!", Toast.LENGTH_SHORT).show();
            }
        }));
    }
}