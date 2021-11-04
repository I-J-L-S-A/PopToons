package com.ijlsa.poptoons

import android.app.Application
import androidx.room.Room
import com.ijlsa.poptoons.data.favorites.FavoritesRepository
import com.ijlsa.poptoons.data.favorites.persistency.FavoritesPersistencyController
import com.ijlsa.poptoons.data.favorites.persistency.FavoritesPersistencyControllerImpl
import com.ijlsa.poptoons.databases.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {

    companion object{
        lateinit var db: AppDatabase
    }

    val appModule = module {
        single<FavoritesPersistencyController> { FavoritesPersistencyControllerImpl() }
        single { FavoritesRepository(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, AppDatabase::class.java, "app-db").build()

        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }

}