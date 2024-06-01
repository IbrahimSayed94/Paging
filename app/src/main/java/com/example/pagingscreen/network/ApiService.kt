package com.example.pagingscreen.network

import com.example.pagingscreen.network.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/search")
    suspend fun getArticles(
        @Query("q") query: String ?= "test",
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): NewsResponse
}