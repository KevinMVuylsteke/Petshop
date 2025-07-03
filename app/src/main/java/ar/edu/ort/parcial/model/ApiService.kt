package ar.edu.ort.parcial.model

import ar.edu.ort.parcial.data.models.LoginRequest
import ar.edu.ort.parcial.data.models.ProductListResponse
import ar.edu.ort.parcial.data.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("users")//register
    suspend fun register(@Body request: RegisterRequest): Response<Unit>

    @POST("auth/login")
    suspend fun loginUser(@Body request: LoginRequest): Response<User>

    // 2. Products (Listado de Productos)
    // Puedes obtener todos los productos, o limitar/saltar (pagination)
    @GET("products")
    suspend fun getAllProducts(): Response<ProductListResponse>


}
