package com.ijlsa.poptoons.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ijlsa.poptoons.databases.daos.SeriesDao
import com.ijlsa.poptoons.ui.model.Series

@Database(entities = [Series::class], version=1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun seriesDao(): SeriesDao
}