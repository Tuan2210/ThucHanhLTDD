package com.example.lap07;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class NameAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Name> nameArrayList;
    private DatabaseHandler db;
    private int positionSelect = -1;

    public NameAdapter(Context context, int layout, ArrayList<Name> nameArrayList, DatabaseHandler db) {
        this.context = context;
        this.layout = layout;
        this.nameArrayList = nameArrayList;
        this.db = db;
    }

    @Override
    public int getCount() {
        if(nameArrayList!=null && !nameArrayList.isEmpty())
            return nameArrayList.size();
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

        ListView listView = view.findViewById(R.id.lvName);
        Button btnRemove = view.findViewById(R.id.btnRemove);
        TextView tvName = view.findViewById(R.id.tvName);
        final ConstraintLayout layoutName = view.findViewById(R.id.layoutName);
        final Name name = nameArrayList.get(i);

        if(nameArrayList!=null && !nameArrayList.isEmpty()){
            int id = name.getId();
            tvName.setText(name.getName());
        }

        if(positionSelect==i)
            layoutName.setBackgroundColor(Color.parseColor("#B3008C5A"));
        else
            layoutName.setBackgroundColor(Color.parseColor("#B36FBDA1"));

        return view;
    }

}
