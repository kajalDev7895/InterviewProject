package com.expaorbit.interviewproject.view;

import android.view.View;

/**
 * Created by kajal on 7/20/2020.
 */

public interface IFormView extends View.OnClickListener{

    void onSubmitFormSuccess();
    void onSubmitFormFailure();
    void resetInputs();
    void onValidationError(int validationCode);
}
