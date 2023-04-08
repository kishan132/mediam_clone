package com.example.api

import org.junit.Test
import org.junit.Assert.*

class ConduitClientTest {

    //private val conduitClient = ConduitClient()

    @Test
    fun getArticlesTest(){                  // or `get articles()` with this(`) symbol you can add space also
        val articles = ConduitClient.api.getArticles().execute()
        assertNotNull(articles.body()?.articles)
    }

}