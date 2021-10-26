package com.ijlsa.poptoons.data.series.network

import com.ijlsa.poptoons.ui.model.Series
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface SeriesAPI {
    @GET("/series")
    suspend fun getSeries(): List<Series>
    @GET("/series/1234543")
    suspend fun searchSeries(query: String): List<Series>
}