package ar.edu.ort.parcial.screens.auth.createaccount

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.parcial.model.RegisterRequest
import ar.edu.ort.parcial.shared.UserApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@HiltViewModel
class CreateAccountViewModel @Inject constructor(
    //private val userApi: UserApi
) : ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth

    var uiState by mutableStateOf(CreateAccountUiState())
        private set

    fun onNameChange(newName: String) {
        uiState = uiState.copy(name = newName)
        validateFields()
    }

    fun onEmailChange(newEmail: String) {
        uiState = uiState.copy(email = newEmail)
        validateFields()
    }

    fun onPasswordChange(newPassword: String) {
        uiState = uiState.copy(password = newPassword)
        validateFields()
    }

    fun onTermsChecked(checked: Boolean) {
        uiState = uiState.copy(acceptedTerms = checked)
    }

    private fun validateFields() {
        val showPasswordError = uiState.name.isNotBlank() &&
                uiState.email.isNotBlank() &&
                uiState.password.isBlank()

        uiState = uiState.copy(
            showPasswordError = showPasswordError,
            triedToInput = true
        )
    }

    /*
    fun register(onSuccess: () -> Unit) {
        viewModelScope.launch {
            userApi.register(
                RegisterRequest(
                    name = uiState.name,
                    email = uiState.email,
                    password = uiState.password
                )
            )
            onSuccess()
        }
    }
    */
    fun register(onSuccess: () -> Unit) {
        val email = uiState.email.trim()
        val password = uiState.password

        if (email.isBlank() || password.isBlank()) {
            uiState = uiState.copy(errorMessage = "Email y contraseña son obligatorios")
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            uiState = uiState.copy(errorMessage = "El email no tiene un formato válido")
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val profileUpdates = user?.updateProfile(
                        com.google.firebase.auth.UserProfileChangeRequest.Builder()
                            .setDisplayName(uiState.name)
                            .build()
                    )
                    profileUpdates?.addOnCompleteListener {
                        uiState = uiState.copy(errorMessage = null)
                        onSuccess()
                    } ?: run {
                        uiState = uiState.copy(errorMessage = null)
                        onSuccess()
                    }
                } else {
                    val errorMsg = task.exception?.message ?: "Error desconocido al registrar"
                    uiState = uiState.copy(errorMessage = errorMsg)
                    Log.e("CreateAccount", "Error al registrar: $errorMsg")
                }
            }
    }



}
