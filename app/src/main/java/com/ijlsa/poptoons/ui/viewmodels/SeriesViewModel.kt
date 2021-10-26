package com.ijlsa.poptoons.ui.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ijlsa.poptoons.data.series.SeriesRepository
import com.ijlsa.poptoons.data.series.network.SeriesNetworkControllerImp
import com.ijlsa.poptoons.data.series.persistency.SeriesPersistencyControllerImp
import com.ijlsa.poptoons.ui.model.Series
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SeriesViewModel : ViewModel() {
    val seriesRepository = SeriesRepository(SeriesNetworkControllerImp(), SeriesPersistencyControllerImp())
    val series = seriesRepository.getSeries().asLiveData()
    val resultSeries = MutableLiveData<List<Series>>()
/*    fun getSeries(){
        seriesRepository.getSeries().onEach {
            series.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }*/

    fun searchSerie(query: String){
        resultSeries.postValue(seriesRepository.searchSeries(query))
    }
}