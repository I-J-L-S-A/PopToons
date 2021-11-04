package com.ijlsa.poptoons.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ijlsa.poptoons.NetworkUtils
import com.ijlsa.poptoons.databinding.ActivityLoginSignUpBinding
import com.ijlsa.poptoons.ui.fragments.LoginFragment
import com.ijlsa.poptoons.ui.fragments.SignUpFragment


class LoginSignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        NetworkUtils.updateIsOnline(this)
    }

}