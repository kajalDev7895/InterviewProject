package com.expaorbit.interviewproject.model;

/**
 * Created by kajal on 7/20/2020.
 */

public class AdminUser implements IUser {
    private String mUserID;
    private String mPassword;

    public AdminUser(String userID, String password){
        mUserID=userID;
        mPassword=password;
    }

    @Override
    public String getUserID(){
        return mUserID;
    }

    @Override
    public  String getPassword(){
        return mPassword;
    }

}
