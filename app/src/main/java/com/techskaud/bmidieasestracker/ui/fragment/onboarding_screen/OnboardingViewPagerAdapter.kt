package com.techskaud.bmidieasestracker.ui.fragment.onboarding_screen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.techskaud.bmidieasestracker.R
import com.techskaud.bmidieasestracker.utilities.ModelObject
import com.wh.woohoo.utils.extensionFunction.navigateWithId
import kotlinx.android.synthetic.main.waring_screen_three.view.*

class OnboardingViewPagerAdapter (val mContext : Context)  : PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val modelObject = ModelObject.values()[position]
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(modelObject.layoutResId, collection, false) as ViewGroup
        collection.addView(layout)
        if (position == 2){
            layout.txtComeIn.setOnClickListener {
                layout.navigateWithId(R.id.action_onBoardingFragment_to_connectionsFragment)
            }
        }
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
    override fun getCount(): Int {
        return ModelObject.values().size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getPageTitle(position: Int): CharSequence {
        return ""
    }

}