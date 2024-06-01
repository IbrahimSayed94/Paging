package com.example.pagingscreen.network.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<Article>
)

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String ?= "",
    @SerializedName("url") val url: String ?= "",
    @SerializedName("urlToImage") val urlToImage: String,
    @SerializedName("publishedAt") val publishedAt: String ?= ""
)