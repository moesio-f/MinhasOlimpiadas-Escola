package com.moesiof.minhasolimpiadas_escola.database

import android.os.Parcel
import android.os.Parcelable

class School (val name : String, val principal : String, val email : String, val phone : String, val address : String, val inepCode : String, val idCode : String, val password : String) : Parcelable {
    //Relação professores + olimpiadas
    //Comentários/Sugestões

    fun hashMap() : HashMap<String, String>
    {
        return hashMapOf(
            "name" to name,
            "principal" to principal,
            "email" to email,
            "phone" to phone,
            "address" to address,
            "inepCode" to inepCode,
            "idCode" to idCode,
            "password" to password
        )
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(principal)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(address)
        parcel.writeString(inepCode)
        parcel.writeString(idCode)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<School> {
        override fun createFromParcel(parcel: Parcel): School {
            return School(parcel)
        }

        override fun newArray(size: Int): Array<School?> {
            return arrayOfNulls(size)
        }
    }

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )
}