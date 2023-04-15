package com.example.mediamclone.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mediamclone.AuthViewModel
import com.example.mediamclone.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private val authViewModel by activityViewModels<AuthViewModel>()
    private var binding : FragmentSettingsBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater,container,false)
        //authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel.user.observe(viewLifecycleOwner, Observer {
            binding?.apply {
                imageEt.setText(it?.image ?: "")
                userEt.setText(it?.username ?: "")
                emailEt.setText(it?.email ?: "")
                bioEt.setText(it?.bio ?: "")
            }
        })

        binding?.apply {
            updateBtn.setOnClickListener {
                authViewModel.update(
                    bioEt.text.toString(),
                    emailEt.text.toString().takeIf { it.isNotBlank() },
                    imageEt.text.toString(),
                    userEt.text.toString().takeIf { it.isNotBlank() },
                    passwordEt.text.toString().takeIf { it.isNotBlank() }
                )
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}