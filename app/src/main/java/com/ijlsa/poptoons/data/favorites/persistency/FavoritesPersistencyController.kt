package com.ijlsa.poptoons.data.favorites.persistency

import com.ijlsa.poptoons.ui.model.Favorite
import kotlinx.coroutines.flow.Flow

interface FavoritesPersistencyController {
    fun getFavoriteById(serieId: Int): Flow<Favorite>
    fun getFavorites(): List<Favorite>
    fun saveFavorite(favorite: Favorite)
    fun deleteFavorite(favorite: Favorite)
}