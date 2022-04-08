package com.example.lap07;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class PlaceAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Place> placeArrayList;
    private DatabaseHandler db;

    public PlaceAdapter(Context context, int layout, ArrayList<Place> placeArrayList, DatabaseHandler db) {
        this.context = context;
        this.layout = layout;
        this.placeArrayList = placeArrayList;
        this.db = db;
    }

    @Override
    public int getCount() {
        if(placeArrayList!=null & !placeArrayList.isEmpty())
            return placeArrayList.size();
        return 0;
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

        TextView tvPlace = view.findViewById(R.id.tvPlace);
        ImageView imgUpdate = view.findViewById(R.id.imgUpdate),
                imgDelete = view.findViewById(R.id.imgDelete);
        final ConstraintLayout layoutPlace = view.findViewById(R.id.layoutPlace);
        final Place place = placeArrayList.get(i);

        if(placeArrayList!=null && !placeArrayList.isEmpty()){
            int id = place.getIdPlace();
            tvPlace.setText(place.getNamePlace());
            imgUpdate.setImageResource(place.getImgUpdate());
            imgDelete.setImageResource(place.getImgDelete());
        }
        return view;
    }
}
