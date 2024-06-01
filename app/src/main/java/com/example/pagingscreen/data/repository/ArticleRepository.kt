package com.example.pagingscreen.data.repository

import android.net.ConnectivityManager
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pagingscreen.data.datasource.local.ArticleDao
import com.example.pagingscreen.data.datasource.remote.ArticleRemoteDataSource
import com.example.pagingscreen.network.ApiService
import com.example.pagingscreen.network.response.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(
    private val apiService: ApiService,
    private val articleDao: ArticleDao,
    private val connectivityManager: ConnectivityManager
) {

    fun getArticles(): Flow<PagingData<Article>> {
        return if (isNetworkConnected()) {
            remoteArticles()
        } else {
            localArticles()
        }
    }

    private fun isNetworkConnected(): Boolean {
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun remoteArticles(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { ArticleRemoteDataSource(apiService, articleDao) }
        ).flow
    }

    private fun localArticles(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { articleDao.getArticles() }
        ).flow
    }
}