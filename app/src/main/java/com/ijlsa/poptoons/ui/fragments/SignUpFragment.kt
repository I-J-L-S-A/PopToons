package com.ijlsa.poptoons.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ijlsa.poptoons.databinding.FragmentSignUpBinding
import com.ijlsa.poptoons.ui.activities.MainMenuActivity
import com.ijlsa.poptoons.ui.viewmodels.LoginViewModel

class SignUpFragment: StepsBaseFragment(){

    private lateinit var binding: FragmentSignUpBinding
    private val loginViewModel: LoginViewModel by viewModels()

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
            if (binding.editConfirmPassword.text.toString() == binding.editPassword.text.toString()){
                val email = binding.editEmail.text.toString()
                val password = binding.editPassword.text.toString()
                val username = binding.editUser.text.toString()

                loginViewModel.register(email, password, username).invokeOnCompletion {
                    val intent = Intent(activity, MainMenuActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                }
            }
        }
        binding.tvLogin.setOnClickListener{
            val directions = SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()
            findNavController().navigate(directions)
        }
    }
}