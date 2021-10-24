package com.ijlsa.poptoons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.databinding.FragmentCategoryBinding
import com.ijlsa.poptoons.databinding.FragmentProfileBinding

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
}