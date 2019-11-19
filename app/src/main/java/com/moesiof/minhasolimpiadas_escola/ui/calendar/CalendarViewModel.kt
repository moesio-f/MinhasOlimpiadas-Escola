package com.moesiof.minhasolimpiadas_escola.ui.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moesiof.minhasolimpiadas_escola.database.Database

class CalendarViewModel : ViewModel() {
    private val events : MutableLiveData<MutableList<CalendarEvent>> by lazy {
        MutableLiveData<MutableList<CalendarEvent>>().also {
            loadEvents()}
    }

    fun getEvents() : LiveData<MutableList<CalendarEvent>>
    {
        return events
    }

    fun loadEvents()
    {
        Database().getFromDatabase("Main").addOnSuccessListener { result ->
            val events = mutableListOf<CalendarEvent>()
            for(document in result)
            {
                events.add(CalendarEvent(document.id, "Dia de realização da prova", document["day"].toString(), true))
                events.add(CalendarEvent(document.id, "Abertura Inscrições", document["registrationOpen"].toString(), true))
                events.add(CalendarEvent(document.id, "Fechamento Inscrições", document["registrationClose"].toString(), true))
            }

            this.events.value = events
        }
    }
}