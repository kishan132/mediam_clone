package com.example.mediamclone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mediamclone.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {

    private var binding : FragmentSignupBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignupBinding.inflate(inflater,container,false)

        return binding?.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}