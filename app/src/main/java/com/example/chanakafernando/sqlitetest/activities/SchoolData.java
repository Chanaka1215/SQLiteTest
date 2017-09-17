package com.example.chanakafernando.sqlitetest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chanakafernando.sqlitetest.R;
import com.example.chanakafernando.sqlitetest.models.School;
import com.example.chanakafernando.sqlitetest.utils.DatabaseHelper;

import org.w3c.dom.Text;

public class SchoolData extends AppCompatActivity {

    private TextView schoolId;
    private TextView schoolName;
    private TextView district;
    private TextView amount;
    private Button sDataSaveButton;
    private Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_data);
        //schoolId = (TextView) findViewById(R.id.tvSchoolId);
        schoolName = (TextView) findViewById(R.id.tvSchoolName);
        district = (TextView) findViewById(R.id.tvDistrict);
        amount = (TextView) findViewById(R.id.tvAmount);
        sDataSaveButton = (Button) findViewById(R.id.btnSsave);
        test = (Button) findViewById(R.id.btnTest);


        //if( !schoolName.getText().toString().isEmpty() && !district.getText().toString().isEmpty()){
        sDataSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final School school = new School();
                // school.setSchoolId(Integer.parseInt(schoolId.getText().toString()));
                Toast.makeText(SchoolData.this, "Sucesss =>" + schoolName.getText().toString(), Toast.LENGTH_LONG).show();
                school.setSchoolName(schoolName.getText().toString());
                school.setAmout(Integer.parseInt(amount.getText().toString()));
                school.setDistrict(district.getText().toString());

                // Get singleton instance of database
                DatabaseHelper databaseHelper = DatabaseHelper.getInstance(SchoolData.this);
                databaseHelper.addSchool(school);


            }
        });

    }


}
