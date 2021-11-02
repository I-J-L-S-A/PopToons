package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.databinding.FragmentCategoryBinding
import com.ijlsa.poptoons.databinding.FragmentSerieDetailsBinding
import com.ijlsa.poptoons.ui.adapters.HomeCategoriesListAdapter
import com.ijlsa.poptoons.ui.adapters.SeasonsAdapter
import com.ijlsa.poptoons.ui.model.Categories
import com.ijlsa.poptoons.ui.model.Series
import com.ijlsa.poptoons.ui.viewmodels.SeriesViewModel

class SerieDetailsFragment : StepsBaseFragment() {

    val args: SerieDetailsFragmentArgs by navArgs()
    lateinit var mySerie : Series
    private lateinit var binding: FragmentSerieDetailsBinding
    private val seasonsAdapter = SeasonsAdapter(this)
    private val seriesViewModel: SeriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSerieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mySerie = args.serie
        Glide.with(view)
            .load(mySerie.imageUrl_Presentation)
            .transform(CenterCrop(), RoundedCorners(25))
            .into(binding.tvImageSerie)
        binding.tvTitleSerie.text = mySerie.title
        //binding.tvSeasonsNumber.text = mySerie.seasons.toString()
        binding.tvSinopsis.text = mySerie.description
        binding.tvDetNTemp.text = "Temporadas disponibles: " + mySerie.seasons.size
        binding.rvSeasons.adapter = seasonsAdapter
        binding.rvSeasons.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        seasonsAdapter.addAll(mySerie.seasons)

    }
}