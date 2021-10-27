package com.ijlsa.poptoons.ui.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
enum class Categories {
    @SerializedName("Comedy")
    Comedy,
    @SerializedName("Child")
    Child,
    @SerializedName("Adventure")
    Adventure,
    @SerializedName("SciFi")
    ScienceFiction,
    @SerializedName("DH")
    DarkHumor,
    @SerializedName("60")
    Decade1960,
    @SerializedName("70")
    Decade1970,
    @SerializedName("80")
    Decade1980,
    @SerializedName("90")
    Decade1990,
    @SerializedName("00")
    Decade2000,
    @SerializedName("10")
    Decade2010
}