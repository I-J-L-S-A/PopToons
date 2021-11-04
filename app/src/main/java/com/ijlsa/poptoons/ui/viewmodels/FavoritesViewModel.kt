package com.ijlsa.poptoons.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ijlsa.poptoons.data.favorites.FavoritesRepository
import com.ijlsa.poptoons.data.favorites.persistency.FavoritesPersistencyControllerImpl
import com.ijlsa.poptoons.data.series.SeriesRepository
import com.ijlsa.poptoons.data.series.network.SeriesNetworkControllerImp
import com.ijlsa.poptoons.data.series.persistency.SeriesPersistencyControllerImp
import kotlinx.coroutines.Dispatchers

class FavoritesViewModel: ViewModel() {
    val favoritesRepository = FavoritesRepository(FavoritesPersistencyControllerImpl())
    val favorites = favoritesRepository.getFavoriteSeries().asLiveData(Dispatchers.IO)
}