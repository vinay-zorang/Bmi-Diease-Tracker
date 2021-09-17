package com.techskaud.bmidieasestracker.ui.fragment.home


import com.example.woohoo.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import com.techskaud.bmidieasestracker.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : BaseFragment() {
    override fun getLayoutID(): Int {
        return R.layout.home_fragment
    }

    override fun onCreateView() {
            init()
    }
    fun init(){
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_search))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_doc_search))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = HomeTabAdapter(requireActivity(),childFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


    }
}