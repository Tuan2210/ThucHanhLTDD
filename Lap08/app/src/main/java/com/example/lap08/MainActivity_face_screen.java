package com.example.lap08;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity_face_screen extends AppCompatActivity {
//    boolean clickHappyFace = false,
//            clickNormalFace = false,
//            clickSadFace = false,
//            clickFinish = true;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference db;

    private GoogleSignInOptions gso;
    private GoogleSignInClient gsc;

    private int happNum = 0;
    private int normalNum = 0;
    private int sadNum = 0;

    ImageView imgHappy4, imgNormal4, imgSad4;
    Button btnFinish, btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_face_screen);

//        nhớ chỉnh màn hình ngang trong AndroidManifest.xml:
//        <activity
//        android:name=".MainActivity_face_screen"
//        android:exported="false"
//        android:screenOrientation="landscape"/>

        imgHappy4 = findViewById(R.id.imgHappy4);
        imgNormal4 = findViewById(R.id.imgNormal4);
        imgSad4 = findViewById(R.id.imgSad4);
        btnFinish = findViewById(R.id.btnFinish);
        btnSignOut = findViewById(R.id.btnSignOut);

        //choose happy face
        imgHappy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                clickHappyFace = true;
                happNum++;

                db = FirebaseDatabase.getInstance().getReference(Account.class.getSimpleName())
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("happy");
                db.setValue(happNum);

                Toast.makeText(MainActivity_face_screen.this, "Đã chọn mặt cười", Toast.LENGTH_SHORT).show();
            }
        });

        //choose normal face
        imgNormal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                clickNormalFace = true;
                normalNum++;
                db = FirebaseDatabase.getInstance().getReference(Account.class.getSimpleName())
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("normal");
                db.setValue(normalNum);

                Toast.makeText(MainActivity_face_screen.this, "Đã chọn mặt bình thường", Toast.LENGTH_SHORT).show();
            }
        });

        //choose sad face
        imgSad4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                clickSadFace = true;
                sadNum++;

                db = FirebaseDatabase.getInstance().getReference(Account.class.getSimpleName())
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("sad");
                db.setValue(sadNum);

                Toast.makeText(MainActivity_face_screen.this, "Đã chọn mặt buồn", Toast.LENGTH_SHORT).show();
            }
        });

        //btnFinish
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (clickHappyFace == true) {
//                    Toast.makeText(MainActivity_face_screen.this, "Bạn đang hạnh phúc! :)", Toast.LENGTH_SHORT).show();
//                    clickHappyFace = false;
//                }
//                if (clickNormalFace == true) {
//                    Toast.makeText(MainActivity_face_screen.this, "Không cảm xúc như Hồ Quang Hiếu! :|", Toast.LENGTH_SHORT).show();
//                    clickNormalFace = false;
//                }
//                if (clickSadFace == true) {
//                    Toast.makeText(MainActivity_face_screen.this, "Đừng buồn nữa, hãy vui lên! - HQH said =))", Toast.LENGTH_SHORT).show();
//                    clickSadFace = false;
//                }
//                if(clickFinish == true && clickHappyFace == false && clickNormalFace == false && clickSadFace == false) {
//                    Toast.makeText(MainActivity_face_screen.this, "Chưa chọn trạng thái mặt", Toast.LENGTH_SHORT).show();
////                    clickHappyFace = false;
////                    clickNormalFace = false;
////                    clickSadFace = false;
//                    clickFinish = false;
//                }
                db = FirebaseDatabase.getInstance().getReference(Account.class.getSimpleName())
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()) {
                            String happy = snapshot.child("happy").getValue().toString(),
                                    normal = snapshot.child("normal").getValue().toString(),
                                    sad = snapshot.child("sad").getValue().toString();
                            Toast.makeText(MainActivity_face_screen.this, "Happy: " + happy + ", Normal: " + normal + ", Sad: " + sad, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        //btnSignOut
        firebaseAuth = FirebaseAuth.getInstance();

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);
//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        Log.d("test infoAccGG", "info acc gg:" +account.getEmail());
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });
    }

    public void signOut(){
        firebaseAuth.signOut();
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
                MainActivity_face_screen.this.startActivity(new Intent(MainActivity_face_screen.this, MainActivity_sign_in_screen.class));
            }
        });
    }

}