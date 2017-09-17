package com.example.chanakafernando.sqlitetest.activities;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chanakafernando.sqlitetest.R;
import com.example.chanakafernando.sqlitetest.models.Student;
import com.example.chanakafernando.sqlitetest.utils.DatabaseHelper;

public class StudentData extends AppCompatActivity {
    private TextView studentIndex;
    private TextView firstName;
    private TextView lastName;
    private TextView eMail;
    private TextView mobile;
    private TextView schoolName;

    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);
        firstName =(TextView) findViewById(R.id.tv_fName);
        lastName = (TextView) findViewById(R.id.tv_lName);
        eMail = (TextView) findViewById(R.id.tvEmail);
        mobile = (TextView) findViewById(R.id.tvMobile);
        studentIndex = (TextView) findViewById(R.id.tvStudentId);
        schoolName = (TextView) findViewById(R.id.tvStuSchoolName);
        saveButton = (Button) findViewById(R.id.btnSave);

        //if(!studentIndex.getText().toString().isEmpty() && !firstName.getText().toString().isEmpty() && !lastName.getText().toString().isEmpty()){
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.i("Helper","Initiating to access");
                    Student student = new Student();
                    student.setStudentId( studentIndex.getText().toString());
                    student.setFname(firstName.getText().toString());
                    student.setlName(lastName.getText().toString());
                    student.seteMail(eMail.getText().toString());
                    student.setMobile(mobile.getText().toString());
                    student.setSchoolName(schoolName.getText().toString());

                    DatabaseHelper db = DatabaseHelper.getInstance(StudentData.this);
                    db.addStudent(student);


                }
            });
        }

}
