package com.example.lap06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ShoesFragment.SendData{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ShoesFragment shoesFragment = new ShoesFragment();
//        getSupportFragmentManager().beginTransaction()    // add xml là FrameLayout thì add bằng java code
//                                    .add(R.id.frmContainerShoes1, new ShoesFragment(), "shoesfragment")
//                                    .commit();
    }

    @Override
    public void sendDataToDetail(Shoes dataShoes) {
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frmContainerShoes2);
        if (detailFragment != null) {
            detailFragment.showDetail(dataShoes);
        }
    }

}