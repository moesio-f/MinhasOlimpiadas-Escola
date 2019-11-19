package com.moesiof.minhasolimpiadas_escola.ui.calendar

import android.graphics.Color

import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.spans.DotSpan

class EventDecorator(val events : MutableList<CalendarEvent>) : DayViewDecorator {
    override fun shouldDecorate(day: CalendarDay?): Boolean {
        if(day != null) {
            for (event in events) {
                if (event.date == trueDate(day)) {
                    return true
                }
            }
        }
        return false
    }

    override fun decorate(view: DayViewFacade?) {
        val span = DotSpan(Color.BLUE)
        view?.addSpan(span)
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