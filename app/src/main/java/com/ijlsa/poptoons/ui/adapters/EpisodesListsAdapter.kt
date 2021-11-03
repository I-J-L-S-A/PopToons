package com.ijlsa.poptoons.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ijlsa.poptoons.databinding.DetailsEpisodeItemBinding
import com.ijlsa.poptoons.ui.model.Episodes
import com.ijlsa.poptoons.ui.model.Series

class EpisodesListsAdapter : RecyclerView.Adapter<EpisodesListViewH>() {

    private val elementList: MutableList<Episodes> = mutableListOf()
    //private var onSerieClickListener: ((serie: Series) -> Unit)? = null

    fun addAll(newElementList: MutableList<Episodes>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    /*fun setOnSerieClickListener(onSerieClickListener: ((serie: Series) -> Unit)?){
        this.onSerieClickListener = onSerieClickListener
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesListViewH {
        val binding = DetailsEpisodeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodesListViewH(binding)
    }

    override fun onBindViewHolder(holder: EpisodesListViewH, position: Int) {
        holder.bind(elementList[position])
        /*holder.itemView.setOnClickListener{
            onSerieClickListener?.invoke(elementList[position])
        }*/
    }

    override fun getItemCount(): Int {
        return elementList.size
    }

}

class EpisodesListViewH(val binding: DetailsEpisodeItemBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(episode: Episodes) {
        val num:Int  = episode.numEpisode
        binding.tvnumEp.text = "Episodio $num"
        binding.tvTitleEp.text = episode.eTitle
        binding.tvDuration.text = episode.duration
    }
}