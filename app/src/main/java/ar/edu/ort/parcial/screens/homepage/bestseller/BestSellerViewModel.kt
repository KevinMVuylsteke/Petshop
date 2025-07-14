package ar.edu.ort.parcial.screens.homepage.bestseller

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import ar.edu.ort.parcial.model.Product

@HiltViewModel
class BestSellerViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        firestore.collection("products")
            .get()
            .addOnSuccessListener { result ->
                val productList = result.map { doc ->
                    val product = doc.toObject(Product::class.java)
                    product.copy(id = doc.id)
                }
                _products.value = productList
            }
            .addOnFailureListener {
                _products.value = emptyList()
            }
    }
}