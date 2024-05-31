package com.example.pagingscreen.domain.di

import com.example.pagingscreen.data.repository.ItemRepository
import com.example.pagingscreen.domain.usecase.GetItemsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetItemUseCase(itemRepository: ItemRepository) : GetItemsUseCase{
        return GetItemsUseCase(itemRepository)
    }
}