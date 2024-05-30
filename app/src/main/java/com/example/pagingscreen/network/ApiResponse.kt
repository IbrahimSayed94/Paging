package com.example.pagingscreen.network

data class ApiResponse(
    val items: List<Item>,
    val total: Int
)