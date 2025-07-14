package ar.edu.ort.parcial.model

data class ProductDetail(
    val id: String = "",
    val name: String = "",
    val fullname: String= "",
    val description: String = "",
    val price: Double = 0.0,
    val imageUrl: String = "",
    val category: String = ""
)