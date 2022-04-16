package com.example.lap07_b_roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private Name name;
    private NameAdapter nameAdapter=new NameAdapter();
    private List<Name> nameArrayList=new ArrayList<>();

    RecyclerView rcvName;
    TextInputEditText edtName;
    Button btnAdd, btnRemove, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        btnCancel = findViewById(R.id.btnCancel);
        rcvName = findViewById(R.id.rcvName);

        showListNames();

        addName();
    }

    public void showListNames(){
        nameArrayList = AppDatabase.getInstance(this).nameDao().getAllNames();
        nameAdapter.setData(nameArrayList);

        nameAdapter = new NameAdapter(nameArrayList, new NameAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Name nameChoose) {
                showToast(nameChoose.getName() +" đc chọn");

                String log = "id: " +nameChoose.getId() +", name: " +nameChoose.getName();
                Log.d("test name đc chọn: ", log);

                deleteName(nameChoose);
                cancelName(nameChoose);
            }
        });

        rcvName.setLayoutManager(new LinearLayoutManager(this));
        rcvName.setAdapter(nameAdapter);
    }

    public void addName(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtName.getText().toString().trim();
                if(!text.equals("") && text!=null && text.length()!=0) {
                    AppDatabase.getInstance(view.getContext()).nameDao().insert(new Name(text));
                    Toast.makeText(view.getContext(), ""+text+" đã được thêm!", Toast.LENGTH_SHORT).show();
                }
                if(text.equals(""))
                    Toast.makeText(view.getContext(), "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show();

                showListNames();
                edtName.setText("");
            }
        });
    }

    public void deleteName(Name nameChoose){
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameChoose != null) {
                    AppDatabase.getInstance(view.getContext()).nameDao().delete(nameChoose);
                    showListNames();
                    Toast.makeText(view.getContext(), "" +nameChoose +" đã xóa", Toast.LENGTH_SHORT).show();
                }
                if(nameChoose==null)
                    Toast.makeText(view.getContext(), "Vui lòng chọn tên để xóa!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cancelName(Name nameChoose) {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtName.setText("");
//                Name name = new Name();
//                if(name == nameChoose)
//                    name = null;
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();;
    }
}