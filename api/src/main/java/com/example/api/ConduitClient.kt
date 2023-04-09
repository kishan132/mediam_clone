package com.example.api

import com.example.api.services.ConduitAPI
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ConduitClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.realworld.io/api/")
        //.baseUrl("https://conduit.productionready.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api = retrofit.create(ConduitAPI::class.java)

}