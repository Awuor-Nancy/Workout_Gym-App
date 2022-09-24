package GymSpa.fit.workout_log.repository

import GymSpa.fit.workout_log.api.ApiClient
import GymSpa.fit.workout_log.api.ApiInterface
import GymSpa.fit.workout_log.models.LoginRequest
import GymSpa.fit.workout_log.models.ProfileRequest
import GymSpa.fit.workout_log.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRespository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest)
    = withContext(Dispatchers.IO){
        val response = apiClient.login(loginRequest)
        return@withContext response
    }

    suspend fun registerUser(registerRequest: RegisterRequest)
            = withContext(Dispatchers.IO){
        val response = apiClient.registerUser(registerRequest)
        return@withContext response
    }

    suspend fun profile(profileRequest: ProfileRequest)
            = withContext(Dispatchers.IO){
        val response = apiClient.profile(profileRequest)
        return@withContext response
    }

 }