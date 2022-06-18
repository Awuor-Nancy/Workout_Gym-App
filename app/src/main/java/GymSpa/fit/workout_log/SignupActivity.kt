package GymSpa.fit.workout_log

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var tilFirstname : TextInputLayout
    lateinit var etFisrtname  : TextInputEditText

    lateinit var tilLastname : TextInputLayout
    lateinit var etLastname  :  TextInputEditText

    lateinit var tilMail :  TextInputLayout
    lateinit var etMail  :  TextInputEditText

    lateinit var tilPass : TextInputLayout
    lateinit var etPass  :  TextInputEditText

    lateinit var tilConfirm : TextInputLayout
    lateinit var etConfirm  : TextInputEditText

    lateinit var btnSign  :  Button
    lateinit var tvLog  : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSign = findViewById(R.id.btnSign)
        tvLog = findViewById(R.id.tvLog)

        tilFirstname = findViewById(R.id.tilFirstname)
        etFisrtname = findViewById(R.id.etFirstname)

        tilLastname  = findViewById(R.id.tilLastname)
        etLastname = findViewById(R.id.etLastname)

        tilMail  = findViewById(R.id.tilMail)
        etMail  = findViewById(R.id.etMail)

        tilPass = findViewById(R.id.tilPass)
        etPass = findViewById(R.id.etPass)

        tilConfirm = findViewById(R.id.tilConfirm)
        etConfirm  = findViewById(R.id.etConfirm)

        btnSign.setOnClickListener {
            signin()

        }
        tvLog.setOnClickListener{
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
        }

    }
    fun signin (){
        var mail = etMail.text.toString()
        var pass = etPass.text.toString()
        var confirm = etConfirm.text.toString()
        var firstName = etFisrtname.text.toString()
        var lastName = etLastname.text.toString()

        if (mail.isBlank()){
            tilMail.error = "Email is required"
            return

        }
        if(pass.isBlank()){
            tilPass.error = "Password is required"
            return
        }
        if(pass.isBlank()){
            tilConfirm.error = "Password is required"
            return
        }
        if (confirm.isBlank()) {
            tilConfirm.error = "check password is needed"
            return
        }
        if( firstName.isBlank()){
            tilFirstname.error = "input first name is needed"
            return
        }
        if (lastName.isBlank()){
            tilLastname.error = "input last name is needed"
            return
        }
        else{
            tilConfirm.error = "invalid password"
        }
    }
}