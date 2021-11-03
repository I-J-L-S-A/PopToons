package com.ijlsa.poptoons.data.series.network

import com.ijlsa.poptoons.ui.model.Series
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class SeriesNetworkControllerImp: SeriesNetworkController{
    val client = Retrofit.Builder()
        .baseUrl("http://192.168.1.10:1880")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SeriesAPI::class.java)

    override suspend fun getSeries(): List<Series>{
        return client.getSeries()
    }
}