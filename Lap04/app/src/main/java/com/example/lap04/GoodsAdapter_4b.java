package com.example.lap04;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GoodsAdapter_4b extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Goods_4b> listGoods;
    private int positionSelect = -1;

    public GoodsAdapter_4b(Context context, int idLayout, List<Goods_4b> listLanguage) {
        this.context = context;
        this.idLayout = idLayout;
        this.listGoods = listLanguage;
    }

    @Override
    public int getCount() {
        if (listGoods.size() != 0 && !listGoods.isEmpty()) {
            return listGoods.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        ImageView imageViewLeft = (ImageView) convertView.findViewById(R.id.imgGoods_4b_left),
                  imageViewRight = (ImageView) convertView.findViewById(R.id.imgGoods_4b_right);
//        TextView  tvGoodsNameLeft = (TextView) convertView.findViewById(R.id.tvGoodsName_4b_left),
//                  tvGoodsNameRight = (TextView) convertView.findViewById(R.id.tvGoodsName_4b_right),
//                  tv15Left = (TextView) convertView.findViewById(R.id.tv15_left),
//                  tv15Right = (TextView) convertView.findViewById(R.id.tv15_right),
//                  tvPriceLeft = (TextView) convertView.findViewById(R.id.tvPrice_left),
//                  tvPriceRight = (TextView) convertView.findViewById(R.id.tvPrice_right),
//                  tvSaleLeft = (TextView) convertView.findViewById(R.id.tvSale_left),
//                  tvSaleRight = (TextView) convertView.findViewById(R.id.tvSale_right);
        final LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.idLinearLayout);
        final Goods_4b goods = listGoods.get(position);

        if (listGoods != null && !listGoods.isEmpty()) {
            int idLanguage = goods.getId();
            switch (idLanguage) {
                case 1:
                    imageViewLeft.setImageResource(R.drawable.giacchuyen_1);
                    imageViewRight.setImageResource(R.drawable.daynguon_1);
                    break;
                case 2:
                    imageViewLeft.setImageResource(R.drawable.dauchuyendoipsps2_1);
                    imageViewRight.setImageResource(R.drawable.dauchuyendoi_1);
                    break;
                case 3:
                    imageViewLeft.setImageResource(R.drawable.carbusbtops2_1);
                    imageViewRight.setImageResource(R.drawable.daucam_1);
                    break;
                default:
                    break;
            }
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, goods.getId(), Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();
            }
        });

        if (positionSelect == position) {
            linearLayout.setBackgroundColor(Color.WHITE);
        } else {
            linearLayout.setBackgroundColor(Color.LTGRAY);
        }
        return convertView;
    }
}
