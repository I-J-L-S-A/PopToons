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
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_categories_list, parent, false)
        return HomeCategoriesListViewH(view, parentFragment)
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

class HomeCategoriesListViewH(itemView: View, private val parentFragment: Fragment) : RecyclerView.ViewHolder(itemView) {

    private val tvCategory = itemView.findViewById<TextView>(R.id.tvCategorie)
    private val recyclerView = itemView.findViewById<RecyclerView>(R.id.tvSeriesList)
    private val seriesAdapter = HomeSeriesListsAdapter()

    fun bind(category: String) {

        tvCategory.text = category.toString()
        recyclerView.adapter = seriesAdapter
        recyclerView.layoutManager =
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