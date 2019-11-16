package com.moesiof.minhasolimpiadas_escola.ui.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moesiof.minhasolimpiadas_escola.database.Database
import com.moesiof.minhasolimpiadas_escola.database.School

class DataViewModel : ViewModel() {

    private val school : MutableLiveData<School> by lazy {
        MutableLiveData<School>().also {
            loadSchool()}
    }

    fun getSchool() : LiveData<School>
    {
        return school
    }

    fun loadSchool()
    {
        Database().getFromDatabase(Database.schoolCollection, "info").addOnSuccessListener { result ->
            val data = result.data
            val obj = School(data!!["name"].toString(), data["principal"].toString(),
                data["email"].toString(), data["phone"].toString(),
                data["address"].toString(),data["inepCode"].toString(),
                data["idCode"].toString(),data["password"].toString())
            school.value = obj
        }
    }
}