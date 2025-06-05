package ar.edu.ort.parcial.data.models

data class FavoriteRequest(
    val productId: String,
    val userId: String
)

data class FavoriteResponse(
    val success: Boolean,
    val message: String
)