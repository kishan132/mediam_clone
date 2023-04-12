package com.example.mediamclone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mediamclone.AuthViewModel
import com.example.mediamclone.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var binding : FragmentLoginBinding ?=null

    private val authViewModel : AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater,container,false)
        //authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        binding?.apply {
            loginBtn.setOnClickListener {
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