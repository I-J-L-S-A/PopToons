package com.ijlsa.poptoons.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.databinding.HomeCategoriesListBinding
import com.ijlsa.poptoons.ui.data.temp_data
import com.ijlsa.poptoons.ui.fragments.HomeFragmentDirections
import com.ijlsa.poptoons.ui.model.Series

class HomeCategoriesListAdapter(private val parentFragment: Fragment) : RecyclerView.Adapter<HomeCategoriesListViewH>() {

    private val elementList: MutableList<String> = mutableListOf()
    private var onSerieItemClickListener: (() -> Unit)? = null

    fun addAll(newElementList: MutableList<String>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoriesListViewH {
        val binding = HomeCategoriesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeCategoriesListViewH(binding, parentFragment)
    }

    override fun onBindViewHolder(holder: HomeCategoriesListViewH, position: Int) {
        holder.bind(elementList[position])
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

    fun bind(category: String) {

        binding.tvCategory.text = category.toString()
        binding.tvCategory.setOnClickListener{
            val directions = HomeFragmentDirections.actionHomeFragmentToCategoryFragment()
            parentFragment.findNavController().navigate(directions)
        }
        binding.tvSeriesList.adapter = seriesAdapter
        binding.tvSeriesList.layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)

        seriesAdapter.addAll(listOfCategorySeries(category, temp_data.seriesList))
        seriesAdapter.setOnSerieClickListener{
            val directions = HomeFragmentDirections.actionHomeFragmentToSerieDetailsFragment(it)
            parentFragment.findNavController().navigate(directions)
        }

    }

    private fun listOfCategorySeries(
        category: String,
        seriesList: MutableList<Series>
    ): MutableList<Series> {
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