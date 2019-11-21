package com.moesiof.minhasolimpiadas_escola.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.moesiof.minhasolimpiadas_escola.R
import kotlinx.android.synthetic.main.home_viewholder.view.*


class OlympicsAdapter(private val olympics : List<Olympics>, private val callback : (Int) -> Unit) : RecyclerView.Adapter<OlympicsAdapter.MyViewHolder>() {
    private lateinit var context : Context

    override fun getItemCount(): Int {
        return olympics.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.home_viewholder, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(olympics[position].imgURL).apply(RequestOptions.fitCenterTransform()).into(holder.logo)
        holder.title.text = olympics[position].name
        holder.teacher.text = olympics[position].teacher
        if(olympics[position].hasTeacher())
        {
            holder.teacherRegistered.text = "PROFESSOR REGISTRADO"
            holder.teacherRegistered.setBackgroundColor(ContextCompat.getColor(context, R.color.colorGreen))
        }
        else
        {
            holder.teacherRegistered.text = "PROFESSOR NÃO REGISTRADO"
            holder.teacherRegistered.setBackgroundColor(ContextCompat.getColor(context, R.color.colorRed))
        }

        if(olympics[position].isOpen())
        {
            holder.registrationOpen.text = "INSCIÇÕES ABERTAS"
            holder.registrationOpen.setBackgroundColor(ContextCompat.getColor(context, R.color.colorGreen))
        }
        else
        {
            holder.registrationOpen.text = "INSCIÇÕES FECHADAS"
            holder.registrationOpen.setBackgroundColor(ContextCompat.getColor(context, R.color.colorRed))
        }

        holder.itemView.setOnClickListener {
            callback(position)
        }
    }

    inner class MyViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        var logo =  itemView.logo
        var teacher = itemView.teacher_text
        var title = itemView.labelTitle
        var registrationOpen = itemView.labelRegistrationOpen
        var teacherRegistered = itemView.labelTeacherRegistered
    }
}