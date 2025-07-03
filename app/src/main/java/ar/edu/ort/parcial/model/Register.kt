package ar.edu.ort.parcial.model

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
)
data class RegisterResponse(
    val id: Int,
    val username: String,
    val email: String,
    val password: String
)
