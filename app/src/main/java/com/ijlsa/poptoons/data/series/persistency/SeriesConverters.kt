package com.ijlsa.poptoons.data.series.persistency

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ijlsa.poptoons.ui.model.Episodes

import com.google.gson.reflect.TypeToken
import com.ijlsa.poptoons.ui.model.Categories

class SeriesConverters {
    @TypeConverter
    fun fromListOfEpisodes(value: List<List<Episodes>>): String? {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun stringToListOfEpisodes(value: String): List<List<Episodes>>? {
        val gson = Gson()
        return gson.fromJson(value, object : TypeToken<List<List<Episodes>>>() {}.type)
    }

    @TypeConverter
    fun fromGenres(value: List<Categories>): String? {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun stringToListOfCategories(value: String): List<Categories>? {
        val gson = Gson()
        return gson.fromJson(value, object : TypeToken<List<Categories>>() {}.type)
    }
}