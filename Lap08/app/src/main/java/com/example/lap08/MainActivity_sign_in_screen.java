package com.example.lap08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_sign_in_screen extends AppCompatActivity {
    private Account account;
    private List<Account> accountList=new ArrayList<>();

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

        getInfoAcc();

        signIn();
        forgotPW();
        signInWithGG();
        registerHere();
    }

    public void signIn() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEmail = edtEmail.getText().toString().trim(),
                        txtPW = edtPass.getText().toString().trim();

                //check empty
                if (txtPW.equals(""))
                    Toast.makeText(view.getContext(), "Vui lòng nhập mật khẩu đăng nhập!", Toast.LENGTH_SHORT).show();
                if (txtEmail.equals(""))
                    Toast.makeText(view.getContext(), "Vui lòng nhập email đăng nhập!", Toast.LENGTH_SHORT).show();

                if(!txtEmail.equals("") && !txtPW.equals("")) {
//                  account = (Account) Acc_RoomDB.getInstance(view.getContext()).accDAO().loadAcc(); //arraylist ko cast object
                    for (Account account : accountList) {
                        accountList = Acc_RoomDB.getInstance(view.getContext()).accDAO().loadAcc();
                        String txtExistEmail = account.getEmail(),
                                txtExistPW = account.getPassWord();

//                        if (!txtEmail.equals(txtExistEmail))
//                            Toast.makeText(view.getContext(), "Tài khoản chưa được đăng ký!", Toast.LENGTH_SHORT).show();
                        if(txtEmail.equals(txtExistEmail)) {
                            if(!txtPW.equals(txtExistPW))
                                Toast.makeText(view.getContext(), "Mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                            else  {
                                MainActivity_sign_in_screen.this.startActivity(new Intent(MainActivity_sign_in_screen.this, MainActivity_face_screen.class));
                                Toast.makeText(view.getContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();

                                edtEmail.setText("");
                                edtPass.setText("");

                                String loginAcc = "email: " +txtExistEmail +", password: " +txtExistPW;
                                Log.d("Acc login successfully",loginAcc);
                            }
                        }
                    }
                }
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

    public void getInfoAcc() {
        accountList = Acc_RoomDB.getInstance(this).accDAO().loadAcc();
        for(Account acc : accountList) {
            String log = "id: " + acc.getId() + ", name: " + acc.getName()
                    + ", email: " + acc.getEmail() + ", password: " + acc.getPassWord();
            Log.d("text info account", log);
        }
    }
}