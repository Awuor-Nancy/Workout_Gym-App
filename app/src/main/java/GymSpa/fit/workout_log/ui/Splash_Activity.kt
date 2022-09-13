package GymSpa.fit.workout_log.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Splash_Activity : AppCompatActivity() {
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)

        val accessToken = sharedPrefs.getString("ACCESS_TOKEN", "")
        if (accessToken!!.isNotBlank())
            startActivity(Intent(this,HomeActivity::class.java))
        else{
            startActivity(Intent(this, Login_Activity::class.java))
        }

        finish()
    }
}