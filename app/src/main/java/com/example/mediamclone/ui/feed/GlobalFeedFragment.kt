package com.example.mediamclone.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediamclone.databinding.FragmentFeedBinding

class GlobalFeedFragment : Fragment() {

    private var fragmentFeedBinding: FragmentFeedBinding? = null
    lateinit var feedAdapter : ArticleFeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        feedAdapter = ArticleFeedAdapter()

        fragmentFeedBinding = FragmentFeedBinding.inflate(inflater, container, false)

        fragmentFeedBinding!!.feedRecyclerView.layoutManager = LinearLayoutManager(context)
        fragmentFeedBinding!!.feedRecyclerView.adapter = feedAdapter

        feedViewModel.fetchGlobalFeed()
        feedViewModel.feed.observe(viewLifecycleOwner, Observer {
            feedAdapter.submitList(it)
        })

        return fragmentFeedBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentFeedBinding = null
    }

}