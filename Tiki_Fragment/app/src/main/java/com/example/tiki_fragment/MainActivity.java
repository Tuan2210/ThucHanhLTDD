package com.example.tiki_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vì là FragmentContainerView nên ko add = java code
//        getSupportFragmentManager().beginTransaction()
//                                    .add(R.id.fragmentContainerView1, new FragmentAbove(), "fragmentAbove")
//                                    .commit();
//
//        getSupportFragmentManager().beginTransaction()
//                                    .add(R.id.fragmentContainerView2, new FragmentBelow(), "fragmentBelow")
//                                    .commit();
    }
}