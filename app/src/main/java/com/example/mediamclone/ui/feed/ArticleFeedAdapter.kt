package com.example.mediamclone.ui.feed

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.api.models.entities.Article
import com.example.mediamclone.R
import com.example.mediamclone.databinding.ListItemArticleBinding

class ArticleFeedAdapter : ListAdapter<Article, ArticleFeedAdapter.ArticleViewHolder>(

    object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }

) {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            parent.context.getSystemService(LayoutInflater::class.java).inflate(
                R.layout.list_item_article, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        ListItemArticleBinding.bind(holder.itemView).apply {

            val article = getItem(position)

            autherName.text = article.author.username
            BodyTv.text = article.body
            headingTv.text = article.title
            dateTv.text = "09 April, 2023"
            autherImage.background = ColorDrawable(Color.GRAY)

        }


    }


}