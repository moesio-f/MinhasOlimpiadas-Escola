package com.moesiof.minhasolimpiadas_escola.ui.sugestions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.moesiof.minhasolimpiadas_escola.R

class SuggestionsFragment : Fragment() {

    private lateinit var suggestionsViewModel: SuggestionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        suggestionsViewModel =
            ViewModelProviders.of(this).get(SuggestionsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_suggestions, container, false)
        val textView: TextView = root.findViewById(R.id.text_tools)
        suggestionsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}