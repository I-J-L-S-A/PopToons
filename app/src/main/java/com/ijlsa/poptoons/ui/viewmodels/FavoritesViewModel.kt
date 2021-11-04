package com.ijlsa.poptoons.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ijlsa.poptoons.data.favorites.FavoritesRepository
import com.ijlsa.poptoons.data.favorites.persistency.FavoritesPersistencyControllerImpl
import kotlinx.coroutines.Dispatchers

class FavoritesViewModel: ViewModel() {
    val favoritesRepository = FavoritesRepository(FavoritesPersistencyControllerImpl())
    val favorites = favoritesRepository.getFavoriteSeries().asLiveData(Dispatchers.IO)
}