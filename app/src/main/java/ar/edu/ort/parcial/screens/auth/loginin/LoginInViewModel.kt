package ar.edu.ort.parcial.screens.auth.loginin

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginInViewModel @Inject constructor(
) : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _loading = MutableLiveData(false)

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

        auth.signInWithEmailAndPassword(uiState.email, uiState.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    uiState = uiState.copy(showPasswordError = false)
                    Log.d("Login", "Login exitoso con FirebaseAuth")
                    onSuccess()
                } else {
                    Log.e("Login", "Error al iniciar sesión: ${task.exception?.message}")
                    uiState = uiState.copy(showPasswordError = true)
                }
            }
    }

    fun clear() {
        uiState = LoginUiState()
    }
}
