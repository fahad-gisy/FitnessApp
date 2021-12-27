package com.example.bmigo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



//نقلنا داله اللسنر هنا
class WorkoutFragment : Fragment(),CustomWorkout.MyOnClickListener {
    var frameLayout: FrameLayout? = null
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
        floatMain()
        recycler()

    }
    private fun connectVs(view: View) {
        bottomNavigationView = view.findViewById(R.id.bottomNavView)
        listView = view.findViewById(R.id.workoutLIST)
        frameLayout = view.findViewById(R.id.container)
    }


    private fun floatMain(){
        var intent:Intent
        floatingButtonBmi?.setOnClickListener {
            intent = Intent(requireContext(),MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)

        }
    }

private fun recycler(){
    val array:ArrayList<Workout> = ArrayList()
    array.add(Workout("قفزة جاك","تمرن 10-20 مرة يوميا",R.drawable.jacksn))
    array.add(Workout("   الوقوف على الكرسي","تمرن بشكل مكرر يوميا ",R.drawable.chairs))
    array.add(Workout("الضغط","تمرن بقد استطاعتك \n     مع زيادة العدد تدريجيا",R.drawable.pushup))
    array.add(Workout("تمرين البطن","10 عدات \n       3 مرات يوميا ",R.drawable.crunches))
    array.add(Workout("المشي"," مشي 1,0000 خطوة يوميا",R.drawable.manwalk))
    array.add(Workout("تمرين البلانك","يوميا بقد استطاعتك \n     مع زيادة المدة تدريجيا",R.drawable.plank))


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
//                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE)
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
            5->{
                fragmentTransaction.replace(R.id.container,PlankFragment(),"PlankFrag")
                fragmentTransaction.addToBackStack("PlankFrag")
//                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                fragmentTransaction.commit()
            }
        }
    }






}
