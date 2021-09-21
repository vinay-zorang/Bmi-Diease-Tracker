package com.techskaud.bmidieasestracker.ui.fragment.time_tracker

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import com.example.woohoo.base.BaseFragment
import com.techskaud.bmidieasestracker.R
import com.techskaud.bmidieasestracker.utilities.DaysCalculations
import com.techskaud.bmidieasestracker.utilities.Utils
import kotlinx.android.synthetic.main.progress_time_tracker_frag.*
import java.util.*

class ProgressTimeTracker : BaseFragment(),DatePickerDialog.OnDateSetListener {
    private var sec = 0
    private var isRunning = false
    private var wasRunning = false
    private var dateTime = ""
    private var day = 0
    private var month = 0
    private var year = 0
    private var hour =0
    private var min=0
    override fun getLayoutID(): Int {
        return R.layout.progress_time_tracker_frag
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView() {
        init()
        onClick()
    }

    fun init() {
        arguments.let {
            dateTime = it?.getString("Time").toString()
        }
        val time = DaysCalculations.calculateTimeBetweenDates(dateTime)
        Log.e("Time", "init: $time")

        isRunning = true
        startTimer()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onClick() {
        imgRefresh.setOnClickListener {
            isRunning = true
            sec = 0
        }
        imgThreeDots.setOnClickListener {
            clQuitPopUp.visibility = View.VISIBLE
        }
        llNo.setOnClickListener {
            clQuitPopUp.visibility = View.GONE
        }
        llYes.setOnClickListener {
            goBack()
        }
        txtDay.setOnClickListener {
            showHorizontalCal()
        }
    }

    override fun onPause() {
        super.onPause()
        wasRunning = isRunning
        isRunning = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning) {
            isRunning = true
        }
    }

    var timeInMin = 0

    private fun startTimer() {
        val hd = Handler(Looper.getMainLooper())
        hd.post(object : Runnable {
            override fun run() {
                val activity: Activity? = activity
                if (activity != null) {
                    val hours_var = sec / 3600
                    val minutes_var = sec % 3600 / 60
                    val secs_var = sec % 60
                    val time_value = String.format(
                        Locale.getDefault(),
                        "%d:%02d:%02d",
                        hours_var,
                        minutes_var,
                        secs_var
                    )

                    if (timeInMin == 0) {
                        setProgressBar(minutes_var)
                        timeInMin = minutes_var
                    } else {
                        if (timeInMin != minutes_var) {
                            setProgressBar(minutes_var)
                        }
                        timeInMin = minutes_var
                    }
                    txtSmokeFreeTime.text = time_value
                    if (isRunning) {
                        sec++
                    }


                    hd.postDelayed(this, 1000)
                }
            }
        })
    }

    private fun setProgressBar(min: Int) {
        arc_progress.setProgress((Math.random() * min).toFloat())
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun showHorizontalCal(){
        getDateCalendar()
        val datePickerDialog = DatePickerDialog(
            requireActivity(), this, year, month,
            day
        )

        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
        datePickerDialog.show()

    }
    //get the current date
    private fun getDateCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR_OF_DAY)
        min  = cal.get(Calendar.MINUTE)

    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        getDateCalendar()
        val yesterdayDate = DaysCalculations.getYesterdayDate()
        val dateSelected = Utils.dateTimeConverter(year,month,dayOfMonth,hour,min)
        if (dateSelected == yesterdayDate){
            txtDay.text ="Yesterday"
        }else{
            txtDay.text = Utils.dateTimeConverterWithMonthName(year,month,dayOfMonth,hour,min)
        }

    }

}