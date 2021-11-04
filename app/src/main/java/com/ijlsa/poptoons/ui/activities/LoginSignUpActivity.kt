package com.ijlsa.poptoons.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ijlsa.poptoons.NetworkUtils
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.databinding.ActivityLoginSignUpBinding
import com.ijlsa.poptoons.ui.fragments.LoginFragment
import com.ijlsa.poptoons.ui.fragments.SignUpFragment
import com.ijlsa.poptoons.ui.replaceFragment


class LoginSignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginSignUpBinding

    private val loginFragment = LoginFragment()
    private val signUpFragment = SignUpFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        NetworkUtils.updateIsOnline(this)
    }

}