package com.example.lap07;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    private Name name;
    private NameAdapter nameAdapter;
    private ArrayList<Name> nameArrayList;
    private DatabaseHandler db;

    ListView listView;
    TextInputEditText edtName;
    Button btnAdd, btnRemove, btnCancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.first_fragment, container, false);

        db = new DatabaseHandler(view.getContext());
        nameArrayList = new ArrayList<Name>();
        nameArrayList = (ArrayList<Name>) db.getAllNames();

        listView = view.findViewById(R.id.lvName);
        edtName = view.findViewById(R.id.edtName);
        btnAdd = view.findViewById(R.id.btnAdd);
        btnRemove = view.findViewById(R.id.btnRemove);
        btnCancel = view.findViewById(R.id.btnCancel);

        nameAdapter = new NameAdapter(view.getContext(), R.layout.item_name, nameArrayList, db);
        listView.setAdapter(nameAdapter);

        addName();
        removeName();
        cancelName();

        //getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE); //resize fragment khi bàn phím (keyboard) xuất hiện

        return view;
    }

    public void showListNames() {
        nameArrayList = (ArrayList<Name>) db.getAllNames();
        NameAdapter nameAdapter = new NameAdapter(getContext(), R.layout.item_name, nameArrayList, db);
        listView.setAdapter(nameAdapter);
    }

    public void addName(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtName.getText().toString().trim();
                if(!text.equals("") && text!=null && text.length()!=0) {
                    Toast.makeText(view.getContext(), ""+text+" đã được thêm!", Toast.LENGTH_SHORT).show();
                    db.addName(new Name(text));
                }
                if(text.equals(""))
                    Toast.makeText(view.getContext(), "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show();

                showListNames();
                edtName.setText("");
            }
        });
    }

    public void removeName() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                name = nameArrayList.get(i);
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name != null) {
                    db.deleteName(name);
                    showListNames();
                }
                else
                    Toast.makeText(view.getContext(), "Vui lòng chọn tên để xóa!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cancelName() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtName.setText("");
                name = null;
            }
        });
    }

}