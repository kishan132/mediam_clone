package com.example.mediamclone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mediamclone.AuthViewModel
import com.example.mediamclone.databinding.FragmentLoginSignupBinding

class SignupFragment : Fragment() {

    private var binding : FragmentLoginSignupBinding ?= null
    private val authViewModel : AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginSignupBinding.inflate(inflater,container,false)
        binding?.userEt?.isVisible = true

        binding?.apply {
            submitBtn.setOnClickListener {
                authViewModel.signup(
                    emailEt.text.toString(),
                    passwordEt.text.toString(),
                    userEt.text.toString()
                )
            }
        }

        return binding?.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}