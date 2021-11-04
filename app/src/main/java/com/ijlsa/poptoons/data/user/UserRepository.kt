package com.ijlsa.poptoons.data.user

import com.ijlsa.poptoons.data.user.network.UserNetworkControllerImp
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow

class UserRepository(val network: UserNetworkControllerImp) {
    fun login(email: String, password: String): Flow<Any>{
        return flow {
            emit(network.login(email, password))
        }
    }

    fun register(email: String, password: String, username: String): Flow<Any> {
        return flow {
            emit(network.register(email, password, username))
        }
    }

}