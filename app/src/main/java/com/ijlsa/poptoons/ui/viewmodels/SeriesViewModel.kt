package com.ijlsa.poptoons.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ijlsa.poptoons.data.series.SeriesRepository
import com.ijlsa.poptoons.data.series.network.SeriesNetworkControllerImp
import com.ijlsa.poptoons.data.series.persistency.SeriesPersistencyControllerImp
import com.ijlsa.poptoons.ui.model.Series
import kotlinx.coroutines.Dispatchers

class SeriesViewModel : ViewModel() {
    val seriesRepository =
        SeriesRepository(SeriesNetworkControllerImp(), SeriesPersistencyControllerImp())
    val series = seriesRepository.getSeries().asLiveData(Dispatchers.IO)
    lateinit var resultSeries: LiveData<List<Series>>
    /*fun getSeries(){
        seriesRepository.getSeries().onEach {
            series.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }*/

    fun searchSerie(query: String) {
        resultSeries = seriesRepository.searchSeries(query).asLiveData(Dispatchers.IO)
    }
}