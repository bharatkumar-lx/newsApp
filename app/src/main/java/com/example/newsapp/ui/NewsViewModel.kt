package com.example.newsapp.ui

import androidx.lifecycle.ViewModel
import com.example.newsapp.respoitory.NewsRepository

class NewsViewModel(
    val newRepository : NewsRepository
) : ViewModel() {
}