package com.example.lap05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_5a extends AppCompatActivity {
    private List<Donut> listDonut = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5a_main);

        listView = findViewById(R.id.lvDonuts);
        //listDonut = new ArrayList<>();
        listDonut.add(new Donut(1, "Tasty Donut", "$10.00", R.drawable.donut_yellow_1));
        listDonut.add(new Donut(2, "Pink Donut", "$20.00", R.drawable.tasty_donut_1));
        listDonut.add(new Donut(3, "Floating Donut", "$30.00", R.drawable.green_donut_1));
        listDonut.add(new Donut(4, "Tasty Donut", "$40.00", R.drawable.donut_red_1));

        DonutAdapter adapter = new DonutAdapter(this, R.layout.activity_5a_item_custom_listview, listDonut);
        listView.setAdapter(adapter);

        findViewById(R.id.btnPinkDonut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Donut donut = listDonut.get(1); //vì ArrayList tính từ 0, 1 là pink donut
                Intent intent = new Intent(MainActivity_5a.this, MainActivity_5b.class);
                intent.putExtra("imgDonut", donut.getImgDonut());
                intent.putExtra("donutName", donut.getDonutName());
                intent.putExtra("donutPrice", donut.getDonutPrice());
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                showInfoPinkDonut(position);
            }
        });
    }

//    private void showInfoPinkDonut(int position){
//        Donut donut = listDonut.get(position);
//        Intent intent = new Intent(MainActivity_5a.this, MainActivity_5b.class);
//        intent.putExtra("donutName", donut.getDonutName());
//        intent.putExtra("donutPrice", donut.getDonutPrice());
//
//        startActivity(intent);
//    }
}