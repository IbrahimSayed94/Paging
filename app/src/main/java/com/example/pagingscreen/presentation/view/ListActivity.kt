package com.example.pagingscreen.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingscreen.R
import com.example.pagingscreen.presentation.viewmodel.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    private val viewModel: ItemViewModel by viewModels()
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        adapter = ItemAdapter()
        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.items.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }
}