package com.example.newsapp.respoitory

import com.example.newsapp.apis.RetrofitInstance
import com.example.newsapp.db.ArticleDatabase

class NewsRepository (
    val db:ArticleDatabase
        ){
    suspend fun getBreakingNews(countryCode: String,pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

}