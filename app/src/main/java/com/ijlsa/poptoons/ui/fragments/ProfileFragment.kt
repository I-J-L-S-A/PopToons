package com.ijlsa.poptoons.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.ui.activities.LoginSignUpActivity

class ProfileFragment: StepsBaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val settings = view.findViewById<ImageView>(R.id.ivSettings)
        settings.setOnClickListener(){
            findNavController().navigate(R.id.action_profileFragment_to_settingsFragment)
        }
        val login = view.findViewById<Button>(R.id.loginButton)
        login.setOnClickListener{
            val intent = Intent(this.context, LoginSignUpActivity::class.java)
            if (view.id == R.id.loginButton) {
                intent.putExtra("fragment", "login")
            } else {
                intent.putExtra("fragment", "signup")
            }
            startActivity(intent)
        }
    }
}