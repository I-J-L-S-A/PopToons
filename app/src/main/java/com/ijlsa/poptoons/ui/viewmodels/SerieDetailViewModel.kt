package com.ijlsa.poptoons.ui.viewmodels

import android.content.Context
import android.content.LocusId
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ijlsa.poptoons.data.favorites.FavoritesRepository
import com.ijlsa.poptoons.data.favorites.persistency.FavoritesPersistencyControllerImpl
import com.ijlsa.poptoons.data.series.SeriesRepository
import com.ijlsa.poptoons.data.series.network.SeriesNetworkControllerImp
import com.ijlsa.poptoons.data.series.persistency.SeriesPersistencyControllerImp
import com.ijlsa.poptoons.ui.model.Favorite
import com.ijlsa.poptoons.ui.model.Series
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SerieDetailViewModel : ViewModel() {
    private val favoritesRepository = FavoritesRepository(FavoritesPersistencyControllerImpl())
    val favorite = MutableLiveData<Favorite?>()

    fun getFavoriteBySerieId(serieId: Int){
        favoritesRepository.getFavoritesBySerieId(serieId).onEach {
            favorite.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun getAllFavorites(): List<Favorite>{
        return favoritesRepository.getFavorites()
    }

    fun saveFavorite(favorite: Favorite){
        favoritesRepository.saveFavorite(favorite).launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun deleteFavorite(favorite: Favorite){
        favoritesRepository.deleteFavorite(favorite).launchIn(CoroutineScope(Dispatchers.IO))
    }

}