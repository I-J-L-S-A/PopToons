package com.ijlsa.poptoons.data.favorites

import com.ijlsa.poptoons.data.favorites.persistency.FavoritesPersistencyController
import com.ijlsa.poptoons.ui.model.Favorite
import com.ijlsa.poptoons.ui.model.Series
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavoritesRepository(private val persistence: FavoritesPersistencyController) {

    fun getFavoritesBySerieId(serieId: Int): Flow<Favorite>{
        return persistence.getFavoriteById(serieId)
    }

    fun getFavorites(): List<Favorite>{
        return persistence.getFavorites()
    }

    fun getFavoriteSeries(): Flow<List<Series>>{
        return flow {
            emit(persistence.getFavoriteSeries())
        }
    }

    fun saveFavorite(favorite: Favorite): Flow<Any>{
        return flow {
            persistence.saveFavorite(favorite)

        }

    }

    fun deleteFavorite(favorite: Favorite): Flow<Any>{
        return flow {
            persistence.deleteFavorite(favorite)
        }
    }
}