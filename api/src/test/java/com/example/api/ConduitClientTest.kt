package com.example.api

import com.example.api.models.entities.UserCreds
import com.example.api.models.requests.SignupRequest
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.*

class ConduitClientTest {

    //private val conduitClient = ConduitClient()

    @Test
    fun getArticlesTest(){                  // or `get articles()` with this(`) symbol you can add space also
        runBlocking {
            val articles = ConduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }

    }

    @Test
    fun getArticlesAutherTest(){
        runBlocking {
            val articles = ConduitClient.api.getArticles("welcome")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun signupTest(){

        val userCreds = UserCreds(username = "kishan${Math.random()}", email = "kishan${Math.random()}@test.com", password = "kishan${Math.random()}")

        runBlocking {
            val resp = ConduitClient.api.signupUser(SignupRequest(userCreds))
            //in assertEquals -> first - expected, second - output
            assertEquals(userCreds.username,resp.body()?.user?.username)
        }
    }

}