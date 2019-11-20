package com.moesiof.minhasolimpiadas_escola.ui.home

import android.util.Log
import java.util.*

class Olympics(val name : String, var teacher : String, val day : String, val registrationOpen : String, val registrationClose : String) {

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
}