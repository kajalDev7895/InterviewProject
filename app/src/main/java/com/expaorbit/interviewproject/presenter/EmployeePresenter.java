package com.expaorbit.interviewproject.presenter;

import android.content.Context;

import com.expaorbit.interviewproject.R;
import com.expaorbit.interviewproject.model.EmpDatabase;
import com.expaorbit.interviewproject.model.Employee;
import com.expaorbit.interviewproject.view.IEmployeeView;

/**
 * Created by kajal on 7/20/2020.
 */

public class EmployeePresenter {

    private IEmployeeView mIEmpView;
    private EmpDatabase empDatabase;
    private Context mContext;

    public EmployeePresenter(IEmployeeView empView, Context context){
        mIEmpView=empView;
        mContext=context;
        empDatabase=EmpDatabase.getInstance(context);

    }


    public void searchEmployee(String empID){
        Employee employee=empDatabase.empDAO().searchEmployee(empID);
        if(employee!=null)
            mIEmpView.onSearchSuccess(employee);
        else
           mIEmpView.onSearchFailure(mContext.getString(R.string.message_emp_id_not_exist));

    }
}
