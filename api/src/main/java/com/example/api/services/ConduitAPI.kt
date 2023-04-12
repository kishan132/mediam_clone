package com.example.api.services

import com.example.api.models.requests.LoginRequest
import com.example.api.models.requests.SignupRequest
import com.example.api.models.responses.ArticleResponse
import com.example.api.models.responses.ArticlesResponse
import com.example.api.models.responses.TagsResponse
import com.example.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAPI {

    @POST("users")
    suspend fun signupUser(
        @Body userCreds: SignupRequest,
    ): Response<UserResponse>

    @POST("users/login")
    suspend fun loginUser(
        @Body userCreds: LoginRequest,
    ): Response<UserResponse>

    @GET("articles")
    suspend fun getArticles(
        @Query("auther") auther: String? = null,
        @Query("favorited") favorited: String? = null,
        @Query("tag") tag: String? = null,
    ): Response<ArticlesResponse>

    @GET("articles/{slug}")
    suspend fun getArticlesBySlug(
        @Path("slug") slug: String,
    ): Response<ArticleResponse>

    @GET("tags")
    suspend fun getTages(): Response<TagsResponse>
}