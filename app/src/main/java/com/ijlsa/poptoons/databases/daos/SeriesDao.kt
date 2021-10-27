package com.ijlsa.poptoons.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ijlsa.poptoons.ui.model.Series

@Dao
interface SeriesDao {

    @Query("SELECT * FROM series")
    fun getAllSeries(): List<Series>

    @Insert
    fun saveAllSeries(Series: List<Series>)

    @Query("SELECT * FROM series WHERE title LIKE :query")
    fun searchSeries(query: String): List<Series>
}