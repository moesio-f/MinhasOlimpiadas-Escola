package com.moesiof.minhasolimpiadas_escola.ui.calendar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.moesiof.minhasolimpiadas_escola.R
import com.prolificinteractive.materialcalendarview.MaterialCalendarView

class CalendarFragment : Fragment() {

    private lateinit var calendarViewModel: CalendarViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        calendarViewModel = ViewModelProviders.of(this).get(CalendarViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_calendar, container, false)
        val calendar : MaterialCalendarView = root.findViewById(R.id.calendarView)
        val eventsOfDay : TextView = root.findViewById(R.id.eventsOfDay_text)
        val progressBar : ProgressBar = root.findViewById(R.id.progressBar_calendar)
        val text : TextView = root.findViewById(R.id.text_calendar)

        calendarViewModel.getEvents().observe(this, Observer<MutableList<CalendarEvent>> {
            progressBar.visibility = View.GONE

            CalendarEvent.setAllEvents(it)
            calendar.invalidateDecorators()
            calendar.addDecorator(EventDecorator(it))

            calendar.visibility = View.VISIBLE
            eventsOfDay.visibility = View.VISIBLE
            text.visibility = View.VISIBLE
        })

        calendar.setOnDateChangedListener {widget, date, selected ->
            if(selected)
            {
                val current = CalendarEvent.hasEvent(date)
                eventsOfDay.text = current.writtenEvent()
            }
        }

        return root
    }
}