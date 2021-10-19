package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.ui.adapters.CategoriesListAdapter
import com.ijlsa.poptoons.ui.data.temp_data

class CategoryFragment: Fragment() {
    private val categoryAdapter = CategoriesListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvCategory)
        recyclerView.adapter = categoryAdapter
        recyclerView.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        categoryAdapter.addAll(temp_data.seriesList)
    }
}