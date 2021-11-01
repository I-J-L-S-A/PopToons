package com.ijlsa.poptoons.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ijlsa.poptoons.data.series.persistency.SeriesConverters
import com.ijlsa.poptoons.databases.daos.EpisodesDao
import com.ijlsa.poptoons.databases.daos.SeriesDao
import com.ijlsa.poptoons.ui.model.Episodes
import com.ijlsa.poptoons.ui.model.Series

@Database(entities = [Series::class, Episodes::class], version=1)
@TypeConverters(SeriesConverters::class)
abstract class AppDatabase: RoomDatabase(){
    abstract fun seriesDao(): SeriesDao
    abstract fun episodesDao(): EpisodesDao
}