package com.expaorbit.interviewproject.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.expaorbit.interviewproject.Constants;
import com.expaorbit.interviewproject.R;
import com.expaorbit.interviewproject.Utilities.KeyboardUtility;
import com.expaorbit.interviewproject.presenter.AddEmployeePresenter;

public class AddEmployeeActivity extends AppCompatActivity implements IFormView {

    EditText empIDEditText;
    EditText empNameEditText;
    EditText emailEditText;
    EditText mobileNoEditText;
    Button saveBtn;
    AddEmployeePresenter addEmpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_add);
        initViews();
        saveBtn.setOnClickListener(this);
        addEmpPresenter=new AddEmployeePresenter(this,AddEmployeeActivity.this);
    }

    public void initViews(){
        empIDEditText=findViewById(R.id.edittext_emp_id);
        empNameEditText=findViewById(R.id.edittext_emp_name);
        emailEditText=findViewById(R.id.edittext_emp_email);
        mobileNoEditText=findViewById(R.id.edittext_emp_mobile_no);
        saveBtn=findViewById(R.id.btn_save_emp_details);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_save_emp_details:
                String empID=empIDEditText.getText().toString().trim();
                String name=empNameEditText.getText().toString().trim();
                String email=emailEditText.getText().toString().trim();
                String mobileNo=mobileNoEditText.getText().toString().trim();
                addEmpPresenter.performSaveOperation(empID,name,email,mobileNo);
                KeyboardUtility.hideKeyboard(this,view);


        }
    }

    @Override
    public void onValidationError(int validationCode){
        switch (validationCode){
            case Constants.ADD_EMPLOYEE_VALIDATION_EMP_ID_ERROR:
                empIDEditText.setError("Please enter valid Employee ID");
                empIDEditText.requestFocus();
                break;
            case Constants.ADD_EMPLOYEE_VALIDATION_DUPLICATE_EMP_ID:
                empIDEditText.setError("Duplicate Employee ID");
                empIDEditText.requestFocus();
                break;
            case Constants.ADD_EMPLOYEE_VALIDATION_NAME_ERROR:
                empNameEditText.setError("Please enter valid name");
                empNameEditText.requestFocus();
                break;
            case Constants.ADD_EMPLOYEE_VALIDATION_EMAIL_ERROR:
                emailEditText.setError("Please enter valid Email ID");
                emailEditText.requestFocus();
                break;
            case Constants.ADD_EMPLOYEE_VALIDATION_MOBILE_NO_ERROR:
                mobileNoEditText.setError("Please enter valid Mobile No");
                mobileNoEditText.requestFocus();
                break;
        }
    }

    @Override
    public void onSubmitFormSuccess() {
        setResult(Constants.RESULT_CODE_EMPLOYEEE_ADDED);
        finish();
    }

    @Override
    public void onSubmitFormFailure() {

    }

    @Override
    public void resetInputs() {
        empIDEditText.setText("");
        empNameEditText.setText("");
        emailEditText.setText("");
        mobileNoEditText.setText("");
    }


}
