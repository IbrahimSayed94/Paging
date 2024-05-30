package com.example.pagingscreen.network

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey val id: Int,
    val name: String
)