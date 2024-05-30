package com.example.pagingscreen.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("items")
    suspend fun getItems(@Query("page") page: Int, @Query("pageSize") pageSize: Int): ApiResponse
}