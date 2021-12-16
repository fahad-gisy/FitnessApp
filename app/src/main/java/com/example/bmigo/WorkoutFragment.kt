package com.example.bmigo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.concurrent.fixedRateTimer

//نقلنا داله اللسنر هنا
class WorkoutFragment : Fragment(),CustomWorkout.MyOnClickListener {

var listView:RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        connectVs(view)
        recycler()
     if (requireFragmentManager().backStackEntryCount > 1){
         requireFragmentManager().popBackStack()
     }
    }
    private fun connectVs(view: View) {
 listView = view.findViewById(R.id.workoutLIST)
    }
private fun recycler(){
    val array:ArrayList<Workout> = ArrayList()
    array.add(Workout("قفزة جاك","تمرين ",R.drawable.jacksn))
    array.add(Workout("الوقوف على الكرسي","تمرين ",R.drawable.chairs))
    array.add(Workout("الضغط","تمرين ",R.drawable.pushup))
    array.add(Workout("البطن","التمرين ",R.drawable.crunches))
    array.add(Workout("المشي","نصف ساعة يوميا",R.drawable.manwalk))
    array.add(Workout("قفزة جاك","التمرين الاول",R.drawable.jacks))
    array.add(Workout("قفزة جاك","التمرين الاول",R.drawable.jacks))
    array.add(Workout("قفزة جاك","التمرين الاول",R.drawable.jacks))
    array.add(Workout("قفزة جاك","التمرين الاول",R.drawable.jacks))
    array.add(Workout("قفزة جاك","التمرين الاول",R.drawable.jacks))

    val customWorkout:CustomWorkout = CustomWorkout(array,this) // نادينا المتغير هنا


listView?.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
listView?.adapter = customWorkout

}
 // تحت عرض الادابتر هنا ورثنا داله اللسنر الي ف الادابتر وخلاص الكلك شغال كذا
    override fun OnClick(position: Int) {
     val fragmentTransaction: FragmentTransaction = requireFragmentManager().beginTransaction()
        when(position){
             0->{
                 fragmentTransaction.replace(R.id.container,jackFragment(),"JackFrag")
                 fragmentTransaction.addToBackStack("JackFrag")
//                 fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                 fragmentTransaction.commit()

             }
            1->{

                fragmentTransaction.replace(R.id.container,ChairFragment(),"ChairFrag")
                fragmentTransaction.addToBackStack("ChairFrag")
//                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                fragmentTransaction.commit()
            }
            2->{

                fragmentTransaction.replace(R.id.container,PushUpFragment(),"PushFrag")
                fragmentTransaction.addToBackStack("PushFrag")
//                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                fragmentTransaction.commit()
            }
            3->{
                fragmentTransaction.replace(R.id.container,CrunchesFragment(),"CrunFrag")
                fragmentTransaction.addToBackStack("CrunFrag")
//                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                fragmentTransaction.commit()

            }
            4->{
                fragmentTransaction.replace(R.id.container,WalkingFragment(),"WalkFrag")
                fragmentTransaction.addToBackStack("WalkFrag")
//                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                fragmentTransaction.commit()
            }
        }
    }

}
