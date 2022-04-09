package com.example.lap07;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
    private Name name;
    private ArrayList<Name> nameArrayList;
    private Place place;
    private PlaceAdapter placeAdapter;
    private ArrayList<Place> placeArrayList;
    private DatabaseHandler db;


    ListView lvPlace, lvName;
    TextInputEditText edtPlace;
    Button btnSave, btnCancel;
    ImageView imgUpdate, imgDelete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        db = new DatabaseHandler(view.getContext());

        View viewName = inflater.inflate(R.layout.first_fragment, container, false);
        lvName = viewName.findViewById(R.id.lvName);
        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                name = nameArrayList.get(i);

                placeArrayList = (ArrayList<Place>) db.getAllPlaces(name.getId());
//        placeArrayList = (ArrayList<Place>) db.getAllPlaces(getActivity().getIntent().getIntExtra("id",0));

                placeAdapter=new PlaceAdapter(view.getContext(), R.layout.item_place, placeArrayList, db);
                lvPlace.setAdapter(placeAdapter);
            }
        });

        lvPlace = view.findViewById(R.id.lvPlace);
        edtPlace = view.findViewById(R.id.edtPlace);
        btnSave = view.findViewById(R.id.btnSave);
        btnCancel = view.findViewById(R.id.btnCancel2);
        imgUpdate = view.findViewById(R.id.imgUpdate);
        imgDelete = view.findViewById(R.id.imgDelete);

        cancelPlace();
        savePlace();
        delPlace();
        updateInfoPlace();

        return view;
    }

    public void showListPlaces(){
        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                name = nameArrayList.get(i);

                placeArrayList = (ArrayList<Place>) db.getAllPlaces(name.getId());
//        placeArrayList = (ArrayList<Place>) db.getAllPlaces(getActivity().getIntent().getIntExtra("id",0));
                PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), R.layout.item_place, placeArrayList, db);
                lvPlace.setAdapter(placeAdapter);
            }
        });
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

    public void savePlace() {
        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                name = nameArrayList.get(i);

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String text = edtPlace.getText().toString().trim();
                        if(!text.equals("") && text!=null && text.length()!=0 && place!=null){
                            Toast.makeText(view.getContext(), "Đã thêm "+text, Toast.LENGTH_SHORT).show();
                            db.addPlace(new Place(text), name.getId());
                        }
                        if(text.equals(""))
                            Toast.makeText(view.getContext(), "Vui lòng nhập địa điểm!", Toast.LENGTH_SHORT).show();

                        showListPlaces();
                        edtPlace.setText("");
                    }
                });
            }
        });

    }

    public void delPlace() {
        lvPlace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                place = placeArrayList.get(i);

                view.findViewById(R.id.imgDelete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(place != null){
                            db.deletePlace(place);
                            showListPlaces();
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
}