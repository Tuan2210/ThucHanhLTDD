package com.example.lap07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

    }

}