package com.ijlsa.poptoons.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ijlsa.poptoons.ui.model.Episodes
import com.ijlsa.poptoons.ui.model.Series
import kotlinx.coroutines.flow.Flow

@Dao
interface EpisodesDao {

    @Query("SELECT * FROM   Episodes WHERE serieId LIKE :query1 AND numSeason LIKE :query2")
    fun getAllEpisodes(query1 :Int, query2 :Int): Flow<List<Episodes>>

}