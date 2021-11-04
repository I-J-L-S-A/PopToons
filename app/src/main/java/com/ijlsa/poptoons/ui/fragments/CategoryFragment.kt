package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.ijlsa.poptoons.databinding.FragmentCategoryBinding
import com.ijlsa.poptoons.ui.adapters.CategoriesListAdapter
import com.ijlsa.poptoons.ui.viewmodels.SeriesViewModel

class CategoryFragment: Fragment() {
    private val categoryAdapter = CategoriesListAdapter()
    private lateinit var binding: FragmentCategoryBinding
    private val seriesViewModel: SeriesViewModel by activityViewModels()
    private val args: CategoryFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.tvTitleCategory.text = args.category.toString()


        binding.rvCategory.adapter = categoryAdapter
        binding.rvCategory.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)

        seriesViewModel.series.observe(viewLifecycleOwner) {
            categoryAdapter.addAll(it.filter { serie ->
                serie.genres.contains(args.category)
            })
        }

        categoryAdapter.setOnSerieClickListener {
            val directions = CategoryFragmentDirections.actionCategoryFragmentToSerieDetailsFragment(it)
            findNavController().navigate(directions)
        }

    }
}