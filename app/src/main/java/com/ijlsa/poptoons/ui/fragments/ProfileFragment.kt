package com.ijlsa.poptoons.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ijlsa.poptoons.R
import com.ijlsa.poptoons.databinding.FragmentProfileBinding
import com.ijlsa.poptoons.ui.activities.LoginSignUpActivity
import com.ijlsa.poptoons.ui.adapters.HomeSeriesListsAdapter
import com.ijlsa.poptoons.ui.model.Categories
import com.ijlsa.poptoons.ui.viewmodels.FavoritesViewModel


class ProfileFragment : StepsBaseFragment() {

    private lateinit var binding: FragmentProfileBinding
    private val favoritesListAdapter = HomeSeriesListsAdapter()
    private val favoritesViewModel: FavoritesViewModel by viewModels()

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

        binding.navHostFragmentContainer2.adapter = favoritesListAdapter
        binding.navHostFragmentContainer2.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        favoritesListAdapter.setOnSerieClickListener {
            val directions = ProfileFragmentDirections.actionProfileFragmentToSerieDetailsFragment(it)
            findNavController().navigate(directions)
        }
        favoritesViewModel.favorites.observe(viewLifecycleOwner){
            favoritesListAdapter.addAll(it)
        }

    }
}