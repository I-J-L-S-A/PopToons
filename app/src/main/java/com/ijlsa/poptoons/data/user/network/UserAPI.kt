package com.ijlsa.poptoons.data.user.network

import com.ijlsa.poptoons.ui.model.LoginRequest
import com.ijlsa.poptoons.ui.model.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {
    @POST("/user")
    suspend fun login(@Body loginRequest: LoginRequest)

    @POST("/register")
    suspend fun register(@Body registerRequest: RegisterRequest)
}