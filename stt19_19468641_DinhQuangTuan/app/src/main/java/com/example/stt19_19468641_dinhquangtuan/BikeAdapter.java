//package com.example.stt19_19468641_dinhquangtuan;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.List;
//
//public class BikeAdapter extends BaseAdapter {
//    private Context context;
//    private int idLayout;
//    private List<Bike> listBike;
//
//    private MainActivity_screen1 mainActivity_screen1;
//    private MainActivity_screen2 mainActivity_screen2;
//
//    public BikeAdapter(Context context, int idLayout, List<Bike> listBike) {
//        this.context = context;
//        this.idLayout = idLayout;
//        this.listBike = listBike;
//    }
//
//    @Override
//    public int getCount() {
//        if(listBike.size()!=0 && !listBike.isEmpty()){
//            return listBike.size();
//        }
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup viewGroup) {
//        if(convertView==null){
//            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);
//        }
//        ImageView imgBikeLeft =convertView.findViewById(R.id.imgBike_Left),
//                 imgBikeRight =convertView.findViewById(R.id.imgBike_Right);
//        TextView tvBikeNameLeft =convertView.findViewById(R.id.tvName_Left),
//                 tvBikeNameRight =convertView.findViewById(R.id.tvName_Right);
//        return null;
//    }
//}
