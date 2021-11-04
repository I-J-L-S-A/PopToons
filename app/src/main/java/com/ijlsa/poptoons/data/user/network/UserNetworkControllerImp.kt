package com.ijlsa.poptoons.data.user.network

import com.ijlsa.poptoons.ui.model.LoginRequest
import com.ijlsa.poptoons.ui.model.RegisterRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserNetworkControllerImp: UserNetworkController {
    val client = Retrofit.Builder()
        .baseUrl("http://192.168.0.16:1880")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAPI::class.java)

    override suspend fun login(email: String, password: String) {
        return client.login(LoginRequest(email, password))
    }

    override suspend fun register(email: String, password: String, username: String) {
        return client.register(RegisterRequest(username, email, password))
    }
}