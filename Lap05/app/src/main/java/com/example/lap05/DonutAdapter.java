package com.example.lap05;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class DonutAdapter extends BaseAdapter implements Filterable {
    private Context context;
    private int idLayout;
    private List<Donut> listDonut;
    private int positionSelect = -1;

    private MainActivity_5a mainActivity_5a;
    private MainActivity_5b mainActivity_5b;

    //private ItemFilter itemFilter = new ItemFilter();

    public DonutAdapter(Context context, int idLayout, List<Donut> listDonut) {
        this.context = context;
        this.idLayout = idLayout;
        this.listDonut = listDonut;
    }

    @Override
    public int getCount() {
        if(listDonut.size()!=0 && !listDonut.isEmpty()){
            return listDonut.size();
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
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        if(convertView==null){
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);
        }
        ImageView imgDonut = convertView.findViewById(R.id.imgDonut);
        TextView tvDonutName = convertView.findViewById(R.id.tvDonutName),
                tvPrice = convertView.findViewById(R.id.tvPrice);

        final LinearLayout linearLayout = convertView.findViewById(R.id.idLinearLayout);
        final Donut donut = listDonut.get(position);

        if(listDonut!=null && !listDonut.isEmpty()){
            imgDonut.setImageResource(donut.getImgDonut());
            tvDonutName.setText(donut.getDonutName());
            tvPrice.setText(donut.getDonutPrice());
            int idDonut = donut.getId();
//            switch (idDonut){
//                case 1:
//                    imgDonut.setImageResource(R.drawable.donut_yellow_1);
//                    break;
//                case 2:
//                    imgDonut.setImageResource(R.drawable.tasty_donut_1);
//                    break;
//                case 3:
//                    imgDonut.setImageResource(R.drawable.green_donut_1);
//                    break;
//                case 4:
//                    imgDonut.setImageResource(R.drawable.donut_red_1);
//                    break;
//                default:
//                    break;
//            }
        }

        //truyền data sang activity khác
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, donut.getDonutName(), Toast.LENGTH_LONG).show();
                positionSelect = position;

                Intent intent = new Intent(view.getContext(), MainActivity_5b.class);
                intent.putExtra("imgDonut", donut.getImgDonut());
                intent.putExtra("donutName", donut.getDonutName());
                intent.putExtra("donutPrice", donut.getDonutPrice());
                view.getContext().startActivity(intent);

                notifyDataSetChanged();
            }
        });

//        if (positionSelect == position) {
//            linearLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(mainActivity_5a, mainActivity_5b.getClass());
//                    mainActivity_5a.startActivity(intent);
//                }
//            });
//        }

        //tìm kiếm
        //mainActivity_5a.findViewById(R.id.svDonut);

        //EditText edtSearch = mainActivity_5a.findViewById(R.id.edtSearch);
//        edtSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return filterDonut;
    }

    private Filter filterDonut = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Donut> filterListDonut = new ArrayList<>();

            if(charSequence==null || charSequence.length()==0 || charSequence.toString().isEmpty())
                filterListDonut.addAll(listDonut);
            else{
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for(Donut donut : listDonut){
                    if(donut.getDonutName().toLowerCase().contains(filterPattern));
                        filterListDonut.add(donut);
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filterListDonut;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            listDonut.clear();
            listDonut.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };



//    private class ItemFilter extends Filter {
//
//        @Override
//        protected FilterResults performFiltering(CharSequence charSequence) {
//            return null;
//        }
//
//        @Override
//        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//
//        }
//    }
}
