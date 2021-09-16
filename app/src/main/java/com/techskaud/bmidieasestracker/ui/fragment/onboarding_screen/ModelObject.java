package com.techskaud.bmidieasestracker.ui.fragment.onboarding_screen;

import com.techskaud.bmidieasestracker.R;


public enum ModelObject {

    FIRST_SCREEN( R.layout.waring_screen_one),
    SECOND_SCREEN( R.layout.waring_screen_two),
    THIRD_SCREEN( R.layout.waring_screen_three);

    private int mLayoutResId;

    ModelObject( int layoutResId) {
        mLayoutResId = layoutResId;
    }


    public int getLayoutResId() {
        return mLayoutResId;
    }

}
