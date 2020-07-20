package com.expaorbit.interviewproject.presenter;

/**
 * Created by kajal on 7/20/2020.
 */

public interface ILoginPresenter {

    public void performLogin(String userID,String password);
    public boolean verifyCredentials(String userId,String password);

}
