package ar.edu.ort.parcial.screens.homepage.productdetail

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.parcial.data.local.FavoriteDao
import ar.edu.ort.parcial.data.local.FavoriteIdEntity
import ar.edu.ort.parcial.data.remote.ProductRepository
import ar.edu.ort.parcial.model.ProductDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val favoriteDao: FavoriteDao,
    private val repository: ProductRepository // nuevo repo para Firestore
) : ViewModel() {

    private val _product = MutableStateFlow<ProductDetail?>(null)
    val product: StateFlow<ProductDetail?> = _product

    fun loadProduct(category: String, productId: String) {
        viewModelScope.launch {
            try {
                val fetchedProduct = repository.getProductByCategoryAndId(category, productId)
                _product.value = fetchedProduct
            } catch (e: Exception) {
                // Manejo de error
                _product.value = null
            }
        }
    }

    suspend fun isFavorite(productId: String): Boolean {
        val result = favoriteDao.getById(productId)
        return result != null
    }

    suspend fun toggleFavorite(productId: String) {
        val existing = favoriteDao.getById(productId)
        if (existing == null) {
            favoriteDao.insert(FavoriteIdEntity(productId))
        } else {
            favoriteDao.delete(existing)
        }
    }
}

/*
@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val favoriteDao: FavoriteDao
) : ViewModel() {

    suspend fun isFavorite(productId: String): Boolean {
        val result = favoriteDao.getById(productId)
        Log.d("FavoriteDaoLog", "isFavorite: productId=$productId -> ${result != null}")

        return favoriteDao.getById(productId) != null
    }

    suspend fun toggleFavorite(productId: String) {
        val existing = favoriteDao.getById(productId)
        if (existing == null) {
            Log.d("FavoriteDaoLog", "toggleFavorite: inserting productId=$productId")
            favoriteDao.insert(FavoriteIdEntity(productId))
        } else {
            Log.d("FavoriteDaoLog", "toggleFavorite: deleting productId=$productId")
            favoriteDao.delete(existing)
        }
    }
}
*/