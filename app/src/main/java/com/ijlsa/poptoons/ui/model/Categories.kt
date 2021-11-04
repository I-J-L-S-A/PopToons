package com.ijlsa.poptoons.ui.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
enum class Categories {
    @SerializedName("Comedy")
    Comedy,
    @SerializedName("Child")
    Child,
    @SerializedName("Adult")
    Adult,
    @SerializedName("Adventure")
    Adventure,
    @SerializedName("Sh")
    Superheroes,
    @SerializedName("Anime")
    Anime,
    @SerializedName("60")
    Decade1960,
    @SerializedName("Ac")
    Action,
    @SerializedName("Musical")
    Musical,
    @SerializedName("DH")
    DarkHumor,
    @SerializedName("Sat")
    Satire,
    @SerializedName("SOp")
    SoapOpera,
    @SerializedName("edu")
    Educative,
    @SerializedName("Drama")
    Drama,
    @SerializedName("Cmr")
    RomanticComedy,
    @SerializedName("Mock")
    Mockumentary,
    @SerializedName("Fan")
    Fantasy,
    @SerializedName("SciFi")
    ScienceFiction,
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