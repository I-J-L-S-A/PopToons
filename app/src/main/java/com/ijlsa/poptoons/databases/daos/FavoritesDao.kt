package com.ijlsa.poptoons.databases.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ijlsa.poptoons.ui.model.Favorite
import com.ijlsa.poptoons.ui.model.Series
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM favorite WHERE serieId = :serieId")
    fun getSerieById(serieId: Int): Flow<Favorite>

    @Query("SELECT s.* FROM series AS s, favorite AS f WHERE s.id = f.serieId")
    fun getFavoriteSeries(): List<Series>

    @Query("SELECT * FROM favorite")
    fun getAllSeries(): List<Favorite>

    @Insert
    fun saveToFavorites(favorite: Favorite)

    @Delete
    fun deleteFavorite(favorite: Favorite)

}