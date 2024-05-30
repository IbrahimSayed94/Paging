package com.example.pagingscreen.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingscreen.network.ApiService
import com.example.pagingscreen.network.Item


class RemoteDataSource (
    private val apiService: ApiService,
    private val itemDao: ItemDao
) : PagingSource<Int, Item>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getItems(page, params.loadSize)
            itemDao.insertAll(response.items)
            LoadResult.Page(
                data = response.items,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.items.isEmpty()) null else page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}