package com.example.bmigo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView

var animationSandWish:LottieAnimationView? = null
class NoonScrollingFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noon_scrolling_food)
        animationSandWish = findViewById(R.id.sandwish)
        animationSandWish?.setMaxFrame(180)
    }
}