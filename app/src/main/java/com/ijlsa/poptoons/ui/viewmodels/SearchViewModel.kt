package com.ijlsa.poptoons.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel: ViewModel() {
    val searchStarted = MutableLiveData(false)
}