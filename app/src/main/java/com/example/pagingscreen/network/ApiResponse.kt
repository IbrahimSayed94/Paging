package com.example.pagingscreen.network

import com.example.pagingscreen.data.datasource.local.Item

data class ApiResponse(
    val items: List<Item>,
    val total: Int
)