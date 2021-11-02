package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.databinding.FragmentCategoryBinding
import com.ijlsa.poptoons.databinding.FragmentSerieDetailsBinding
import com.ijlsa.poptoons.ui.model.Favorite
import com.ijlsa.poptoons.ui.model.Series
import com.ijlsa.poptoons.ui.viewmodels.SerieDetailViewModel
import com.ijlsa.poptoons.ui.viewmodels.SeriesViewModel
import java.util.*

class SerieDetailsFragment : StepsBaseFragment() {

    val args: SerieDetailsFragmentArgs by navArgs()
    lateinit var mySerie : Series
    private lateinit var binding: FragmentSerieDetailsBinding
    private val serieDetailViewModel: SerieDetailViewModel by viewModels()
    var isFavorite = false

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
        binding.tvSeasonsNumber.text = mySerie.seasons.toString()
        binding.tvSinopsis.text = mySerie.description

        serieDetailViewModel.favorite.observe(viewLifecycleOwner){
            isFavorite = it != null
            if(isFavorite){
                binding.buttonFavorite.text = "ES FAVORITO"
            } else {
                binding.buttonFavorite.text = "NO ES FAVORITO"
            }
        }

        serieDetailViewModel.getFavoriteBySerieId(mySerie.id)

        binding.buttonFavorite.setOnClickListener{
            if(isFavorite){
                serieDetailViewModel.deleteFavorite(serieDetailViewModel.favorite.value!!)
            } else {
                serieDetailViewModel.saveFavorite(Favorite(1, mySerie.id, System.currentTimeMillis().toString()))
            }
        }
    }
}