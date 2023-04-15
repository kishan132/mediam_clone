package com.example.mediamclone.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mediamclone.AuthViewModel
import com.example.mediamclone.R
import com.example.mediamclone.databinding.FragmentArticleBinding
import com.example.mediamclone.extensions.loadImage
import com.example.mediamclone.extensions.timestamp

class ArticleFragment : Fragment() {

    private var binding: FragmentArticleBinding? = null
    lateinit var articleViewModel: ArticleViewModel
    private var articleId: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentArticleBinding.inflate(inflater, container, false)
        articleViewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)

        arguments?.let {
            articleId = it.getString(resources.getString(R.string.arg_article_id))
        }

        articleId?.let {
            articleViewModel.fetchArticle(it)
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articleViewModel.article.observe(viewLifecycleOwner, Observer {
            binding?.apply {
                titleTv.text = it.title
                bodyTv.text = it.body
                dateTv.timestamp = it.updatedAt
                //dateTv.showFormattedDate(it.updatedAt)
                username.text = it.author.username
                avatarIv.loadImage(it.author.image, true)
            }
        })

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}