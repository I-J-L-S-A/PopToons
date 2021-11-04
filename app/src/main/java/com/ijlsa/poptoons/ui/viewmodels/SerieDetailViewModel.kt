package com.ijlsa.poptoons.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ijlsa.poptoons.data.favorites.FavoritesRepository
import com.ijlsa.poptoons.ui.model.Favorite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.java.KoinJavaComponent.inject

class SerieDetailViewModel : ViewModel() {
    private val favoritesRepository by inject(FavoritesRepository::class.java)
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