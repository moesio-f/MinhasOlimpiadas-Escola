package com.moesiof.minhasolimpiadas_escola.ui.calendar

import com.prolificinteractive.materialcalendarview.CalendarDay

class CalendarEvent(val name : String, val description : String, val date : String, val isValid : Boolean) {

    fun writtenEvent() : String
    {
        if(isValid)
            return "$name: $description"
        else
            return "Nenhum evento para exibir."
    }

    companion object{
        lateinit var events : MutableList<CalendarEvent>

        fun setAllEvents(events : MutableList<CalendarEvent>)
        {
            this.events = events
        }

        fun hasEvent(date: CalendarDay) : CalendarEvent
        {
            for (event in events)
            {
                if(event.date == trueDate(date))
                {
                    return event
                }
            }
            return CalendarEvent("","","", false)
        }

        private fun trueDate(date : CalendarDay) : String
        {
            var day = date.day.toString()
            var month = date.month.toString()
            var year = date.year.toString()

            if(day.length < 2)
            {
                day = "0$day"
            }

            if(month.length < 2)
            {
                month = "0$month"
            }

            return "$day/$month/$year"
        }
    }
}