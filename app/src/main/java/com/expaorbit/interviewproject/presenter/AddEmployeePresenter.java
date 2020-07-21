package com.expaorbit.interviewproject.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import com.expaorbit.interviewproject.Constants;
import com.expaorbit.interviewproject.model.EmpDatabase;
import com.expaorbit.interviewproject.model.Employee;
import com.expaorbit.interviewproject.view.IFormView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kajal on 7/21/2020.
 */

public class AddEmployeePresenter {
    private IFormView mFormView;
    private EmpDatabase empDatabase;

    public AddEmployeePresenter(IFormView formView, Context context){
        mFormView=formView;
        empDatabase=EmpDatabase.getInstance(context);
    }

    public void addEmployee(Employee employee){
        empDatabase.empDAO().insert(employee);

          }
    public int validateEmployeeDetails(String empID,String name,String email,String mobileNo)
    {
        if(empID.isEmpty())
            return Constants.ADD_EMPLOYEE_VALIDATION_EMP_ID_ERROR;
        else if(empDatabase.empDAO().doesEmpIDExist(empID)>0)
            return Constants.ADD_EMPLOYEE_VALIDATION_DUPLICATE_EMP_ID;
        else if(name.isEmpty())
            return Constants.ADD_EMPLOYEE_VALIDATION_NAME_ERROR;
        else if(!isValidEmail(email))
            return Constants.ADD_EMPLOYEE_VALIDATION_EMAIL_ERROR;
        else if(!isValidMobileNo(mobileNo))
            return Constants.ADD_EMPLOYEE_VALIDATION_MOBILE_NO_ERROR;
        return Constants.VALIDATION_SUCCESSFUL;

    }
    public void performSaveOperation(String empID,String name,String email,String mobileNo){

        int validationCode = validateEmployeeDetails(empID,name,email,mobileNo);

        if(validationCode == Constants.VALIDATION_SUCCESSFUL)
        {
            Employee employee=new Employee();
            employee.setEmpID(empID);
            employee.setEmpName(name);
            employee.setEmail(email);
            employee.setMobileNo(mobileNo);
            addEmployee(employee);
            mFormView.onSubmitFormSuccess();
        }
        else
        {
            mFormView.onValidationError(validationCode);
        }


    }

    public boolean isValidEmail(String email){
        String Email_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(Email_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidMobileNo(String mobileNo){
        if(mobileNo.length()<10)
            return false;
        if (!TextUtils.isEmpty(mobileNo)) {
            return Patterns.PHONE.matcher(mobileNo).matches();
        }
        return false;
    }
}
