package com.example.lap04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class activity_4b_main extends AppCompatActivity {
    private List<Goods_4b> listGoods;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4b_main);

        listView = findViewById(R.id.listView_4b);
        listGoods = new ArrayList<>();
        listGoods.add(new Goods_4b(1, R.drawable.giacchuyen_1));
        listGoods.add(new Goods_4b(2, R.drawable.daucam_1));
        listGoods.add(new Goods_4b(3, R.drawable.dauchuyendoipsps2_1));
        listGoods.add(new Goods_4b(4, R.drawable.dauchuyendoi_1));
        listGoods.add(new Goods_4b(5, R.drawable.carbusbtops2_1));
        listGoods.add(new Goods_4b(6, R.drawable.daucam_1));

        GoodsAdapter_4b adapter = new GoodsAdapter_4b(this, R.layout.activity_4b_item_custom_listview, listGoods);
        listView.setAdapter(adapter);
    }
}