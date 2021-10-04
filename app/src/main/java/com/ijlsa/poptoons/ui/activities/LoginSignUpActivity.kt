package com.ijlsa.poptoons.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.ui.fragments.LoginFragment
import com.ijlsa.poptoons.ui.fragments.SignUpFragment
import com.ijlsa.poptoons.ui.replaceFragment


class LoginSignUpActivity : AppCompatActivity() {

    lateinit var extra : Bundle

    val loginFragment = LoginFragment()
    val signUpFragment = SignUpFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sign_up)
        supportActionBar?.hide()
        extra = intent.extras!!
        val valor = extra.getString("fragment")
        if(valor == "login"){
            replaceFragment(R.id.containerLoginSignUp, loginFragment)
        } else if(valor == "signup"){
            replaceFragment(R.id.containerLoginSignUp, signUpFragment)
        }

        loginFragment.setOnSuccsessListener {
            replaceFragment(R.id.containerLoginSignUp, signUpFragment)
        }

        loginFragment.setOnErrorListener {
            Toast.makeText(this, "Error ${it}", Toast.LENGTH_SHORT).show()
        }

        signUpFragment.setOnSuccsessListener {
            replaceFragment(R.id.containerLoginSignUp, loginFragment)
        }

        signUpFragment.setOnErrorListener {
            Toast.makeText(this, "Error ${it}", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onBackPressed() {
        if(supportFragmentManager.fragments.size > 1){
            supportFragmentManager.popBackStack()
            return
        }
        super.onBackPressed()
    }
}