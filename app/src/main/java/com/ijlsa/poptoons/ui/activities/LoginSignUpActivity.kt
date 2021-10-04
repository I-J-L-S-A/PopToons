package com.ijlsa.poptoons.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.ui.fragments.LoginFragment
import com.ijlsa.poptoons.ui.fragments.SignUpFragment
import com.ijlsa.poptoons.ui.interfaces.OnActionCompleteListener


class LoginSignUpActivity : AppCompatActivity() {

    val loginFragment = LoginFragment()
    val signUpFragment = SignUpFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sign_up)

        replaceWithFragment(loginFragment)

        loginFragment.setActionCompleteListener(object: OnActionCompleteListener{
            override fun success() {
                goToNextFragment(signUpFragment)
            }
            override fun error() {
                TODO("Not yet implemented")
            }

        })

    }

    fun replaceWithFragment(fragment: Fragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.containerLoginSignUp, fragment)
        ft.commit()
    }

    fun goToNextFragment(fragment: Fragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.containerLoginSignUp, fragment)
        ft.addToBackStack("TODO")
        ft.commit()
    }

    override fun onBackPressed() {
        if(supportFragmentManager.fragments.size > 1){
            supportFragmentManager.popBackStack()
            return
        }
        super.onBackPressed()
    }
}