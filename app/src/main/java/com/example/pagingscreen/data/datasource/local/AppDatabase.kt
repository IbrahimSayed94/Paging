package com.example.pagingscreen.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pagingscreen.network.response.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}