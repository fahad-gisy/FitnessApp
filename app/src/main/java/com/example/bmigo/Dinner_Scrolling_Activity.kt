package com.example.bmigo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView

var animationSalad:LottieAnimationView? = null
var animationSecondMilk:LottieAnimationView? = null
var animationSecondSalad:LottieAnimationView? = null
var animationFish:LottieAnimationView? = null
class Dinner_Scrolling_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dinner_scrolling)

        connectVs()
        animationFish?.setMaxFrame(150)
        animationSecondMilk?.setMaxFrame(150)
        animationSecondSalad?.setMaxFrame(150)
        animationSalad?.setMaxFrame(150)
    }

    private fun connectVs() {
        animationSalad = findViewById(R.id.fruits)
        animationSecondMilk = findViewById(R.id.Socendmilk)
        animationSecondSalad = findViewById(R.id.SecondSalad)
        animationFish = findViewById(R.id.tuna)
    }
}