package com.example.lap05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_5a extends AppCompatActivity {
    private List<Donut> listDonut = new ArrayList<>();
    private ListView listView;
    private DonutAdapter donutAdapter;

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

//        EditText edtSearch = findViewById(R.id.edtSearch);
//        edtSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                donutAdapter.getFilter().filter(charSequence.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });

//        SearchView svDonut = findViewById(R.id.svDonut);
//        svDonut.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                donutAdapter.getFilter().filter(s);
//                return false;
//            }
//        });
    }
}