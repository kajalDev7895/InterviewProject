package com.expaorbit.interviewproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.expaorbit.interviewproject.GlobalConstants;
import com.expaorbit.interviewproject.HomeActivity;
import com.expaorbit.interviewproject.R;
import com.expaorbit.interviewproject.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView {

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
                if(isInputValid())
                    mLoginPresenter.performLogin(mUserIDEditText.getText().toString(), mPasswordEditText.getText().toString());
                break;

        }
    }

    @Override
    public void onLoginResult(int resultCode) {

        switch (resultCode)
        {
            case GlobalConstants.LOGIN_RESULT_SUCCESSFUL:
                Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case GlobalConstants.LOGIN_RESULT_INVALID_CREDENTIALS:
                Toast.makeText(this,getString(R.string.message_invalid_credentials),Toast.LENGTH_LONG).show();
                resetInputs();
                break;
        }
    }

    @Override
    public void resetInputs(){
        mUserIDEditText.setText("");
        mPasswordEditText.setText("");
    }


    @Override
    public boolean isInputValid() {
        if (mUserIDEditText.getText().toString().trim().isEmpty()) {
            mUserIDEditText.setError("Please enter valid UserID");
            mUserIDEditText.requestFocus();
            return false;
        }
        else if (mPasswordEditText.getText().toString().isEmpty()) {
            mPasswordEditText.setError("Please enter password");
            mPasswordEditText.requestFocus();
            return false;
        }
        return true;

    }
}