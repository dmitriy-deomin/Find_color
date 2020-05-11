package deomin.dmitriy.find_color.game

import deomin.dmitriy.find_color.`fun`.SIZE_FIND_COLOR
import deomin.dmitriy.find_color.`fun`.size_find_clik

fun main_game() {
    //По количеству правельно натыканых будем смотреть какой уровень запустить
    when(size_find_clik){
        in 0..SIZE_FIND_COLOR-> level_1()
        in SIZE_FIND_COLOR..(SIZE_FIND_COLOR*2)-> level_1()
        in (SIZE_FIND_COLOR*2)..(SIZE_FIND_COLOR*3)-> level_1()
    }
}