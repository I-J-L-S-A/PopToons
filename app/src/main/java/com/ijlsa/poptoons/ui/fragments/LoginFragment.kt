package com.ijlsa.poptoons.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ijlsa.poptoons.databinding.FragmentLoginBinding
import com.ijlsa.poptoons.ui.activities.MainMenuActivity
import com.ijlsa.poptoons.ui.viewmodels.LoginViewModel

class LoginFragment: StepsBaseFragment() {
    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.loginButton.setOnClickListener{
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            loginViewModel.login(email, password).invokeOnCompletion {
                val intent = Intent(activity, MainMenuActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }

        }

        binding.tvSignUp.setOnClickListener{
            val directions = LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
            findNavController().navigate(directions)
        }

    }
}
