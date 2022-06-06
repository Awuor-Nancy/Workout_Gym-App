package GymSpa.fit.workout_log

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Login_Activity : AppCompatActivity() {
    lateinit var btnLogin: Button

    lateinit var tilEmail:TextInputLayout
    lateinit var etEmail:TextInputEditText

    lateinit var tilPassword:TextInputLayout
    lateinit var etPassword:TextInputEditText

    lateinit var tvSign : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin = findViewById(R.id.btnLogin)
        tvSign = findViewById(R.id.tvSign)

        tilEmail = findViewById(R.id.tilEmail)
        etEmail= findViewById(R.id.etEmail)

        tilPassword= findViewById(R.id.tilPassword)
        etPassword= findViewById(R.id.etPassword)

        btnLogin.setOnClickListener {
            validateLogin()
        }
        tvSign.setOnClickListener {
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
    }
    fun validateLogin(){
        var email = etEmail.toString()
        var password = etPassword.toString()

        if (email.isBlank()){
            tilEmail.error = getString(R.string.Email_required)
        }
        if (password.isBlank()){
            tilPassword.error = getString(R.string.Password_required)
        }
        else{
            "invalid password"
        }
    }
}
