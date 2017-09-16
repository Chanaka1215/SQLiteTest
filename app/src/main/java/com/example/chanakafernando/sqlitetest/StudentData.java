package com.example.chanakafernando.sqlitetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentData extends AppCompatActivity {
    private TextView firstName;
    private TextView lastName;
    private TextView eMail;
    private TextView mobile;
    private TextView studentId;

    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);
        firstName =(TextView) findViewById(R.id.tv_fName);
        lastName = (TextView) findViewById(R.id.tv_lName);
        eMail = (TextView) findViewById(R.id.tvEmail);
        mobile = (TextView) findViewById(R.id.tvMobile);
        studentId = (TextView) findViewById(R.id.tvId);
        saveButton = (Button) findViewById(R.id.btnSave);

        if(!firstName.getText().toString().isEmpty() && !lastName.getText().toString().isEmpty() && !studentId.getText().toString().isEmpty()){
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Student student = new Student();
                    student.setFname(firstName.getText().toString());
                    student.setlName(lastName.getText().toString());
                    student.seteMail(eMail.getText().toString());
                    student.setMobile(mobile.getText().toString());
                    student.setsId(studentId.getText().toString());
                }
            });
        }



    }
}
