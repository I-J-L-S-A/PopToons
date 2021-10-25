package com.ijlsa.poptoons.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.databinding.FragmentCategoryBinding
import com.ijlsa.poptoons.databinding.FragmentLoginBinding
import com.ijlsa.poptoons.ui.activities.MainMenuActivity

class LoginFragment: StepsBaseFragment() {
    private lateinit var buttonLogin: Button
    private lateinit var binding: FragmentLoginBinding

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
            val intent = Intent(activity, MainMenuActivity::class.java)
            startActivity(intent)
            //Pasar datos de login a otra funcion
            activity?.finish()
        }
        val signup = view.findViewById<TextView>(R.id.tvSignUp)
        signup.setOnClickListener{
            val ft = parentFragmentManager.beginTransaction()
            ft.add(SignUpFragment(), "tagSignUp")
            ft.addToBackStack("SignUp")
            ft.commit()
        }

    }
}
