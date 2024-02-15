package com.storeapp.store.data.repository

import arrow.core.Either
import com.storeapp.store.data.mapper.toGeneralError
import com.storeapp.store.data.remote.ApiService
import com.storeapp.store.domain.model.NetworkError
import com.storeapp.store.domain.model.ProductResponse
import com.storeapp.store.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductsRepository {
    override suspend fun getProducts(): Either<NetworkError, List<ProductResponse>> {
        return Either.catch {
            apiService.getProducts()
        }.mapLeft { it.toGeneralError() }
    }
}