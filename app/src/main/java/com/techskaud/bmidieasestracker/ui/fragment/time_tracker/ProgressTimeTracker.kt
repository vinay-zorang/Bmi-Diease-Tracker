package com.techskaud.bmidieasestracker.ui.fragment.time_tracker

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.woohoo.base.BaseFragment
import com.techskaud.bmidieasestracker.R
import kotlinx.android.synthetic.main.progress_time_tracker_frag.*
import java.util.*

class ProgressTimeTracker : BaseFragment() {

    private var sec = 0
    private var isRunning = false
    private var wasRunning = false
    override fun getLayoutID(): Int {
        return R.layout.progress_time_tracker_frag
    }

    override fun onCreateView() {
        init()
        onClick()
    }

    fun init() {
        isRunning=true
        startTimer()
    }

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
                    txtSmokeFreeTime.text = time_value
                    if (isRunning) {
                        sec++
                    }
                    if (timeInMin == 0) {
                        setProgressBar(minutes_var)
                        timeInMin = minutes_var
                    } else {
                        if (timeInMin != minutes_var) {
                            setProgressBar(minutes_var)
                        }
                        timeInMin = minutes_var
                    }

                    hd.postDelayed(this, 1000)
                }
            }
        })
    }

    private fun setProgressBar(min:Int){
        arc_progress.setProgress((Math.random() * min).toFloat())
    }

}