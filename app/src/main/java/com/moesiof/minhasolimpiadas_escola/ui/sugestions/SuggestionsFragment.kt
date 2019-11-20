package com.moesiof.minhasolimpiadas_escola.ui.sugestions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moesiof.minhasolimpiadas_escola.R
import kotlinx.android.synthetic.main.fragment_suggestions.*

class SuggestionsFragment : Fragment() {

    private lateinit var suggestionsViewModel: SuggestionsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        suggestionsViewModel = ViewModelProviders.of(this).get(SuggestionsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_suggestions, container, false)
        val progressBar = root.findViewById<ProgressBar>(R.id.progressSuggestions)

        suggestionsViewModel.getAllSuggestions().observe(this, Observer<MutableList<Suggestion>>{
            viewManager = LinearLayoutManager(root.context)
            viewAdapter = SuggestionAdapter(it)
            recyclerView = rvSuggestions.apply {
                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter
            }

            progressBar.visibility = View.GONE
        })

        return root
    }
}