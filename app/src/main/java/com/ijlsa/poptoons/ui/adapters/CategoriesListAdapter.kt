package com.ijlsa.poptoons.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.ui.model.Series

class CategoriesListAdapter: RecyclerView.Adapter<CategoriesViewHolder>() {

    val elementList: MutableList<Series> = mutableListOf()

    fun addAll(newElementList: MutableList<Series>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_item_list, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(elementList[position])
    }

    override fun getItemCount(): Int {
        return elementList.size
    }
}

class CategoriesViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView){
    private val ivImageSerie = itemView.findViewById<ImageView>(R.id.ivImageSerie)
    private val tvTitleSerie = itemView.findViewById<TextView>(R.id.tvTitleSerie)

    fun bind(series: Series) {
        tvTitleSerie.text = series.title

        Glide.with(itemView)
            .load(series.imageUrl_Preview)
            .transform(CenterCrop(), RoundedCorners(27))
            .into(ivImageSerie)
    }
}