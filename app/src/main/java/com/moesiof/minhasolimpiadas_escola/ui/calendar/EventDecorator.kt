package com.moesiof.minhasolimpiadas_escola.ui.calendar

import android.graphics.Color

import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.spans.DotSpan

class EventDecorator : DayViewDecorator {
    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return (day == CalendarDay.today())
    }

    override fun decorate(view: DayViewFacade?) {
        val span = DotSpan(Color.GREEN)
        view?.addSpan(span)
    }
}