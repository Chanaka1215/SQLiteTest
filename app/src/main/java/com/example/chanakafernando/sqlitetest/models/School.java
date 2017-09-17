package com.example.chanakafernando.sqlitetest.models;

/**
 * Created by Chanaka Fernando on 9/17/2017.
 */

public class School {
    private String sName;
    private int sId;
    private String district;
    private int amout;

    public String getsName(){
        return sName;
    }

    public int getSchoolId(){
        return sId;
    }

    public String getDistrict(){
        return district;
    }

    public int getAmout(){
        return amout;
    }

    public void setSchoolName(String school){
        this.sName = school;
    }

    public void setDistrict(String district){
        this.district = district;
    }

    public void setSchoolId(int id){
        this.sId =id;
    }

    public void setAmout(int amount){
        this.amout = amount;
    }
}
