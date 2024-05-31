package com.example.pagingscreen.data.repository

import android.net.ConnectivityManager
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pagingscreen.data.datasource.local.ItemDao
import com.example.pagingscreen.data.datasource.remote.RemoteDataSource
import com.example.pagingscreen.network.ApiService
import com.example.pagingscreen.data.datasource.local.Item
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemRepository @Inject constructor(
    private val apiService: ApiService,
    private val itemDao: ItemDao,
    private val connectivityManager: ConnectivityManager
) {

    fun getItems(): Flow<PagingData<Item>> {
        return if (isNetworkConnected()) {
            remoteItems()
        } else {
            localItems()
        }
    }

    private fun isNetworkConnected(): Boolean {
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun remoteItems(): Flow<PagingData<Item>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { RemoteDataSource(apiService, itemDao) }
        ).flow
    }

    private fun localItems(): Flow<PagingData<Item>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { itemDao.getItems() }
        ).flow
    }
}