package com.techskaud.bmidieasestracker.ui.fragment.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomeTabAdapter (val context : Context, val fragmentManager: FragmentManager, val tabs :Int) : FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return tabs
    }

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return DataListFragment()
            }
            1 -> {
                return SearchFragment()
            }

            2->{
                return HospitalListFragment()
            }

            else -> return DataListFragment()
        }
    }
}