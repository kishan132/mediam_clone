package com.example.mediamclone.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.entities.Article
import com.example.mediamclone.data.ArticlesRepo
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {

    private val _feed = MutableLiveData<List<Article>>()

    val feed: LiveData<List<Article>> = _feed

    fun fetchGlobalFeed() =  viewModelScope.launch {
        ArticlesRepo.getGlobalFeed()?.let {
            _feed.postValue(it)
            //Log.d("mediam","Global feed fetched: ${it}")
        }
    }

    fun fetchMyFeed() =  viewModelScope.launch {
        ArticlesRepo.getMyFeed()?.let {
            _feed.postValue(it)
            //Log.d("mediam","My feed fetched: ${it}")
        }
    }

}
