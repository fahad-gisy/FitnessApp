package com.example.bmigo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.LottieAnimationView

class jackFragment : Fragment() {

var lottieAnimationView:LottieAnimationView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jack, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      connectVs(view)
        workOutFun()
    }
private fun connectVs(view: View){
    lottieAnimationView = view.findViewById(R.id.jackjump)
}
    private fun workOutFun(){

        lottieAnimationView?.playAnimation()

    }
    override fun onResume() {
        super.onResume()
        lottieAnimationView?.playAnimation()
    }
    override fun onPause() {
        super.onPause()
        lottieAnimationView?.pauseAnimation()
    }
}