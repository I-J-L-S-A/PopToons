package com.ijlsa.poptoons.data.series.persistency

import com.ijlsa.poptoons.App
import com.ijlsa.poptoons.ui.model.Series
import kotlinx.coroutines.flow.Flow

class SeriesPersistencyControllerImp: SeriesPersistencyController {

    private val db = App.db

    override fun getSeries(): Flow<List<Series>> {
        return db.seriesDao().getAllSeries()
    }

    override fun searchSeries(query: String): List<Series>{
        return db.seriesDao().searchSeries(query)
    }

    override fun saveSeries(series: List<Series>) {
        db.seriesDao().saveAllSeries(series)
    }
}