package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ijlsa.poptoons.databinding.FragmentSearchBinding
import com.ijlsa.poptoons.ui.adapters.HomeSeriesListsAdapter
import com.ijlsa.poptoons.ui.adapters.SearchPageCategoriesListAdapter
import com.ijlsa.poptoons.ui.model.Categories
import com.ijlsa.poptoons.ui.viewmodels.SearchViewModel
import com.ijlsa.poptoons.ui.viewmodels.SeriesViewModel

class SearchFragment : StepsBaseFragment() {

    private lateinit var binding: FragmentSearchBinding
    private val seriesListAdapter = HomeSeriesListsAdapter()
    private val categoriesListAdapter = SearchPageCategoriesListAdapter()
    private val seriesViewModel: SeriesViewModel by viewModels()
    private val searchViewModel: SearchViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.seriesResult.adapter = seriesListAdapter
        binding.categoriesList.adapter = categoriesListAdapter

        binding.seriesResult.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        seriesListAdapter.setOnSerieClickListener {
            val directions = SearchFragmentDirections.actionSearchFragmentToSerieDetailsFragment(it)
            findNavController().navigate(directions)
        }

        binding.categoriesList.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        categoriesListAdapter.setOnCategoryItemClickListener {
            val directions = SearchFragmentDirections.actionSearchFragmentToCategoryFragment(it)
            findNavController().navigate(directions)
        }

        categoriesListAdapter.addAll(Categories.values().toList())

        seriesViewModel.series.observe(viewLifecycleOwner) {
            seriesListAdapter.addAll(it)
        }
        //seriesViewModel.getSeries(requireContext())


        //TODO implementar un text watcher
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //searchViewModel.searchStarted.postValue( s != null && s.isNotEmpty())
                if (!s.isNullOrEmpty()) {
                    binding.seriesResult.visibility = View.VISIBLE
                } else {
                    binding.seriesResult.visibility = View.GONE
                }
                seriesViewModel.searchSerie(s.toString())
            }
        }

        binding.searchToolbar.addTextChangedListener(textWatcher)
    }
}