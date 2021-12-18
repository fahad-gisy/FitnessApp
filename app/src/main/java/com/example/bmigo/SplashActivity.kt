package com.example.bmigo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.airbnb.lottie.LottieAnimationView

class SplashActivity : AppCompatActivity() {
    var lottieSplash:LottieAnimationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_load)
        lottieSplash = findViewById(R.id.splash)
        lottieSplash?.playAnimation()
        Handler(Looper.myLooper()!!).postDelayed({

            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        },3000)




    }
}