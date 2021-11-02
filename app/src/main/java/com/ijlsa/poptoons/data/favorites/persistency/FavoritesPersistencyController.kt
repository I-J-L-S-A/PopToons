package com.ijlsa.poptoons.data.favorites.persistency

import com.ijlsa.poptoons.ui.model.Favorite

interface FavoritesPersistencyController {
    fun getFavoriteById(serieId: Int): Favorite
    fun getFavorites(): List<Favorite>
    fun saveFavorite(favorite: Favorite)
    fun deleteFavorite(favorite: Favorite)
}