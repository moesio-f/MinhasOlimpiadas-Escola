package com.moesiof.minhasolimpiadas_escola.ui.home

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Olympics(val name : String, var teacher : String, val day : String, val registrationOpen : String, val registrationClose : String, val description : String, val imgURL : String) : Parcelable {

    fun isOpen() : Boolean
    {
        val current = Calendar.getInstance()

        val registrationOpen = Calendar.getInstance()
        var YEAR : Int = this.registrationOpen.split("/")[2].toInt()
        var MONTH : Int = this.registrationOpen.split("/")[1].toInt()
        var DAY : Int = this.registrationOpen.split("/")[0].toInt()
        registrationOpen.set(Calendar.YEAR, YEAR)
        registrationOpen.set(Calendar.MONTH, MONTH)
        registrationOpen.set(Calendar.DAY_OF_MONTH, DAY)

        val registrationClose = Calendar.getInstance()
        YEAR = this.registrationClose.split("/")[2].toInt()
        MONTH = this.registrationClose.split("/")[1].toInt()
        DAY = this.registrationClose.split("/")[0].toInt()
        registrationClose.set(Calendar.YEAR, YEAR)
        registrationClose.set(Calendar.MONTH, MONTH)
        registrationClose.set(Calendar.DAY_OF_MONTH, DAY)

        if(current.after(registrationOpen) && current.before(registrationClose)) {
            return true
        }
        return false
    }

    fun hasTeacher() : Boolean
    {
        if(teacher != "Sem Professor")
        {
            return true
        }
        return false
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(teacher)
        parcel.writeString(day)
        parcel.writeString(registrationOpen)
        parcel.writeString(registrationClose)
        parcel.writeString(description)
        parcel.writeString(imgURL)
    }

    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString())

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Olympics> {
        override fun createFromParcel(parcel: Parcel): Olympics {
            return Olympics(parcel)
        }

        override fun newArray(size: Int): Array<Olympics?> {
            return arrayOfNulls(size)
        }
    }
}