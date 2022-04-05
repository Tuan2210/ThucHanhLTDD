package com.example.demo_share_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText edtInput;
    private TextView textView;

    private String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText edtInput = findViewById(R.id.edtInput);
        TextView textView = findViewById(R.id.tvTextData);

        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(edtInput.getText().toString());
            }
        });

        findViewById(R.id.btnSaveData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        loadData();
        updateView();
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharePrefs", MODE_PRIVATE);
        SharedPreferences .Editor editor = sharedPreferences.edit();

        editor.putString("text", textView.getText().toString());

        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("sharePrefs", MODE_PRIVATE);
        txt = sharedPreferences.getString("text", "");
    }

    public void updateView(){
        textView.setText(txt);
    }
}