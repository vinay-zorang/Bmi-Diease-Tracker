package com.techskaud.bmidieasestracker.ui.tab_adapter

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.techskaud.bmidieasestracker.ui.fragment.ApplicationFragment
import com.techskaud.bmidieasestracker.ui.fragment.DeviceFragment

class TabAdapter (val context :Context,val fragmentManager: FragmentManager,val tabs :Int) : FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return tabs
    }

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return ApplicationFragment()
            }
            1 -> {
                return DeviceFragment()
            }

            else -> return ApplicationFragment()
        }
    }
}