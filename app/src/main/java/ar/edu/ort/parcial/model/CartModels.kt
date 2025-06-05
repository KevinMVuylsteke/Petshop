package ar.edu.ort.parcial.data.models

data class CartProduct(
    val id: Int,
    val title: String,
    val price: Double,
    val quantity: Int,
    val total: Double,
    val discountPercentage: Double,
    val discountedPrice: Double,
    val thumbnail: String
)

data class Cart(
    val id: Int,
    val products: List<CartProduct>,
    val total: Double,
    val discountedTotal: Double,
    val userId: Int,
    val totalProducts: Int,
    val totalQuantity: Int
)

data class CartsByUserResponse(
    val carts: List<Cart>,
    val total: Int,
    val skip: Int,
    val limit: Int
)