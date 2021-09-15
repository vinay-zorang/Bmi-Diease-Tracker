package com.techskaud.bmidieasestracker.ui.fragment

import com.example.woohoo.base.BaseFragment
import com.techskaud.bmidieasestracker.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.techskaud.bmidieasestracker.ui.tab_adapter.TabAdapter
import kotlinx.android.synthetic.main.connection_fragment.*


class ConnectionsFragment : BaseFragment() {
    override fun getLayoutID(): Int {
        return R.layout.connection_fragment
    }

    override fun onCreateView() {
        init()
    }

    fun init(){
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.applications)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.devices)))
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL)

        val adapter = TabAdapter(requireActivity(),childFragmentManager, tabLayout.getTabCount())
        viewPager.setAdapter(adapter)

        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.setCurrentItem(tab.position)
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


    }
}