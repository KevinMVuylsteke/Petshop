package ar.edu.ort.parcial.data.models

data class LoginRequest(
    val username: String,
    val password: String,
    val expiresInMins: Int = 60
)

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val token: String
)