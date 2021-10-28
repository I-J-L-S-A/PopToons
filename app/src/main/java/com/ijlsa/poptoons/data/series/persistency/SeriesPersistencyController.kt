package com.ijlsa.poptoons.data.series.persistency

import com.ijlsa.poptoons.ui.model.Series
import kotlinx.coroutines.flow.Flow

interface SeriesPersistencyController {
    fun getSeries(): Flow<List<Series>>
    fun searchSeries(query: String): List<Series>
    fun saveSeries(series: List<Series>)
}