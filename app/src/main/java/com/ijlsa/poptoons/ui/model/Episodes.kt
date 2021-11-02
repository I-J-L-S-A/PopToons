package com.ijlsa.poptoons.ui.model


import java.io.FileDescriptor
import java.io.Serializable

data class Episodes (val numSeason :Int,
                     val numEpisodio:Int,
                     val eTitle: String,
                     val duration: String,
                     val description: String
                     /*val status: Boolean*/): Serializable