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

public class MainActivity_register_screen extends AppCompatActivity {
    private Account account;
    private List<Account> accountList=new ArrayList<>();
    private InfoAccount infoAccount=new InfoAccount();

    TextInputEditText edtRegisterName, edtRegisterEmail, edtRegisterPass, edtRegisterPassCheck;
    Button btnRegister2;
    TextView tvRegisterGG,tvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register_screen);

        edtRegisterName = findViewById(R.id.edtRegisterName);
        edtRegisterEmail = findViewById(R.id.edtRegisterEmail);
        edtRegisterPass = findViewById(R.id.edtRegisterPass);
        edtRegisterPassCheck = findViewById(R.id.edtRegisterPassCheck);
        btnRegister2 = findViewById(R.id.btnRegister2);
        tvRegisterGG = findViewById(R.id.tvRegisterGG);
        tvSignIn = findViewById(R.id.tvSignIn);

        getInfoAcc();

        register();
        signIn();
    }

    public void getInfoAcc() {
        accountList = Acc_RoomDB.getInstance(this).accDAO().loadAcc();
        for(Account acc : accountList) {
            String log = "id: " + acc.getId() + ", name: " + acc.getName()
                    + ", email: " + acc.getEmail() + ", password: " + acc.getPassWord();
            Log.d("text info account", log);
        }
    }

    public void register() {
        btnRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtName = edtRegisterName.getText().toString().trim(),
                        txtEmail = edtRegisterEmail.getText().toString().trim(),
                        txtPW = edtRegisterPass.getText().toString().trim(),
                        txtPWCheck = edtRegisterPassCheck.getText().toString().trim();

                //check empty
                if (txtPWCheck.equals(""))
                    Toast.makeText(view.getContext(), "Vui lòng nhập lại mật khẩu đăng ký!", Toast.LENGTH_SHORT).show();
                if (txtPW.equals(""))
                    Toast.makeText(view.getContext(), "Vui lòng nhập mật khẩu đăng ký!", Toast.LENGTH_SHORT).show();
                if (txtEmail.equals(""))
                    Toast.makeText(view.getContext(), "Vui lòng nhập email đăng ký!", Toast.LENGTH_SHORT).show();
                if (txtName.equals(""))
                    Toast.makeText(view.getContext(), "Vui lòng nhập tên đăng ký!", Toast.LENGTH_SHORT).show();

                //insert account
                if (!txtName.equals("") && !txtEmail.equals("") && !txtPW.equals("") && !txtPWCheck.equals("")) {
                    if(txtPWCheck.equals(txtPW)){
                        for(Account account : accountList) {
                            accountList = Acc_RoomDB.getInstance(view.getContext()).accDAO().loadAcc();
                            String txtRegisteredEmail = account.getEmail();

                            //check data
                            if (txtEmail.equals(txtRegisteredEmail))
                                Toast.makeText(view.getContext(), "Email này đã được đăng ký!", Toast.LENGTH_SHORT).show();
//                            if (txtName.equals(txtRegisteredName))
//                                Toast.makeText(view.getContext(), "Tài khoản trùng tên!", Toast.LENGTH_SHORT).show();

                            //insert
                            else {
//                            if (!txtEmail.equals(txtRegisteredEmail)) {
                                Acc_RoomDB.getInstance(view.getContext()).accDAO().insertAcc(new Account(txtName, txtEmail, txtPWCheck));
                                Toast.makeText(view.getContext(), "Tài khoản có email là " + txtEmail + " đăng ký thành công", Toast.LENGTH_SHORT).show();

                                MainActivity_register_screen.this.startActivity(new Intent(MainActivity_register_screen.this, MainActivity_sign_in_screen.class));

                                edtRegisterName.setText("");
                                edtRegisterEmail.setText("");
                                edtRegisterPass.setText("");
                                edtRegisterPassCheck.setText("");

                                getInfoAcc();
                            }
                        }
                    }
                    else
                        Toast.makeText(view.getContext(), "Mật khẩu nhập lại không khớp!", Toast.LENGTH_SHORT).show();
                }
            }
        });
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