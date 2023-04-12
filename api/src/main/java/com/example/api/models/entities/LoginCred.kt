package com.example.api.models.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginCred(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String
)