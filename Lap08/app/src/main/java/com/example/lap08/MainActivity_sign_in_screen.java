package com.example.lap08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_sign_in_screen extends AppCompatActivity {
    private Account acc;
    private DatabaseReference db;

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

    public void getInfoAccLogin(Account acc){
        String log = "id: " +acc.getId() + "name: " + acc.getName()
                + ", email: " + acc.getEmail() + ", password: " + acc.getPassWord();
        Log.d("text info_acc login", log);
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

                if (!txtEmail.equals("") && !txtPW.equals("")) {
                    db = FirebaseDatabase.getInstance().getReference(Account.class.getSimpleName());
                    db.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            if(snapshot.exists()) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {   //skip child id
                                String txtExistEmail = dataSnapshot.child("email").getValue().toString(),
                                        txtExistPW = dataSnapshot.child("passWord").getValue().toString();

                                acc=new Account(txtExistEmail);

                                if(txtEmail.equals(txtExistEmail) && txtPW.equals(txtExistPW)) {
                                    MainActivity_sign_in_screen.this.startActivity(new Intent(MainActivity_sign_in_screen.this, MainActivity_face_screen.class));
                                    Toast.makeText(view.getContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();

                                    edtEmail.setText("");
                                    edtPass.setText("");

                                    getInfoAccLogin(acc);

                                    db.onDisconnect();
                                }

//                                if (!txtEmail.equals(txtExistEmail))
//                                    Toast.makeText(view.getContext(), "Tài khoản chưa được đăng ký!", Toast.LENGTH_SHORT).show();
//                                else {
//                                    if (!txtPW.equals(txtExistPW))
//                                        Toast.makeText(view.getContext(), "Mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
//                                    else {
//                                        MainActivity_sign_in_screen.this.startActivity(new Intent(MainActivity_sign_in_screen.this, MainActivity_face_screen.class));
//                                        Toast.makeText(view.getContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
//
//                                        edtEmail.setText("");
//                                        edtPass.setText("");
//
//                                        getInfoAccLogin(acc);
//                                    }
//                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
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

    //đọc db
//    public void basicReadWrite() {
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//        // [END read_message]
//    }
}

////sign in with RoomDB
//public class MainActivity_sign_in_screen extends AppCompatActivity {
//    private List<Account> accountList=new ArrayList<>();
//
//    TextInputEditText edtEmail, edtPass;
//    Button btnSignIn;
//    TextView tvForgotPass,tvSignInGG, tvRegisterHere;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_sign_in_screen);
//
//        edtEmail = findViewById(R.id.edtEmail);
//        edtPass = findViewById(R.id.edtPass);
//        btnSignIn = findViewById(R.id.btnSignIn2);
//        tvForgotPass = findViewById(R.id.tvForgotPass);
//        tvSignInGG = findViewById(R.id.tvSignInGG);
//        tvRegisterHere = findViewById(R.id.tvRegisterHere);
//
//        getInfoAcc();
//
//        signIn();
//        forgotPW();
//        signInWithGG();
//        registerHere();
//    }
//
//    public void signIn() {
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String txtEmail = edtEmail.getText().toString().trim(),
//                        txtPW = edtPass.getText().toString().trim();
//
//                //check empty
//                if (txtPW.equals(""))
//                    Toast.makeText(view.getContext(), "Vui lòng nhập mật khẩu đăng nhập!", Toast.LENGTH_SHORT).show();
//                if (txtEmail.equals(""))
//                    Toast.makeText(view.getContext(), "Vui lòng nhập email đăng nhập!", Toast.LENGTH_SHORT).show();
//
//                if(!txtEmail.equals("") && !txtPW.equals("")) {
////                  account = (Account) Acc_RoomDB.getInstance(view.getContext()).accDAO().loadAcc(); //arraylist ko cast object
//                    for (Account account : accountList) {
//                        accountList = Acc_RoomDB.getInstance(view.getContext()).accDAO().loadAcc();
//                        String txtExistEmail = account.getEmail(),
//                                txtExistPW = account.getPassWord();
//
////                        if (!txtEmail.equals(txtExistEmail))
////                            Toast.makeText(view.getContext(), "Tài khoản chưa được đăng ký!", Toast.LENGTH_SHORT).show();
//                        if(txtEmail.equals(txtExistEmail)) {
//                            if(!txtPW.equals(txtExistPW))
//                                Toast.makeText(view.getContext(), "Mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
//                            else  {
//                                MainActivity_sign_in_screen.this.startActivity(new Intent(MainActivity_sign_in_screen.this, MainActivity_face_screen.class));
//                                Toast.makeText(view.getContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
//
//                                edtEmail.setText("");
//                                edtPass.setText("");
//
//                                String loginAcc = "email: " +txtExistEmail +", password: " +txtExistPW;
//                                Log.d("Acc login successfully",loginAcc);
//                            }
//                        }
//                    }
//                }
//            }
//        });
//    }
//
//    public void forgotPW() {
//        tvForgotPass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//    }
//
//    public void signInWithGG() {
//        tvRegisterHere.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//    }
//
//    public void registerHere() {
//        tvRegisterHere.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MainActivity_sign_in_screen.this.startActivity(new Intent(MainActivity_sign_in_screen.this, MainActivity_register_screen.class));
//            }
//        });
//    }
//
//    public void getInfoAcc() {
//        accountList = Acc_RoomDB.getInstance(this).accDAO().loadAcc();
//        for(Account acc : accountList) {
//            String log = "id: " + acc.getId() + ", name: " + acc.getName()
//                    + ", email: " + acc.getEmail() + ", password: " + acc.getPassWord();
//            Log.d("text info account", log);
//        }
//    }
//
//}