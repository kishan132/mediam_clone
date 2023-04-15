package com.example.mediamclone.data

import com.example.api.ConduitClient
import com.example.api.models.entities.LoginCred
import com.example.api.models.entities.User
import com.example.api.models.entities.UserCreds
import com.example.api.models.entities.UserUpdate
import com.example.api.models.requests.LoginRequest
import com.example.api.models.requests.SignupRequest
import com.example.api.models.requests.UserUpdateRequest
import com.example.api.models.responses.UserResponse
import com.example.api.services.ConduitAPI
import com.example.api.services.ConduitAuthAPI

object UserRepo {

    val publicAPI = ConduitClient.publicApi
    val authAPI = ConduitClient.authApi

    suspend fun login(email: String, password: String): User? {
        val response = publicAPI.loginUser(LoginRequest(LoginCred(email, password)))

        //TODO: will store token in sharedPref
        ConduitClient.authToken = response.body()?.user?.token

        return response.body()?.user
    }

    suspend fun signup(email: String, password: String, username: String): User? {
        val response = publicAPI.signupUser(SignupRequest(UserCreds(email, password, username)))

        //TODO: will store token in sharedPref
        ConduitClient.authToken = response.body()?.user?.token

        return response.body()?.user
    }

    suspend fun getCurrentUser(token:String) : User?{
        ConduitClient.authToken = token

        val response = ConduitClient.authApi.getCurrentUser()
        return response.body()?.user
    }

    suspend fun update(
        bio: String?,
        email: String?,
        image: String?,
        username: String?,
        password: String?
    ): User? {
        val response = authAPI.updateCurrentUser(
            UserUpdateRequest(
                (UserUpdate(
                    bio,
                    email,
                    image,
                    username,
                    password
                ))
            )
        )

        //TODO: will store token in sharedPref
        ConduitClient.authToken = response.body()?.user?.token

        return response.body()?.user
    }

}