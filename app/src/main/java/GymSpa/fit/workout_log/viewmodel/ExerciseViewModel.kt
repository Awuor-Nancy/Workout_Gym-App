package GymSpa.fit.workout_log.viewmodel

import GymSpa.fit.workout_log.models.ExerciseCategory
import GymSpa.fit.workout_log.repository.ExerciseRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ExerciseViewModel: ViewModel() {
    val exerciseRepository= ExerciseRepository()
    val exerciseCategoryLiveData = MutableLiveData<List<ExerciseCategory>>()
    var errorLiveData = MutableLiveData<String?>()

//    function to fetch exercise category
    fun fetchExerciseCategories (accessToken: String){
        viewModelScope.launch {
            val response=exerciseRepository.fetchExerciseCategory(accessToken)
            if(response.isSuccessful) {
                exerciseCategoryLiveData.postValue(response.body())

            }
    else{

        var errorMsg = response.errorBody()?.string()
        errorLiveData.postValue(errorMsg)
          }
        }
    }
 }
