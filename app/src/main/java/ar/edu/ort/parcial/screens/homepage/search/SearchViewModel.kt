package ar.edu.ort.parcial.screens.homepage.search

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ar.edu.ort.parcial.screens.homepage.home.Category
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import androidx.lifecycle.viewModelScope
import ar.edu.ort.parcial.model.Product
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn



@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {

    private val db = FirebaseFirestore.getInstance()

    private val _categories = mutableStateListOf<Category>()
    val categories: List<Category> get() = _categories

    // Cambié mutableStateOf por MutableStateFlow para que combine funcione
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _selectedCategoryName = MutableStateFlow<String?>(null)
    val selectedCategoryName: StateFlow<String?> = _selectedCategoryName

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    val filteredProducts: StateFlow<List<Product>> = combine(
        searchQuery,
        selectedCategoryName,
        products
    ) { query: String, category: String?, productList: List<Product> ->

        productList.filter { product ->
            val matchesQuery = product.name.contains(query, ignoreCase = true)
            val matchesCategory = category == null || product.category == category
            matchesQuery && matchesCategory
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun updateQuery(query: String) {
        _searchQuery.value = query
    }

    fun selectCategory(name: String?) {
        _selectedCategoryName.value = name
    }

    init {
        fetchCategories()
        fetchProducts()
    }

    private fun fetchCategories() {
        db.collection("categories")
            .get()
            .addOnSuccessListener { result ->
                _categories.clear()
                for (document in result) {
                    val name = document.getString("name") ?: continue
                    _categories.add(Category(id = document.id, name = name))
                }
            }
            .addOnFailureListener {
                Log.e("SearchViewModel", "Error al cargar categorías", it)
            }
    }
    private fun fetchProducts() {
        db.collection("products")
            .get()
            .addOnSuccessListener { result ->
                val productList = result.map { doc ->
                    val product = doc.toObject(Product::class.java)
                    product.copy(id = doc.id)
                }
                _products.value = productList
            }
            .addOnFailureListener {
                Log.e("SearchViewModel", "Error al cargar productos", it)
            }
    }
/*
    private fun fetchProducts() {
        db.collection("products")
            .get()
            .addOnSuccessListener { result ->
                val productList = mutableListOf<Product>()
                for (doc in result) {
                    val product = doc.toObject(Product::class.java)
                    productList.add(product)
                }
                _products.value = productList
            }
            .addOnFailureListener {
                Log.e("SearchViewModel", "Error al cargar productos", it)
            }
    }*/
}