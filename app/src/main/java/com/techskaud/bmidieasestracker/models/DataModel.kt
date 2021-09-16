package com.techskaud.bmidieasestracker.models

import android.os.Parcel
import android.os.Parcelable
import com.techskaud.bmidieasestracker.ui.adapter.AbstractModel

class DataModel(
    val image:Int,
    val dataType:String,
    val typeOrQuantity: String,
    val color:String
) : AbstractModel() {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(dataType)
        parcel.writeString(typeOrQuantity)
        parcel.writeString(color)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataModel> {
        override fun createFromParcel(parcel: Parcel): DataModel {
            return DataModel(parcel)
        }

        override fun newArray(size: Int): Array<DataModel?> {
            return arrayOfNulls(size)
        }
    }
}
