package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.ui.adapters.HomeCategoriesListAdapter
import com.ijlsa.poptoons.ui.data.temp_data

class HomeFragment : StepsBaseFragment() {

    private val homeAdapter = HomeCategoriesListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvHome)
        recyclerView.adapter = homeAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        homeAdapter.addAll(temp_data.categoriesList)
        //homeAdapter.setOnSeriesItemClickListener{
        //    findNavController().navigate(R.id.action_homeFragment_to_serieDetailsFragment)
        //}

    }
}