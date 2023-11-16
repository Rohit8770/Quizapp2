package com.example.quizapp2.Api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.quizapp2.R;

public class ApiActivity extends AppCompatActivity {

    EditText et1;
    Button btn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        et1=findViewById(R.id.et1);
        btn1=findViewById(R.id.btn1);


    }
}