package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ijlsa.poptoons.databinding.FragmentHomeBinding
import com.ijlsa.poptoons.ui.adapters.HomeCategoriesListAdapter
import com.ijlsa.poptoons.ui.model.Categories
import com.ijlsa.poptoons.ui.viewmodels.SeriesViewModel

class HomeFragment : StepsBaseFragment() {

    private val homeAdapter = HomeCategoriesListAdapter(this)
    private lateinit var binding: FragmentHomeBinding
    private val seriesViewModel: SeriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvHome.adapter = homeAdapter
        binding.rvHome.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        seriesViewModel.series.observe(viewLifecycleOwner){
            val categoriesHome = Categories.values().toList()
            homeAdapter.addAll(categoriesHome.subList(0, 8) ,it)
        }

    }
}