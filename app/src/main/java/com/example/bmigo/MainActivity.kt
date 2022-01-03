package com.example.bmigo



import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


var btnYes:Button? = null
var btnNo:Button? = null
var bottomNavigationView:BottomNavigationView? = null
var floatingButtonBmi:FloatingActionButton? = null
class MainActivity : AppCompatActivity() {

    var button: Button? = null
    var editTextH: EditText? = null
    var editTextW: EditText? = null
    var result: TextView? = null
    var imageView: ImageView? = null
    var frameLayout: FrameLayout? = null
    var lottieAnimationWeight: LottieAnimationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lottieAnimationWeight?.playAnimation()
        connectVs()
        clickBtn()
        navBottomClick()


    }

    private fun connectVs() {
        button = findViewById(R.id.btnCal)
        editTextH = findViewById(R.id.ETheight)
        editTextW = findViewById(R.id.EDweight)
        result = findViewById(R.id.bmiResult)
        imageView = findViewById(R.id.imgVr)
        bottomNavigationView = findViewById(R.id.bottomNavView)
        frameLayout = findViewById(R.id.container)
        floatingButtonBmi = findViewById(R.id.flotBMI)

    }

    private fun clickBtn() {
        button?.setOnClickListener {

            try {
                val h: Float =
                    editTextH?.text.toString().toFloat() / 100 //نحول الطول من سانتي متر ل متر
                val w: Float = editTextW?.text.toString().toFloat() // نحول الوزن من نص ل فلوت
                val res: Float = w / (h * h)

                var intent: Intent = Intent(this, Result::class.java)
                intent.putExtra("R", res)
                startActivity(intent)
            } catch (error: NumberFormatException) {
                "خطا ادخل رقم"
            }


        }
    }


    private fun navBottomClick() {

        bottomNavigationView?.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.workout -> {
                    var fragmentTransaction: FragmentTransaction =
                        supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.container, WorkoutFragment(), "WORKOUT")
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE)
                    fragmentTransaction.commit()


                }
                R.id.health -> {
                    var fragmentTransaction: FragmentTransaction =
                        supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.container, HealthyFoodFragment(), "HealthFood")
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE)
                    fragmentTransaction.commit()

                }

            }
            true
        }

    }

    override fun onBackPressed() {

        if(supportFragmentManager.backStackEntryCount > 2){
            val i = Intent(MainActivity@this,MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(i)
        }else{
            super.onBackPressed()
        }

    }


}










