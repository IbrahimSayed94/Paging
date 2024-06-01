package com.example.pagingscreen.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.pagingscreen.databinding.ActivityListBinding
import com.example.pagingscreen.presentation.viewmodel.ArticlesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    private val viewModel: ArticlesViewModel by viewModels()
    private lateinit var adapter: ArticleAdapter
    private lateinit var binding : ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initList()
        setData()
    }

    private fun initList(){
        adapter = ArticleAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun setData(){
        lifecycleScope.launch {
            viewModel.articles.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }
}