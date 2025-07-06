package ar.edu.ort.parcial.shared

import ar.edu.ort.parcial.shared.ApiService
import ar.edu.ort.parcial.model.RegisterRequest
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostServiceUser @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun invoke(request: RegisterRequest): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            apiService.register(request)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
