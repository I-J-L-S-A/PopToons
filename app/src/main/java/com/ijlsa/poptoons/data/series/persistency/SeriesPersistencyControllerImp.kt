package com.ijlsa.poptoons.data.series.persistency

import com.ijlsa.poptoons.ui.model.Categories
import com.ijlsa.poptoons.ui.model.Series
import java.util.*

class SeriesPersistencyControllerImp: SeriesPersistencyController {

    private var seriesList = mutableListOf<Series>()

    override fun getSeries(): List<Series> {
        return seriesList
    }

    override fun searchSeries(query: String): List<Series>{
        return seriesList.filter {
            it.title.lowercase(Locale.getDefault()).contains(query.lowercase(Locale.getDefault()))
        }
    }

    override fun saveSeries(series: List<Series>) {
        seriesList = series.toMutableList()
    }
}