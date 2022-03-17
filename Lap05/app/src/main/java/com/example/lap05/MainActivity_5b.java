package com.example.lap05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity_5b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5b_main);

        ImageView imgDonut = findViewById(R.id.imgPinkDonut);
        TextView tvDonut = findViewById(R.id.tvPinkDonut),
                 tvPrice = findViewById(R.id.tvPricePink);
        
        int img = getIntent().getIntExtra("imgDonut",0);
        String name = getIntent().getStringExtra("donutName"),
               price = getIntent().getStringExtra("donutPrice");

        imgDonut.setImageResource(img);
        tvDonut.setText(name);
        tvPrice.setText(price);
    }
}