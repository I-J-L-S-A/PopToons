package com.ijlsa.poptoons.data.user.network

interface UserNetworkController {
    suspend fun login(email: String, password: String)
}