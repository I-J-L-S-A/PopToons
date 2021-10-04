package com.ijlsa.poptoons.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.ijlsa.poptoons.R

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        supportActionBar?.hide()

        //val buttonLogin = findViewById<Button>(R.id.buttonLoginMainMenu)
        //val buttonSignUp = findViewById<Button>(R.id.buttonSignUpMainMenu)


    }

    fun loginSignUpMenu(view: View) {
        val intent = Intent(this, LoginSignUpActivity::class.java)
        startActivity(intent)
    }
}