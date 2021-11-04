package com.ijlsa.poptoons.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ijlsa.poptoons.data.user.UserRepository
import com.ijlsa.poptoons.data.user.network.UserNetworkControllerImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn

class LoginViewModel: ViewModel() {
    private val userRepository = UserRepository(UserNetworkControllerImp())

    fun login(email: String, password: String): Job{
        return userRepository.login(email, password).launchIn(CoroutineScope(Dispatchers.IO))
    }
}