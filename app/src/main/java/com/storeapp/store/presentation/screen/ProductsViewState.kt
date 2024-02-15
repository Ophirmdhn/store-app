package com.storeapp.store.presentation.screen

import com.storeapp.store.domain.model.ProductResponse

data class ProductsViewState(
    val isLoading: Boolean = false,
    val success: List<ProductResponse> = emptyList(),
    val error: String? = null
)
