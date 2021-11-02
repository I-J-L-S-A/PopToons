package com.ijlsa.poptoons.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ijlsa.poptoons.ui.model.Series
import kotlinx.coroutines.flow.Flow

@Dao
interface SeriesDao {

    @Query("SELECT * FROM series")
    fun getAllSeries(): Flow<List<Series>>

    @Insert
    fun saveAllSeries(series: List<Series>)

    @Query("SELECT * FROM series WHERE title LIKE :query")
    fun searchSeries(query: String): Flow<List<Series>>
}