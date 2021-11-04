package com.ijlsa.poptoons.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ijlsa.poptoons.databinding.FragmentSignUpBinding
import com.ijlsa.poptoons.ui.activities.MainMenuActivity

class SignUpFragment: StepsBaseFragment(){

    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.registerButton.setOnClickListener{
            val intent = Intent(activity, MainMenuActivity::class.java)
            startActivity(intent)
            //TODO Pasar datos de signUp a otra funcion (llamar al API en todo caso)
            activity?.finish()
        }
        binding.tvLogin.setOnClickListener{
            val directions = SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()
            findNavController().navigate(directions)
        }
    }
}