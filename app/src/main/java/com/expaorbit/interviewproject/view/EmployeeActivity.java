package com.expaorbit.interviewproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.expaorbit.interviewproject.Constants;
import com.expaorbit.interviewproject.R;
import com.expaorbit.interviewproject.Utilities.KeyboardUtility;
import com.expaorbit.interviewproject.model.Employee;
import com.expaorbit.interviewproject.presenter.EmployeePresenter;

public class EmployeeActivity extends AppCompatActivity implements IEmployeeView {

    EditText empIdEditText;
    Button searchBtn,addEmpBtn;
    EmployeePresenter empPresenter;
    WebView empDetailsWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        searchBtn.setOnClickListener(this);
        addEmpBtn.setOnClickListener(this);
        empPresenter=new EmployeePresenter(this,EmployeeActivity.this);


    }


    public void initViews(){
        empIdEditText=findViewById(R.id.edittext_emp_id);
        searchBtn=findViewById(R.id.btn_search);
        addEmpBtn=findViewById(R.id.btn_add_emp);
        empDetailsWebView=findViewById(R.id.webview_searched_emp_details);
    }



    @Override
    public void onSearchSuccess(Employee employee){
        String details=getHTMLTableString(employee);
        empDetailsWebView.setVisibility(View.VISIBLE);
        empDetailsWebView.loadDataWithBaseURL(null,details,"text/html", "utf-8", null);

    }

    @Override
    public void onSearchFailure(String errorMessage){
        Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show();
        reset();
    }

    private String getHTMLTableString(Employee employee)
    {
        return "<html><head><title>Employee Details</title></head><body> <font color = \"#444444\" ><table style=\"width: 100%;\" border = \"1\" align=\"center\" cellpadding = \"5\" cellspacing = \"0\" ><tr align=\"center\"><th>EmpID</th><td>"+employee.getEmpID()+"</td><tr align=\"center\"><th>Name</th><td>"+employee.getEmpName()+"</td></tr><tr align=\"center\"><th>Email</th><td>"+employee.getEmail()+"</td></tr><tr align=\"center\"><th>Mobile No</th><td>"+employee.getMobileNo()+"</td></tr></table></body></html>";
    }

    @Override
    public void reset(){
        empIdEditText.setText("");
        empDetailsWebView.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.btn_search:
                String empID=empIdEditText.getText().toString();
                if (empID.trim().isEmpty()) {
                    empIdEditText.setError("Please enter valid Employee Id");
                    empIdEditText.requestFocus();

                }
                else
                    empPresenter.searchEmployee(empID);

                empIdEditText.setText("");
                break;
            case R.id.btn_add_emp:
                Intent intent=new Intent(this,AddEmployeeActivity.class);
                startActivityForResult(intent, Constants.REQUEST_CODE_EMPLOYEE_ADD_ACTIVITY);
                break;


        }
        //Hiding the keyboard
        KeyboardUtility.hideKeyboard(this,view);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == Constants.REQUEST_CODE_EMPLOYEE_ADD_ACTIVITY && resultCode == Constants.RESULT_CODE_EMPLOYEEE_ADDED){
            Toast.makeText(this,"Employee successfully added",Toast.LENGTH_LONG).show();
        }
    }



}
