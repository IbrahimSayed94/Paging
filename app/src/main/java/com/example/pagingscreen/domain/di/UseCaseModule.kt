package com.example.pagingscreen.domain.di

import com.example.pagingscreen.data.repository.ArticleRepository
import com.example.pagingscreen.domain.usecase.GetArticlesUseCase
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
    fun provideGetArticlesUseCase(articleRepository: ArticleRepository) : GetArticlesUseCase{
        return GetArticlesUseCase(articleRepository)
    }
}