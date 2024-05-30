package com.example.pagingscreen.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pagingscreen.data.datasource.ItemDao

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}