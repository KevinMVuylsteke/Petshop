package ar.edu.ort.parcial.screens.home.productdetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.parcial.data.local.FavoriteDao
import ar.edu.ort.parcial.data.local.FavoriteIdEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

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
