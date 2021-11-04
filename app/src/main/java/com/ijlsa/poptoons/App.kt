package com.ijlsa.poptoons

import android.app.Application
import androidx.room.Room
import com.ijlsa.poptoons.databases.AppDatabase
import com.ijlsa.poptoons.ui.model.User

class App: Application() {

    companion object{
        lateinit var db: AppDatabase
        lateinit var user: User
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, AppDatabase::class.java, "app-db").build()
    }

}