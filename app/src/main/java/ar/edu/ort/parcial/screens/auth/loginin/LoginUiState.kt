package ar.edu.ort.parcial.screens.auth.loginin

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val showEmailError: Boolean = false,
    val showPasswordError: Boolean = false,
    val triedToLogin: Boolean = false
) {
    val isButtonEnabled: Boolean
        get() = email.isNotBlank() && password.isNotBlank()
}
