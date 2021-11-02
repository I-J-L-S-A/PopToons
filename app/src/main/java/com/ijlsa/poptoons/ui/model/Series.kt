package com.ijlsa.poptoons.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Series (@PrimaryKey val id: Int,
                   val title: String,
                   val imageUrl_Preview: String,
                   val imageUrl_Presentation: String,
                   val description: String,
                   val seasons: MutableList<MutableList<Episodes>>, // TODO ARREGLAR ENTRADA/TABLA EN -RED NODE(?-
                   val publication_year: Int,
                   val genres: MutableList<Categories>): Serializable