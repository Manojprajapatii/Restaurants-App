package com.restaurants.model

import android.os.Parcel
import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng

data class ParcelableLatLng(val latitude: Double, val longitude: Double) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun toLatLng(): LatLng {
        return LatLng(latitude, longitude)
    }

    companion object CREATOR : Parcelable.Creator<ParcelableLatLng> {
        override fun createFromParcel(parcel: Parcel): ParcelableLatLng {
            return ParcelableLatLng(parcel)
        }

        override fun newArray(size: Int): Array<ParcelableLatLng?> {
            return arrayOfNulls(size)
             
        }
    }
}
