package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.ui.interfaces.OnActionCompleteListener

class SignUpFragment: Fragment(){
    private var actionCompleteListener: OnActionCompleteListener? = null
    private lateinit var buttonSignUp: Button
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        //view.background.alpha = 0
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonSignUp = view.findViewById(R.id.registerButton)
        buttonSignUp.setOnClickListener {
            actionCompleteListener?.success()
        }
    }

    fun setActionCompleteListener(actionListener: OnActionCompleteListener){
        actionCompleteListener = actionListener
    }
}