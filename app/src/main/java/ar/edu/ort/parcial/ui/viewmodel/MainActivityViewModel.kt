package ar.edu.ort.parcial.ui.viewmodel

import androidx.lifecycle.ViewModel
data class UiState (
    val userName: String
)

class MainActivityViewModel : ViewModel() {
    var titleBar: String = ""
        set(value) {
            field = value
            // Otras acciones si es necesario
        }
}