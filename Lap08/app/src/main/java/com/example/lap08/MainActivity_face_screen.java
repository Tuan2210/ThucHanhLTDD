package com.example.lap08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity_face_screen extends AppCompatActivity {
    boolean clickHappyFace = false,
            clickNormalFace = false,
            clickSadFace = false,
            clickFinish = true;

    ImageView imgHappy4, imgNormal4, imgSad4;
    Button btnFinish;

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

        //choose happy face
        imgHappy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHappyFace = true;
                Toast.makeText(MainActivity_face_screen.this, "Đã chọn mặt cười", Toast.LENGTH_SHORT).show();
            }
        });

        //choose normal face
        imgNormal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNormalFace = true;
                Toast.makeText(MainActivity_face_screen.this, "Đã chọn mặt bình thường", Toast.LENGTH_SHORT).show();
            }
        });

        //choose sad face
        imgSad4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSadFace = true;
                Toast.makeText(MainActivity_face_screen.this, "Đã chọn mặt buồn", Toast.LENGTH_SHORT).show();
            }
        });

        //btnFinish
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickHappyFace == true) {
                    Toast.makeText(MainActivity_face_screen.this, "Bạn đang hạnh phúc! :)", Toast.LENGTH_SHORT).show();
                    clickHappyFace = false;
                }
                if (clickNormalFace == true) {
                    Toast.makeText(MainActivity_face_screen.this, "Không cảm xúc như Hồ Quang Hiếu! :|", Toast.LENGTH_SHORT).show();
                    clickNormalFace = false;
                }
                if (clickSadFace == true) {
                    Toast.makeText(MainActivity_face_screen.this, "Đừng buồn nữa, hãy vui lên! - HQH said =))", Toast.LENGTH_SHORT).show();
                    clickSadFace = false;
                }
                if(clickFinish == true && clickHappyFace == false && clickNormalFace == false && clickSadFace == false) {
                    Toast.makeText(MainActivity_face_screen.this, "Chưa chọn trạng thái mặt", Toast.LENGTH_SHORT).show();
//                    clickHappyFace = false;
//                    clickNormalFace = false;
//                    clickSadFace = false;
                    clickFinish = false;
                }
            }
        });
    }
}