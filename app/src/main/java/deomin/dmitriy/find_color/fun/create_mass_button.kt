package deomin.dmitriy.find_color.`fun`

import android.view.View
import deomin.dmitriy.find_color.Btn
import deomin.dmitriy.find_color.Main
import deomin.dmitriy.find_color.Main.Companion.HEIGH
import deomin.dmitriy.find_color.Main.Companion.WIDCH
import deomin.dmitriy.find_color.Main.Companion.heightPixels_display
import deomin.dmitriy.find_color.Main.Companion.navigationBarHeight
import deomin.dmitriy.find_color.Main.Companion.widthPixels_display

fun create_mass_button():ArrayList<Btn>{

    //всего кнопок
    val SIZE_TABLE = WIDCH * HEIGH

    val mas_button = ArrayList<Btn>(SIZE_TABLE)
    for(b in 0 until  SIZE_TABLE){
        val btn = Btn(Main.context)
        btn.setOnClickListener(View.OnClickListener { clik(btn) })
        btn.height =(heightPixels_display + navigationBarHeight) / HEIGH
        btn.width = widthPixels_display / WIDCH
        btn.id = b
        mas_button.add(btn)
    }
    return mas_button
}