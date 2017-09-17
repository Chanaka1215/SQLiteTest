package com.example.chanakafernando.sqlitetest.models;

import java.util.Map;

/**
 * Created by Chanaka Fernando on 9/17/2017.
 */

public class Student {
    private Map data;
    private String index;
    private String fname;
    private String lName;
    private String mobile;
    private String eMail;
    private String schoolName;

    public void Student(Map body){
        this.data = body;
    }

    public void setStudentId(String studentId){
        this.index = studentId;
    }

    public void setFname(String fname){
        this.fname = fname;
    }

    public void setlName(String lname){
        this.lName = lname;
    }

    public void seteMail(String eMail){
        this.eMail = eMail;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    public String getStudentId(){
        return this.index;
    }

    public String getFname(){
        return fname;
    }

    public String getlName(){
        return  lName;
    }

    public String getMobile(){
        return mobile;
    }

    public String geteMail(){
        return eMail;
    }

    public String getsSchoolName(){
        return schoolName;
    }

}
