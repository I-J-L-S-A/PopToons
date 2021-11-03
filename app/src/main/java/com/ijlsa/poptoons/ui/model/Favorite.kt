package com.ijlsa.poptoons.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val serieId: Int,
    val date: String
    )