package com.example.mediamclone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.mediamclone.R
import com.example.mediamclone.databinding.FragmentAuthBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class AuthFragment : Fragment() {

    private var binding: FragmentAuthBinding? = null
    private var navController : NavController ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = binding?.let {Navigation.findNavController(it.root)}

        binding?.authTabLayout?.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {

                when(tab?.position){
                    0 -> {
                        navController?.navigate(R.id.loginFragment)
                    }
                    1 -> {
                        navController?.navigate(R.id.signupFragment)
                    }
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })


    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}