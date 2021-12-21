package com.example.bmigo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment


class HealthyFoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_healthy_food, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (requireFragmentManager().backStackEntryCount > 1){
            requireFragmentManager().popBackStack()
        }

//        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                if (requireFragmentManager().backStackEntryCount == 1){
//               requireFragmentManager().popBackStack()
//        }
//            }
//        })


    }


}