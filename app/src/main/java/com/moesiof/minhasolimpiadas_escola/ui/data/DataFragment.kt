package com.moesiof.minhasolimpiadas_escola.ui.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.moesiof.minhasolimpiadas_escola.R
import com.moesiof.minhasolimpiadas_escola.database.School

class DataFragment : Fragment() {

    //private lateinit var dataViewModel: DataViewModel
    private lateinit var school : School

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //dataViewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_data, container, false)
        val textView: TextView = root.findViewById(R.id.schoolName_text)

        //dataViewModel.text.observe(this, Observer { //textView.text = it })
        return root
    }
}