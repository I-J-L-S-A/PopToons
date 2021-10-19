package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.ui.model.Serie

class SerieDetailsFragment : StepsBaseFragment() {

    val args: SerieDetailsFragmentArgs by navArgs()
    lateinit var mySerie : Serie

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_serie_details, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = view.findViewById<ImageView>(R.id.tvImageSerie)
        val title = view.findViewById<TextView>(R.id.tvTitleSerie)
        val season = view.findViewById<TextView>(R.id.tvSeasonsNumber)
        val sinopsis = view.findViewById<TextView>(R.id.tvSinopsis)

        mySerie = args.serie
        Glide.with(view)
            .load(mySerie.imageUrl_Presentation)
            .transform(CenterCrop(), RoundedCorners(25))
            .into(image)
        title.text = mySerie.title
        season.text = mySerie.seasons.toString()
        sinopsis.text = mySerie.description
    }
}