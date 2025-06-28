package ar.edu.ort.parcial.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.parcial.data.models.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {

    private val _productsState = MutableStateFlow<ProductsState>(ProductsState.Loading)
    val productsState: StateFlow<ProductsState> = _productsState

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        _productsState.value = ProductsState.Loading
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getAllProducts()
                if (response.isSuccessful) {
                    val productListResponse = response.body()
                    if (productListResponse != null) {
                        _productsState.value = ProductsState.Success(productListResponse.products)
                    } else {
                        _productsState.value = ProductsState.Error("Respuesta de productos vacía.")
                    }
                } else {
                    _productsState.value = ProductsState.Error(
                        "Error al cargar productos: ${response.code()} ${response.errorBody()?.string() ?: response.message()}"
                    )
                }
            } catch (e: Exception) {
                _productsState.value = ProductsState.Error("Error de red: ${e.message}")
            }
        }
    }
}

sealed class ProductsState {
    object Loading : ProductsState()
    data class Success(val products: List<Product>) : ProductsState()
    data class Error(val message: String) : ProductsState()
}