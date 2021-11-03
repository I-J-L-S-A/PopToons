package com.ijlsa.poptoons.data.favorites.persistency

import com.ijlsa.poptoons.App
import com.ijlsa.poptoons.ui.model.Favorite
import kotlinx.coroutines.flow.Flow

class FavoritesPersistencyControllerImpl : FavoritesPersistencyController {

    private val db = App.db

    override fun getFavoriteById(serieId: Int): Flow<Favorite> {
        return db.favoritesDao().getSerieById(serieId)
    }

    override fun getFavorites(): List<Favorite>{
        return db.favoritesDao().getAllSeries()
    }

    override fun saveFavorite(favorite: Favorite) {
        db.favoritesDao().saveToFavorites(favorite)
    }

    override fun deleteFavorite(favorite: Favorite) {
        db.favoritesDao().deleteFavorite(favorite)
    }


}