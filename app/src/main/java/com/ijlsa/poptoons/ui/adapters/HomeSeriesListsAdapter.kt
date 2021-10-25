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
import com.ijlsa.poptoons.databinding.HomeItemListBinding
import com.ijlsa.poptoons.ui.model.Series

class HomeSeriesListsAdapter : RecyclerView.Adapter<HomeSeriesListViewH>() {

    private val elementList: MutableList<Series> = mutableListOf()
    private var onSerieClickListener: ((serie: Series) -> Unit)? = null

    fun addAll(newElementList: List<Series>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    fun setOnSerieClickListener(onSerieClickListener: ((serie: Series) -> Unit)?){
        this.onSerieClickListener = onSerieClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSeriesListViewH {
        val binding = HomeItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeSeriesListViewH(binding)
    }

    override fun onBindViewHolder(holder: HomeSeriesListViewH, position: Int) {
        holder.bind(elementList[position])
        holder.itemView.setOnClickListener{
            onSerieClickListener?.invoke(elementList[position])
        }
    }

    override fun getItemCount(): Int {
        return elementList.size
    }

}

class HomeSeriesListViewH(val binding: HomeItemListBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(series: Series) {
        binding.tvTitleSerie.text = series.title

        Glide.with(itemView)
            .load(series.imageUrl_Preview)
            .transform(CenterCrop(), RoundedCorners(27))
            .into(binding.ivImageSerie)
    }
}