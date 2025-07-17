package ar.edu.ort.parcial.shared

import ar.edu.ort.parcial.model.LoginRequest
import ar.edu.ort.parcial.model.RegisterRequest
import ar.edu.ort.parcial.models.ProductListResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("users")
    suspend fun register(@Body request: RegisterRequest): Response<Unit>

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<Unit>

    // 2. Products (Listado de Productos)
    // Puedes obtener todos los productos, o limitar/saltar (pagination)
    @GET("products")
    suspend fun getAllProducts(): Response<ProductListResponse>


}