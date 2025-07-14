package ar.edu.ort.parcial.data.remote

import android.util.Log
import ar.edu.ort.parcial.model.ProductDetail
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    suspend fun getProductByCategoryAndId(category: String, productId: String): ProductDetail? {

        return try {
            val docSnapshot = firestore.collection("products")
                .document(productId)
                .get()
                .await()
            Log.d("ProductRepository", "Documento existe: ${docSnapshot.exists()}")

            if (docSnapshot.exists()) {
                val product = docSnapshot.toObject(ProductDetail::class.java)
                Log.d("ProductRepository", "Producto mapeado: $product")

                product?.copy(id = docSnapshot.id)

            } else {
                Log.w("ProductRepository", "No se encontró el documento con ID $productId")
                null
            }
        } catch (e: Exception) {
            Log.e("ProductRepository", "Error al obtener producto: ${e.message}", e)
            null
        }
    }

}
