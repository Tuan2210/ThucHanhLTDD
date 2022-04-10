package com.example.lap07;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    private Name name=new Name();
    private ArrayList<Name> nameArrayList;
    private Place place;
    private PlaceAdapter placeAdapter;
    private ArrayList<Place> placeArrayList=new ArrayList<Place>();
    private DatabaseHandler db;


    ListView lvPlace;
    TextInputEditText edtPlace;
    Button btnSave, btnCancel;
    ImageView imgUpdate, imgDelete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);

        lvPlace = view.findViewById(R.id.lvPlace);
        edtPlace = view.findViewById(R.id.edtPlace);
        btnSave = view.findViewById(R.id.btnSave);
        btnCancel = view.findViewById(R.id.btnCancel2);
        imgUpdate = view.findViewById(R.id.imgUpdate);
        imgDelete = view.findViewById(R.id.imgDelete);

        int idName = getActivity().getIntent().getIntExtra("id",0); // receive data idname
        String log = "id_name: "+idName;
        Log.d("secondfragment_idname",log);

        name.setId(idName);

        db = new DatabaseHandler(view.getContext());
        //db.getName(idName);
        placeArrayList = (ArrayList<Place>) db.getAllPlaces(idName);
        placeAdapter=new PlaceAdapter(view.getContext(), R.layout.item_place, placeArrayList, db);
        lvPlace.setAdapter(placeAdapter);

        cancelPlace();

        savePlace(idName, name);
//

        delPlace(name);
        updateInfoPlace();

        return view;
    }

    public void showListPlaces(Name nameInfo){
//                String nameId = String.format("%d",name.getId());
        placeArrayList = (ArrayList<Place>) db.getAllPlaces(nameInfo.getId());
//        placeArrayList = (ArrayList<Place>) db.getAllPlaces(getActivity().getIntent().getIntExtra("id",0));
        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), R.layout.item_place, placeArrayList, db);
        lvPlace.setAdapter(placeAdapter);
    }

    public void cancelPlace() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPlace.setText("");
                place = null;
            }
        });
    }

    public void savePlace(int idName, Name nameInfo) {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtPlace.getText().toString().trim();
                String idNAME = String.format("%d",idName);
                if(!text.equals("") && text!=null && text.length()!=0 && place!=null){

//                    Place place=new Place();
//                    place.setNamePlace(text);
//                    place.setName(nameInfo);
                    try{
                        boolean b1 = new DatabaseHandler(view.getContext()).addPlace(text, nameInfo);
                        if(b1)
                            Toast.makeText(view.getContext(), "Đã thêm "+text, Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(view.getContext(), "Thêm thất bại!", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(text.equals(""))
                    Toast.makeText(view.getContext(), "Vui lòng nhập địa điểm!", Toast.LENGTH_SHORT).show();

                showListPlaces(nameInfo);
                edtPlace.setText("");

                String log = "idname: "+nameInfo.getId();
                Log.d("testIdName_addPlace",log);

                for(Place place : placeArrayList){
                    String log_place = "idplace: "+place.getIdPlace() +" place: "+place.getNamePlace();
                    Log.d("info_place",log_place);
                }
            }
        });
    }

    public void delPlace(Name nameInfo) {
        lvPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                place = placeArrayList.get(i);

                view.findViewById(R.id.imgDelete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(place != null){
                            db.deletePlace(place);
                            showListPlaces(nameInfo);
                        }
                    }
                });
            }
        });


    }

    public void updateInfoPlace() {
        lvPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                place = placeArrayList.get(i);

                view.findViewById(R.id.imgUpdate).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(edtPlace!=null && edtPlace.length()!=0 && place!=null){
                            String text = edtPlace.getText().toString().trim();
                            place.setNamePlace(text);
                            db.updatePlace(place);
                            edtPlace.setText("");
                        }
                    }
                });
            }
        });
    }

//    public void chooseName(Name infoName){
//        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                infoName = nameArrayList.get(i);
//            }
//        });
//    }
}