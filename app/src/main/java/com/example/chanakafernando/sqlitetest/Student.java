package com.example.chanakafernando.sqlitetest;

import java.util.Map;

/**
 * Created by Chanaka Fernando on 9/17/2017.
 */

public class Student {
    private Map data;
    private String fname;
    private String lName;
    private String mobile;
    private String eMail;
    private String sId;

    public void Student(Map body){
        this.data = body;
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

    public void setsId(String sId){
        this.sId = sId;
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

    public String getsId(){
        return sId;
    }

}
