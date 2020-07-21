package com.expaorbit.interviewproject.model;

/**
 * Created by kajal on 7/20/2020.
 */

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "T_Employee")
public class Employee {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "EmpID")
    private String mEmpID;

    @ColumnInfo(name = "EmpName")
    private String mEmpName;

    @ColumnInfo(name = "Email")
    private String mEmail;

    @ColumnInfo(name = "MobileNo")
    private String mMobileNo;

    public void setEmpID(String empID){
        mEmpID=empID;
    }

    public void setEmpName(String empName){
        mEmpName=empName;
    }

    public void setEmail(String email){
        mEmail=email;
    }

    public void setMobileNo(String mobileNo){
        mMobileNo=mobileNo;
    }

    public String getEmpID(){
        return mEmpID;
    }

    public String getEmpName(){
        return mEmpName;
    }

    public String getEmail(){
        return mEmail;

    }

    public String getMobileNo(){
        return mMobileNo;
    }


}

