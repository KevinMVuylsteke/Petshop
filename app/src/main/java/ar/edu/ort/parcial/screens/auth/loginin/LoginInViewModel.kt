package ar.edu.ort.parcial.screens.auth.loginin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val showEmailError: Boolean = false,
    val showPasswordError: Boolean = false,
    val triedToLogin: Boolean = false
) {
    val isButtonEnabled: Boolean // Habilita botón si ambos campos están completos
        get() = email.isNotBlank() && password.isNotBlank()
}

class LoginInViewModel : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(newEmail: String) {
        val passwordValid = uiState.password.isNotBlank()
        uiState = uiState.copy(
            email = newEmail,
            showEmailError = if (uiState.triedToLogin) newEmail.isBlank() else false,
            // Si el email ya está completo y el password es inválido, muestro error en password
            showPasswordError = newEmail.isNotBlank() && !passwordValid
        )
    }

    fun onPasswordChange(newPassword: String) {
        uiState = uiState.copy(password = newPassword)
        // Opcional: borrar error cuando usuario modifica password
        if (uiState.triedToLogin) {
            val passwordValid = newPassword.isNotBlank()
            uiState = uiState.copy(showPasswordError = !passwordValid && uiState.email.isNotBlank())
        }
    }

    fun validateCredentials(): Boolean {
        val emailValid = uiState.email.isNotBlank()
        val passwordValid = uiState.password.isNotBlank()

        uiState = uiState.copy(
            showEmailError = !emailValid,
            // Mostrar error password solo si email es válido
            showPasswordError = emailValid && !passwordValid,
            triedToLogin = true
        )

        return emailValid && passwordValid
    }

    fun clear() {
        uiState = LoginUiState()
    }
}
