package com.example.quizapp2.Quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quizapp2.R;

public class Start extends AppCompatActivity {
Button bt1;
EditText etname;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        bt1=findViewById(R.id.bt1);
        etname=findViewById(R.id.etName);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Start.this, MainActivity.class);
                startActivity(intent);
            }
        });
        etname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isChild()){

                }
            }
        });

    }
}