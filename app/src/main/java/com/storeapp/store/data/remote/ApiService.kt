package com.storeapp.store.data.remote

import com.storeapp.store.domain.model.ProductResponse
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts(): List<ProductResponse>
}