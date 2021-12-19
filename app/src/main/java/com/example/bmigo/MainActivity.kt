package com.example.bmigo

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    var button: Button? = null
    var editTextH: EditText? = null
    var editTextW: EditText? = null
    var result: TextView? = null
    var imageView: ImageView? = null
    var bottomNavigationView: BottomNavigationView? = null
    var frameLayout: FrameLayout? = null
    var lottieAnimationWeight:LottieAnimationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lottieAnimationWeight?.playAnimation()
        connectVs()
        clickBtn()
        navBottomClick()


    }

    private fun connectVs() {
        lottieAnimationWeight = findViewById(R.id.weightLottie)
        button = findViewById(R.id.btnCal)
        editTextH = findViewById(R.id.ETheight)
        editTextW = findViewById(R.id.EDweight)
        result = findViewById(R.id.bmiResult)
        imageView = findViewById(R.id.imgVr)
        bottomNavigationView = findViewById(R.id.bottomNavView)
        frameLayout = findViewById(R.id.container)
    }

    private fun clickBtn() {
        button?.setOnClickListener {

            try {
                val h: Float =
                    editTextH?.text.toString().toFloat() / 100 //نحول الطول من سانتي متر ل متر
                val w: Float = editTextW?.text.toString().toFloat() // نحول الوزن من نص ل فلوت
                val res: Float = w / (h * h)


                val intent: Intent = Intent(this, Result::class.java)
                intent.putExtra("R", res)
                startActivity(intent)
            } catch (error: NumberFormatException) {
                "خطا ادخل رقم"
            }


        }
    }

    private fun navBottomClick() {
        bottomNavigationView?.setOnItemSelectedListener {

            var intent = Intent()

            when (it.itemId) {

                R.id.workout -> {

                    var fragmentTransaction: FragmentTransaction =
                        supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.container, WorkoutFragment(), "WORKOUT")
                    fragmentTransaction.addToBackStack("WORKOUT")
                    fragmentTransaction.commit()

                    if (supportFragmentManager.backStackEntryCount > 0) {
                        supportFragmentManager.popBackStack()
                    }
                }
                R.id.health -> {
                    var fragmentTransaction: FragmentTransaction =
                        supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.container, HealthyFoodFragment(), "HealthFood")
                    fragmentTransaction.addToBackStack("HealthFood")
                    fragmentTransaction.commit()

                    if (supportFragmentManager.backStackEntryCount > 0) {
                        supportFragmentManager.popBackStack()
                    }

                }

            }
            true
        }

    }
}













