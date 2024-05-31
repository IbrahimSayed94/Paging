package com.example.pagingscreen.domain.usecase

import androidx.paging.PagingData
import com.example.pagingscreen.data.datasource.local.Item
import com.example.pagingscreen.data.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    operator fun invoke(): Flow<PagingData<Item>> {
        return itemRepository.getItems()
    }
}