package com.example.mediamclone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.entities.User
import com.example.mediamclone.data.UserRepo
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    fun login(email: String, password: String) = viewModelScope.launch {
        UserRepo.login(email, password)?.let {
            _user.postValue(it)
        }
    }

    fun signup(email: String, password: String, username: String) = viewModelScope.launch {
        UserRepo.signup(email, password, username)?.let {
            _user.postValue(it)
        }
    }

}