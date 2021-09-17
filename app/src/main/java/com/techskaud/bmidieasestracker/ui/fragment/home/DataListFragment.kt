package com.techskaud.bmidieasestracker.ui.fragment.home

import android.annotation.SuppressLint
import com.example.woohoo.base.BaseFragment
import com.techskaud.bmidieasestracker.R
import com.techskaud.bmidieasestracker.models.DataModel
import kotlinx.android.synthetic.main.data_list_frag.*
import androidx.recyclerview.widget.GridLayoutManager
import com.techskaud.bmidieasestracker.ui.adapter.DataListAdapter


class DataListFragment : BaseFragment() {
    lateinit var dataListAdapter: DataListAdapter
    override fun getLayoutID(): Int {
        return R.layout.data_list_frag
    }

    override fun onCreateView() {
        init()
    }

    fun init() {
        val dataList = ArrayList<DataModel>()
        dataList.add(DataModel(R.drawable.ic_level_of_risk, "Level Of Risk", "Middle", "yellow","",0))
        dataList.add(DataModel(R.drawable.ic_bmi, "Body Mass Index", "18.8", "red","",0))
        dataList.add(DataModel(R.drawable.ic_obesity_rate, "Obesity Rate", "Normal", "yellow","",0))
        dataList.add(DataModel(R.drawable.ic_bmi, "Ideal Weight", "86.5 Kg", "green","",0))
        dataList.add(DataModel(R.drawable.ic_metabolism,"Basic Metabolism","2290","yellow","",0))
        dataList.add(DataModel(R.drawable.ic_waist,"Waist & Hips Ratio","1.2","green","",0))
        dataList.add(DataModel(R.drawable.ic_age,"Biological Age","25","grey","",0))
        dataList.add(DataModel(R.drawable.ic_body_type,"Body Type","Mesomorph","grey","",0))
        dataList.add(DataModel(R.drawable.ic_fat,"Subcutaneous Fat","15%","yellow","",0))
        setAdapter(dataList)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setAdapter(dataList : ArrayList<DataModel>){

        rvDataList.apply {
            rvDataList.setLayoutManager(GridLayoutManager(requireActivity(), 2))
            dataListAdapter = DataListAdapter(dataList){
                it.let {
                    if (it.isSelected == 0) {
                        it.isSelected = 1
                    } else {
                        it.isSelected = 0
                    }
                    dataListAdapter.notifyDataSetChanged()
                }
            }
            adapter = dataListAdapter
        }
    }
}