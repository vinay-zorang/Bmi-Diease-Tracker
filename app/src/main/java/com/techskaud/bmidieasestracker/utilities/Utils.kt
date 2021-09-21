package com.techskaud.bmidieasestracker.utilities

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.techskaud.bmidieasestracker.ApplicationClass
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.min

object Utils {
    fun showToast(message: String) {
        Toast.makeText(ApplicationClass.getContext(), message, Toast.LENGTH_SHORT).show()
    }

    //this method is used to hide the keyboard
    fun hideKeyboard(activity: Activity) {
        val view = activity.findViewById<View>(android.R.id.content)
        if (view != null) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    /** Internet Connection Detector */
    @Suppress("DEPRECATION")
    fun isInternetAvailable(): Boolean {
        var result = false
        val cm = ApplicationClass.getContext()
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm?.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                }
            }
        } else {
            cm?.run {
                cm.activeNetworkInfo?.run {
                    if (type == ConnectivityManager.TYPE_WIFI) {
                        result = true
                    } else if (type == ConnectivityManager.TYPE_MOBILE) {
                        result = true
                    }
                }
            }
        }
        return result
    }

    fun getCurrentDateAndTime(): String {
        val sdf = SimpleDateFormat("dd MMMM yyyy, hh:mm a", Locale.getDefault())
        val currentDateandTime: String = sdf.format(Date())
        return currentDateandTime
    }

    fun cleanDate(_day: Int, _month: Int, _year: Int): String {
        var day = _day.toString()
        var month = _month.toString()

        if (_day < 10) {
            day = "0$_day"
        }

        if (_month < 9) { //Because the month instance we retrieve starts at 0 and it's stupid!
            month = "0${_month + 1}"
        } else if (_month >= 9 && _month <= 11) {
            month = (_month + 1).toString()
        }

        return "$day/$month/$_year"
    }

    //get the current time
     fun getTimeCalendar(): Pair<Int, Int> {
        val cal = Calendar.getInstance()
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        val minute = cal.get(Calendar.MINUTE)
        return Pair(first = hour, second = minute)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun dateTimeConverter(year:Int,month:Int,day:Int,hour:Int,minute:Int):String{
        val calendar = Calendar.getInstance()
        calendar.set(year,month,day,hour,minute)
        val format = SimpleDateFormat(Constants.DATE_FORMAT)
        val strDate: String = format.format(calendar.time)
        return  strDate
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun dateTimeConverterWithMonthName(year:Int,month:Int,day:Int,hour:Int,minute:Int):String{
        val calendar = Calendar.getInstance()
        calendar.set(year,month,day,hour,minute)
        val format = SimpleDateFormat(Constants.DATE_FORMAT_MONTH)
        val strDate: String = format.format(calendar.time)
        return  strDate
    }


}