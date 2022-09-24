package GymSpa.fit.workout_log.viewmodel

import GymSpa.fit.workout_log.models.LoginRequest
import GymSpa.fit.workout_log.models.LoginResponse
import GymSpa.fit.workout_log.models.ProfileRequest
import GymSpa.fit.workout_log.models.RegisterRequest
import GymSpa.fit.workout_log.repository.UserRespository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val userRepository = UserRespository()
    var loginResponseLiveData = MutableLiveData<LoginResponse>()
    val loginErrorLiveData = MutableLiveData<String?>()
    val registerResponseLiveData = MutableLiveData<String?>()
    val registerErrorLiveData = MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if (response.isSuccessful) {
                loginResponseLiveData.postValue(response.body())
            } else {
                val error = response.errorBody()?.string()
                loginErrorLiveData.postValue(error)

            }
        }
    }
        fun registerUser(registerRequest: RegisterRequest){
            viewModelScope.launch {
                val response = userRepository.registerUser(registerRequest)
                if (response.isSuccessful) {
                    registerResponseLiveData.postValue(response.body().toString())

                }
                else{
                    val error = response.errorBody()?.string()
                    registerErrorLiveData.postValue(error)

                }
            }

        }

    fun profile(profileRequest: ProfileRequest){
        viewModelScope.launch {
            val response = userRepository.profile(profileRequest)
            if (response.isSuccessful) {
                registerResponseLiveData.postValue(response.body().toString())

            }
            else{
                val error = response.errorBody()?.string()
                registerErrorLiveData.postValue(error)

            }
        }

    }

    }

