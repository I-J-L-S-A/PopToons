package com.ijlsa.poptoons.ui.model

import java.io.Serializable

data class Episodes (val numSeason :Int,
                     val numEpisode:Int,
                     val eTitle: String,
                     val duration: String,
                     val description: String): Serializable