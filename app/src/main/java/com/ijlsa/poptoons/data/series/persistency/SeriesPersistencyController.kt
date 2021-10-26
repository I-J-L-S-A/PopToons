package com.ijlsa.poptoons.data.series.persistency

import com.ijlsa.poptoons.ui.model.Series

interface SeriesPersistencyController {
    fun getSeries(): List<Series>
    fun searchSeries(query: String): List<Series>
    fun saveSeries(series: List<Series>)
}