package com.techskaud.bmidieasestracker.utilities

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.techskaud.bmidieasestracker.ApplicationClass

object Utils {
    fun showToast(message:String){
        Toast.makeText(ApplicationClass.getContext(),message, Toast.LENGTH_SHORT).show()
    }

    //this method is used to hide the keyboard
    fun hideKeyboard(activity: Activity) {
        val view = activity.findViewById<View>(android.R.id.content)
        if (view != null) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}