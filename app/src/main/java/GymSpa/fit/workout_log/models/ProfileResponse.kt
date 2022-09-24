package GymSpa.fit.workout_log.models

import com.google.gson.annotations.SerializedName

class ProfileResponse (
    @SerializedName("gender")var gender : String,
    @SerializedName("height")var height : String,
    @SerializedName("weight")var weight : String,
    @SerializedName("date_of_birth")var dateOfBirth : String

)