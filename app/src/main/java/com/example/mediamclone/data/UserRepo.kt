package com.example.mediamclone.data

import com.example.api.ConduitClient
import com.example.api.models.entities.LoginCred
import com.example.api.models.requests.LoginRequest
import com.example.api.models.responses.UserResponse
import com.example.api.services.ConduitAPI
import com.example.api.services.ConduitAuthAPI

object UserRepo {

    suspend fun login(email: String, password: String): UserResponse? {
        val response = ConduitClient.api.loginUser(LoginRequest(LoginCred(email, password)))
        return response.body()
    }

}