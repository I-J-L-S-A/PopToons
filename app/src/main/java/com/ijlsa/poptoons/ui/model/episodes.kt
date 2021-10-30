package com.ijlsa.poptoons.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Episodes (@PrimaryKey val id: Int,
                   val serieId: Int,
                   val eTitle: String,
                   val status: String): Serializable