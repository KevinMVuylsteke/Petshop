package ar.edu.ort.parcial.screens.auth.loginin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.parcial.model.LoginRequest
import ar.edu.ort.parcial.shared.UserApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginInViewModel @Inject constructor(
    private val userApi: UserApi
) : ViewModel() {


    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(newEmail: String) {
        val passwordValid = uiState.password.isNotBlank()
        uiState = uiState.copy(
            email = newEmail,
            showEmailError = if (uiState.triedToLogin) newEmail.isBlank() else false,
            showPasswordError = newEmail.isNotBlank() && !passwordValid
        )
    }

    fun onPasswordChange(newPassword: String) {
        uiState = uiState.copy(password = newPassword)
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
            showPasswordError = emailValid && !passwordValid,
            triedToLogin = true
        )

        return emailValid && passwordValid
    }
    fun login(onSuccess: () -> Unit) {
        if (!validateCredentials()) return

        viewModelScope.launch {
            val response = userApi.login(LoginRequest(uiState.email, uiState.password))
            if (response.isSuccessful) {
                uiState = uiState.copy( showPasswordError = false)
                onSuccess()
            } else {
                uiState = uiState.copy( showPasswordError = true)
            }
        }
    }

    fun clear() {
        uiState = LoginUiState()
    }
}
