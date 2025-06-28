package ar.edu.ort.parcial.data

import ar.edu.ort.parcial.data.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    // 1. Auth (User Login)
    @POST("auth/login")
    suspend fun loginUser(@Body request: LoginRequest): Response<User>

    // 2. Products (Listado de Productos)
    // Puedes obtener todos los productos, o limitar/saltar (pagination)
    @GET("products")
    suspend fun getAllProducts(): Response<ProductListResponse>

    @GET("carts/user/{userId}")
    suspend fun getUserCarts(@Path("userId") userId: Int): Response<CartsByUserResponse>

    // Si quieres ver un carrito específico por su ID (ej. el carrito con id=1)
    @GET("carts/{cartId}")
    suspend fun getSingleCart(@Path("cartId") cartId: Int): Response<Cart>
}