package GymSpa.fit.workout_log.models

import com.google.gson.annotations.SerializedName

data class User(

@SerializedName("first_Name") var firstName: String,
@SerializedName("last_Name") var lastName: String,
@SerializedName("phone_number") var phoneNumber: String,
var email: String,
@SerializedName("user_id") var userId: String,

)
