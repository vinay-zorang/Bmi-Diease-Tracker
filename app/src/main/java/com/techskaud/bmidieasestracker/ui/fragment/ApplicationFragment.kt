package com.techskaud.bmidieasestracker.ui.fragment

import android.view.View
import com.example.woohoo.base.BaseFragment
import com.techskaud.bmidieasestracker.R
import kotlinx.android.synthetic.main.application_fragment.*
import kotlinx.android.synthetic.main.application_fragment.view.*

class ApplicationFragment : BaseFragment(){


    override fun getLayoutID(): Int {
        return R.layout.application_fragment
    }

    override fun onCreateView() {
            init()
            clickEvents()
    }

    fun init(){

    }

    fun clickEvents(){
      llGoogleFit.setOnClickListener {
          imgGoogleFitSelected.visibility = View.VISIBLE
          imgGarminSelected.visibility = View.GONE
          imgsamsungFitSelected.visibility = View.GONE
          imgMiFitSelected.visibility = View.GONE
      }
        llSamsungFit.setOnClickListener {
            imgGoogleFitSelected.visibility = View.GONE
            imgGarminSelected.visibility = View.GONE
            imgsamsungFitSelected.visibility = View.VISIBLE
            imgMiFitSelected.visibility = View.GONE
        }
        llMiFit.setOnClickListener {
            imgGoogleFitSelected.visibility = View.GONE
            imgGarminSelected.visibility = View.GONE
            imgsamsungFitSelected.visibility = View.GONE
            imgMiFitSelected.visibility = View.VISIBLE
        }

        llGarminC.setOnClickListener {
            imgGoogleFitSelected.visibility = View.GONE
            imgGarminSelected.visibility = View.VISIBLE
            imgsamsungFitSelected.visibility = View.GONE
            imgMiFitSelected.visibility = View.GONE
        }
    }

}