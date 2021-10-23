package com.example.newsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.ItemArticlePreviewBinding
import com.example.newsapp.model.Article


class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>(){
    inner class ArticleViewHolder(val binding: ItemArticlePreviewBinding): RecyclerView.ViewHolder(binding.root)

//    DiffUtil only update the changed  list
//    it compare 2 lists and only update the changed one
    private val differCallBack = object :DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == oldItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }


    private val differ = AsyncListDiffer(this,differCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticlePreviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        val binding = holder.binding
        holder.binding.apply {
            Glide.with(binding.previewImageView).load(article.urlToImage).into(binding.previewImageView)
            binding.previewTitle.text = article.title
            binding.previewDescription.text = article.description

//            setOnClickListener{
//                onItemClickListener?.let {
//                    it(article)
//                }
//            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


//    private var onItemClickListener :((Article) -> Unit)? = null
//
//    private fun setOnItemClickListener(listener:(Article) -> Unit){
//         onItemClickListener = listener
//
//    }

}