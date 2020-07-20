package com.expaorbit.interviewproject.presenter;

import com.expaorbit.interviewproject.GlobalConstants;
import com.expaorbit.interviewproject.model.AdminUser;
import com.expaorbit.interviewproject.view.ILoginView;

/**
 * Created by kajal on 7/20/2020.
 */

public class LoginPresenter implements ILoginPresenter {

    ILoginView iLoginView;
    AdminUser adminUser;

    public LoginPresenter(ILoginView loginView){
        iLoginView=loginView;

    }

    @Override
    public void performLogin(String userID,String password){
            if(verifyCredentials(userID,password))
                iLoginView.onLoginResult(GlobalConstants.LOGIN_RESULT_SUCCESSFUL);
            else
                iLoginView.onLoginResult(GlobalConstants.LOGIN_RESULT_INVALID_CREDENTIALS);

    }

    @Override
    public boolean verifyCredentials(String userId, String password) {
        if(userId.equals(GlobalConstants.ADMIN_USER_ID) && password.equals(GlobalConstants.ADMIN_PASSWORD))
             return true;
        return false;
    }


}
