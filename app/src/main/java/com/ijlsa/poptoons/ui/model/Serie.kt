package com.ijlsa.poptoons.ui.model

import java.io.Serializable

data class Serie (val title: String,
                  val imageUrl_Preview: String,
                  val imageUrl_Presentation: String,
                  val description: String,
                  val seasons: Int,
                  val publication_year: Int,
                  val episodes: MutableList<MutableList<String>>,
                  val genders: MutableList<String>): Serializable