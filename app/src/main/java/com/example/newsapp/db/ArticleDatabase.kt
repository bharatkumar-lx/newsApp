package com.example.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.model.Article


@Database(
    entities = [Article ::class],
    version = 1
)
@TypeConverters(
    Converters::class
)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun getArticlesDao() : ArticleDao

    companion object{
        //Volatile will let know other threads that it being use
        @Volatile
        private var instance :ArticleDatabase? = null
        //to lock thread (coroutine)
        private var Lock = Any()

        operator fun invoke(context : Context) = instance ?: synchronized(Lock){
            instance ?: createDataBase(context).also{ instance = it }
        }

        private fun createDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase :: class.java,
                "article_db.db"
            ).build()

    }

}