package com.example.pagingscreen.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pagingscreen.network.response.Article

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles")
    fun getArticles(): PagingSource<Int, Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<Article>)

    @Query("DELETE FROM articles")
    suspend fun clearAll()
}