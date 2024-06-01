package com.example.pagingscreen.data.di

import android.net.ConnectivityManager
import com.example.pagingscreen.data.datasource.local.ArticleDao
import com.example.pagingscreen.data.repository.ArticleRepository
import com.example.pagingscreen.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideArticleRepository(apiService: ApiService, articleDao: ArticleDao, connectivityManager: ConnectivityManager): ArticleRepository {
        return ArticleRepository(apiService,articleDao,connectivityManager)
    }
}