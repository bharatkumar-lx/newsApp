package com.example.newsapp.respoitory

import com.example.newsapp.apis.RetrofitInstance
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.model.Article

class NewsRepository (
    val db:ArticleDatabase
        ){
    suspend fun getBreakingNews(countryCode: String,pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNew(searchQuery,pageNumber)


    suspend fun upsert(article : Article) = db.getArticlesDao().upsert(article)

    fun savedNews() = db.getArticlesDao().getArticles()

    suspend fun deleteArticle(article: Article) = db.getArticlesDao().deleteArticle(article)

}