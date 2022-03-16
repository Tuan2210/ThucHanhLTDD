package com.example.lap05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_5a extends AppCompatActivity {
    private List<Donut> listDonut;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5a_main);

        //        MainActivity_5a.this.startActivity(new Intent(MainActivity_5a.this, MainActivity_5b.class));

        listView = findViewById(R.id.lvDonuts);
        listDonut = new ArrayList<>();
        listDonut.add(new Donut(1, "Tasty Donut", "$10.00", R.drawable.donut_yellow_1));
        listDonut.add(new Donut(2, "Pink Donut", "$20.00", R.drawable.tasty_donut_1));
        listDonut.add(new Donut(3, "Floating Donut", "$30.00", R.drawable.green_donut_1));
        listDonut.add(new Donut(4, "Tasty Donut", "$40.00", R.drawable.donut_red_1));

        DonutAdapter adapter = new DonutAdapter(this, R.layout.activity_5a_item_custom_listview, listDonut);
        listView.setAdapter(adapter);
    }
}