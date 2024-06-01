package com.example.pagingscreen.domain.usecase
import androidx.paging.PagingData
import com.example.pagingscreen.data.repository.ArticleRepository
import com.example.pagingscreen.network.response.Article
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
@ExperimentalCoroutinesApi
class GetArticlesUseCaseTest {

    private lateinit var articleRepository: ArticleRepository
    private lateinit var getArticlesUseCase: GetArticlesUseCase

    @Before
    fun setUp() {
        articleRepository = mockk()
        getArticlesUseCase = GetArticlesUseCase(articleRepository)
    }

    @Test
    fun `invoke should return flow of PagingData`() = runTest {
        val articles = listOf(
            Article(id = 1, title = "Test Article 1", urlToImage = "image 1"),
            Article(id = 2, title = "Test Article 2", urlToImage = "image 2")
        )
        val pagingData = PagingData.from(articles)
        coEvery { articleRepository.getArticles() } returns flowOf(pagingData)

        val result: Flow<PagingData<Article>> = getArticlesUseCase()

        val resultList = result.toList()
        assert(resultList.isNotEmpty())
        coVerify { articleRepository.getArticles() }
    }
}