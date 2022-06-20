package GymSpa.fit.workout_log

import GymSpa.fit.workout_log.databinding.ActivityHomeBinding
import GymSpa.fit.workout_log.databinding.ActivitySignUpBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

//   lateinit var fcvHome : FragmentContainerView
//    lateinit var bnvHome : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
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
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, PlanFragment())
                    transaction.commit()
                    true

                }
                R.id.track ->{
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, TrackFragment())
                    transaction.commit()
                    true
                }
                R.id.Profile ->{
                   supportFragmentManager.beginTransaction().replace(R.id.fcvHome,ProfileFragment()).commit()
                    true

                }
                else -> false
            }
        }
    }
}