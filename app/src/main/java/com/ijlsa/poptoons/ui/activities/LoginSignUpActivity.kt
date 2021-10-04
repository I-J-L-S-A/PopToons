package com.ijlsa.poptoons.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.ui.fragments.LoginFragment


class LoginSignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sign_up)

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.containerLogin, LoginFragment())
        ft.commit()
    }
}