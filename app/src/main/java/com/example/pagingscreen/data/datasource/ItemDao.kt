package com.example.pagingscreen.data.datasource

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pagingscreen.network.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    fun getItems(): PagingSource<Int, Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<Item>)

    @Query("DELETE FROM items")
    suspend fun clearAll()
}