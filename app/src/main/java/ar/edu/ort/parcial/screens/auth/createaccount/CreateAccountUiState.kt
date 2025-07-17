package ar.edu.ort.parcial.screens.auth.createaccount

data class CreateAccountUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val acceptedTerms: Boolean = false,
    val showPasswordError: Boolean = false,
    val triedToInput: Boolean = false,
    val errorMessage: String? = null
) {
    val isButtonEnabled: Boolean
        get() = name.isNotBlank() && email.isNotBlank() && password.isNotBlank() && acceptedTerms
}
