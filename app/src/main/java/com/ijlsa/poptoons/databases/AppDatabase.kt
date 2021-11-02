package com.ijlsa.poptoons.databases

import androidx.room.Database
import androidx.room.RoomDatabase

import com.ijlsa.poptoons.databases.daos.FavoritesDao
import com.ijlsa.poptoons.databases.daos.SeriesDao
import com.ijlsa.poptoons.ui.model.Favorite
import com.ijlsa.poptoons.ui.model.Series
import androidx.room.TypeConverters
import com.ijlsa.poptoons.data.series.persistency.SeriesConverters
import com.ijlsa.poptoons.databases.daos.EpisodesDao
import com.ijlsa.poptoons.ui.model.Episodes


@Database(entities = [Series::class, Favorite::class, Episodes::class], version=1)
@TypeConverters(SeriesConverters::class)
abstract class AppDatabase: RoomDatabase(){
    abstract fun seriesDao(): SeriesDao
    abstract fun favoritesDao(): FavoritesDao
    abstract fun episodesDao(): EpisodesDao

}