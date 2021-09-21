package com.techskaud.bmidieasestracker.ui.fragment.time_tracker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.woohoo.base.BaseFragment
import com.techskaud.bmidieasestracker.R
import com.techskaud.bmidieasestracker.utilities.Utils
import kotlinx.android.synthetic.main.quite_task_edit_fragment.*
import java.util.*
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker


class QuiteTaskEditFragment : BaseFragment(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {
    private var day = 0
    private var month = 0
    private var year = 0
    private var hour = 0
    private var minute = 0
    private var time =""
    override fun getLayoutID(): Int {
        return R.layout.quite_task_edit_fragment
    }

    override fun onCreateView() {
        time = Utils.getCurrentDateAndTime()
        txtTime.text = time
        onClickEvents()
    }

    fun onClickEvents() {
        clTimePicker.setOnClickListener {
            getDateCalendar()
            val datePickerDialog = DatePickerDialog(
                requireActivity(), this, year, month,
                day
            )
            datePickerDialog.datePicker.minDate = System.currentTimeMillis()
            datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
            datePickerDialog.show()
        }
        clSetTimeTracker.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("Time",time)
            findNavController().navigate(R.id.action_quiteTaskEditFragment_to_progressTimeTracker,bundle)
        }



    }

    //get the current date
    private fun getDateCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Log.e("Date", "onDateSet: $view")
        this.year = year
        this.month = month
        day = dayOfMonth
        hour = Utils.getTimeCalendar().first
        minute = Utils.getTimeCalendar().second
        TimePickerDialog(context, this, hour, minute, false).show()


    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        hour = hourOfDay
        this.minute = minute
        time = Utils.dateTimeConverter(year,month,day,hour,minute)
        txtTime.text = time

    }
}