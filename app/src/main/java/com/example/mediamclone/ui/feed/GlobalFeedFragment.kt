package com.example.mediamclone.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mediamclone.databinding.FragmentFeedBinding

class GlobalFeedFragment : Fragment() {

    private var fragmentFeedBinding: FragmentFeedBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

        fragmentFeedBinding = FragmentFeedBinding.inflate(inflater, container, false)

        fragmentFeedBinding!!.fetchFeedButton.setOnClickListener {
            feedViewModel.fetchGlobalFeed()
        }

        return fragmentFeedBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentFeedBinding = null
    }

}