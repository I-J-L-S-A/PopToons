package com.ijlsa.poptoons.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ijlsa.poptoons.databinding.SearchCategoriesListBinding
import com.ijlsa.poptoons.ui.model.Categories

class SearchPageCategoriesListAdapter() : RecyclerView.Adapter<SearchPageCategoriesListAdapterViewHolder>() {

    private val elementList: MutableList<Categories> = mutableListOf()
    private var onCategoryItemClickListener: ((category: Categories) -> Unit)? = null

    fun addAll(newElementList: List<Categories>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPageCategoriesListAdapterViewHolder {
        val binding = SearchCategoriesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchPageCategoriesListAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchPageCategoriesListAdapterViewHolder, position: Int) {
        holder.bind(elementList[position])
        holder.binding.root.setOnClickListener{
            onCategoryItemClickListener?.invoke(elementList[position])
        }
    }

    override fun getItemCount(): Int {
        return elementList.size
    }

    fun setOnCategoryItemClickListener(onCategoryItemClickListener: ((category: Categories)-> Unit)?){
        this.onCategoryItemClickListener = onCategoryItemClickListener
    }

}

class SearchPageCategoriesListAdapterViewHolder(val binding: SearchCategoriesListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(category: Categories) {

        binding.tvCategory.text = category.toString()


    }

}