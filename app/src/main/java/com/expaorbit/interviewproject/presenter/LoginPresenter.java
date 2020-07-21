package com.expaorbit.interviewproject.presenter;

import com.expaorbit.interviewproject.Constants;
import com.expaorbit.interviewproject.model.AdminUser;
import com.expaorbit.interviewproject.view.IFormView;

/**
 * Created by kajal on 7/20/2020.
 */

public class LoginPresenter {

    IFormView iFormView;
    AdminUser adminUser;

    public LoginPresenter(IFormView loginView){
        iFormView =loginView;

    }


    public void performLogin(String userID,String password){

        int validationCode = validateLoginDetails(userID, password);
        if(validationCode==Constants.VALIDATION_SUCCESSFUL) {
            if (verifyCredentials(userID, password))
                iFormView.onSubmitFormSuccess();
            else
                iFormView.onSubmitFormFailure();
        }
        else
        {
            iFormView.onValidationError(validationCode);
        }

    }
    public int validateLoginDetails(String userID,String password)
    {
        if (userID.trim().isEmpty())
            return Constants.LOGIN_VALIDATION_NAME_ERROR;
        else if (password.isEmpty())
            return Constants.LOGIN_VALIDATION_PASSWORD_ERROR;
        return Constants.VALIDATION_SUCCESSFUL;


    }

    public boolean verifyCredentials(String userId, String password) {
        if(userId.equals(Constants.ADMIN_USER_ID) && password.equals(Constants.ADMIN_PASSWORD))
            return true;
        return false;


    }


}
