package GymSpa.fit.workout_log.ui

import GymSpa.fit.workout_log.databinding.ActivitySignUpBinding
import GymSpa.fit.workout_log.models.RegisterRequest
import GymSpa.fit.workout_log.models.RegisterResponse
import GymSpa.fit.workout_log.api.ApiClient
import GymSpa.fit.workout_log.api.ApiInterface
import GymSpa.fit.workout_log.viewmodel.UserViewModel
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Observer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    val userViewModel: UserViewModel by viewModels()
    lateinit var sharedPrefs :SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSign.setOnClickListener {
            signin()
        }

        binding.tvLog.setOnClickListener {
            val intent = Intent(this, Login_Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer { registerResponse->
            Toast.makeText(baseContext,registerResponse?.message,Toast.LENGTH_LONG).show()
        })
    }

    fun signin() {
        var mail = binding.etMail.text.toString()
        var password = binding.etPass.text.toString()
        var confirmPass = binding.etConfirm.text.toString()
        var firstName = binding.etFirstname.text.toString()
        var lastName = binding.etLastname.text.toString()
        var phoneNumber = binding.etPhone.text.toString()
        var error = false

        if (mail.isBlank()) {
            binding.tilMail.error = "Email is required"
            return
        }
        if (phoneNumber.isBlank()) {
            binding.tilPhoneNumber.error = "Phone number is required"
            return
        }

        if (password.isBlank()) {
            binding.tilPass.error = "Password is required"
            return
        }
        if (confirmPass.isBlank()) {
            binding.tilConfirm.error = "check password is needed"
            return
        }
        else{
            binding.tilConfirm.error=null
        }

        if (firstName.isBlank()) {
            binding.tilFirstname.error = "input firstname is needed"
            return
        }
        if (lastName.isBlank()) {
            binding.tilLastname.error = "input lastname is needed"
            return
        }
        else{
            binding.tilConfirm.error = "invalid password"
        }
        if (!error){
            val registerRequest=RegisterRequest(firstName,lastName,phoneNumber,mail,password,confirmPass)
            userViewModel.registerUser(registerRequest)
        }
    }
}