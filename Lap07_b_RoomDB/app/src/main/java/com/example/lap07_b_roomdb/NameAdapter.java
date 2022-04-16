package com.example.lap07_b_roomdb;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {
    private static Name name=new Name();
    private static List<Name> nameArrayList;
    private ItemClickListener itemClickListener;

    public void setData(List<Name> arrayList){
        this.nameArrayList = arrayList;
        notifyDataSetChanged();
    }

    public NameAdapter() {
    }

    public NameAdapter(List<Name> nameArrayList, ItemClickListener itemClickListener) {
        this.nameArrayList = nameArrayList;
        this.itemClickListener = itemClickListener;
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

        holder.itemView.setOnClickListener(view -> {
            itemClickListener.onItemClick(nameArrayList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        if(nameArrayList!=null && !nameArrayList.isEmpty())
            return nameArrayList.size();
        return 0;
    }

    //class interface ItemClickListener
    public interface ItemClickListener{
        void onItemClick(Name name);
    }

    //class NameViewHolder
    public static class NameViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
