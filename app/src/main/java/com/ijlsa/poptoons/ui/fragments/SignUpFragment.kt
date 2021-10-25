package com.ijlsa.poptoons.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.databinding.FragmentCategoryBinding
import com.ijlsa.poptoons.databinding.FragmentSignUpBinding
import com.ijlsa.poptoons.ui.activities.MainMenuActivity
import com.ijlsa.poptoons.ui.interfaces.OnActionCompleteListener

class SignUpFragment: StepsBaseFragment(){

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var buttonSignUp: Button
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
            //Pasar datos de login a otra funcion
            activity?.finish()
        }
        val login = view.findViewById<TextView>(R.id.tvLogin)
        login.setOnClickListener{
            val ft = parentFragmentManager.beginTransaction()
            ft.add(LoginFragment(), "tagLogin")
            ft.addToBackStack("Login")
            ft.commit()
        }
    }
}