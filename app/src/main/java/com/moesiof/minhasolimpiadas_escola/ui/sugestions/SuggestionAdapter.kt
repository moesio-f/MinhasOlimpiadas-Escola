package com.moesiof.minhasolimpiadas_escola.ui.sugestions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moesiof.minhasolimpiadas_escola.R
import kotlinx.android.synthetic.main.suggestions_viewholder.view.*

class SuggestionAdapter(private val suggestions : List<Suggestion>) : RecyclerView.Adapter<SuggestionAdapter.MyViewHolder>() {
    private lateinit var context : Context

    override fun getItemCount(): Int {
        return suggestions.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.suggestions_viewholder, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.author.text = suggestions[position].author
        holder.date.text = suggestions[position].date
        holder.content.text = suggestions[position].suggestion
    }

    inner class MyViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        var author =  itemView.name_text
        var date = itemView.datetime_text
        var content = itemView.content_text
    }
}