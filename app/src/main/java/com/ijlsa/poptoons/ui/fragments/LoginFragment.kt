package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.ui.interfaces.OnActionCompleteListener

class LoginFragment: StepsBaseFragment() {
    private lateinit var buttonLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        //view.background.alpha = 0
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonLogin = view.findViewById(R.id.loginButton)
        buttonLogin.setOnClickListener {
            onSuccess?.invoke()
        }


    }
}
