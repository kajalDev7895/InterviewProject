package com.expaorbit.interviewproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.expaorbit.interviewproject.Constants;
import com.expaorbit.interviewproject.R;
import com.expaorbit.interviewproject.Utilities.KeyboardUtility;
import com.expaorbit.interviewproject.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements IFormView {

    private Button mLoginBtn;
    private LoginPresenter mLoginPresenter;
    private EditText mUserIDEditText, mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        mLoginBtn.setOnClickListener(this);
        mLoginPresenter = new LoginPresenter(this);

    }

    public void initViews() {
        mLoginBtn = findViewById(R.id.btn_login);
        mUserIDEditText = findViewById(R.id.edittext_user_id);
        mPasswordEditText = findViewById(R.id.edittext_password);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                    mLoginPresenter.performLogin(mUserIDEditText.getText().toString(), mPasswordEditText.getText().toString());
                KeyboardUtility.hideKeyboard(this,view);
                break;

        }
    }

    @Override
    public void onSubmitFormSuccess() {
        Intent intent=new Intent(LoginActivity.this,EmployeeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSubmitFormFailure() {
        Toast.makeText(this,getString(R.string.message_invalid_credentials),Toast.LENGTH_LONG).show();
        resetInputs();
    }

    @Override
    public void resetInputs(){
        mUserIDEditText.setText("");
        mPasswordEditText.setText("");
    }

    @Override
    public void onValidationError(int validationCode) {
        switch (validationCode) {
            case Constants.LOGIN_VALIDATION_NAME_ERROR:
                mUserIDEditText.setError("Please enter valid UserID");
                mUserIDEditText.requestFocus();
                break;
            case Constants.LOGIN_VALIDATION_PASSWORD_ERROR:
                mPasswordEditText.setError("Please enter password");
                mPasswordEditText.requestFocus();
                break;
        }

    }



}