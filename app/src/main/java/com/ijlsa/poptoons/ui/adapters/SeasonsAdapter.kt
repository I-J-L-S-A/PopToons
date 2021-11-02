package com.ijlsa.poptoons.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ijlsa.poptoons.databinding.DetailsSeasonsItemBinding
import com.ijlsa.poptoons.ui.model.Episodes

class SeasonsAdapter(private val parentFragment: Fragment) : RecyclerView.Adapter<SeasonsListViewH>() {

    private val elementList: MutableList<List<Episodes>> = mutableListOf()
    //private var onSerieItemClickListener: (() -> Unit)? = null

    fun addAll(newElementList: List<List<Episodes>>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonsListViewH {
        val binding = DetailsSeasonsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeasonsListViewH(binding, parentFragment)
    }

    override fun onBindViewHolder(holder: SeasonsListViewH, position: Int) {
        holder.bind(position, elementList[position])
    }

    override fun getItemCount(): Int {
        return elementList.size
    }

    /*fun setOnSeriesItemClickListener(onSerieItemClickListener: (() -> Unit)?){
        this.onSerieItemClickListener = onSerieItemClickListener
    }*/

}

class SeasonsListViewH(val binding: DetailsSeasonsItemBinding, private val parentFragment: Fragment) : RecyclerView.ViewHolder(binding.root) {

    private val episodesAdapter = EpisodesListsAdapter()

    fun bind(season: Int, episodes: List<Episodes>) {

        binding.tvSeason.text = "Temporada $season"
        binding.rvEpisodes.adapter = episodesAdapter
        binding.rvEpisodes.layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL, false)

        episodesAdapter.addAll(episodes as MutableList<Episodes>)
        /*episodesAdapter.setOnSerieClickListener{
            val directions = HomeFragmentDirections.actionHomeFragmentToSerieDetailsFragment(it)
            parentFragment.findNavController().navigate(directions)
        }*/

    }

    /*private fun listOfEpisodes(
        season: Int,
        episodes: List<Episodes>
    ): MutableList<Episodes> {

        return episodes.filter { episodes ->
            episodes.numSeason == season
        } as MutableList<Episodes>
    }*/
}