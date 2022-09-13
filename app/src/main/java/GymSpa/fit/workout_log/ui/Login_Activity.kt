package GymSpa.fit.workout_log.ui

import GymSpa.fit.workout_log.R
import GymSpa.fit.workout_log.databinding.ActivityLoginBinding
import GymSpa.fit.workout_log.models.LoginRequest
import GymSpa.fit.workout_log.models.LoginResponse
import GymSpa.fit.workout_log.api.ApiClient
import GymSpa.fit.workout_log.api.ApiInterface
import GymSpa.fit.workout_log.viewmodel.UserViewModel
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login_Activity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            validateLogin()
            finish()

        }
        binding.tvSign.setOnClickListener {
           val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer { loginResponse->

            saveLoginDetails(loginResponse!!)
            Toast.makeText(baseContext, loginResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext, HomeActivity::class.java))
            finish()
        })
        userViewModel.loginErrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error, Toast.LENGTH_LONG).show()

        })
    }

    fun validateLogin(){
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        var error = false

        if (email.isBlank()){
            binding.tilEmail.error = getString(R.string.Email_required)
            error = true
        }
        if (password.isBlank()){
            binding.tilPassword.error = getString(R.string.Password_required)
            error= true
        }
        if (!error){
          var loginRequest = LoginRequest(email, password)
            binding.pblLogin.visibility = View.VISIBLE

       //   invoke the makeLoginRequestfunction
            userViewModel.loginUser(loginRequest)
       }
    }

        fun saveLoginDetails(loginResponse: LoginResponse){
            val editor = sharedPrefs.edit()
            editor.putString("ACCESS_TOKEN", loginResponse.accessToken)
            editor.putString("USER_ID", loginResponse.userId)
            editor.putString("PROFILE_ID", loginResponse.profileId)
            editor.apply()
        }
}
