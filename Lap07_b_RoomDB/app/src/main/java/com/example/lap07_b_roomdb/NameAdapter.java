package com.example.lap07_b_roomdb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {
    private List<Name> nameArrayList;

    public void setData(List<Name> arrayList){
        this.nameArrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NameAdapter.NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);

        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        Name name = nameArrayList.get(position);
        if(name==null)
            return;
        holder.tvName.setText(name.getName());
    }

    @Override
    public int getItemCount() {
        if(nameArrayList!=null && !nameArrayList.isEmpty())
            return nameArrayList.size();
        return 0;
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
