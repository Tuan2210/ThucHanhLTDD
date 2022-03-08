package com.example.lap04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class activity_4a_main extends AppCompatActivity {
    private List<Goods> listGoods;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4a_main);

        listView = (ListView) findViewById(R.id.listView);
        listGoods = new ArrayList<>();
        listGoods.add(new Goods(1, "Ca nấu lẩu, nấu mì mini...", "Shop Devang", R.drawable.ca_nau_lau));
        listGoods.add(new Goods(2, "1KG KHÔ GÀ BƠ TỎI...", "Shop LTD Food", R.drawable.ga_bo_toi));
        listGoods.add(new Goods(3, "Xe cần cẩu đa năng", "Shop Thế giới đồ chơi", R.drawable.xe_can_cau));
        listGoods.add(new Goods(4, "Đồ chơi dạng mô hình", "Shop Thế giới đồ chơi", R.drawable.do_choi_dang_mo_hinh));
        listGoods.add(new Goods(5, "Lãnh đạo giản đơn", "Shop Minh Long Book", R.drawable.lanh_dao_gian_don));
        listGoods.add(new Goods(6, "Hiểu lòng con trẻ", "Shop Minh Long Book", R.drawable.hieu_long_con_tre));

        GoodsAdapter adapter = new GoodsAdapter(this, R.layout.activity_4a_item_custom_listview, listGoods);
        listView.setAdapter(adapter);
    }
}