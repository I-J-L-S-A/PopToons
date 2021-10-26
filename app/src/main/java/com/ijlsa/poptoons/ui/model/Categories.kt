package com.ijlsa.poptoons.ui.model

import com.google.gson.annotations.SerializedName

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
    @SerializedName("90")
    Decade1990,
    @SerializedName("00")
    Decade2000,
    @SerializedName("10")
    Decade2010
}