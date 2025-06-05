package ar.edu.ort.parcial.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.parcial.data.api.RetrofitClient // Asegúrate de importar tu RetrofitClient
import ar.edu.ort.parcial.data.models.FavoriteRequest // Asegúrate de importar FavoriteRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductDetailViewModel : ViewModel() {

    private val _favoriteStatus = MutableStateFlow<FavoriteState>(FavoriteState.Idle)
    val favoriteStatus: StateFlow<FavoriteState> = _favoriteStatus

    // Función para manejar la adición/eliminación de un producto a favoritos
    // Por simplicidad, este ejemplo solo "agrega". En una API real,
    // el endpoint podría manejar alternar el estado (add/remove) o podrías tener dos funciones.
    fun addOrRemoveFavorite(productId: String) {
        // En una aplicación real, el `userId` se obtendría de una sesión de usuario
        // (por ejemplo, desde SharedPreferences o DataStore después del login).
        // Para este ejemplo con DummyJSON, que no tiene un endpoint de favoritos persistente
        // y real, usaremos un ID de usuario fijo y una simulación de respuesta.
        val userId = "dummyUser123" // Reemplaza esto con el ID real del usuario logueado

        // Si la petición ya está en curso, no hacemos nada para evitar duplicados
        if (_favoriteStatus.value is FavoriteState.Loading) {
            return
        }

        _favoriteStatus.value = FavoriteState.Loading // Indica que la operación está en curso

        viewModelScope.launch {
            try {
                // Dado que DummyJSON no tiene un endpoint de favoritos real,
                // simulamos una respuesta exitosa.
                // Si tuvieras un backend real, harías esto:
                // val request = FavoriteRequest(productId, userId)
                // val response = RetrofitClient.apiService.addFavorite(request)
                //
                // if (response.isSuccessful) {
                //     val body = response.body()
                //     if (body != null && body.success) {
                //         _favoriteStatus.value = FavoriteState.Success("Producto agregado a favoritos.")
                //     } else {
                //         _favoriteStatus.value = FavoriteState.Error(body?.message ?: "Error desconocido.")
                //     }
                // } else {
                //     _favoriteStatus.value = FavoriteState.Error("Error de la API: ${response.code()} ${response.message()}")
                // }

                // --- SIMULACIÓN PARA DUMMYJSON ---
                kotlinx.coroutines.delay(800) // Simula un retardo de red
                val success = Math.random() > 0.3 // 70% de éxito, 30% de error para probar ambos casos
                if (success) {
                    _favoriteStatus.value = FavoriteState.Success("¡Producto favorito actualizado!")
                } else {
                    _favoriteStatus.value = FavoriteState.Error("Fallo al actualizar favorito. Inténtelo de nuevo.")
                }
                // --- FIN SIMULACIÓN ---

            } catch (e: Exception) {
                _favoriteStatus.value = FavoriteState.Error("Error de red: ${e.message}")
            }
        }
    }

    // Opcional: Función para resetear el estado después de mostrar un mensaje
    fun resetFavoriteState() {
        _favoriteStatus.value = FavoriteState.Idle
    }
}

/**
 * Sealed class que representa los diferentes estados de la operación de favoritos.
 */
sealed class FavoriteState {
    object Idle : FavoriteState()      // Estado inicial o después de una operación completada/reseteada
    object Loading : FavoriteState()    // La operación está en curso
    data class Success(val message: String) : FavoriteState() // La operación fue exitosa
    data class Error(val message: String) : FavoriteState()   // Ocurrió un error
}