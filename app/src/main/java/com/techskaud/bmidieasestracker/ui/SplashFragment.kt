package com.techskaud.bmidieasestracker.ui

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.example.woohoo.base.BaseFragment
import com.techskaud.bmidieasestracker.R

class SplashFragment : BaseFragment() {
    override fun getLayoutID(): Int {
        return R.layout.splash_fragment
    }

    override fun onCreateView() {
            navigateUpto()
    }
    fun navigateUpto(){
        Handler(Looper.getMainLooper()).postDelayed({
         findNavController().navigate(R.id.action_splashFragment_to_quiteTaskEditFragment)
        },1000)
    }
}