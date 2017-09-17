package com.example.chanakafernando.sqlitetest.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chanakafernando.sqlitetest.R;

public class SplashActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(SplashActivity.this,StudentData.class);
//                startActivity(intent);
//            }
//        },3000);

        Button student =(Button) findViewById(R.id.btnStudent);
        Button school =(Button) findViewById(R.id.btnSchool);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stuI = new Intent(SplashActivity.this,StudentData.class);
                startActivity(stuI);
            }
        });

        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schI = new Intent(SplashActivity.this,SchoolData.class);
                startActivity(schI);
            }
        });

    }
}
