package com.example.lap08;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
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

import java.util.ArrayList;
import java.util.List;

//Firebase realtime db USE authentication; sign in with GG
public class MainActivity_sign_in_screen extends AppCompatActivity {
    private Account acc;
    private DatabaseReference db;
    private FirebaseAuth firebaseAuth;

    private GoogleSignInOptions gso;
    private GoogleSignInClient gsc;

    TextInputEditText edtEmail, edtPass;
    Button btnSignIn2;
    TextView tvForgotPass,tvSignInGG, tvRegisterHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_in_screen);

        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        btnSignIn2 = findViewById(R.id.btnSignIn2);
        tvForgotPass = findViewById(R.id.tvForgotPass);
        tvSignInGG = findViewById(R.id.tvSignInGG);
        tvRegisterHere = findViewById(R.id.tvRegisterHere);

        firebaseAuth = FirebaseAuth.getInstance();
        btnSignIn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);
        tvSignInGG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInWithGG();
            }
        });

        forgotPW();
        registerHere();
    }

    public void getInfoAccLogin(Account acc){
        String log = "name: " + acc.getName()
                + ", email: " + acc.getEmail() + ", password: " + acc.getPassWord();
        Log.d("text info_acc login", log);
    }

    public void signIn() {
        String txtEmail = edtEmail.getText().toString().trim(),
                txtPW = edtPass.getText().toString().trim();

        //check empty
        if (txtPW.equals(""))
            Toast.makeText(this, "Vui lòng nhập mật khẩu đăng nhập!", Toast.LENGTH_SHORT).show();
        if (txtEmail.equals(""))
            Toast.makeText(this, "Vui lòng nhập email đăng nhập!", Toast.LENGTH_SHORT).show();

        if (!txtEmail.equals("") && !txtPW.equals("")) {
            firebaseAuth.signInWithEmailAndPassword(txtEmail, txtPW)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                acc = new Account(txtEmail, txtPW);
                                getInfoAccLogin(acc);

                                edtEmail.setText("");
                                edtPass.setText("");
                                edtEmail.requestFocus();

                                MainActivity_sign_in_screen.this.startActivity(new Intent(MainActivity_sign_in_screen.this, MainActivity_face_screen.class));

                                Toast.makeText(MainActivity_sign_in_screen.this, "Tài khoản có email là " + txtEmail + " đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity_sign_in_screen.this, "Authentication login failed (mk phải nhập 6 kí tự trở lên)", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void forgotPW() {
        tvForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    public void signInWithGG() {
        Intent intent = gsc.getSignInIntent();
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                MainActivity_sign_in_screen.this.startActivity(new Intent(MainActivity_sign_in_screen.this, MainActivity_face_screen.class));
            } catch (ApiException e) {
                e.printStackTrace();
                Toast.makeText(this, "Sign in with Google failed", Toast.LENGTH_SHORT).show();
            }
        }
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

////Firebase realtime db NOT USE authentication
//public class MainActivity_sign_in_screen extends AppCompatActivity {
//    private Account acc;
//    private DatabaseReference db;
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
//        signIn();
//        forgotPW();
//        signInWithGG();
//        registerHere();
//    }
//
//    public void getInfoAccLogin(Account acc){
//        String log = "id: " +acc.getId() + "name: " + acc.getName()
//                + ", email: " + acc.getEmail() + ", password: " + acc.getPassWord();
//        Log.d("text info_acc login", log);
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
//                if (!txtEmail.equals("") && !txtPW.equals("")) {
//                    db = FirebaseDatabase.getInstance().getReference(Account.class.getSimpleName());
//                    db.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
////                            if(snapshot.exists()) {
//                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {   //skip child id
//                                String txtExistEmail = dataSnapshot.child("email").getValue().toString(),
//                                        txtExistPW = dataSnapshot.child("passWord").getValue().toString();
//
//                                acc=new Account(txtExistEmail);
//
//                                if(txtEmail.equals(txtExistEmail) && txtPW.equals(txtExistPW)) {
//                                    MainActivity_sign_in_screen.this.startActivity(new Intent(MainActivity_sign_in_screen.this, MainActivity_face_screen.class));
//                                    Toast.makeText(view.getContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
//
//                                    edtEmail.setText("");
//                                    edtPass.setText("");
//                                    edtEmail.requestFocus();
//
//                                    getInfoAccLogin(acc);
//
//                                    db.onDisconnect();
//                                }
//
////                                if (!txtEmail.equals(txtExistEmail))
////                                    Toast.makeText(view.getContext(), "Tài khoản chưa được đăng ký!", Toast.LENGTH_SHORT).show();
////                                else {
////                                    if (!txtPW.equals(txtExistPW))
////                                        Toast.makeText(view.getContext(), "Mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
////                                    else {
////                                        MainActivity_sign_in_screen.this.startActivity(new Intent(MainActivity_sign_in_screen.this, MainActivity_face_screen.class));
////                                        Toast.makeText(view.getContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
////
////                                        edtEmail.setText("");
////                                        edtPass.setText("");
////
////                                        getInfoAccLogin(acc);
////                                    }
////                                }
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//                        }
//                    });
//                }
//            }
//        });
//    }
//
//    public void forgotPW() {
//        tvForgotPass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
//    }
//
//    public void signInWithGG() {
//        tvRegisterHere.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
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
//    //đọc db
////    public void basicReadWrite() {
////        FirebaseDatabase database = FirebaseDatabase.getInstance();
////        DatabaseReference myRef = database.getReference("message");
////
////        myRef.setValue("Hello, World!");
////
////        myRef.addValueEventListener(new ValueEventListener() {
////            @Override
////            public void onDataChange(DataSnapshot dataSnapshot) {
////                // This method is called once with the initial value and again
////                // whenever data at this location is updated.
////                String value = dataSnapshot.getValue(String.class);
////                Log.d(TAG, "Value is: " + value);
////            }
////
////            @Override
////            public void onCancelled(DatabaseError error) {
////                // Failed to read value
////                Log.w(TAG, "Failed to read value.", error.toException());
////            }
////        });
////        // [END read_message]
////    }
//}

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