
package ar.edu.ort.parcial.model


import retrofit2.Response
import javax.inject.Inject

class UserApi @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun register(request: RegisterRequest): Response<Unit> {
        return apiService.register(request)
    }
}
