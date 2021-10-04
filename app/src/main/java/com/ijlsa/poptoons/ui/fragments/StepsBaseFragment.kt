package com.ijlsa.poptoons.ui.fragments

import androidx.fragment.app.Fragment

abstract class StepsBaseFragment: Fragment() {
    var onSuccess : (()-> Unit)? = null
    var onError : ((error: String)-> Unit)? = null

    fun setOnSuccsessListener(callback: (() -> Unit)){
        onSuccess = callback
    }

    fun setOnErrorListener(callback: ((error: String) -> Unit)){
        onError = callback
    }
}