package ar.edu.ort.parcial.screens.homepage.home

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor() : ViewModel() {

    private val _categories = mutableStateListOf<Category>()
    val categories: List<Category> get() = _categories

    private val db = FirebaseFirestore.getInstance()

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        db.collection("categories")
            .get()
            .addOnSuccessListener { result ->
                _categories.clear()
                for (document in result) {
                    val name = document.getString("name") ?: continue
                    Log.d("CategoryViewModel", "Cargando categoría: ${document.id} - $name")
                    val category = Category(id = document.id, name = name)
                    _categories.add(category)
                }
                Log.d("CategoryViewModel", "Total categorías: ${_categories.size}")
            }
            .addOnFailureListener {
                Log.e("CategoryViewModel", "Error al cargar categorías", it)
            }
    }
}
data class Category(
    val id: String = "",
    val name: String = ""
)
