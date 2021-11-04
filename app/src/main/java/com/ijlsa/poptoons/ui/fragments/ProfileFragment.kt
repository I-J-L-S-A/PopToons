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
import com.ijlsa.poptoons.databinding.FragmentProfileBinding
import com.ijlsa.poptoons.ui.activities.LoginSignUpActivity


class ProfileFragment: StepsBaseFragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.ivSettings.setOnClickListener(){
            findNavController().navigate(R.id.action_profileFragment_to_settingsFragment)
        }
        binding.loginButton.setOnClickListener{
            val intent = Intent(this.context, LoginSignUpActivity::class.java)
            startActivity(intent)
        }
    }
}