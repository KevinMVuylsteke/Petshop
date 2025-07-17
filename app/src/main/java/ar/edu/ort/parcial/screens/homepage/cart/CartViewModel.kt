package ar.edu.ort.parcial.screens.homepage.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.parcial.model.CartResponse
import ar.edu.ort.parcial.data.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: CartRepository
) : ViewModel() {

    private val _cartState = MutableStateFlow<CartResponse?>(null)
    val cartState: StateFlow<CartResponse?> = _cartState

    fun fetchCart() {
        viewModelScope.launch {
            val result = repository.getCart()
            result.onSuccess {
                _cartState.value = it
            }.onFailure {
                // Manejo de error, log o estado de error
            }
        }
    }
}
