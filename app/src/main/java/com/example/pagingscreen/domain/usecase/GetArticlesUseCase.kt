package com.example.pagingscreen.domain.usecase

import androidx.paging.PagingData
import com.example.pagingscreen.data.repository.ArticleRepository
import com.example.pagingscreen.network.response.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {
    operator fun invoke(): Flow<PagingData<Article>> {
        return articleRepository.getArticles()
    }
}