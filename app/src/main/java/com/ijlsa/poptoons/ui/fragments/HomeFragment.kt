package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ijlsa.poptoons.databinding.FragmentHomeBinding
import com.ijlsa.poptoons.ui.adapters.HomeCategoriesListAdapter
import com.ijlsa.poptoons.ui.model.Categories

class HomeFragment : StepsBaseFragment() {

    private val homeAdapter = HomeCategoriesListAdapter(this)
    private lateinit var binding: FragmentHomeBinding

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

        homeAdapter.addAll(Categories.values().toList())
        //homeAdapter.setOnSeriesItemClickListener{
        //    findNavController().navigate(R.id.action_homeFragment_to_serieDetailsFragment)
        //}

    }
}