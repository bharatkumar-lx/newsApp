package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.R
import com.example.newsapp.apis.RetrofitInstance
import com.example.newsapp.databinding.ActivityNewsBinding
import com.example.newsapp.utils.Constants.Companion.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
        lifecycleScope.launch(Dispatchers.IO){
            Log.d("MainActivity",
                RetrofitInstance.api.getBreakingNews().toString()
            )
        }


    }
}

