package com.example.pagingscreen.data.repository.di

import com.example.pagingscreen.data.repository.ItemRepository
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
    fun provideItemRepository(apiService: ApiService): ItemRepository {
        return ItemRepository(apiService)
    }
}