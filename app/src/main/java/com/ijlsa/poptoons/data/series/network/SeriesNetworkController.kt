package com.ijlsa.poptoons.data.series.network

import com.ijlsa.poptoons.ui.model.Series

interface SeriesNetworkController {
    suspend fun getSeries(): List<Series>
}