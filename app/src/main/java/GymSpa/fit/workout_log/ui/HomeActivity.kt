package GymSpa.fit.workout_log.ui

import GymSpa.fit.workout_log.R
import GymSpa.fit.workout_log.databinding.ActivityHomeBinding
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvLogout.setOnClickListener {
            val intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
            finish()
            logOutRequest()

        }
        castViews()
        setupBottonNav()

    }
    fun castViews (){
        binding.fcvHome

























































        binding.bnvHome
    }
    fun setupBottonNav(){
        binding.bnvHome.setOnItemSelectedListener {item->
            when(item.itemId){
                R.id.Plan ->{
                    supportFragmentManager.beginTransaction()
                    .replace(R.id.fcvHome, PlanFragment())
                    .commit()
                    true
                }
                R.id.track ->{
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, TrackFragment())
                    transaction.commit()
                    true
                }
                R.id.Profile ->{
                   supportFragmentManager.beginTransaction().replace(
                       R.id.fcvHome,
                       ProfileFragment()
                   ).commit()
                    true

                }
                else -> false
            }
        }
    }
    fun logOutRequest (){
        sharedPref.edit().clear().commit()
    }
}