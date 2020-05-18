package deomin.dmitriy.find_color.`fun`

import android.content.Context
import android.util.DisplayMetrics
import deomin.dmitriy.find_color.Main

fun get_size_button(context: Context,metricsB: DisplayMetrics,h_nav:Int){
    val size_button =
        Pair((metricsB.heightPixels + h_nav) / HEIGH, metricsB.widthPixels / WIDCH)
    //создадим массив кнопок и повесим на них обработку, кнопки видны всем
    Main.mas_button = create_mass_button(context, SIZE_TABLE, size_button)
}