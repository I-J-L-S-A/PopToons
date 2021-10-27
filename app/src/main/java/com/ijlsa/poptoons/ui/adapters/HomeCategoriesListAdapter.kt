package com.ijlsa.poptoons.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ijlsa.poptoons.databinding.HomeCategoriesListBinding
import com.ijlsa.poptoons.ui.fragments.HomeFragmentDirections
import com.ijlsa.poptoons.ui.model.Categories
import com.ijlsa.poptoons.ui.model.Series
import com.ijlsa.poptoons.ui.viewmodels.SeriesViewModel

class HomeCategoriesListAdapter(private val parentFragment: Fragment) : RecyclerView.Adapter<HomeCategoriesListViewH>() {

    private val elementList: MutableList<Categories> = mutableListOf()
    private var onSerieItemClickListener: (() -> Unit)? = null
    private var series = mutableListOf<Series>()

    fun addAll(newElementList: List<Categories>, series: List<Series>) {
        elementList.clear()
        elementList.addAll(newElementList)
        this.series = series.toMutableList()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoriesListViewH {
        val binding = HomeCategoriesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeCategoriesListViewH(binding, parentFragment)
    }

    override fun onBindViewHolder(holder: HomeCategoriesListViewH, position: Int) {
        holder.bind(elementList[position], this.series)
    }

    override fun getItemCount(): Int {
        return elementList.size
    }

    fun setOnSeriesItemClickListener(onSerieItemClickListener: (() -> Unit)?){
        this.onSerieItemClickListener = onSerieItemClickListener
    }
}

class HomeCategoriesListViewH(val binding: HomeCategoriesListBinding, private val parentFragment: Fragment) : RecyclerView.ViewHolder(binding.root) {

    private val seriesAdapter = HomeSeriesListsAdapter()

    fun bind(category: Categories, series: List<Series>) {

        binding.tvCategory.text = category.toString()
        binding.tvCategory.setOnClickListener{
            val directions = HomeFragmentDirections.actionHomeFragmentToCategoryFragment(category)
            parentFragment.findNavController().navigate(directions)
        }
        binding.tvSeriesList.adapter = seriesAdapter
        binding.tvSeriesList.layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)

        seriesAdapter.addAll(listOfCategorySeries(category, series))
        seriesAdapter.setOnSerieClickListener{
            val directions = HomeFragmentDirections.actionHomeFragmentToSerieDetailsFragment(it)
            parentFragment.findNavController().navigate(directions)
        }

    }

    private fun listOfCategorySeries(
        category: Categories,
        seriesList: List<Series>
    ): List<Series> {
//        var newSeriesList = mutableListOf<Serie>()

//        seriesList.forEach { serie ->
//            serie.genders.forEach { gender ->
//                if (gender == category) newSeriesList.add(serie)
//            }
//        }
        return seriesList.filter { serie ->
            serie.genres.contains(category)
        } as MutableList<Series>
    }
}