package com.techskaud.bmidieasestracker.ui.fragment.home

import com.example.woohoo.base.BaseFragment
import com.techskaud.bmidieasestracker.R
import com.techskaud.bmidieasestracker.models.DataModel

class DataListFragment : BaseFragment() {

    override fun getLayoutID(): Int {
        return R.layout.data_list_frag
    }

    override fun onCreateView() {
        init()
    }

    fun init() {
        val dataList = ArrayList<DataModel>()
        dataList.add(DataModel(R.drawable.ic_level_of_risk, "Level Of Risk", "Middle", "yellow"))
        dataList.add(DataModel(R.drawable.ic_bmi, "Body Mass Index", "18.8", "red"))
        dataList.add(DataModel(R.drawable.ic_obesity_rate, "Obesity Rate", "Normal", "yellow"))
        dataList.add(DataModel(R.drawable.ic_bmi, "Ideal Weight", "86.5 Kg", "green"))
        dataList.add(DataModel(R.drawable.ic_metabolism,"Basic Metabolism","2290","yellow"))
        dataList.add(DataModel(R.drawable.ic_waist,"Waist & Hips Ratio","1.2","green"))
        dataList.add(DataModel(R.drawable.ic_age,"Biological Age","25","grey"))
        dataList.add(DataModel(R.drawable.ic_body_type,"Body Type","Mesomorph","grey"))
        dataList.add(DataModel(R.drawable.ic_fat,"Subcutaneous Fat","15%","yellow"))
    }

    fun setAdapter() {

    }
}