package com.example.mediamclone.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediamclone.R
import com.example.mediamclone.databinding.FragmentFeedBinding

class MyFeedFragment : Fragment() {

    private var fragmentFeedBinding: FragmentFeedBinding? = null
    lateinit var feedViewModel : FeedViewModel
    lateinit var feedAdapter : ArticleFeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        feedAdapter = ArticleFeedAdapter{openArticle(it)}

        fragmentFeedBinding = FragmentFeedBinding.inflate(inflater, container, false)

        fragmentFeedBinding!!.feedRecyclerView.layoutManager = LinearLayoutManager(context)
        fragmentFeedBinding!!.feedRecyclerView.adapter = feedAdapter

        return fragmentFeedBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        feedViewModel.fetchMyFeed()
        feedViewModel.feed.observe(viewLifecycleOwner, Observer {
            feedAdapter.submitList(it)
        })
    }

    fun openArticle(articleId :String){
        findNavController().navigate(R.id.action_nav_my_feed_to_nav_article,
            bundleOf(
            resources.getString(R.string.arg_article_id) to articleId
        ))

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentFeedBinding = null
    }


}