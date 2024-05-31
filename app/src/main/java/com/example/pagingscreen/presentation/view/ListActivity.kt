package com.example.pagingscreen.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingscreen.R
import com.example.pagingscreen.data.datasource.local.Item
import com.example.pagingscreen.databinding.ActivityListBinding
import com.example.pagingscreen.presentation.viewmodel.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    private val viewModel: ItemViewModel by viewModels()
    private lateinit var adapter: ItemAdapter
    private lateinit var binding : ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initList()
        setData()
    }

    private fun initList(){
        adapter = ItemAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun setData(){
        lifecycleScope.launch {
            viewModel.items.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }
}