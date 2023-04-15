package com.example.mediamclone.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.ConduitClient
import com.example.api.models.entities.Article
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {

    private val _article = MutableLiveData<Article>()
    val article:LiveData<Article> =_article

    fun fetchArticle(slug:String) = viewModelScope.launch {
        val response = ConduitClient.publicApi.getArticlesBySlug(slug)

        response.body()?.article.let {
            _article.postValue(it)
        }
    }

}