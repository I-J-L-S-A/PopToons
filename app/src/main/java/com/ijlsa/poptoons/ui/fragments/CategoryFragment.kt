package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.databinding.FragmentCategoryBinding
import com.ijlsa.poptoons.ui.adapters.CategoriesListAdapter
import com.ijlsa.poptoons.ui.data.temp_data

class CategoryFragment: Fragment() {
    private val categoryAdapter = CategoriesListAdapter()
    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvCategory.adapter = categoryAdapter
        binding.rvCategory.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        categoryAdapter.addAll(temp_data.seriesList)
    }
}