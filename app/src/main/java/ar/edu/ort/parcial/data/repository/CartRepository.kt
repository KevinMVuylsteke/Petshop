package ar.edu.ort.parcial.data.repository

import ar.edu.ort.parcial.data.remote.shared.ApiService.ProductApiService
import ar.edu.ort.parcial.model.CartResponse


import javax.inject.Inject

class CartRepository @Inject constructor(
    private val api: ProductApiService
) {
    suspend fun getCart(): Result<CartResponse> {
        return try {
            val response = api.getCart()
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Error: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}