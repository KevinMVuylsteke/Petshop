package ar.edu.ort.parcial.screens.auth.createaccount

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CreateAccountViewModel : ViewModel() {

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
}
