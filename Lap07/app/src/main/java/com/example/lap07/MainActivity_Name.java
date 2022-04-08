package com.example.lap07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity_Name extends AppCompatActivity {
    private int layout;
    private ViewGroup viewGroup;
    private ArrayList<Name> nameArrayList;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_name);

//        getSupportFragmentManager().beginTransaction()
//                                    .add(R.id.frmContainer, new FirstFragment(), "name_fragment").commit();



//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
//        NameAdapter nameAdapter=new NameAdapter(view.getContext(), R.layout.item_name, nameArrayList, db);

//        SecondFragment secondFragment=new SecondFragment();
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////               getSupportFragmentManager().beginTransaction()
////                                            .replace(R.id.frmContainer, new SecondFragment(), "second_fragment").commit();
//            }
//        });


    }


}