package com.example.bmigo

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

//                                                3 val type of onclick
class CustomWorkout(val array:ArrayList<Workout>,val listener:MyOnClickListener):
    RecyclerView.Adapter<CustomWorkout.DataHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
val dataHolder:DataHolder = DataHolder(LayoutInflater.from(parent.context).inflate
    (R.layout.workout_items,parent,false))
        return dataHolder

    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
 val workout:Workout = array.get(position)
        holder.imageView.setImageResource(workout.img)
        holder.workTitle.setText(workout.name)
        holder.workSup.setText(workout.workout)
    }

    override fun getItemCount(): Int {
return array.size
    }
   inner class DataHolder(view:View):RecyclerView.ViewHolder(view){
var imageView:ImageView = view.findViewById(R.id.workoutPic)
var workTitle:TextView = view.findViewById(R.id.workTv)
var workSup:TextView = view.findViewById(R.id.supworkTv)
       init {
           itemView.setOnClickListener {//2لو ضغطتنا على الفيو هنا  راح ينادي البوزشن
               val position = adapterPosition
               listener.OnClick(position) //  سوينا متغير فوق من نوع الداله اون كلك لسنر في الكلاس عشان نمرره للفراقمت او الكونتنس يعني
           }
       }
    }
    //سوينا داله تمرر البوزشن الي هو الاندكس في مصفوفه الداتا1
    interface MyOnClickListener{
      fun OnClick(position: Int)
    }
}