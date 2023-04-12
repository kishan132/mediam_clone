package com.example.mediamclone.data

import com.example.api.ConduitClient

object ArticlesRepo {

    suspend fun getGlobalFeed() = ConduitClient.publicApi.getArticles().body()?.articles

    suspend fun getMyFeed() = ConduitClient.authApi.getFeedArticles().body()?.articles

}