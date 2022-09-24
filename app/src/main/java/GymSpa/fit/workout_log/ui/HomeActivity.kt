package GymSpa.fit.workout_log.ui

import GymSpa.fit.workout_log.R
import GymSpa.fit.workout_log.databinding.ActivityHomeBinding
import GymSpa.fit.workout_log.utils.Constants
import GymSpa.fit.workout_log.viewmodel.ExerciseViewModel
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.Observer
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var sharedPref: SharedPreferences
    lateinit var fcvHome:FragmentContainerView
    lateinit var  bnvHome:BottomNavigationView
    val exerciseViewModel:ExerciseViewModel by viewModels()
    lateinit var sharedPreferences: SharedPreferences

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
        sharedPref = getSharedPreferences(Constants.prefsFile, MODE_PRIVATE)
        val token = sharedPref.getString(Constants.accessToken, Constants.EMPTY_STRING)
        exerciseViewModel.fetchExerciseCategories(token!!)

    }

    override fun onResume() {
        super.onResume()
        exerciseViewModel.exerciseCategoryLiveData.observe(this, Observer { exerciseCategories ->
            Toast.makeText(this,"fetched ${exerciseCategories.size} categories", Toast.LENGTH_LONG).show()
        })
        exerciseViewModel.errorLiveData.observe(this, Observer { errorMsg->
            Toast.makeText(this,errorMsg,Toast.LENGTH_LONG).show()
        })
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