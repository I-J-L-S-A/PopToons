package com.ijlsa.poptoons.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.annotation.StyleRes
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ijlsa.poptoons.R

class MainMenuActivity : AppCompatActivity() {

    private lateinit var bottomMenu: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        supportActionBar?.hide()

        bottomMenu = findViewById(R.id.bottom_menu)
        bottomMenu.itemIconTintList = null


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

        val navController = navHostFragment.navController

        bottomMenu.setupWithNavController(navController)


        //val buttonLogin = findViewById<Button>(R.id.buttonLoginMainMenu)
        //val buttonSignUp = findViewById<Button>(R.id.buttonSignUpMainMenu)


    }

    fun loginSignUpMenu(view: View) {
        val intent = Intent(this, LoginSignUpActivity::class.java)
        if (view.id == R.id.buttonLoginMainMenu) {
            intent.putExtra("fragment", "login")
        } else if (view.id == R.id.buttonSignUpMainMenu) {
            intent.putExtra("fragment", "signup")
        }
        startActivity(intent)
    }
}