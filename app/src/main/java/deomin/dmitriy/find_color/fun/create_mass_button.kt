package deomin.dmitriy.find_color.`fun`

import android.content.Context
import android.view.View
import deomin.dmitriy.find_color.Btn

fun create_mass_button(context: Context,SIZE_TABLE:Int,size_button:Pair<Int,Int>):ArrayList<Btn>{
    val mas_button = ArrayList<Btn>(SIZE_TABLE)
    for(b in 0 until  SIZE_TABLE){
        val btn = Btn(context)
        btn.setOnClickListener(View.OnClickListener { clik(context,btn) })
        btn.height = size_button.first
        btn.width = size_button.second
        btn.id = b
        mas_button.add(btn)
    }
    return mas_button
}