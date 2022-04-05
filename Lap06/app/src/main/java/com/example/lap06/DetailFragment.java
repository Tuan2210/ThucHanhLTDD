package com.example.lap06;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DetailFragment extends Fragment {
    private ImageView imgDetailShoes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

//        Bundle bundle = this.getArguments();
//        if(bundle!=null) {
//            int img = bundle.getInt("image", 0);
            imgDetailShoes = view.findViewById(R.id.imgDetailShoes);
//            imgDetailShoes.setImageResource(img);
//        }

        return view;
    }

    public void showDetail(Shoes shoes){
        if(shoes!=null){
            imgDetailShoes.setImageResource(shoes.getImage());
        }
    }
}