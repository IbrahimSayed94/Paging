package com.example.pagingscreen.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pagingscreen.domain.usecase.GetArticlesUseCase
import com.example.pagingscreen.network.response.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {

    val articles: Flow<PagingData<Article>> = getArticlesUseCase().cachedIn(viewModelScope)
}