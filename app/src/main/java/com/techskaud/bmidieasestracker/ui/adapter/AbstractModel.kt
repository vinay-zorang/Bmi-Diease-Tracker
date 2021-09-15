package com.techskaud.bmidieasestracker.ui.adapter

import android.os.Parcelable

abstract class AbstractModel (
    var adapterPosition: Int = -1,
    var onItemClick: RecyclerAdapter.OnItemClick? = null
):Parcelable