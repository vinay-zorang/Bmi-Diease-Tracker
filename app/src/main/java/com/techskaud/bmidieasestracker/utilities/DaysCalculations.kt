package com.techskaud.bmidieasestracker.utilities

import android.annotation.SuppressLint
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object DaysCalculations {
    fun calculateTimeBetweenDates(startDate: String): String {

        val endDate = timeStampToString(System.currentTimeMillis())

        val sdf = SimpleDateFormat("dd MMMM yyyy, hh:mm a")
        val date1 = sdf.parse(startDate)
        val date2 = sdf.parse(endDate)

        var isNegative = false

        var difference = date2.time - date1.time
        if (difference < 0) {
            difference = -(difference)
            isNegative = true
        }

        val minutes = difference / 60 / 1000
        val hours = difference / 60 / 1000 / 60
        val days = (difference / 60 / 1000 / 60) / 24
        val months = (difference / 60 / 1000 / 60) / 24 / (365 / 12)
        val years = difference / 60 / 1000 / 60 / 24 / 365

        if (isNegative) {
            return when {
                minutes < 240 -> "Starts in $minutes minutes"
                hours < 48 -> "Starts in $hours hours"
                days < 61 -> "Starts in $days days"
                months < 24 -> "Starts in $months months"
                else -> "Starts in $years years"
            }
        }

        return when {
            minutes < 240 -> "$minutes minutes ago"
            hours < 48 -> "$hours hours ago"
            days < 61 -> "$days days ago"
            months < 24 -> "$months months ago"
            else -> "$years years ago"
        }
    }

     fun timeStampToString(timeStamp: Long): String {
        val stamp = Timestamp(timeStamp)
        val sdf = SimpleDateFormat(Constants.DATE_FORMAT)
        val date = sdf.format(Date(stamp.time))

        return date.toString()
    }

    /*compare date and time*/
    @SuppressLint("SimpleDateFormat")
    fun compareDateAndTime(currenDateAndTime: String, selectedDateAndTime: String): Boolean {
        var isDateCompare = false
        val sdformat = SimpleDateFormat(Constants.DATE_FORMAT)
        val d1 = sdformat.parse(currenDateAndTime)
        val d2 = sdformat.parse(selectedDateAndTime)
        if (d1.compareTo(d2) > 0) {
            // When Date d1 > Date d2
            isDateCompare = false
        } else if (d1.compareTo(d2) < 0) {
            // When Date d1 < Date d2
            isDateCompare = true
            println("Date 1 occurs before Date 2")
        } else if (d1.compareTo(d2) === 0) {
            // When Date d1 = Date d2
            isDateCompare = false
            println("Both dates are equal")
        }
        return isDateCompare
    }

    fun getYesterdayDate(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)
        val time = calendar.time
        val pp = SimpleDateFormat(Constants.DATE_FORMAT)
        val selectTimeForReminder = pp.format(time).toString()
        return selectTimeForReminder
    }
}