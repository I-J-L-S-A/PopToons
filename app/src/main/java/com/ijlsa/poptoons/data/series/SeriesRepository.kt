package com.ijlsa.poptoons.data.series

import android.content.Context
import com.ijlsa.poptoons.NetworkUtils
import com.ijlsa.poptoons.data.series.network.SeriesNetworkController
import com.ijlsa.poptoons.data.series.persistency.SeriesPersistencyController
import com.ijlsa.poptoons.isNetworkConnected
import com.ijlsa.poptoons.ui.model.Series
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SeriesRepository(val network: SeriesNetworkController,
                       val persistency: SeriesPersistencyController) {

    fun getSeries(): Flow<List<Series>> {
        flow {
            /*val persistencyVar = persistency.getSeries()
            if (persistencyVar.size > 0) {

            }*/
            try {
                if(NetworkUtils.isOnline){
                    val series = network.getSeries()
                    persistency.saveSeries(series)
                    emit(series)
                }
            } catch (e: Exception) {

            }
        }

        return persistency.getSeries()
    }

    fun searchSeries(query: String): List<Series>{
        return persistency.searchSeries(query)
    }
}