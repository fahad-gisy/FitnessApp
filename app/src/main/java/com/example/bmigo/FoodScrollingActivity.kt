package com.example.bmigo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView

var animationLottieMilk:LottieAnimationView? =null
var animationLottieToast:LottieAnimationView? = null
var animationLottieOrange:LottieAnimationView?= null
class FoodScrollingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.foodscrolling_main)

        connectVs()
        animationLottieMilk?.setMaxFrame(170)
        animationLottieToast?.setMaxFrame(110)
        animationLottieOrange?.setMaxFrame(30)

    }

    private fun connectVs() {
        animationLottieMilk = findViewById(R.id.milk)
        animationLottieToast = findViewById(R.id.toast)
        animationLottieOrange = findViewById(R.id.orange)
    }

    }
