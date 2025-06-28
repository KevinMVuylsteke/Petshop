package ar.edu.ort.parcial.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.parcial.data.models.LoginRequest
import ar.edu.ort.parcial.data.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun login(username: String, password: String) {
        _loginState.value = LoginState.Loading
        viewModelScope.launch {
            try {
                val request = LoginRequest(username, password)
                val response = RetrofitClient.apiService.loginUser(request)

                if (response.isSuccessful) {
                    val user = response.body()
                    if (user != null) {
                        _loginState.value = LoginState.Success(user)
                        // Aquí guardarías el token o la sesión del usuario
                    } else {
                        _loginState.value = LoginState.Error("Respuesta de usuario vacía.")
                    }
                } else {
                    _loginState.value = LoginState.Error(
                        "Error de login: ${response.code()} ${response.errorBody()?.string() ?: response.message()}"
                    )
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error("Error de red: ${e.message}")
            }
        }
    }
}

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val user: User) : LoginState()
    data class Error(val message: String) : LoginState()
}