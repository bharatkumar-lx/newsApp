package com.example.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.model.Article


// It's Data accessing interface it's similar retrofit interface
@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article :Article) : Long

    @Query("SELECT * FROM articles")
    fun getArticles() : LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}