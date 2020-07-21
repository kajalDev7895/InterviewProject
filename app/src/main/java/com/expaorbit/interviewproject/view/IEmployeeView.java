package com.expaorbit.interviewproject.view;

import android.view.View;

import com.expaorbit.interviewproject.model.Employee;

/**
 * Created by kajal on 7/20/2020.
 */

public interface IEmployeeView extends View.OnClickListener{


    void onSearchSuccess(Employee employee);
    void onSearchFailure(String errorMessage);
    void reset();
}
