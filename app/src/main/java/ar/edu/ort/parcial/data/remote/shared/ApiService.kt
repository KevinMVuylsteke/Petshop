package ar.edu.ort.parcial.data.remote.shared

import ar.edu.ort.parcial.model.CartResponse
import ar.edu.ort.parcial.model.LoginRequest
import ar.edu.ort.parcial.model.ProductListResponse
import ar.edu.ort.parcial.model.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    interface ProductApiService {
        @GET("cart/1")
        suspend fun getCart(): Response<CartResponse>
    }



    @POST("users")
    suspend fun register(@Body request: RegisterRequest): Response<Unit>

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<Unit>

    // 2. Products (Listado de Productos)
    // Puedes obtener todos los productos, o limitar/saltar (pagination)
    @GET("products")
    suspend fun getAllProducts(): Response<ProductListResponse>


}