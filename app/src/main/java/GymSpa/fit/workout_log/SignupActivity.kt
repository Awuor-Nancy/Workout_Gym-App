package GymSpa.fit.workout_log

import GymSpa.fit.workout_log.databinding.ActivityHomeBinding
import GymSpa.fit.workout_log.databinding.ActivitySignUpBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSign.setOnClickListener {
            signin()
        }
        binding.tvLog.setOnClickListener{
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
        }
    }
    fun signin (){
        var mail = binding.etMail.text.toString()
        var pass = binding.etPass.text.toString()
        var confirm = binding.etConfirm.text.toString()
        var firstName = binding.etFirstname.text.toString()
        var lastName = binding.etLastname.text.toString()

        if (mail.isBlank()){
            binding.tilMail.error = "Email is required"
            return
        }
        if(pass.isBlank()){
            binding.tilPass.error = "Password is required"
            return
        }
        if(pass.isBlank()){
            binding.tilConfirm.error = "Password is required"
            return
        }
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "check password is needed"
            return
        }
        if( firstName.isBlank()){
            binding.tilFirstname.error = "input first name is needed"
            return
        }
        if (lastName.isBlank()){
            binding.tilLastname.error = "input last name is needed"
            return
        }
        else{
            binding.tilConfirm.error = "invalid password"
        }
    }
}