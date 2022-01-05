package com.example.bmigo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.lang.NumberFormatException

var result: TextView? = null
var imageView: ImageView? = null

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

connectVs()

    }

    private fun connectVs() {
        result = findViewById(R.id.bmiResult)
        imageView = findViewById(R.id.imgVr)

        val intent =intent
         var resultGo = intent.getFloatExtra("R",0f)
        result?.text = resultGo.toString()

        if (resultGo < 18.5){
            result?.text ="%.2f".format(resultGo)+"\n نحيف جدا"
            imageView?.setImageResource(R.drawable.underweight)
        }else if (resultGo > 18.5 && resultGo <24.9){
            result?.text = "%.2f".format(resultGo)+"\n طبيعي "
            imageView?.setImageResource(R.drawable.normalweight)

        } else if (resultGo > 24.9 && resultGo < 29.9){
            result?.text = "%.2f".format(resultGo)+"\n وزن زائد "
            imageView?.setImageResource(R.drawable.overweight)
        }else if (resultGo >= 30.0){
            result?.text = "%.2f".format(resultGo)+"\n سمنة "
            imageView?.setImageResource(R.drawable.obese)
        }

    }


    }



