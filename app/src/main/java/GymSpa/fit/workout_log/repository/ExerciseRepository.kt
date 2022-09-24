package GymSpa.fit.workout_log.repository

import GymSpa.fit.workout_log.api.ApiClient
import GymSpa.fit.workout_log.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExerciseRepository {
    var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun fetchExerciseCategory(accessToken:String) = withContext(Dispatchers.IO){
        return@withContext apiClient.fetchExerciseCategories(accessToken)
    }
}