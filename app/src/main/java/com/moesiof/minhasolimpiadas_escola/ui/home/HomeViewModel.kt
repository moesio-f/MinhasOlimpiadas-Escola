package com.moesiof.minhasolimpiadas_escola.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moesiof.minhasolimpiadas_escola.database.Database

class HomeViewModel : ViewModel() {

    private val olympics : MutableLiveData<MutableList<Olympics>> by lazy {
        MutableLiveData<MutableList<Olympics>>().also {
            loadOlympics()}
    }

    fun getAllOlympics() : LiveData<MutableList<Olympics>>
    {
        return olympics
    }

    fun loadOlympics()
    {
        Database().getFromDatabase("Main").addOnSuccessListener { result ->
            val olympics = mutableListOf<Olympics>()
            for(document in result)
            {
                olympics.add(Olympics(document.id, "Sem Professor", document["day"].toString(), document["registrationOpen"].toString(), document["registrationClose"].toString(), document["description"].toString(), document["imgURL"].toString()))
            }

            Database().getFromDatabase(Database.schoolCollection, "relation").addOnSuccessListener {result2 ->
                for(value in olympics)
                {
                    value.teacher = result2[value.name].toString()
                }

                this.olympics.value = olympics
            }
        }
    }
}