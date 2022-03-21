package com.example.lap05;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity_5a extends AppCompatActivity {
    private List<Donut> listDonut = new ArrayList<>();
    private ListView listView;
    private DonutAdapter donutAdapter;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5a_main);

        listView = findViewById(R.id.lvDonuts);

        listDonut.add(new Donut(1, "Tasty Donut", "$10.00", R.drawable.donut_yellow_1, "tasty1"));
        listDonut.add(new Donut(2, "Pink Donut", "$20.00", R.drawable.tasty_donut_1, "pink"));
        listDonut.add(new Donut(3, "Floating Donut", "$30.00", R.drawable.green_donut_1, "floating"));
        listDonut.add(new Donut(4, "Tasty Donut", "$40.00", R.drawable.donut_red_1, "tasty2"));

        Button btnDonut = findViewById(R.id.btnDonut),
               btnPinkDonut = findViewById(R.id.btnPinkDonut),
               btnFloating = findViewById(R.id.btnFloating);

        btnDonut.setBackgroundColor(Color.parseColor("#C4C4C4"));
        btnPinkDonut.setBackgroundColor(Color.parseColor("#C4C4C4"));
        btnFloating.setBackgroundColor(Color.parseColor("#C4C4C4"));

        //all donut
        btnDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DonutAdapter adapter = new DonutAdapter(listView.getContext(), R.layout.activity_5a_item_custom_listview, listDonut);
                listView.setAdapter(adapter);

                btnDonut.setBackgroundColor(Color.parseColor("#F1B000"));
                btnPinkDonut.setBackgroundColor(Color.parseColor("#C4C4C4"));
                btnFloating.setBackgroundColor(Color.parseColor("#C4C4C4"));
            }
        });

        //lọc theo pinkdonut
        btnPinkDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Donut donut = listDonut.get(1); //vì ArrayList tính từ 0, 1 là pink donut
//                Intent intent = new Intent(MainActivity_5a.this, MainActivity_5b.class);
//                intent.putExtra("imgDonut", donut.getImgDonut());
//                intent.putExtra("donutName", donut.getDonutName());
//                intent.putExtra("donutPrice", donut.getDonutPrice());
//                startActivity(intent);

                List<Donut> lstPinkDonut = new ArrayList<>();
                for(Donut pinkDonut : listDonut){
                    if(pinkDonut.getDonutName().equals("Pink Donut")) //ko cần loại donut nếu mỗi loại 1 cái
                    //if(pinkDonut.getLoaiDonut().equalsIgnoreCase("pink") //mỗi loại nhiều cái
                        lstPinkDonut.add(pinkDonut);
                }
                DonutAdapter donutAdapter = new DonutAdapter(listView.getContext(), R.layout.activity_5a_item_custom_listview, lstPinkDonut);
                listView.setAdapter(donutAdapter);

                btnPinkDonut.setBackgroundColor(Color.parseColor("#F1B000"));
                btnDonut.setBackgroundColor(Color.parseColor("#C4C4C4"));
                btnFloating.setBackgroundColor(Color.parseColor("#C4C4C4"));
            }
        });

        //lọc theo floatingdonut
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Donut> lstFloating = new ArrayList<>();
                for(Donut floatingDonut : listDonut){
                    if(floatingDonut.getDonutName().equals("Floating Donut"))
                        lstFloating.add(floatingDonut);
                }
                DonutAdapter donutAdapter = new DonutAdapter(listView.getContext(), R.layout.activity_5a_item_custom_listview, lstFloating);
                listView.setAdapter(donutAdapter);

                btnFloating.setBackgroundColor(Color.parseColor("#F1B000"));
                btnPinkDonut.setBackgroundColor(Color.parseColor("#C4C4C4"));
                btnDonut.setBackgroundColor(Color.parseColor("#C4C4C4"));
            }
        });

        //tìm kiếm
        EditText edtSearch = findViewById(R.id.edtSearch);
        edtSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(view.getId()==R.id.edtSearch && keyEvent.getAction()==KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER) {
                    String text = edtSearch.getText().toString();
                    List<Donut> listSearch = new ArrayList<>();
                    ListView listView = findViewById(R.id.lvDonuts);

                    for (Donut donut : listDonut) {
                        if (donut.getDonutName().contains(text))
                            listSearch.add(donut);
                        if(!donut.getDonutName().contains(text))
                            Toast.makeText(listView.getContext(), "Không tìm thấy donut!", Toast.LENGTH_SHORT).show();
                        if(edtSearch.getText().toString().equals(""))
                            Toast.makeText(listView.getContext(), "Chưa nhập tên donut tìm kiếm!", Toast.LENGTH_SHORT).show();
                    }

                    DonutAdapter donutAdapter = new DonutAdapter(listView.getContext(), R.layout.activity_5a_item_custom_listview, listSearch);
                    listView.setAdapter(donutAdapter);
                }
                return false;
            }
        });
    }
}