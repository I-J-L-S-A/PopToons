package com.ijlsa.poptoons.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ijlsa.poptoons.databases.daos.FavoritesDao
import com.ijlsa.poptoons.databases.daos.SeriesDao
import com.ijlsa.poptoons.ui.model.Favorite
import com.ijlsa.poptoons.ui.model.Series

@Database(entities = [Series::class, Favorite::class], version=1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun seriesDao(): SeriesDao
    abstract fun favoritesDao(): FavoritesDao
}