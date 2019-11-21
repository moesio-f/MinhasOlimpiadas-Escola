package com.moesiof.minhasolimpiadas_escola.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moesiof.minhasolimpiadas_escola.EditActivity
import com.moesiof.minhasolimpiadas_escola.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var dataset: MutableList<Olympics>
    private val REQUEST_CODE = 1010

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel.getAllOlympics().observe(this, Observer<MutableList<Olympics>>{
            dataset = it
            viewManager = LinearLayoutManager(root.context)
            viewAdapter = OlympicsAdapter(dataset, ::editOlympics)
            recyclerView = rvHome.apply {
                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter
            }
        })
        return root
    }

    fun editOlympics(position : Int)
    {
        val intent = Intent(context, EditActivity::class.java)
        intent.putExtra("olympics", dataset[position])
        startActivityForResult(intent,  REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE)
        {
            homeViewModel.loadOlympics()
        }
    }
}