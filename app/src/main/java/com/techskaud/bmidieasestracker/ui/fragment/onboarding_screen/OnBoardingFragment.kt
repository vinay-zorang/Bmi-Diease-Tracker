package com.techskaud.bmidieasestracker.ui.fragment.onboarding_screen

import com.example.woohoo.base.BaseFragment
import com.techskaud.bmidieasestracker.R
import com.techskaud.bmidieasestracker.utilities.ViewPagerAnimation
import kotlinx.android.synthetic.main.onboarding_fragment.*

class OnBoardingFragment : BaseFragment() {
    override fun getLayoutID(): Int {
        return R.layout.onboarding_fragment
    }

    override fun onCreateView() {
        viewPager.setPageTransformer(true, ViewPagerAnimation())
        viewPager.adapter = OnboardingViewPagerAdapter(requireActivity())
    }
}