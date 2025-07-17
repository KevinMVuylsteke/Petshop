package ar.edu.ort.parcial.data.remote.api

import ar.edu.ort.parcial.data.remote.shared.ApiService
import ar.edu.ort.parcial.model.LoginRequest
import ar.edu.ort.parcial.model.RegisterRequest
import retrofit2.Response
import javax.inject.Inject

class UserApi @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun register(request: RegisterRequest): Response<Unit> {
        return apiService.register(request)
    }
    suspend fun login(request: LoginRequest): Response<Unit> {
        return apiService.login(request)
    }
}