package com.storeapp.store.domain.repository

import arrow.core.Either
import com.storeapp.store.domain.model.NetworkError
import com.storeapp.store.domain.model.ProductResponse

interface ProductsRepository {

    suspend fun getProducts(): Either<NetworkError, List<ProductResponse>>
}