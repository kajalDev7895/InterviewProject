package com.expaorbit.interviewproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.expaorbit.interviewproject.view.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private boolean mIsLoggedIn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!mIsLoggedIn)
        {
            Intent intent  = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();

        }
    }
}
