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
var foodCard:CardView? = null
    var noonFood:CardView? = null
    var dinnerFood:CardView? = null
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
        foodCard = view.findViewById(R.id.cardView)
        noonFood = view.findViewById(R.id.cardView2)
        dinnerFood = view.findViewById(R.id.cardView3)
    }
     private fun cardEvents(){

         dinnerFood?.setOnClickListener {
             var i = Intent(requireContext(),Dinner_Scrolling_Activity::class.java)
             i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
             startActivity(i)
         }

         noonFood?.setOnClickListener {

             var i = Intent(requireContext(),NoonScrollingFoodActivity::class.java)
             i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
             startActivity(i)

         }
         foodCard?.setOnClickListener {
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