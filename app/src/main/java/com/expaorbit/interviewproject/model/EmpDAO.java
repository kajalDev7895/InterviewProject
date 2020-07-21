package com.expaorbit.interviewproject.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by kajal on 7/20/2020.
 */

@Dao
public interface EmpDAO {

    @Query("SELECT * FROM T_Employee")
    List<Employee> getAll();

//    @Query("INSERT INTO T_Employee values (:empID,:empName,:email,:mobileNo)")
//    void addEmployee(String empID,String empName,String email,String mobileNo);

    @Query("SELECT * FROM T_Employee where EmpId= :empID")
    Employee searchEmployee(String empID);


    @Query("SELECT count(*) FROM T_Employee where EmpId= :empID")
    int doesEmpIDExist(String empID);

    @Insert
    void insert(Employee employee);

    @Update
    void update(Employee employee);

    @Delete
    void delete(Employee employee);

    @Delete
    void delete(Employee... employees);

}
