package com.example.lap06;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class ShoesAdapter extends BaseAdapter {
    // 3 arguments (tham số)
    private Context context;
    private int layout;
    private ArrayList<Shoes> shoesArrayList;
    private int positionSelected = -1;

    private ShoesFragment.SendData sendData;

    public ShoesAdapter(Context context, int layout, ArrayList<Shoes> shoesArrayList, ShoesFragment.SendData sendData) {
        this.context = context;
        this.layout = layout;
        this.shoesArrayList = shoesArrayList;
        this.sendData = sendData;
    }

    @Override
    public int getCount() {
//        if(shoesArrayList.size()!=0 && !shoesArrayList.isEmpty())
//            return shoesArrayList.size();
//        return 0;
        return shoesArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);

        ImageView imgShoes = view.findViewById(R.id.imgShoes);
        TextView tvShoesName = view.findViewById(R.id.tvShoesName),
                 tvTouch = view.findViewById(R.id.tvTouch);
        final ConstraintLayout idLayout = view.findViewById(R.id.idLayout);
        final ConstraintLayout layoutItem = view.findViewById(R.id.layoutItem);
        final Shoes shoes = shoesArrayList.get(i);

        if(shoesArrayList!=null && !shoesArrayList.isEmpty()){
            int id = shoes.getId();
            imgShoes.setImageResource(shoes.getImage());
            tvShoesName.setText(shoes.getName());
            tvTouch.setText(shoes.getDescription());
        }

        if(positionSelected == i)
            layoutItem.setBackgroundResource(R.drawable.view_item_shoes_choose);
        else
            layoutItem.setBackgroundResource(R.drawable.view_item_shoes);

        //truyền data
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, shoes.getName(), Toast.LENGTH_LONG).show();
                positionSelected = i;

                sendData.sendDataToDetail(shoes);

//                Bundle bundle=new Bundle();
//                bundle.putInt("image", shoes.getImage());
//
//                DetailFragment detailFragment=new DetailFragment();
//                ShoesFragment shoesFragment=new ShoesFragment();
//                detailFragment.setArguments(bundle);
//                if(detailFragment.getActivity() != null && shoesFragment != null) {
//                    shoesFragment.getActivity().getSupportFragmentManager().beginTransaction()
//                            .remove(shoesFragment)
//                            .commit();
//                    detailFragment.getActivity().getSupportFragmentManager().beginTransaction()
//                            .add(R.id.frmContainerShoes2, detailFragment)
//                            .commit();
//                }
            }
        });

        return view;
    }
}
