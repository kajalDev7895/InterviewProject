package com.expaorbit.interviewproject.view;

import android.view.View;

/**
 * Created by kajal on 7/20/2020.
 */

public interface ILoginView extends View.OnClickListener{

    public void onLoginResult(int resultCode);
    public boolean isInputValid();
    public void resetInputs();

}
