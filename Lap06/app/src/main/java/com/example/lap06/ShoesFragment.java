package com.example.lap06;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ShoesFragment extends Fragment {
    private ArrayList<Shoes> shoesArrayList = new ArrayList<>();
    private ListView listView;
    private Shoes shoes;
    private ShoesAdapter shoesAdapter;


    public interface SendData{
        public void sendDataToDetail(Shoes dataShoes);
    }
    private SendData sendData;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        sendData = (SendData) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.shoes_fragment, container, false);

        listView = view.findViewById(R.id.lvShoes);

        shoesArrayList.add(new Shoes(1, "Pls touch to see detail", R.drawable.shoes_rm_preview_b, "Nike shoes-discount 50%"));
        shoesArrayList.add(new Shoes(2, "Pls touch to see detail", R.drawable.shoes_rm_preview_a, "Adidas shoes-discount 80%"));
        shoesArrayList.add(new Shoes(3, "Pls touch to see detail", R.drawable.shoes_rm_purple, "Nike Bicycle-discount 30%"));
        shoesArrayList.add(new Shoes(4, "Pls touch to see detail", R.drawable.shoes_rm_preview, "Yonex shoes-discount 50%"));
        shoesArrayList.add(new Shoes(5, "Pls touch to see detail", R.drawable.shoes_rm_yellow, "Victor shoes-discount 50%"));
        shoesArrayList.add(new Shoes(6, "Pls touch to see detail", R.drawable.shoes_white_removebg_preview, "Lining shoes-discount 50%"));
        shoesArrayList.add(new Shoes(7, "Pls touch to see detail", R.drawable.color_removebg_preview, "Binh Minh shoes-discount 90%"));

        shoesAdapter = new ShoesAdapter(listView.getContext(), R.layout.item_shoes, shoesArrayList, sendData);
        listView.setAdapter(shoesAdapter);

//        return inflater.inflate(R.layout.shoesfragment, container, false);
        return view;
    }
}