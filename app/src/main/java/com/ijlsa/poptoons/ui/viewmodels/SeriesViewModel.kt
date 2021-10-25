package com.ijlsa.poptoons.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ijlsa.poptoons.ui.data.SerieDataSource

class SeriesViewModel : ViewModel() {
    val filteredSeries = MutableLiveData(SerieDataSource.getSeries())

    fun searchSerie(query: String){
        filteredSeries.postValue(SerieDataSource.searchSeries(query))
    }
}