package com.ijlsa.poptoons.data.series

import com.ijlsa.poptoons.NetworkUtils
import com.ijlsa.poptoons.data.series.network.SeriesNetworkController
import com.ijlsa.poptoons.data.series.persistency.SeriesPersistencyController
import com.ijlsa.poptoons.ui.model.Series
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SeriesRepository(
    val network: SeriesNetworkController,
    val persistency: SeriesPersistencyController
) {

    fun getSeries(): Flow<List<Series>> {
        return flow {
            emit(persistency.getSeries())
            try {
                if(NetworkUtils.isOnline){
                    val series = network.getSeries()
                    persistency.saveSeries(series)
                    emit(series)
                }
            } catch (e: Exception) {
            }
        }
        //return persistency.getSeries()
    }

    fun searchSeries(query: String): Flow<List<Series>> {
        return persistency.searchSeries(query)
    }
}