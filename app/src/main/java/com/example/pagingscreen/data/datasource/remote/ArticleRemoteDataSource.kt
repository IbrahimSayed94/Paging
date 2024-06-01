package com.example.pagingscreen.data.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingscreen.data.datasource.local.ArticleDao
import com.example.pagingscreen.network.ApiService
import com.example.pagingscreen.network.response.Article
import javax.inject.Inject
import javax.inject.Singleton


@Singleton

class ArticleRemoteDataSource @Inject constructor(
    private val apiService: ApiService,
    private val articleDao: ArticleDao,
) : PagingSource<Int, Article>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getArticles(page = page, pageSize = params.loadSize)
            articleDao.insertAll(response.articles)
            LoadResult.Page(
                data = response.articles,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.articles.isEmpty()) null else page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}