package com.expaorbit.interviewproject.Utilities;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by kajal on 7/21/2020.
 */

public class KeyboardUtility {

    public static void hideKeyboard(Context context,View view){
        InputMethodManager im = (InputMethodManager)context.getSystemService(INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
