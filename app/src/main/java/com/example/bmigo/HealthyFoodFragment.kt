package com.example.bmigo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment


class HealthyFoodFragment : Fragment() {
var foodcard:CardView? = null
    var noonfood:CardView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_healthy_food, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       connectVs(view)
        cardEvents()
       floatMain()


    }

    private fun connectVs(view: View){
        foodcard = view.findViewById(R.id.cardView)
        noonfood = view.findViewById(R.id.cardView2)
    }
     private fun cardEvents(){
         foodcard?.setOnClickListener {
             var i = Intent(requireContext(),FoodScrollingActivity::class.java)
             i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
             startActivity(i)
         }
     }
    private fun floatMain(){
        var intent: Intent
        floatingButtonBmi?.setOnClickListener {
            intent = Intent(requireContext(),MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
    }


}