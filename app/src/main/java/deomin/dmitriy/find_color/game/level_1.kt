package deomin.dmitriy.find_color.game

import deomin.dmitriy.find_color.Main.Companion.mas_button
import deomin.dmitriy.find_color.`fun`.*

fun level_1(){
    mas_button[0].text = "Level 1"
    mas_button[1].text = "Find color "+ (TIME_CLIK- time_tik).toString()
    mas_button[2].text = "$size_find_clik/$SIZE_FIND_COLOR"

    if (time_tik >= TIME_CLIK) {
        mas_button[find_button].start_anim_help()
        time_tik =0
    }
    time_tik++
}