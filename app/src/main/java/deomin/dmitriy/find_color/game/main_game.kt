package deomin.dmitriy.find_color.game

import deomin.dmitriy.find_color.`fun`.SIZE_FIND_COLOR
import deomin.dmitriy.find_color.`fun`.size_find_clik
import deomin.dmitriy.find_color.game.levels.level_1
import deomin.dmitriy.find_color.game.levels.level_2
import deomin.dmitriy.find_color.game.levels.level_3
import deomin.dmitriy.find_color.game.levels.level_4
import deomin.dmitriy.find_color.menu.game_menu

fun main_game() {
    //По количеству правельно натыканых будем смотреть какой уровень запустить
    when(size_find_clik){
        in 0..SIZE_FIND_COLOR-> level_1()
        in SIZE_FIND_COLOR..(SIZE_FIND_COLOR*2)-> level_2()
        in (SIZE_FIND_COLOR*2)..(SIZE_FIND_COLOR*3)-> level_3()
        in (SIZE_FIND_COLOR*3)..(SIZE_FIND_COLOR*4)-> level_4()
        in -1 downTo -1000 -> game_menu()
    }
}