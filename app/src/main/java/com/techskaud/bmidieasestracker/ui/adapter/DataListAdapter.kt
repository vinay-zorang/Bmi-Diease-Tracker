package com.techskaud.bmidieasestracker.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.techskaud.bmidieasestracker.R
import com.techskaud.bmidieasestracker.models.DataModel
import com.wh.woohoo.utils.extensionFunction.inflate
import kotlinx.android.synthetic.main.grid_view_data.view.*

class DataListAdapter(val dataList : ArrayList<DataModel>,val onClick : (DataModel) -> Unit):RecyclerView.Adapter<DataListAdapter.ViewHolderDataListAdapter>() {
        lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDataListAdapter {
        context=parent.context
        return  ViewHolderDataListAdapter(parent.inflate(R.layout.grid_view_data,false))
    }

    override fun onBindViewHolder(holder: ViewHolderDataListAdapter, position: Int) {
        val data = dataList[position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    inner class ViewHolderDataListAdapter(val view:View) : RecyclerView.ViewHolder(view){
        fun setData(data : DataModel){
            view.txtDataType.text = data.dataType
            view.imgType.setImageResource(data.image)
            view.txtTypeQuantity.text=data.typeOrQuantity
            when(data.color){
                "yellow" ->{
                    view.txtTypeQuantity.setTextColor(ContextCompat.getColor(context,R.color.yellow))
                }
                "green" ->{
                    view.txtTypeQuantity.setTextColor(ContextCompat.getColor(context,R.color.green))
                }
                "red" ->{
                    view.txtTypeQuantity.setTextColor(ContextCompat.getColor(context,R.color.red))
                }
                "grey" ->{
                    view.txtTypeQuantity.setTextColor(ContextCompat.getColor(context,R.color.grey))
                }
            }
            view.llData.setOnClickListener {
                onClick(data)
            }
            if (data.isSelected ==1)
                view.txtDescription.visibility = View.VISIBLE
            else
                view.txtDescription.visibility = View.GONE

        }

    }
}