package GymSpa.fit.workout_log.api

import GymSpa.fit.workout_log.models.LoginRequest
import GymSpa.fit.workout_log.models.LoginResponse
import GymSpa.fit.workout_log.models.RegisterRequest
import GymSpa.fit.workout_log.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>

    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>

}