package com.example.mediamclone.data

import com.example.api.ConduitClient

object ArticlesRepo {

    suspend fun getGlobalFeed() = ConduitClient.api.getArticles()

}