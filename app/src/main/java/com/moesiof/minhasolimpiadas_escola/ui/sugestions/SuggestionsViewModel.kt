package com.moesiof.minhasolimpiadas_escola.ui.sugestions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moesiof.minhasolimpiadas_escola.database.Database
import com.moesiof.minhasolimpiadas_escola.ui.calendar.CalendarEvent

class SuggestionsViewModel : ViewModel() {

    private val suggestions : MutableLiveData<MutableList<Suggestion>> by lazy {
        MutableLiveData<MutableList<Suggestion>>().also {
            loadSuggestions()}
    }

    fun getAllSuggestions() : LiveData<MutableList<Suggestion>>
    {
        return suggestions
    }

    fun loadSuggestions()
    {
        Database().getFromDatabase(Database.schoolCollection, "isSuggestion", true).addOnSuccessListener { result ->
            val suggestions = mutableListOf<Suggestion>()
            for(document in result)
            {
                suggestions.add(Suggestion(document["author"].toString(), document["date"].toString(), document["suggestion"].toString()))
            }

            this.suggestions.value = suggestions
        }
    }
}