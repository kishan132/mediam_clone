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

class LoginFragment : Fragment() {

    private var binding : FragmentLoginSignupBinding?=null

    private val authViewModel : AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginSignupBinding.inflate(inflater,container,false)
        //authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding?.userEt?.isVisible = false

        binding?.apply {
            submitBtn.setOnClickListener {
                authViewModel.login(
                    emailEt.text.toString(),
                    passwordEt.text.toString()
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