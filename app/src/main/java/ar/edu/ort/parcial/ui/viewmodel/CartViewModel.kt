package ar.edu.ort.parcial.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.parcial.data.api.RetrofitClient
import ar.edu.ort.parcial.data.models.Cart
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {

    private val _cartState = MutableStateFlow<CartState>(CartState.Loading)
    val cartState: StateFlow<CartState> = _cartState

    fun fetchUserCart(userId: Int) {
        _cartState.value = CartState.Loading
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getUserCarts(userId)
                if (response.isSuccessful) {
                    val cartsResponse = response.body()
                    if (cartsResponse != null && cartsResponse.carts.isNotEmpty()) {
                        _cartState.value = CartState.Success(cartsResponse.carts.first()) // Asumimos el primer carrito del usuario
                    } else {
                        _cartState.value = CartState.Error("Carrito no encontrado para el usuario o respuesta vacía.")
                    }
                } else {
                    _cartState.value = CartState.Error(
                        "Error al cargar el carrito: ${response.code()} ${response.errorBody()?.string() ?: response.message()}"
                    )
                }
            } catch (e: Exception) {
                _cartState.value = CartState.Error("Error de red: ${e.message}")
            }
        }
    }
}

sealed class CartState {
    object Loading : CartState()
    data class Success(val cart: Cart) : CartState()
    data class Error(val message: String) : CartState()
}