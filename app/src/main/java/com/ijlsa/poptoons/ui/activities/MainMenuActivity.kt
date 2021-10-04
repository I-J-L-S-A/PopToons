package com.ijlsa.poptoons.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ijlsa.poptoons.R

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        supportActionBar?.hide()
    }
}